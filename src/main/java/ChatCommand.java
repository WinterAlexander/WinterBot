/**
 * Created by Alexander Winter on 2015-11-30.
 */
public abstract class ChatCommand implements Command
{
	@Override
	public boolean doesExecute(String sender, String channel, String message)
	{
		return message.toLowerCase().contains("WinterBot".toLowerCase());
	}
}
