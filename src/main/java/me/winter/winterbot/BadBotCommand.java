package me.winter.winterbot;

import me.winter.winterbot.command.Command;
import me.winter.winterbot.command.CommandBot;

/**
 * Undocumented :(
 * <p>
 * Created by Alexander Winter on 2017-10-28.
 */
public class BadBotCommand implements Command
{
	@Override
	public boolean doesExecute(CommandBot bot, String channel, String sender, String message)
	{
		return true;
	}

	@Override
	public void execute(CommandBot bot, String channel, String sender, String message)
	{
		if(message.toLowerCase().contains("bad bot"))
		{
			if(sender.toLowerCase().startsWith("loomy"))
			{
				bot.sendMessage(channel, "Bad human.");
			}
			else
			{
				bot.sendMessage(channel, "Sorry. :(");
			}
		}
	}
}
