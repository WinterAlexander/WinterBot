package me.winter.winterbot.command;

/**
 * Created by Alexander Winter on 2015-11-30.
 */
public abstract class InterpellationCommand implements Command
{
	@Override
	public boolean doesExecute(CommandBot bot, String channel, String sender, String message)
	{
		return message.toLowerCase().startsWith(bot.getNick().toLowerCase());
	}
}
