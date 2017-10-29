package me.winter.winterbot.command;

import me.winter.winterbot.history.ChatHistory;
import org.jibble.pircbot.PircBot;

import java.util.ArrayList;
import java.util.List;

/**
 * Undocumented :(
 * <p>
 * Created by Alexander Winter on 2017-10-28.
 */
public class CommandBot extends PircBot
{
	protected final List<Command> commands = new ArrayList<>();
	private final ChatHistory chatHistory = new ChatHistory();

	public CommandBot(String name)
	{
		setName(name);
	}

	@Override
	protected void onMessage(String channel, String sender, String login, String hostname, String message)
	{
		chatHistory.register(channel, sender, message);

		for(Command command : commands)
			if(command.doesExecute(this, channel, sender, message))
				command.execute(this, channel, sender, message);
	}

	public List<Command> getCommands()
	{
		return commands;
	}

	public ChatHistory getChatHistory()
	{
		return chatHistory;
	}
}
