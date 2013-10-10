/**************************************************************************
***************************************************************************
* 	
*     ============    Team 2  -  Project 6: Space Shooter    ============
*     	
*	FILE NAME: ShipShopWeaponsMenuEventHandler.java
*	AUTHOR(S): Alexander Banke
*	DATE OF FIRST VERSION: 11/01/2012
*	DATE LAST MODIFIED: 11/01/2012
*	UNIT TESTING COMPLETED: Yes
*	STATUS OF UNIT TESTING: No Problems
*	INTEGRATION TESTING COMPLETED: Yes
*	PURPOSE OF FILE IN THE SYSTEM: This file enables us to move around the different parts of 
*   the ship shop , save and go to the next level
*
***************************************************************************
**************************************************************************/
package Orions_War.main;

import java.io.FileNotFoundException;
import java.util.ArrayList;



public class ShipShopWeaponsMenuEventHandler
{

	public static void handleEvent(int eventId) throws FileNotFoundException
	{
		//Alex Banke: Changes focus to Main Ship Shop Menu
		if(eventId == 1)
		{
			System.out.println("Exit Ship Shop Weapons menu to Main Ship Shop Menu selected");
			Main.ShipShopWeaponsMenu.setVisible(false);
			Main.ShipShopWeaponsMenu.setEnabled(false);
			Main.ShipShopWeaponsMenu.setFocusable(false);
			
			Main.mainFrame.remove(Main.ShipShopWeaponsMenu);
			
			Main.mainFrame.add(Main.ShipShopMenu);
		   
			Main.ShipShopMenu.setVisible(true);
			Main.ShipShopMenu.setEnabled(true);
			Main.ShipShopMenu.setFocusable(true);
			Main.ShipShopMenu.requestFocusInWindow();
		}
		
        // Alex Banke: Change focus to the Engines menu
		else if(eventId == 2)
		{
			System.out.println("Exit Ship Shop Weapons menu to Engines Ship Shop Menu selected");
			Main.ShipShopWeaponsMenu.setVisible(false);
			Main.ShipShopWeaponsMenu.setEnabled(false);
			Main.ShipShopWeaponsMenu.setFocusable(false);
			
			Main.mainFrame.remove(Main.ShipShopWeaponsMenu);
			
			Main.mainFrame.add(Main.ShipShopEnginesMenu);
		   
			Main.ShipShopEnginesMenu.setVisible(true);
			Main.ShipShopEnginesMenu.setEnabled(true);
			Main.ShipShopEnginesMenu.setFocusable(true);
			Main.ShipShopEnginesMenu.requestFocusInWindow();
		}
		//Alex Banke: Changes focus to the hulls menu
		else if(eventId == 3)
		{
			System.out.println("Exit Ship Shop Weapons menu to Hulls Ship Shop Menu selected");
			Main.ShipShopWeaponsMenu.setVisible(false);
			Main.ShipShopWeaponsMenu.setEnabled(false);
			Main.ShipShopWeaponsMenu.setFocusable(false);
			
			Main.mainFrame.remove(Main.ShipShopWeaponsMenu);
			
			Main.mainFrame.add(Main.ShipShopHullsMenu);
		   
			Main.ShipShopHullsMenu.setVisible(true);
			Main.ShipShopHullsMenu.setEnabled(true);
			Main.ShipShopHullsMenu.setFocusable(true);
			Main.ShipShopHullsMenu.requestFocusInWindow();
		}
		//Alex Banke: Changes focus to the Thrusters Menu
		else if(eventId == 4)
		{
			System.out.println("Exit Ship Shop Weapons menu to Thrusters Ship Shop Menu selected");
			Main.ShipShopWeaponsMenu.setVisible(false);
			Main.ShipShopWeaponsMenu.setEnabled(false);
			Main.ShipShopWeaponsMenu.setFocusable(false);
			
			Main.mainFrame.remove(Main.ShipShopWeaponsMenu);
			
			Main.mainFrame.add(Main.ShipShopThrustersMenu);
		   
			Main.ShipShopThrustersMenu.setVisible(true);
			Main.ShipShopThrustersMenu.setEnabled(true);
			Main.ShipShopThrustersMenu.setFocusable(true);
			Main.ShipShopThrustersMenu.requestFocusInWindow();
		}
		//Alex Banke: Do nothing because same menu selected
		else if(eventId == 5)
		{
			
		}//Alex Banke: Pops up the screen to tell the user their game has been saved
		else if(eventId == 6)
		{
			Save_Confirmation_PopUp_MenuEventHandler.menu_choice = 3;
			Main.ShipShopWeaponsMenu.setVisible(false);
			Main.ShipShopWeaponsMenu.setEnabled(false);
			Main.ShipShopWeaponsMenu.setFocusable(false);
			Main.mainFrame.remove(Main.ShipShopWeaponsMenu);
			
			Main.mainFrame.add(Main.Save_Confirmation_PopUp);
			Main.Save_Confirmation_PopUp.setVisible(true);
			Main.Save_Confirmation_PopUp.setEnabled(true);
			Main.Save_Confirmation_PopUp.setFocusable(true);
			Main.Save_Confirmation_PopUp.requestFocusInWindow();
		}
		//Alex Banke: Checks to see what level the user is on and then plays the game
		else if(eventId == 7)
		{
			System.out.println("Exit Ship Shop Weapons menu to Next Level selected");
			Main.ShipShopWeaponsMenu.setVisible(false);
			Main.ShipShopWeaponsMenu.setEnabled(false);
			Main.ShipShopWeaponsMenu.setFocusable(false);
			
			Main.mainFrame.remove(Main.ShipShopWeaponsMenu);
			if(Main.Player1.progress == 1)
			{
				Main.mainFrame.add(Main.Game_Screen);
			    Main.Game_Screen.setVisible(true);
	     	    Main.Game_Screen.setEnabled(true);
		        Main.Game_Screen.setFocusable(true);
		        Main.Game_Screen.requestFocusInWindow();
			    Main.Game_Screen.play();
			}
			else if(Main.Player1.progress == 2)
			{
				Main.mainFrame.add(Main.Game_Screen2);
			    Main.Game_Screen2.setVisible(true);
	     	    Main.Game_Screen2.setEnabled(true);
		        Main.Game_Screen2.setFocusable(true);
		        Main.Game_Screen2.requestFocusInWindow();
			    Main.Game_Screen2.play();
			}
			else if(Main.Player1.progress == 3)
			{
				Main.mainFrame.add(Main.Game_Screen3);
			    Main.Game_Screen3.setVisible(true);
	     	    Main.Game_Screen3.setEnabled(true);
		        Main.Game_Screen3.setFocusable(true);
		        Main.Game_Screen3.requestFocusInWindow();
			    Main.Game_Screen3.play();
			}
			else if(Main.Player1.progress == 4)
			{
				Main.mainFrame.add(Main.Game_Screen4);
			    Main.Game_Screen4.setVisible(true);
	     	    Main.Game_Screen4.setEnabled(true);
		        Main.Game_Screen4.setFocusable(true);
		        Main.Game_Screen4.requestFocusInWindow();
			    Main.Game_Screen4.play();
			}
			else if(Main.Player1.progress == 5)
			{
				Main.mainFrame.add(Main.Game_Screen5);
			    Main.Game_Screen5.setVisible(true);
	     	    Main.Game_Screen5.setEnabled(true);
		        Main.Game_Screen5.setFocusable(true);
		        Main.Game_Screen5.requestFocusInWindow();
			    Main.Game_Screen5.play();
			}
		}
		//Alex Banke: Pops up the confirmation menu to make sure the user wants to buy the upgrade.
		else if(eventId == 9 || eventId == 10 || eventId == 11)
		{
			Main.ShipShopWeaponsMenu.setVisible(false);
			Main.ShipShopWeaponsMenu.setEnabled(false);
			Main.ShipShopWeaponsMenu.setFocusable(false);
			Main.mainFrame.add(Main.Ship_Shop_Weapon_Confirmation);
			Main.Ship_Shop_Weapon_Confirmation.setLocation(265,200);
			
			Main.Ship_Shop_Weapon_Confirmation.setVisible(true);
			Main.Ship_Shop_Weapon_Confirmation.setEnabled(true);
			Main.Ship_Shop_Weapon_Confirmation.setFocusable(true);
			Main.Ship_Shop_Weapon_Confirmation.requestFocusInWindow();
			
			
		}	
		
		
	}
}
