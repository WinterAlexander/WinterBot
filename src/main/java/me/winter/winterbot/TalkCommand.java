package me.winter.winterbot;

import me.winter.winterbot.command.CommandBot;
import me.winter.winterbot.command.InterpellationCommand;

/**
 * Undocumented :(
 * <p>
 * Created by Alexander Winter on 2017-10-28.
 */
public class TalkCommand extends InterpellationCommand
{
	@Override
	public String getName()
	{
		return "WinterBot";
	}

	@Override
	public void execute(CommandBot bot, String channel, String sender, String fullCommand)
	{
		String message = fullCommand.replaceAll("(.)*WinterBot([,:])?(\\s)*", "");

		if(message.matches("(?i)are you available(.)*"))
		{
			bot.sendMessage(channel, "As always :p");
			return;
		}

		if(message.matches("(?i)do you even lift(.)*"))
		{
			bot.sendMessage(channel, "I do.");
			return;
		}

		if(message.matches("(?i)what('s)? your favorite game(.)*"))
		{
			bot.sendMessage(channel, "osu!");
			return;
		}

		if(message.matches("(.)*Winter(.)*") && !sender.equalsIgnoreCase("Winter"))
		{
			bot.sendMessage(channel, "I will never say anything against my loved master.");
			return;
		}

		if(message.matches("(?i)do you like taco(s)(.)*"))
		{
			bot.sendMessage(channel, "That's not funny.");
			return;
		}


		if(message.split(": ")[0].equalsIgnoreCase("repeat"))
		{
			bot.sendMessage(channel, message.split(": ")[1].
					replace("I", "You").
					replace("am", "are").
					replace("Mine", "Yours"));
			return;
		}

		if(sender.startsWith("Winter"))
		{
			if(message.replace("\\s", "").equals("?"))
			{
				bot.sendMessage(channel, "Yes master ?");
				return;
			}

			if(message.matches("(?i)you dumb shit(.)*"))
			{
				bot.sendMessage(channel, "Sorry, I won't do that again. :(");
				return;
			}

			bot.sendMessage(channel, "I don't know SORRY don't hit me again :'(");
			return;
		}
		else if(sender.equalsIgnoreCase("Z750"))
		{
			if(message.equals("?"))
			{
				bot.sendMessage(channel, "Who the f*** do you think you are talking to ?");
				return;
			}

			bot.sendMessage(channel, "Idk");
			return;
		}
		else if(sender.equalsIgnoreCase("Jarcode"))
		{
			if(message.equals("?"))
			{
				bot.sendMessage(channel, "What do you want from me senpai ?");
				return;
			}

			bot.sendMessage(channel, "Idk");
			return;
		}
		else if(sender.equalsIgnoreCase("__0x277F"))
		{
			if(message.equals("?"))
			{
				bot.sendMessage(channel, "Will I get a ban If I do not answer the stupid question you are about to ask me ?");
				return;
			}

			bot.sendMessage(channel, "Idk");
			return;
		}
		else if(sender.equalsIgnoreCase("Pangea"))
		{
			if(message.equals("?"))
			{
				bot.sendMessage(channel, "No. I don't like you.");
				return;
			}

			bot.sendMessage(channel, "Idk whatever leave me alone");
			return;
		}
		else
		{
			if(message.equals("?"))
			{
				bot.sendMessage(channel, "Hi ! What do you want ?");
				return;
			}

			bot.sendMessage(channel, "Idk");
			return;
		}
	}
}