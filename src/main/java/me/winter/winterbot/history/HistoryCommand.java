package me.winter.winterbot.history;

import me.winter.winterbot.command.CommandBot;
import me.winter.winterbot.command.DotCommand;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Undocumented :(
 * <p>
 * Created by Alexander Winter on 2017-10-28.
 */
public class HistoryCommand extends DotCommand
{
	public HistoryCommand()
	{
		super("history", Arrays.asList("h", "logs"));
	}

	@Override
	public void execute(CommandBot bot, String channel, String sender, String message)
	{
		try
		{
			List<String> list = bot.getChatHistory().getHistory(channel);
			StringBuilder sb = new StringBuilder();

			for(String line : list)
				sb.append(line);

			String blob = sb.toString();

			String url = Jsoup.connect("https://pastebin.com/api/api_post.php")
					.data("api_option", "paste")
					.data("api_dev_key", "9dd8622d1eeb50c50c8546d6905eab67")
					.data("api_paste_private", "1")
					.data("api_paste_name", "Chat history export " + new Date().toString())
					.data("api_paste_expire_date", "10M")
					.data("api_paste_code", blob)
					.post().body().html();

			bot.sendMessage(channel, url);
		}
		catch(IOException ex)
		{
			bot.sendMessage(channel, "Pastebin post failed : " + ex.getMessage());
		}
	}
}
