package me.winter.ai;

/**
 *
 * Created by Alexander Winter on 2015-12-01.
 */
public enum SentenceType
{
	QUESTION("(.)+[?]+", "?"),
	EXCLAMATION("(.)+[!]+", "!"),
	DECLARATION("(.)+[.]", "."),
	;

	public String detectionRegex;
	private String typicalEnd;

	SentenceType(String detectionRegex, String typicalEnd)
	{
		this.detectionRegex = detectionRegex;
		this.typicalEnd = typicalEnd;
	}

	public boolean matches(Sentence sentence)
	{
		return sentence.getRaw().matches(detectionRegex);
	}

	public String getEnd()
	{
		return this.typicalEnd;
	}

	public static SentenceType get(Sentence sentence)
	{
		for(SentenceType type : values())
			if(type.matches(sentence))
				return type;

		return null;
	}
}
