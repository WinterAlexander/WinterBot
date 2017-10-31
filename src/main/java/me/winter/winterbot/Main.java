package me.winter.winterbot;

import org.jibble.pircbot.PircBot;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/**
 *
 * Created by Alexander Winter on 2015-11-30.
 */
public class Main
{
	public static void main(String[] args)
	{
		WinterBot bot = new WinterBot(false);
		try
		{
			bot.connect("chat.freenode.net");

			bot.joinChannel("#cem");
			bot.joinChannel("#bots");
		}
		catch(Throwable t)
		{
			boolean couldSaveLogs;
			try
			{
				bot.getChatHistory().saveHistoryEverywhere();
				couldSaveLogs = true;
			}
			catch(Throwable t2)
			{
				couldSaveLogs = false;
			}

			Date date = new Date();
			try
			{

				File file = new File("Crash " + date.getTime());

				BufferedWriter writer = new BufferedWriter(new FileWriter(file));

				writer.write("Crash occurred : " + t.toString());

				if(!couldSaveLogs)
					writer.write("\n\nCould not save logs after error !");

				writer.close();
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
