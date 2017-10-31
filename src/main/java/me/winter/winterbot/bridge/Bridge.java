package me.winter.winterbot.bridge;

import org.jibble.pircbot.PircBot;

/**
 * Undocumented :(
 * <p>
 * Created by Alexander Winter on 2017-10-30.
 */
public class Bridge
{
	private final PircBot botA, botB;

	public Bridge(String networkA, final String channelA, String networkB, final String channelB) throws Exception
	{
		botA = new PircBot() {
			{
				setName("B_55");
			}

			@Override
			protected void onMessage(String channel, String sender, String login, String hostname, String message)
			{
				botB.sendMessage(channelB, sender + ": " + message);
			}
		};
		//botA.setVerbose(true);
		botA.connect(networkA);
		botA.joinChannel(channelA);


		botB = new PircBot() {
			{
				setName("Winter_");
			}

			@Override
			protected void onMessage(String channel, String sender, String login, String hostname, String message)
			{
				if(sender.equalsIgnoreCase("root"))
					return;

				botA.sendMessage(channelA, sender + ": " + message);
			}
		};

		//botB.setVerbose(true);
		botB.connect(networkB);
		//botB.sendMessage("&bitlbee", "register psswd");
		botB.sendMessage("&bitlbee", "identify psswd");
		//botB.sendMessage("&bitlbee", "account list");
		//botB.sendMessage("&bitlbee", "account add facebook mail psswd");
		//botB.sendMessage("&bitlbee", "account facebook on");
		//Thread.sleep(10000);
		//botB.sendMessage("&bitlbee", "chat add facebook 1612849258735422 #cem");
		botB.joinChannel(channelB);
	}

	public static void main(String[] args) throws Throwable
	{
		new Bridge("chat.freenode.net", "#cem", "im.codemonkey.be", "#cem");
	}
}
