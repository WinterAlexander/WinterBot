package me.winter.ai;

import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * Created by Alexander Winter on 2015-12-01.
 */
public class Memory
{
	private LinkedList<User> users;
	private LinkedList<Sentence> sentences;

	public Memory(AIBot bot)
	{
		this.users = new LinkedList<>();
		this.sentences = new LinkedList<>();

		this.users.addFirst(bot);
	}

	public void receive(String sender, String message)
	{
		this.sentences.addLast(new Sentence(sender, message));

		if(!doRemember(sender))
			this.users.add(new MemoryUser(sender));
	}

	public void send(Sentence sentence)
	{
		this.sentences.add(sentence);
	}

	public boolean doRemember(String sender)
	{
		return getUser(sender) != null;
	}

	public User getUser(String sender)
	{
		if(users == null)
			return null;

		User bestUser = null;
		float bestLevel = 0;

		for(User user : users)
		{
			float level;
			if((level = user.getIdentityLevel(sender)) > bestLevel)
			{
				bestUser = user;
				bestLevel = level;
			}
		}

		return bestUser;
	}

	public AIBot getItself()
	{
		return (AIBot)this.users.getFirst();
	}

	public Sentence getLastSentenceBy(User user)
	{
		if(user == null)
			return sentences.getLast();

		LinkedList<Sentence> reversedList = new LinkedList<>(sentences);

		Collections.reverse(reversedList);

		for(Sentence sentence : reversedList)
			if(getUser(sentence.getSender()).equals(user))
				return sentence;
		return null;
	}

	public LinkedList<Sentence> getSentencesBy(User user)
	{
		if(user == null)
			return sentences;

		LinkedList<Sentence> newList = new LinkedList<>();

		for(Sentence sentence : sentences)
			if(getUser(sentence.getSender()).equals(user))
				newList.add(sentence);
		return newList;
	}

	public LinkedList<User> getUsers()
	{
		return users;
	}
}
