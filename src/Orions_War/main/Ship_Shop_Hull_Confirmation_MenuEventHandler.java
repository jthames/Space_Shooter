/**************************************************************************
***************************************************************************
* 	
*     ============    Team 2  -  Project 6: Space Shooter    ============
*     	
*	FILE NAME: Ship_Shop_Hull_Confirmation_MenuEventHandler.java
*	AUTHOR(S): Alexander Banke
*	DATE OF FIRST VERSION: 11/01/2012
*	DATE LAST MODIFIED: 11/01/2012
*	UNIT TESTING COMPLETED: Yes
*	STATUS OF UNIT TESTING: No Problems
*	INTEGRATION TESTING COMPLETED: Yes
*	PURPOSE OF FILE IN THE SYSTEM: This file enables us to buy and equip
*   Hulls to the user
*
***************************************************************************
**************************************************************************/

package Orions_War.main;

import javax.swing.JLabel;
import javax.swing.JPanel;



public class Ship_Shop_Hull_Confirmation_MenuEventHandler
{
	//Alex Banke: If you have questions on how this class works
	   // see the comments in Ship_Shop_Engines_Confirmation_MenuEventHandler
	   // it is the same functionality except with Hulls
	public static void handleEvent(int eventId)
	{

		if(eventId == 1)
		{
			Main.Ship_Shop_Hull_Confirmation.setVisible(false);
			Main.Ship_Shop_Hull_Confirmation.setEnabled(false);
			Main.Ship_Shop_Hull_Confirmation.setFocusable(false);
			Main.mainFrame.remove(Main.Ship_Shop_Hull_Confirmation);
			if(Main.ShipShopHullsMenu.selectionOvalX == 340)
			{
				Main.Player1.Ship.Ship_Hull.update_purhcased_Hulls(0);
				Main.Player1.credits -= Main.Player1.Ship.Ship_Hull.Hull_Cost.get(0);
				Main.Player1.Ship.update_parts();
				Main.Player1.set_current_ship_image();
			}
			else if(Main.ShipShopHullsMenu.selectionOvalX == 540)
			{
				Main.Player1.Ship.Ship_Hull.update_purhcased_Hulls(1);
				Main.Player1.credits -= Main.Player1.Ship.Ship_Hull.Hull_Cost.get(1);
				Main.Player1.Ship.update_parts();
				Main.Player1.set_current_ship_image();
			}
			else if(Main.ShipShopHullsMenu.selectionOvalX == 740)
			{
				Main.Player1.Ship.Ship_Hull.update_purhcased_Hulls(2);
				Main.Player1.credits -= Main.Player1.Ship.Ship_Hull.Hull_Cost.get(2);
				Main.Player1.Ship.update_parts();
				Main.Player1.set_current_ship_image();
			}
			
			
			
			Main.mainFrame.add(Main.ShipShopHullsMenu);
			Main.ShipShopHullsMenu.setVisible(true);
			Main.ShipShopHullsMenu.setEnabled(true);
			Main.ShipShopHullsMenu.setFocusable(true);
			Main.ShipShopHullsMenu.requestFocusInWindow();
		}
		else if(eventId == 2)
		{
			Main.Ship_Shop_Hull_Confirmation.setVisible(false);
			Main.Ship_Shop_Hull_Confirmation.setEnabled(false);
			Main.Ship_Shop_Hull_Confirmation.setFocusable(false);
			Main.mainFrame.remove(Main.Ship_Shop_Hull_Confirmation);
			
			Main.mainFrame.add(Main.ShipShopHullsMenu);
			Main.ShipShopHullsMenu.setVisible(true);
			Main.ShipShopHullsMenu.setEnabled(true);
			Main.ShipShopHullsMenu.setFocusable(true);
			Main.ShipShopHullsMenu.requestFocusInWindow();
		}
		else if(eventId == 3)
		{
			Main.Ship_Shop_Hull_Confirmation.setVisible(false);
			Main.Ship_Shop_Hull_Confirmation.setEnabled(false);
			Main.Ship_Shop_Hull_Confirmation.setFocusable(false);
			Main.mainFrame.remove(Main.Ship_Shop_Hull_Confirmation);
			if(Main.ShipShopHullsMenu.selectionOvalX == 340)
			{
				Main.Player1.Ship.Ship_Hull.update_equipped_Hull(0);
				Main.Player1.Ship.update_parts();
				Main.Player1.set_current_ship_image();
			}
			else if(Main.ShipShopHullsMenu.selectionOvalX == 540)
			{
				Main.Player1.Ship.Ship_Hull.update_equipped_Hull(1);
				Main.Player1.Ship.update_parts();
				Main.Player1.set_current_ship_image();
			}
			else if(Main.ShipShopHullsMenu.selectionOvalX == 740)
			{
				Main.Player1.Ship.Ship_Hull.update_equipped_Hull(2);
				Main.Player1.Ship.update_parts();
				Main.Player1.set_current_ship_image();
			}

			Main.mainFrame.add(Main.ShipShopHullsMenu);
			Main.ShipShopHullsMenu.setVisible(true);
			Main.ShipShopHullsMenu.setEnabled(true);
			Main.ShipShopHullsMenu.setFocusable(true);
			Main.ShipShopHullsMenu.requestFocusInWindow();
		}
	}
}