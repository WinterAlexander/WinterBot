package me.winter.winterbot;

import me.winter.winterbot.command.Command;
import me.winter.winterbot.command.CommandBot;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.URL;

/**
 * Undocumented :(
 * <p>
 * Created by Alexander Winter on 2017-10-28.
 */
public class LinkDescriptor implements Command
{
	@Override
	public void execute(CommandBot bot, String channel, String sender, String message)
	{
		try
		{
			URL url = new URL(message);

			bot.sendMessage(channel, Jsoup.connect(message).get().title());
		}
		catch(IOException ex)
		{

		}
	}

	@Override
	public boolean doesExecute(String channel, String sender, String message)
	{
		return true;
	}
}