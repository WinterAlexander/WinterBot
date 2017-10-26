package me.winter.ai;

import me.winter.WinterBot;
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
		//PircBot bot = new WinterBot();

		bot.setVerbose(true);

		bot.connect("chat.freenode.net");

		bot.joinChannel("#cem");
	}
}
