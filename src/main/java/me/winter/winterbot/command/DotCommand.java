package me.winter.winterbot.command;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Alexander Winter on 2015-11-30.
 */
public abstract class DotCommand implements Command
{
	private final String name;
	private final List<String> aliases;

	public DotCommand(String name)
	{
		this.name = name;
		this.aliases = new ArrayList<>();
	}

	public DotCommand(String name, List<String> aliases)
	{
		this.name = name;
		this.aliases = aliases;
	}

	@Override
	public boolean doesExecute(CommandBot bot, String channel, String sender, String fullCommand)
	{
		if(fullCommand.split(" ")[0].equalsIgnoreCase("." + name))
			return true;

		for(String string : this.aliases)
			if(fullCommand.split(" ")[0].equalsIgnoreCase("." + string))
				return true;

		return false;
	}
}
