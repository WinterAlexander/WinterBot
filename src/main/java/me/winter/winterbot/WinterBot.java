package me.winter.winterbot;

import me.winter.winterbot.command.CommandBot;
import me.winter.winterbot.command.DotCommand;
import me.winter.winterbot.connect4.Connect4Command;
import me.winter.winterbot.control.ExitCommand;
import me.winter.winterbot.control.JoinCommand;
import me.winter.winterbot.control.LeaveCommand;
import me.winter.winterbot.control.NickCommand;
import me.winter.winterbot.history.DeleteLogsCommand;
import me.winter.winterbot.history.HistoryCommand;

import java.util.Arrays;
import java.util.Random;

/**
 * Undocumented :(
 * <p>
 * Created by Alexander Winter on 2017-10-28.
 */
public class WinterBot extends CommandBot
{
	public WinterBot(boolean debug)
	{
		super("WinterBot" + (debug ? "_test" : ""));

		setVerbose(debug);

		commands.add(new ResponseCommand("ask", Arrays.asList("aask"), "Don't ask to ask, just ask !"));
		commands.add(new ResponseCommand("dumb", Arrays.asList("dumbdumb"), "FUUUUCKING DUMB-DUMB !!!"));

		commands.add(new ActionCommand("taco", Arrays.asList("tacoing", "tacokill"), "Takes a taco and smashes it on the ground."));
		commands.add(new ResponseCommand("triggered", Arrays.asList("t", "po"), "T R I G G E R E D"));

		commands.add(new DotCommand("huggle", Arrays.asList("hugglehim", "huggleher"))
		{
			@Override
			public void execute(CommandBot bot, String channel, String sender, String message)
			{
				sendAction(channel, "huggles" + message.replaceFirst(".huggle", ""));
			}
		});

		commands.add(new DotCommand("russianroulette", Arrays.asList("russianroll", "rr"))
		{
			@Override
			public void execute(CommandBot bot, String channel, String sender, String message)
			{
				sendMessage(channel, bot.getUsers(channel)[new Random().nextInt(bot.getUsers(channel).length)] + " dies.");
			}
		});

		commands.add(new LinkDescriptor());
		commands.add(new BadBotCommand());
		commands.add(new TalkCommand());

		commands.add(new Connect4Command());

		commands.add(new HistoryCommand());
		commands.add(new DeleteLogsCommand());

		commands.add(new ExitCommand());
		commands.add(new JoinCommand());
		commands.add(new LeaveCommand());
		commands.add(new NickCommand());
	}
}
