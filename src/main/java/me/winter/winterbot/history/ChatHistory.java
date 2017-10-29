package me.winter.winterbot.history;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Undocumented :(
 * <p>
 * Created by Alexander Winter on 2017-10-28.
 */
public class ChatHistory
{
	private Map<String, List<String>> history = new HashMap<>();

	private static final File directory = new File("logs");

	private static final SimpleDateFormat fileNameFormat = new SimpleDateFormat("yyyy-MM-dd");

	private static final Object dirLock = new Object();

	private static final int LINES_IN_RAM_LIMIT = 2000;

	public ChatHistory()
	{
		if(!directory.isDirectory() && !directory.mkdir())
			throw new RuntimeException("Couldn't make dir for logs");
	}

	public void register(final String channel, String sender, String message)
	{
		if(!history.containsKey(channel))
			history.put(channel, new ArrayList<String>());

		List<String> list = history.get(channel);
		list.add(new Date().toString() + " " + sender + ": " + message + "\n");

		if(list.size() > LINES_IN_RAM_LIMIT)
		{
			saveHistory(channel);
		}
	}

	public void saveHistoryEverywhere()
	{
		for(String channel : history.keySet())
			saveHistory(channel);
	}

	public void saveHistory(final String channel)
	{
		List<String> list = history.get(channel);
		if(list == null)
			return;

		final List<String> copy = new ArrayList<>(list);
		list.clear();

		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				synchronized(dirLock)
				{
					try
					{
						File dir = new File(directory, channel);
						dir.mkdir();

						File file = new File(dir, fileNameFormat.format(new Date()));
						file.createNewFile();

						BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));

						for(String line : copy)
							writer.write(line);

						writer.flush();
						writer.close();
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
			}
		}).start();
	}

	public List<String> getHistory(final String channel)
	{
		return history.get(channel);
	}

	public void deleteLogs()
	{
		synchronized(dirLock)
		{
			for(File file : directory.listFiles())
			{
				delete(file);
			}
		}
	}

	private void delete(File path)
	{
		for (File f : path.listFiles())
			if(f.isDirectory())
				delete(f);
			else if(!f.delete())
				throw new RuntimeException("Could not delete : " + f.getAbsolutePath());

		if(!path.delete())
			throw new RuntimeException("Could not delete : " + path.getAbsolutePath());
	}
}
