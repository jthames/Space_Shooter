/**************************************************************************
 ***************************************************************************
 * 	
 *     ============    Team 2  -  Project 6: Space Shooter    ============
 *     	
 *	FILE NAME: Weapon_Upgrades.java
 *	AUTHOR(S): Christopher Margol
 *	DATE OF FIRST VERSION: 11/01/2012
 *	DATE LAST MODIFIED: 11/01/2012
 *	UNIT TESTING COMPLETED: Yes
 *	STATUS OF UNIT TESTING: No Problems
 *	INTEGRATION TESTING COMPLETED: Yes
 *	PURPOSE OF FILE IN THE SYSTEM: This file enables us to deal with
 *   everything used for loading the handling of key events
 *
 ***************************************************************************
 **************************************************************************/
package Orions_War.main;

import java.io.FileNotFoundException;
import java.util.ArrayList;



public class LoadGameMenuEventHandler 
{


	public static void handleEvent(int eventId) throws FileNotFoundException
	{
		if(eventId == 1)
		{
			System.out.println("Exit load game menu selected");
			Main.loadGameMenu.setVisible(false);
			Main.loadGameMenu.setEnabled(false);
			Main.loadGameMenu.setFocusable(false);
			
			
			Main.mainFrame.remove(Main.loadGameMenu);
			Main.mainFrame.add(Main.mainMenu);
			
			Main.mainMenu.setVisible(true);
			Main.mainMenu.setEnabled(true);
			Main.mainMenu.setFocusable(true);
			Main.mainMenu.requestFocusInWindow();
		}
		

		else if(eventId == 2)
		{
			System.out.println("loading save file");
			if(Main.Player1.progress > 1)
			{
			  Main.loadGameMenu.setVisible(false);
			  Main.loadGameMenu.setEnabled(false);
			  Main.loadGameMenu.setFocusable(false);
			  Main.mainFrame.remove(Main.loadGameMenu);
			  
			  Main.mainFrame.add(Main.ShipShopMenu);
			  Main.ShipShopMenu.setVisible(true);
			  Main.ShipShopMenu.setEnabled(true);
			  Main.ShipShopMenu.setFocusable(true);
			  Main.ShipShopMenu.requestFocusInWindow();
			}
			else
			{
				Main.loadGameMenu.setVisible(false);
				Main.loadGameMenu.setEnabled(false);
				Main.loadGameMenu.setFocusable(false);
				Main.mainFrame.remove(Main.loadGameMenu);
				
				Main.mainFrame.add(Main.Game_Screen);
				if(Main.played == 0)
				{	
			 	    Main.Game_Screen.setVisible(true);
			     	Main.Game_Screen.setEnabled(true);
				    Main.Game_Screen.setFocusable(true);
				    Main.Game_Screen.requestFocusInWindow();
				    Main.played = 1;
				    Main.Game_Screen.play();
				}
				else
				{
					Main.Game_Screen.Ship_Alive = true;
					Main.Game_Screen.levelFinished = false;
				    Main.Game_Screen.Enemy_Shots2 = new ArrayList<Enemy_Shot>();
	                Main.Game_Screen.Enemy_Asteroids = new ArrayList <Asteroids>();
	                Main.Game_Screen.Enemy_NPC_Ships = new ArrayList <NPC_Ships>();
	                Main.Game_Screen.Enemy_Shots = new ArrayList<Enemy_Shot>();
				    Main.Game_Screen.Enemy_Shots2 = new ArrayList<Enemy_Shot>();
				    Main.Game_Screen.newShots = new ArrayList<Shot>();
					Main.Game_Screen.newEnemies = new ArrayList<NPC_Ships>();
					Main.Game_Screen.newEnemyShots = new ArrayList<Enemy_Shot>();
				    Main.Game_Screen.newAsteroids = new ArrayList<Asteroids>();
					Main.Game_Screen.level_score = 0;
					Main.Game_Screen.sc = null;
					Main.Game_Screen.level = null;
					Main.Game_Screen.setVisible(true);
			     	Main.Game_Screen.setEnabled(true);
				    Main.Game_Screen.setFocusable(true);
				    Main.Game_Screen.requestFocusInWindow();
				    Main.Game_Screen.play();
				}
			
	
				
				
			}
		}
		
		
		
		
		
	}
	
	
}
	