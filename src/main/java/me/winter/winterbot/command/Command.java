package me.winter.winterbot.command;

/**
 *
 * Created by Alexander Winter on 2015-11-30.
 */
public interface Command
{
	boolean doesExecute(String channel, String sender, String message);

	void execute(CommandBot bot, String channel, String sender, String message);
}
