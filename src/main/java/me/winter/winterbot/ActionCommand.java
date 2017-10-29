package me.winter.winterbot;

import me.winter.winterbot.command.CommandBot;
import me.winter.winterbot.command.DotCommand;

import java.util.List;

/**
 * Undocumented :(
 * <p>
 * Created by Alexander Winter on 2017-10-28.
 */
public class ActionCommand extends DotCommand
{
	private final String action;

	public ActionCommand(String name, String action)
	{
		super(name);
		this.action = action;
	}

	public ActionCommand(String name, List<String> aliases, String action)
	{
		super(name, aliases);
		this.action = action;
	}

	@Override
	public void execute(CommandBot bot, String channel, String sender, String message)
	{
		bot.sendAction(channel, action);
	}
}
