package me.winter.ai.word;

import me.winter.ai.EnglishUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * Created by Alexander Winter on 2015-12-01.
 */
public interface Verb extends Word
{
	default String conjugate(VerbTense tense, ConjugationType type, int person, String subject)
	{
		String form = tense.getForm(type);

		if(subject == null)
			subject = EnglishUtil.getPronoun(person) + "";

		form = form.replace("%subject;", subject);
		form = form.replace("%not;", " not");
		form = form.replace("%will;", "will");
		form = form.replace("%cond;", "could");

		Matcher matcher = VerbTense.codePattern.matcher(form);

		while(matcher.find())
			form = form.replaceAll(Pattern.quote(matcher.group()), getForm(matcher.group(), person) + "");


		if(type == ConjugationType.INTERROGATIVE || type == ConjugationType.NEGATIVE_AND_INTERROGATIVE)
			form += " ?";
		else
			form += ".";


		return EnglishUtil.capitalize(form);
	}

	String getInfinitive();


	default String getBaseForm(int person)
	{
		if(person != 3)
			return this.getInfinitive();

		if(getInfinitive().endsWith("y"))
		{
			if(EnglishUtil.isVowel(getInfinitive().toCharArray()[getInfinitive().length() - 2]))
			{
				return getInfinitive() + "s";
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
		else if(getInfinitive().endsWith("o") || getInfinitive().endsWith("z") || getInfinitive().endsWith("sh") || getInfinitive().endsWith("x") || getInfinitive().endsWith("ch"))
		{
			return getInfinitive() + "es";
		}
		else
		{
			return getInfinitive() + "s";
		}
	}

	String getPastForm(int person);

	String getParticiple();

	default boolean isVerb(String conjugatedVerb)
	{
		return getSubject(null, null, conjugatedVerb) != null;
	}

	default String getSubject(VerbTense tense, ConjugationType type, String conjugatedVerb)
	{
		String form = tense.getForm(type);

		String formParts[] = form.split(" ");
		String verbParts[] = conjugatedVerb.split(" ");

		if(formParts.length > verbParts.length)
			return null;

		if(!form.contains("%subject;"))
			return null;

		int subjectStartIndex = -1;

		int words = formParts.length;

		for(int i = 0; i < words; i++)
		{
			if(formParts[i].contains("%subject;"))
				subjectStartIndex = i;

			if(formParts[i].contains("%not;"))
			{
				if(subjectStartIndex == -1)
					i++;

				words++;
			}
		}

		int subjectWords = verbParts.length - words;

		String subject = verbParts[subjectStartIndex];

		for(int i = 1; i < subjectWords; i++)
			subject += " " + verbParts[subjectStartIndex + i];

		return subject;
	}

	default String getIngForm()
	{
		if(getInfinitive().endsWith("e"))
		{
			return getInfinitive().substring(0, getInfinitive().length() - 1) + "ing";
		}
		else if(!EnglishUtil.isVowel(getInfinitive(), -1) && EnglishUtil.isVowel(getInfinitive(), -2))
		{
			return getInfinitive() + getInfinitive().toCharArray()[getInfinitive().length() - 1] + "ing";
		}
		return getInfinitive() + "ing";
	}

	default boolean isAuxiliary()
	{
		return false;
	}

	static Set<Verb> getAuxiliaries()
	{
		return new HashSet<>(Arrays.asList(IrregularVerb.BE, IrregularVerb.DO, IrregularVerb.HAVE, IrregularVerb.GO));
	}

	static Verb getAuxiliary(String name)
	{
		switch(name.toLowerCase())
		{
			case "be":
				return IrregularVerb.BE;

			case "do":
				return IrregularVerb.DO;

			case "have":
				return IrregularVerb.HAVE;

			case "go":
				return IrregularVerb.GO;

			default:
				return null;
		}
	}

	default String getForm(String code, int person)
	{
		String[] args = code.replace("%", "").replace(";", "").split(":");

		if(args[0].equalsIgnoreCase("aux") && args.length == 3)
		{
			Verb aux = getAuxiliary(args[1]);

			if(aux == null)
				return null;

			return aux.getForm(args[2], person);
		}

		switch(args[0].toLowerCase())
		{
			case "inf":
				return getInfinitive();

			case "base":
				return getBaseForm(person);

			case "past":
				return getPastForm(person);

			case "part":
				return getParticiple();

			case "-ing":
				return getIngForm();

			default:
				return null;
		}
	}

	@Override
	default WordType getType()
	{
		return WordType.VERB;
	}
}
