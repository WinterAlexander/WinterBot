package me.winter.winterbot.connect4;

import me.winter.winterbot.command.CommandBot;

import static java.lang.Integer.parseInt;

/**
 * Undocumented :(
 * <p>
 * Created by Alexander Winter on 2017-10-28.
 */
public class Connect4Game
{
	private final String player1, player2;
	private boolean firstPlayerPlays = true;
	private int winState = -1; //0 = draw, 1 = player 1 wins, 2 = player 2 wins

	private int[][] gameGrid = new int[6][7];

	public Connect4Game(String player1, String player2)
	{
		this.player1 = player1;
		this.player2 = player2;
	}

	public void start(CommandBot bot, String channel)
	{
		bot.sendMessage(channel, player1 + " started a connect-4 game with " + player2 + ".");
		displayGrid(bot, channel);
		announceCurrentTurn(bot, channel);
	}

	public void play(CommandBot bot, String channel, String sender, String message)
	{
		System.out.println(Thread.currentThread().getId());
		if(!sender.equals(firstPlayerPlays ? getPlayer1() : getPlayer2()))
		{
			bot.sendMessage(channel, sender + ", it is not your turn to play.");
			return;
		}

		if(!message.contains(" "))
			displayGrid(bot, channel);

		message = message.split(" ")[1];

		try
		{
			int val = parseInt(message);

			if(val < 1 || val > 7)
				throw new NumberFormatException();

			val--;

			if(gameGrid[0][val] != 0)
			{
				bot.sendMessage(channel, sender + ", This column is full !");
				displayGrid(bot, channel);
				return;
			}

			int vIndex = 0;

			while(vIndex < 5 && gameGrid[vIndex + 1][val] == 0)
				vIndex++;

			gameGrid[vIndex][val] = firstPlayerPlays ? 1 : 2;
			displayGrid(bot, channel);

			if(wins(val, vIndex))
			{
				announceWin(bot, channel);
				winState = firstPlayerPlays ? 1 : 2;
			}
			else
			{
				firstPlayerPlays = !firstPlayerPlays;
				announceCurrentTurn(bot, channel);
			}
		}
		catch(NumberFormatException ex)
		{
			bot.sendMessage(channel, sender + ", You must send the column on which you want to play. [1, 7]");
		}
	}

	public void displayGrid(CommandBot bot, String channel)
	{
		//header
		{
			StringBuilder sb = new StringBuilder();

			for(int i = 0; i < 7; i++)
			{
				sb.append(' ').append(i + 1).append(' ');

				if(i != 6)
					sb.append('|');
			}

			bot.sendMessage(channel, sb.toString());
		}

		for(int j = 0; j < 6; j++)
		{
			StringBuilder sb = new StringBuilder();

			for(int i = 0; i < 7; i++)
			{
				sb.append(' ').append(symbolOf(gameGrid[j][i])).append(' ');

				if(i != 6)
					sb.append('|');
			}

			bot.sendMessage(channel, sb.toString());
		}
	}

	public boolean wins(int x, int y)
	{
		int color = gameGrid[y][x];

		if(x <= 3)
		{
			for(int i = x; i < x + 4; i++)
			{
				if(gameGrid[y][i] != color)
					break;
				if(i == x + 3)
					return true;
			}
		}

		if(x >= 3)
		{
			for(int i = x; i > x - 4; i--)
			{
				if(gameGrid[y][i] != color)
					break;
				if(i == x - 3)
					return true;
			}
		}

		if(y <= 3)
		{
			for(int j = y; j < y + 4; j++)
			{
				if(gameGrid[j][x] != color)
					break;
				if(j == y + 3)
					return true;
			}
		}

		if(y >= 3)
		{
			for(int j = y; j > y - 4; j--)
			{
				if(gameGrid[j][x] != color)
					break;
				if(j == y - 3)
					return true;
			}
		}

		if(x <= 3 && y <= 3)
		{
			for(int a = 0; a < 4; a++)
			{
				if(gameGrid[y + a][x + a] != color)
					break;
				if(a == 3)
					return true;
			}
		}

		if(x >= 3 && y >= 3)
		{
			for(int a = 0; a < 4; a++)
			{
				if(gameGrid[y - a][x - a] != color)
					break;
				if(a == 3)
					return true;
			}
		}

		if(x <= 3 && y >= 3)
		{
			for(int a = 0; a < 4; a++)
			{
				if(gameGrid[y - a][x + a] != color)
					break;
				if(a == 3)
					return true;
			}
		}

		if(x >= 3 && y <= 3)
		{
			for(int a = 0; a < 4; a++)
			{
				if(gameGrid[y + a][x - a] != color)
					break;
				if(a == 3)
					return true;
			}
		}

		return false;
	}

	private char symbolOf(int val)
	{
		switch(val)
		{
			case 1:
				return 'o';

			case 2:
				return 'x';

			default:
				return '_';
		}
	}

	public void announceCurrentTurn(CommandBot bot, String channel)
	{
		bot.sendMessage(channel, "It is " + (firstPlayerPlays ? player1 : player2) + "'s turn.");
	}

	public void announceWin(CommandBot bot, String channel)
	{
		if(winState == 0)
		{
			bot.sendMessage(channel, "It's a draw.");
		}
		else if(winState == 1)
		{
			bot.sendMessage(channel, player1 + " has won the game against " + player2 + " !");
		}
		else if(winState == 2)
		{
			bot.sendMessage(channel, player2 + " has won the game against " + player1 + " !");
		}
	}

	public boolean isDone()
	{
		return winState != -1;
	}

	public String getPlayer1()
	{
		return player1;
	}

	public String getPlayer2()
	{
		return player2;
	}
}
