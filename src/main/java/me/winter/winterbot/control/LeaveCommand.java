package me.winter.winterbot.control;

import me.winter.winterbot.command.CommandBot;
import me.winter.winterbot.command.DotCommand;

/**
 * Undocumented :(
 * <p>
 * Created by Alexander Winter on 2017-10-29.
 */
public class LeaveCommand extends DotCommand
{
	public LeaveCommand()
	{
		super("leave");
	}

	@Override
	public void execute(CommandBot bot, String channel, String sender, String message)
	{
		bot.partChannel(channel);
	}
}
