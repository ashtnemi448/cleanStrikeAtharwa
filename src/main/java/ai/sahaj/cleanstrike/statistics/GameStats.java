package ai.sahaj.cleanstrike.statistics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import ai.sahaj.cleanstrike.player.Player;
import ai.sahaj.cleanstrike.carrom.Coins;
import ai.sahaj.cleanstrike.carrom.StrikeType;


public class GameStats 
{

	File gameStatsFile;
	Player player1;
	Player player2;
	Coins coins;

	public GameStats(Player player1, Player player2,Coins coins) throws IOException 
	{
		super();
		this.player1 = player1;
		this.player2 = player2;
		this.coins = coins;

		gameStatsFile = new File("gameStats.txt");
		FileWriter fr = new FileWriter(gameStatsFile, false);
		fr.write("Game Stats for clean Strike");
		fr.close();
	}

	public void saveStats(Player curPlayer, int turn, StrikeType strikeType) throws IOException 
	{
		FileWriter fr = new FileWriter(gameStatsFile, true);

		fr.write("\n\nturnNumber - ");
		fr.write(String.valueOf(turn));

		fr.write("\nCurrent player - Player");
		fr.write(String.valueOf(curPlayer.getId()));
		
		fr.write("\nStrike Type - ");
		fr.write(String.valueOf(strikeType));
		
		fr.write("\nRemaining Black Coins - ");
		fr.write(String.valueOf(coins.getAvailableBlackCoins()));
		
		fr.write("\nRemaining Red Coins - ");
		fr.write(String.valueOf(coins.getAvailableRedCoins()));

		fr.write("\nPlayer 1 - ");
		fr.write("\n\tPoints -> ");
		fr.write(String.valueOf(player1.getPoints()));
		
		fr.write("\n\tConsecutiveLose - ");
		fr.write(String.valueOf(player1.getConsecutiveLoseCount()));
		
		fr.write("\n\tFouls - ");
		fr.write(String.valueOf(player1.getFoul()));

		
		fr.write("\nPlayer 2 - ");
		fr.write("\n\tPoints -> ");
		fr.write(String.valueOf(player2.getPoints()));
		
		fr.write("\n\tConsecutiveLose - ");
		fr.write(String.valueOf(player2.getConsecutiveLoseCount()));
		
		fr.write("\n\tFouls - ");
		fr.write(String.valueOf(player2.getFoul()));

		fr.close();
	}

}