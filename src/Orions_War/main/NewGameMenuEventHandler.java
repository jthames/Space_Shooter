/**************************************************************************
 ***************************************************************************
 * 	
 *     ============    Team 2  -  Project 6: Space Shooter    ============
 *     	
 *	FILE NAME: NewGameMenuEventHandler.java
 *	AUTHOR(S): Christopher Margol
 *	DATE OF FIRST VERSION: 11/01/2012
 *	DATE LAST MODIFIED: 11/01/2012
 *	UNIT TESTING COMPLETED: Yes
 *	STATUS OF UNIT TESTING: No Problems
 *	INTEGRATION TESTING COMPLETED: Yes
 *	PURPOSE OF FILE IN THE SYSTEM: This file enables us to deal with
 *   everything used for actions taken for new game menu options
 *
 ***************************************************************************
 **************************************************************************/
package Orions_War.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;



public class NewGameMenuEventHandler 
{
	// TODO: update this
	// event 1: play game
	// event 2: view highScores
	// event 3: options
	// event 4: exit application

	public static void handleEvent(int eventId) throws IOException
	{
		// return to main menu
		if(eventId == 1)
		{
			System.out.println("Exit new game menu selected");
			Main.newGameMenu.setVisible(false);
			Main.newGameMenu.setEnabled(false);
			Main.newGameMenu.setFocusable(false);
			
			Main.mainFrame.remove(Main.newGameMenu);
			Main.mainFrame.add(Main.mainMenu);
			
			Main.mainMenu.setVisible(true);
			Main.mainMenu.setEnabled(true);
			Main.mainMenu.setFocusable(true);
			Main.mainMenu.requestFocusInWindow();

		}
		
		// TODO: this currently returns to main menu as placeholder
		// start a new game
		else if(eventId == 2)
		{
			
			if(Main.newGameMenu.checkDuplicateSave(Main.newGameMenu.getNewName()))
			{
				return;
			}
			else if(!Main.newGameMenu.checkDuplicateSave(Main.newGameMenu.getNewName()))
			{
				
				Main.newGameMenu.setVisible(false);
				Main.newGameMenu.setEnabled(false);
				Main.newGameMenu.setFocusable(false);
				
				Main.mainFrame.remove(Main.newGameMenu);
				Main.Player1.Update_Player_Name(Main.newGameMenu.getNewName());
				Main.Player1.saveGame();


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
				
				
			}
			
			
		}
		
		else if(eventId == 3)
		{
		}
		
		else if(eventId == 4)
		{
		}
		else if(eventId == 5)
		{

		}
		
		
		
	}
	
	
}
	
	

	