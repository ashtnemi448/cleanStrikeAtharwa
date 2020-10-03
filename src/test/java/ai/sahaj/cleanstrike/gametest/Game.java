package ai.sahaj.cleanstrike.gametest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ai.sahaj.cleanstrike.carrom.Coins;
import ai.sahaj.cleanstrike.game.StrikeAction;
import ai.sahaj.cleanstrike.player.Player;

class Game {

	Player player1; 
	Player player2; 
	Coins coins;
	
	@BeforeEach
	public void init()
	{
		player1 = new Player(1);
		player2 = new Player(2);
		coins = new Coins(1, 9);
	}
	
	@AfterEach
	public void destroy()
	{
		player1 =null;
		player2 =null;
		coins =null;
	}
	
	@Test
	public void strikeMustResultInOnePointGain() 
	{
		StrikeAction strikeAction = new StrikeAction();
		strikeAction.strike(player1, coins);

		assertEquals(1, player1.getPoints());
		assertEquals(8, coins.getAvailableBlackCoins());
	}
	
	@Test
	public void  redStrikeMustResultInOnePointGain() 
	{
		StrikeAction strikeAction = new StrikeAction();
		strikeAction.redStrike(player1, coins);

		assertEquals(3, player1.getPoints());
		assertEquals(9, coins.getAvailableBlackCoins());
		assertEquals(0, coins.getAvailableRedCoins());
	}
}
