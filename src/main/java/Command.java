/**
 *
 * Created by Alexander Winter on 2015-11-30.
 */
public interface Command
{
	boolean doesExecute(String sender, String channel, String message);
	void execute(String sender, String channel, String message);
}
