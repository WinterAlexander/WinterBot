package me.winter.winterbot.connect4;

import me.winter.winterbot.command.CommandBot;
import me.winter.winterbot.command.DotCommand;
import org.jibble.pircbot.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Undocumented :(
 * <p>
 * Created by Alexander Winter on 2017-10-28.
 */
public class Connect4Command extends DotCommand
{
	private Map<String, Connect4Game> games = new HashMap<>();

	public Connect4Command()
	{
		super("c4");
	}

	@Override
	public void execute(CommandBot bot, String channel, String sender, String message)
	{
		Connect4Game game = games.get(channel);

		if(game == null)
		{
			if(!message.contains(" "))
				bot.sendMessage(channel, sender + ": Usage: .c4 <opponent>");

			String player2 = null;

			message = message.split(" ")[1];

			for(User user : bot.getUsers(channel))
			{
				if(user.getNick().equalsIgnoreCase(message))
				{
					player2 = message;
					break;
				}
			}

			if(player2 == null)
			{
				bot.sendMessage(channel, "Cannot find opponent " + message);
				return;
			}

			game = new Connect4Game(sender, player2);
			games.put(channel, game);

			game.start(bot, channel);
			return;
		}

		game.play(bot, channel, sender, message);

		if(game.isDone())
			games.put(channel, null);
	}
}
