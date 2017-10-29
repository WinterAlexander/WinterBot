package me.winter.winterbot.history;

import me.winter.winterbot.command.CommandBot;
import me.winter.winterbot.command.DotCommand;

/**
 * Undocumented :(
 * <p>
 * Created by Alexander Winter on 2017-10-28.
 */
public class DeleteLogsCommand extends DotCommand
{
	public DeleteLogsCommand()
	{
		super("cleanlogs");
	}

	@Override
	public void execute(CommandBot bot, String channel, String sender, String message)
	{
		try
		{
			bot.getChatHistory().deleteLogs();
			bot.sendMessage(channel, "Done");
		}
		catch(Exception ex)
		{
			bot.sendMessage(channel, "Error: " + ex.getMessage());
		}
	}
}
