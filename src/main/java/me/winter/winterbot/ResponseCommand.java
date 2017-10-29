package me.winter.winterbot;

import me.winter.winterbot.command.CommandBot;
import me.winter.winterbot.command.DotCommand;

import java.util.List;

/**
 * Undocumented :(
 * <p>
 * Created by Alexander Winter on 2017-10-28.
 */
public class ResponseCommand extends DotCommand
{
	private final String response;

	public ResponseCommand(String name, String response)
	{
		super(name);
		this.response = response;
	}

	public ResponseCommand(String name, List<String> aliases, String response)
	{
		super(name, aliases);
		this.response = response;
	}

	@Override
	public void execute(CommandBot bot, String channel, String sender, String message)
	{
		bot.sendMessage(channel, response);
	}
}
