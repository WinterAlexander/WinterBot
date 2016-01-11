package me.winter.ai;

import me.winter.ai.AIBot;
import org.jibble.pircbot.PircBot;

/**
 *
 * Created by Alexander Winter on 2015-11-30.
 */
public class Main
{
	public static void main(String[] args) throws Throwable
	{
		PircBot bot = new AIBot();

		bot.setVerbose(true);

		bot.connect("irc.spi.gt");

		bot.joinChannel("#_");
		bot.joinChannel("#BotTesting");
	}
}
