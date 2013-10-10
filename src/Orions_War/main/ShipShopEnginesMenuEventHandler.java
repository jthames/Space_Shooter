/**************************************************************************
***************************************************************************
* 	
*     ============    Team 2  -  Project 6: Space Shooter    ============
*     	
*	FILE NAME: ShipShopEnginesMenuEventHandler.java
*	AUTHOR(S): Alexander Banke
*	DATE OF FIRST VERSION: 11/01/2012
*	DATE LAST MODIFIED: 11/01/2012
*	UNIT TESTING COMPLETED: Yes
*	STATUS OF UNIT TESTING: No Problems
*	INTEGRATION TESTING COMPLETED: Yes
*	PURPOSE OF FILE IN THE SYSTEM: This file changes the screen from 
*   Ship Shop Engines to another screen selected by the user.
***************************************************************************
**************************************************************************/

package Orions_War.main;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;



public class ShipShopEnginesMenuEventHandler
{
    // Alex Banke: For information on this class
	// see the comments in ShipShopThrustersMenuEventHandler
	// it has the same functionality but with Engines.
	public static void handleEvent(int eventId) throws FileNotFoundException
	{
		
		if(eventId == 1)
		{
			System.out.println("Exit Ship Shop Engines menu to Main Ship Shop Menu selected");
			Main.ShipShopEnginesMenu.setVisible(false);
			Main.ShipShopEnginesMenu.setEnabled(false);
			Main.ShipShopEnginesMenu.setFocusable(false);
			
			Main.mainFrame.remove(Main.ShipShopEnginesMenu);
			
			Main.mainFrame.add(Main.ShipShopMenu);
		   
			Main.ShipShopMenu.setVisible(true);
			Main.ShipShopMenu.setEnabled(true);
			Main.ShipShopMenu.setFocusable(true);
			Main.ShipShopMenu.requestFocusInWindow();
		}
		
		// Do nothing because same screen selected
		else if(eventId == 2)
		{
		
		}
		
		else if(eventId == 3)
		{
			System.out.println("Exit Ship Shop Engines menu to Hulls Ship Shop Menu selected");
			Main.ShipShopEnginesMenu.setVisible(false);
			Main.ShipShopEnginesMenu.setEnabled(false);
			Main.ShipShopEnginesMenu.setFocusable(false);
			
			Main.mainFrame.remove(Main.ShipShopEnginesMenu);
			
			Main.mainFrame.add(Main.ShipShopHullsMenu);
		   
			Main.ShipShopHullsMenu.setVisible(true);
			Main.ShipShopHullsMenu.setEnabled(true);
			Main.ShipShopHullsMenu.setFocusable(true);
			Main.ShipShopHullsMenu.requestFocusInWindow();
		}
		
		else if(eventId == 4)
		{
			System.out.println("Exit Ship Shop Engines menu to Thrusters Ship Shop Menu selected");
			Main.ShipShopEnginesMenu.setVisible(false);
			Main.ShipShopEnginesMenu.setEnabled(false);
			Main.ShipShopEnginesMenu.setFocusable(false);
			
			Main.mainFrame.remove(Main.ShipShopEnginesMenu);
			
			Main.mainFrame.add(Main.ShipShopThrustersMenu);
		   
			Main.ShipShopThrustersMenu.setVisible(true);
			Main.ShipShopThrustersMenu.setEnabled(true);
			Main.ShipShopThrustersMenu.setFocusable(true);
			Main.ShipShopThrustersMenu.requestFocusInWindow();
		}
		else if(eventId == 5)
		{
			System.out.println("Exit Ship Shop Engines menu to Weapons Ship Shop Menu selected");
			Main.ShipShopEnginesMenu.setVisible(false);
			Main.ShipShopEnginesMenu.setEnabled(false);
			Main.ShipShopEnginesMenu.setFocusable(false);
			
			Main.mainFrame.remove(Main.ShipShopEnginesMenu);
			
			Main.mainFrame.add(Main.ShipShopWeaponsMenu);
		   
			Main.ShipShopWeaponsMenu.setVisible(true);
			Main.ShipShopWeaponsMenu.setEnabled(true);
			Main.ShipShopWeaponsMenu.setFocusable(true);
			Main.ShipShopWeaponsMenu.requestFocusInWindow();
		}
		else if(eventId == 6)
		{
			Save_Confirmation_PopUp_MenuEventHandler.menu_choice = 1;
			Main.ShipShopEnginesMenu.setVisible(false);
			Main.ShipShopEnginesMenu.setEnabled(false);
			Main.ShipShopEnginesMenu.setFocusable(false);
			Main.mainFrame.remove(Main.ShipShopEnginesMenu);
			
			Main.mainFrame.add(Main.Save_Confirmation_PopUp);
			Main.Save_Confirmation_PopUp.setVisible(true);
			Main.Save_Confirmation_PopUp.setEnabled(true);
			Main.Save_Confirmation_PopUp.setFocusable(true);
			Main.Save_Confirmation_PopUp.requestFocusInWindow();
		}
		else if(eventId == 7)
		{
			System.out.println("Exit Ship Shop Engines menu to Next Level selected");
			Main.ShipShopEnginesMenu.setVisible(false);
			Main.ShipShopEnginesMenu.setEnabled(false);
			Main.ShipShopEnginesMenu.setFocusable(false);
			
			Main.mainFrame.remove(Main.ShipShopEnginesMenu);
			
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
		else if(eventId == 8)
		{
			System.out.println("Exit Ship Shop Engines menu to Main Menu selected");
			Main.ShipShopEnginesMenu.setVisible(false);
			Main.ShipShopEnginesMenu.setEnabled(false);
			Main.ShipShopEnginesMenu.setFocusable(false);
			
			Main.mainFrame.remove(Main.ShipShopEnginesMenu);
			
			Main.mainFrame.add(Main.mainMenu);
		   
			Main.mainMenu.setVisible(true);
			Main.mainMenu.setEnabled(true);
			Main.mainMenu.setFocusable(true);
			Main.mainMenu.requestFocusInWindow();
			
		}
		else if(eventId == 9 || eventId == 10 || eventId == 11)
		{
			Main.ShipShopEnginesMenu.setVisible(false);
			Main.ShipShopEnginesMenu.setEnabled(false);
			Main.ShipShopEnginesMenu.setFocusable(false);
			Main.mainFrame.add(Main.Ship_Shop_Engine_Confirmation);
			Main.Ship_Shop_Engine_Confirmation.setLocation(265,200);
			
			Main.Ship_Shop_Engine_Confirmation.setVisible(true);
			Main.Ship_Shop_Engine_Confirmation.setEnabled(true);
			Main.Ship_Shop_Engine_Confirmation.setFocusable(true);
			Main.Ship_Shop_Engine_Confirmation.requestFocusInWindow();
			
			
		}	
		
		
	}
}
