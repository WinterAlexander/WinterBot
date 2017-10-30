package me.winter.bridge;

import com.github.messenger4j.MessengerPlatform;
import com.github.messenger4j.receive.MessengerReceiveClient;
import com.github.messenger4j.receive.events.TextMessageEvent;
import com.github.messenger4j.receive.handlers.TextMessageEventHandler;
import com.github.messenger4j.send.MessengerSendClient;
import org.jibble.pircbot.PircBot;
import org.slf4j.event.Level;

import java.util.HashMap;
import java.util.Map;

/**
 * Undocumented :(
 * <p>
 * Created by Alexander Winter on 2017-10-30.
 */
public class BridgeBot extends PircBot implements TextMessageEventHandler
{
	private final String facebookUser, facebookPassword;

	private final Map<String, String> bridges = new HashMap<>();

	public static void main(String[] args) throws Throwable
	{
		MessengerSendClient sendClient =
				MessengerPlatform.newSendClientBuilder("EAACEdEose0cBAF17fzxGTJTQJyfkGZB0mF6hniSxCFi6M4gvMApoplvuuQfQlf8zZB9O1CvZApBWbcaMHf7Ak3oUwyukOfCSWzgGZCS5UYBu1PAJDHqOZAGnWZCCKZAQOm6CHHt9SU9pRqCv9ZALicyYVl01IGkH7jZAtLZBEKykXnvnaaIUuB8YnkUvsaV8gnhZB6IzCgfDLMKBuVBpdbrZBMLj9nAz3M9KmnYZD").build();
		sendClient.sendTextMessage("1612849258735422", "Test");
	}

	public BridgeBot(String facebookUser, String facebookPassword)
	{
		this.facebookUser = facebookUser;
		this.facebookPassword = facebookPassword;

		MessengerReceiveClient receiveClient = MessengerPlatform.newReceiveClientBuilder("APP_SECRET", "VERIFICATION_TOKEN")
				.onTextMessageEvent(this)
				.build();
	}

	public void bridgeChannel(String channel, String facebookThread)
	{
		bridges.put(channel, facebookThread);
	}

	@Override
	protected void onMessage(String channel, String sender, String login, String hostname, String message)
	{
		if(!bridges.containsKey(channel))
			return;


	}

	@Override
	public void handle(TextMessageEvent event)
	{
		sendMessage("#cem", event.getText());
	}
}
