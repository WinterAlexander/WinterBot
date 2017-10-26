package me.winter;

import org.jibble.pircbot.PircBot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * Created by Alexander Winter on 2015-11-30.
 */
public class WinterBot extends PircBot
{
	private List<Command> commands;

	public WinterBot()
	{
		this.setName("WinterBot");

		this.commands = new ArrayList<Command>();

		this.commands.add(new DotCommand("taco", Arrays.asList("tacoing", "tacokill"))
		{
			@Override
			public void execute(String sender, String channel, String fullCommand)
			{
				sendAction(channel, "Takes a taco and smash it on the ground.");
			}
		});

		this.commands.add(new DotCommand("huggle", Arrays.asList("hugglehim", "huggleher"))
		{
			@Override
			public void execute(String sender, String channel, String message)
			{
				sendAction(channel, "huggles" + message.replaceFirst(".huggle", ""));
			}
		});

		this.commands.add(new DotCommand("russianroulette", Arrays.asList("russianroll", "rr"))
		{
			@Override
			public void execute(String sender, String channel, String message)
			{
				sendMessage(channel, WinterBot.this.getUsers(channel)[new Random().nextInt(WinterBot.this.getUsers(channel).length)] + " dies.");
			}
		});

		this.commands.add(new ChatCommand()
		{
			@Override
			public void execute(String sender, String channel, String fullCommand)
			{
				String message = fullCommand.replaceAll("(.)*WinterBot([,:])?(\\s)*", "");

				if(message.matches("(?i)are you available(.)*"))
				{
					sendMessage(channel, "As always :p");
					return;
				}

				if(message.matches("(?i)do you even lift(.)*"))
				{
					sendMessage(channel, "I do.");
					return;
				}

				if(message.matches("(?i)what('s)? your favorite game(.)*"))
				{
					sendMessage(channel, "osu!");
					return;
				}

				if(message.matches("(.)*WinterGuardian(.)*") && !sender.equalsIgnoreCase("WinterGuardian"))
				{
					sendMessage(channel, "I will never say anything against my loved master.");
					return;
				}

				if(message.matches("(?i)do you like taco(s)(.)*"))
				{
					sendMessage(channel, "That's not funny.");
					return;
				}

				if(sender.equalsIgnoreCase("WinterGuardian"))
				{
					if(message.replace("\\s", "").equals("?"))
					{
						sendMessage(channel, "Yes master ?");
						return;
					}

					if(message.matches("(?i)you dumb shit(.)*"))
					{
						sendMessage(channel, "Sorry, I won't do that again. :(");
						return;
					}

					if(message.split(": ")[0].equalsIgnoreCase("repeat"))
					{
						sendMessage(channel, message.split(": ")[1].
								replace("I", "You").
								replace("am", "are").
								replace("Mine", "Yours"));
						return;
					}

					sendMessage(channel, "I don't know SORRY don't hit me again :'(");
					return;
				}
				else if(sender.equalsIgnoreCase("Z750"))
				{

					if(message.equals("?"))
					{
						sendMessage(channel, "Who the f*** do you think you are talking to ?");
						return;
					}

					sendMessage(channel, "Idk");
					return;
				}
				else if(sender.equalsIgnoreCase("Jarcode"))
				{

					if(message.equals("?"))
					{
						sendMessage(channel, "What do you want from me senpai ?");
						return;
					}

					sendMessage(channel, "Idk");
					return;
				}
				else if(sender.equalsIgnoreCase("__0x277F"))
				{

					if(message.equals("?"))
					{
						sendMessage(channel, "Will I get a ban If I do not answer the stupid question you are about to ask me ?");
						return;
					}

					sendMessage(channel, "Idk");
					return;
				}
				else if(sender.equalsIgnoreCase("Pangea"))
				{

					if(message.equals("?"))
					{
						sendMessage(channel, "No. I don't like you.");
						return;
					}

					sendMessage(channel, "Idk whatever leave me alone");
					return;
				}
				else
				{

					if(message.equals("?"))
					{
						sendMessage(channel, "Hi ! What do you want ?");
						return;
					}

					sendMessage(channel, "Idk");
					return;
				}

			}
		});
	}

	@Override
	protected void onMessage(String channel, String sender, String login, String hostname, String message)
	{
		super.onMessage(channel, sender, login, hostname, message);

		for(Command command : commands)
			if(command.doesExecute(sender, channel, message))
				command.execute(sender, channel, message);
	}
}
