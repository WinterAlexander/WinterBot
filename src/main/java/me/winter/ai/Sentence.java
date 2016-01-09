package me.winter.ai;

/**
 *
 * Created by Alexander Winter on 2015-12-01.
 */
public class Sentence
{
	private long sentTime;
	private String raw;
	private String sender;

	public Sentence(String sender, String raw)
	{
		this.sentTime = System.currentTimeMillis();
		this.sender = sender;
		this.raw = raw;
	}

	public boolean isValid()
	{
		return Character.isUpperCase(raw.charAt(0)) && getType() != null;
	}

	public SentenceType getType()
	{
		return SentenceType.get(this);
	}

	public String getRaw()
	{
		return raw;
	}

	public String getSender()
	{
		return this.sender;
	}
}
