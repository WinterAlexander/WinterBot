package me.winter.winterbot;

import me.winter.winterbot.command.CommandBot;
import me.winter.winterbot.command.DotCommand;

/**
 * Undocumented :(
 * <p>
 * Created by Alexander Winter on 2017-10-28.
 */
public class ExitCommand extends DotCommand
{
	public ExitCommand()
	{
		super("exit");
	}

	@Override
	public void execute(CommandBot bot, String channel, String sender, String message)
	{
		bot.getChatHistory().saveHistoryEverywhere();
		bot.disconnect();
		bot.dispose();
	}
}
