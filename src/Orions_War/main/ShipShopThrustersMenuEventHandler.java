/**************************************************************************
***************************************************************************
* 	
*     ============    Team 2  -  Project 6: Space Shooter    ============
*     	
*	FILE NAME: ShipShopThrustersMenuEventHandler.java
*	AUTHOR(S): Alexander Banke
*	DATE OF FIRST VERSION: 11/01/2012
*	DATE LAST MODIFIED: 11/01/2012
*	UNIT TESTING COMPLETED: Yes
*	STATUS OF UNIT TESTING: No Problems
*	INTEGRATION TESTING COMPLETED: Yes
*	PURPOSE OF FILE IN THE SYSTEM: This file changes the screen from 
*   Ship Shop Thrusters to another screen selected by the user.
***************************************************************************
**************************************************************************/
package Orions_War.main;

import java.io.FileNotFoundException;
import java.util.ArrayList;



public class ShipShopThrustersMenuEventHandler
{

	public static void handleEvent(int eventId) throws FileNotFoundException
	{
		//Alex Banke: Switches to Ship Shop Main Menu
		if(eventId == 1)
		{
			System.out.println("Exit Ship Shop Thrusters to Main Ship Shop Menu selected");
			Main.ShipShopThrustersMenu.setVisible(false);
			Main.ShipShopThrustersMenu.setEnabled(false);
			Main.ShipShopThrustersMenu.setFocusable(false);
			
			Main.mainFrame.remove(Main.ShipShopThrustersMenu);
			
			Main.mainFrame.add(Main.ShipShopMenu);
		   
			Main.ShipShopMenu.setVisible(true);
			Main.ShipShopMenu.setEnabled(true);
			Main.ShipShopMenu.setFocusable(true);
			Main.ShipShopMenu.requestFocusInWindow();
		}
		
		//Alex Banke: Switches to the engines portion
		else if(eventId == 2)
		{
			System.out.println("Exit Ship Shop Thrusters to Thrusters Ship Shop Menu selected");
			Main.ShipShopThrustersMenu.setVisible(false);
			Main.ShipShopThrustersMenu.setEnabled(false);
			Main.ShipShopThrustersMenu.setFocusable(false);
			
			Main.mainFrame.remove(Main.ShipShopThrustersMenu);
			
			Main.mainFrame.add(Main.ShipShopEnginesMenu);
		   
			Main.ShipShopEnginesMenu.setVisible(true);
			Main.ShipShopEnginesMenu.setEnabled(true);
			Main.ShipShopEnginesMenu.setFocusable(true);
			Main.ShipShopEnginesMenu.requestFocusInWindow();
		}
		//Alex Banke: Switches to the hulls portion
		else if(eventId == 3)
		{
			System.out.println("Exit Ship Shop Thrusters to Hulls Ship Shop Menu selected");
			Main.ShipShopThrustersMenu.setVisible(false);
			Main.ShipShopThrustersMenu.setEnabled(false);
			Main.ShipShopThrustersMenu.setFocusable(false);
			
			Main.mainFrame.remove(Main.ShipShopThrustersMenu);
			
			Main.mainFrame.add(Main.ShipShopHullsMenu);
		   
			Main.ShipShopHullsMenu.setVisible(true);
			Main.ShipShopHullsMenu.setEnabled(true);
			Main.ShipShopHullsMenu.setFocusable(true);
			Main.ShipShopHullsMenu.requestFocusInWindow();
		}
		//Alex Banke: Do nothing same menu selected
		else if(eventId == 4)
		{
			
		}
		//Alex Banke: Switch to Weapons Menu
		else if(eventId == 5)
		{
			System.out.println("Exit Ship Shop Thrusters to Weapons Ship Shop Menu selected");
			Main.ShipShopThrustersMenu.setVisible(false);
			Main.ShipShopThrustersMenu.setEnabled(false);
			Main.ShipShopThrustersMenu.setFocusable(false);
			
			Main.mainFrame.remove(Main.ShipShopThrustersMenu);
			
			Main.mainFrame.add(Main.ShipShopWeaponsMenu);
		   
			Main.ShipShopWeaponsMenu.setVisible(true);
			Main.ShipShopWeaponsMenu.setEnabled(true);
			Main.ShipShopWeaponsMenu.setFocusable(true);
			Main.ShipShopWeaponsMenu.requestFocusInWindow();
		}
		//Alex Banke: Popup the save confirmation to let the user know their
		// game has been saved
		else if(eventId == 6)
		{
			Save_Confirmation_PopUp_MenuEventHandler.menu_choice = 2;
			Main.ShipShopThrustersMenu.setVisible(false);
			Main.ShipShopThrustersMenu.setEnabled(false);
			Main.ShipShopThrustersMenu.setFocusable(false);
			Main.mainFrame.remove(Main.ShipShopThrustersMenu);
			
			Main.mainFrame.add(Main.Save_Confirmation_PopUp);
			Main.Save_Confirmation_PopUp.setVisible(true);
			Main.Save_Confirmation_PopUp.setEnabled(true);
			Main.Save_Confirmation_PopUp.setFocusable(true);
			Main.Save_Confirmation_PopUp.requestFocusInWindow();	
		}
		//Alex Banke: Checks the users progress in the game and then plays the level
		// theyre on
		else if(eventId == 7)
		{
			System.out.println("Exit Ship Shop Thrusters to Next Level selected");
			Main.ShipShopThrustersMenu.setVisible(false);
			Main.ShipShopThrustersMenu.setEnabled(false);
			Main.ShipShopThrustersMenu.setFocusable(false);
			
			Main.mainFrame.remove(Main.ShipShopThrustersMenu);
		
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
		//Alex Banke: Popsup the option to buy their selection
		else if(eventId == 9 || eventId == 10 || eventId == 11)
		{
			Main.ShipShopThrustersMenu.setVisible(false);
			Main.ShipShopThrustersMenu.setEnabled(false);
			Main.ShipShopThrustersMenu.setFocusable(false);
			Main.mainFrame.add(Main.Ship_Shop_Thruster_Confirmation);
			Main.Ship_Shop_Thruster_Confirmation.setLocation(265,200);
			
			Main.Ship_Shop_Thruster_Confirmation.setVisible(true);
			Main.Ship_Shop_Thruster_Confirmation.setEnabled(true);
			Main.Ship_Shop_Thruster_Confirmation.setFocusable(true);
			Main.Ship_Shop_Thruster_Confirmation.requestFocusInWindow();
			
			
		}	
		
	}
}
