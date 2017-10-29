package me.winter.winterbot.control;

import me.winter.winterbot.command.CommandBot;
import me.winter.winterbot.command.DotCommand;

/**
 * Undocumented :(
 * <p>
 * Created by Alexander Winter on 2017-10-29.
 */
public class JoinCommand extends DotCommand
{
	public JoinCommand()
	{
		super("join");
	}

	@Override
	public void execute(CommandBot bot, String channel, String sender, String message)
	{
		if(!message.contains(" "))
		{
			bot.sendMessage(channel, "Usage: .join <#channel>");
			return;
		}

		bot.joinChannel(message.split(" ")[1]);
	}
}
