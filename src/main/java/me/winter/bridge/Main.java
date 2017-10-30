package me.winter.bridge;

import org.jibble.pircbot.PircBot;

/**
 * Undocumented :(
 * <p>
 * Created by Alexander Winter on 2017-10-30.
 */
public class Main
{
	public static void main(String[] args) throws Throwable
	{
		BridgeBot bot = new BridgeBot("martenscedriccem@gmail.com", "P@ssw0rd");

		bot.connect("chat.freenode.net");

		bot.bridgeChannel("#cem", "1612849258735422");
	}
}
