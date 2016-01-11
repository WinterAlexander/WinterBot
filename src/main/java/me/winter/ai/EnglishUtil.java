package me.winter.ai;

/**
 *
 * Created by Alexander Winter on 2015-12-01.
 */
public class EnglishUtil
{
	private EnglishUtil(){}

	public static boolean isCompletlyAlphabetic(String word)
	{
		for(char c : word.toCharArray())
			if(!Character.isAlphabetic(c))
				return false;
		return true;
	}

	public static boolean isVowel(char character)
	{
		if(!Character.isAlphabetic(character))
			return false;

		switch(Character.toLowerCase(character))
		{
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'y':
				return true;

			default:
				return false;
		}
	}

	public static boolean isVowel(String character)
	{
		if(character == null || character.length() != 1)
			return false;

		return isVowel(character.toCharArray()[0]);
	}

	public static boolean isConsonant(char character)
	{
		if(!Character.isAlphabetic(character))
			return false;

		switch(Character.toLowerCase(character))
		{
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				return false;

			default:
				return true;
		}
	}

	public static boolean isConsonant(String character)
	{
		if(character == null || character.length() != 1)
			return false;

		return isConsonant(character.toCharArray()[0]);
	}

	public static boolean isVowel(String word, int index)
	{
		return EnglishUtil.isVowel(word.toCharArray()[index > 0 ? index : word.length() + index]);
	}

	public static boolean isConsonant(String word, int index)
	{
		return EnglishUtil.isConsonant(word.toCharArray()[index > 0 ? index : word.length() + index]);
	}

	public static void toLowerCase(String[] array)
	{
		for(int i = 0; i < array.length; i++)
			array[i] = (array[i] + "").toLowerCase();
	}

	public static String capitalize(String string)
	{
		return string.substring(0, 1).toUpperCase() + string.substring(1);
	}

	public static String getPronoun(int person)
	{
		switch(person)
		{
			case 1:
				return "I";

			case 2:
			case 5:
				return "you";

			case 3:
				return "he";

			case 4:
				return "we";

			case 6:
				return "they";

			default:
				return null;
		}
	}

	public static int getPerson(String pronoun)
	{
		if(pronoun.contains(" and "))
		{
			String[] persons = splitPersons(pronoun);

			for(String person : persons)
				if(person.equalsIgnoreCase("i") || person.equalsIgnoreCase("me"))
					return 4;

			for(String person : persons)
				if(person.equalsIgnoreCase("you"))
					return 5;

			return 6;
		}

		switch(pronoun.toLowerCase())
		{
			case "i":
			case "me":
				return 1;

			case "you":
				return 2;

			case "we":
			case "us":
				return 4;

			case "they":
			case "them":
			case "themselves":
				return 6;

			default:
				return 3;
		}
	}

	public static String[] splitPersons(String pronoun)
	{
		return pronoun.split("(, )|( and )");
	}
}
