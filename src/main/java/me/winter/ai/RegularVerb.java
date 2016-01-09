package me.winter.ai;

/**
 *
 * Created by Alexander Winter on 2015-12-01.
 */
public class RegularVerb implements Verb
{
	private String infinitive;
	
	public RegularVerb(String infinitive)
	{
		this.infinitive = infinitive;
	}

	@Override
	public String getInfinitive()
	{
		return this.infinitive;
	}

	@Override
	public String getPastForm(int person)
	{
		if(getInfinitive().endsWith("e"))
		{
			return getInfinitive() + "d";
		}
		else if(getInfinitive().endsWith("y"))
		{
			if(EnglishUtil.isVowel(getInfinitive().toCharArray()[getInfinitive().length() - 2]))
			{
				return getInfinitive() + "ed";
			}
			else
			{
				return getInfinitive().substring(0, getInfinitive().length() - 1) + "ied";
			}
		}
		else if(EnglishUtil.isConsonant(getInfinitive(), -1) && EnglishUtil.isVowel(getInfinitive(), -2))
		{
			return getInfinitive() + getInfinitive().toCharArray()[getInfinitive().length() - 1] + "ed";
		}
		else
		{
			return getInfinitive() + "ed";
		}
	}

	@Override
	public String getParticiple()
	{
		return this.getPastForm(0);
	}
}
