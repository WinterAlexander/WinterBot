package me.winter.ai;

import java.util.LinkedList;

/**
 * Created by Alexander Winter on 2015-12-01.
 */
public class CompoundSentence
{
	private Sentence sentence;
	private int index;

	public CompoundSentence(Sentence sentence, int index)
	{
		this.index = index;
	}

	public String getRaw()
	{
		if(!sentence.isValid())
			return "invalid sentence";
		return sentence.getRaw().replace("[^A-Za-z ]", "").replace("([ ]{2,})", "");
	}

	public LinkedList<String> getWords()
	{
		LinkedList<String> words = new LinkedList<>();

		for(String string : getRaw().split(" "))
			if(EnglishUtil.isCompletlyAlphabetic(string))
				words.add(string);

		return words;
	}

	public String getSubjectString()
	{
		if(getWords().size() < 1)
			return null;

		return getWords().get(0);
	}

	public String getVerbString()
	{
		if(getWords().size() < 1)
			return null;

		return getWords().get(1);
	}

	public String getObjectString()
	{
		if(getWords().size() < 1)
			return null;

		return getWords().getLast();
	}
}
