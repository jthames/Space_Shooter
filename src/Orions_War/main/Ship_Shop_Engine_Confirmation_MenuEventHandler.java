
/**************************************************************************
***************************************************************************
* 	
*     ============    Team 2  -  Project 6: Space Shooter    ============
*     	
*	FILE NAME: Asteroids.java
*	AUTHOR(S): Alexander Banke
*	DATE OF FIRST VERSION: 11/01/2012
*	DATE LAST MODIFIED: 11/30/2012
*	UNIT TESTING COMPLETED: Yes
*	STATUS OF UNIT TESTING: No Problems
*	INTEGRATION TESTING COMPLETED: Yes
*	PURPOSE OF FILE IN THE SYSTEM: This file enables us to buy and equip
*   engines to the user
*
***************************************************************************
**************************************************************************/
package Orions_War.main;


import javax.swing.JLabel;
import javax.swing.JPanel;



public class Ship_Shop_Engine_Confirmation_MenuEventHandler
{
    
	public static void handleEvent(int eventId)
	{
		//Alex Banke: Changes focus back to Engines Menu and purchases
		// the upgrade selected based on the SelectionOValX location
		if(eventId == 1)
		{
			Main.Ship_Shop_Engine_Confirmation.setVisible(false);
			Main.Ship_Shop_Engine_Confirmation.setEnabled(false);
			Main.Ship_Shop_Engine_Confirmation.setFocusable(false);
			Main.mainFrame.remove(Main.Ship_Shop_Engine_Confirmation);
			if(Main.ShipShopEnginesMenu.selectionOvalX == 340)
			{
				Main.Player1.Ship.Ship_Engine.update_purhcased_Engines(0);
				Main.Player1.credits -= Main.Player1.Ship.Ship_Engine.Engine_Cost.get(0);
				Main.Player1.Ship.update_parts();
				Main.Player1.set_current_ship_image();
			}
			else if(Main.ShipShopEnginesMenu.selectionOvalX == 540)
			{
				Main.Player1.Ship.Ship_Engine.update_purhcased_Engines(1);
				Main.Player1.credits -= Main.Player1.Ship.Ship_Engine.Engine_Cost.get(1);
				Main.Player1.Ship.update_parts();
				Main.Player1.set_current_ship_image();
			}
			else if(Main.ShipShopEnginesMenu.selectionOvalX == 740)
			{
				Main.Player1.Ship.Ship_Engine.update_purhcased_Engines(2);
				Main.Player1.credits -= Main.Player1.Ship.Ship_Engine.Engine_Cost.get(2);
				Main.Player1.Ship.update_parts();
				Main.Player1.set_current_ship_image();
			}
			
			
			
			Main.mainFrame.add(Main.ShipShopEnginesMenu);
			Main.ShipShopEnginesMenu.setVisible(true);
			Main.ShipShopEnginesMenu.setEnabled(true);
			Main.ShipShopEnginesMenu.setFocusable(true);
			Main.ShipShopEnginesMenu.requestFocusInWindow();
		}
		//Alex Banke: Changes focus back to Engines Menu
		else if(eventId == 2)
		{
			Main.Ship_Shop_Engine_Confirmation.setVisible(false);
			Main.Ship_Shop_Engine_Confirmation.setEnabled(false);
			Main.Ship_Shop_Engine_Confirmation.setFocusable(false);
			Main.mainFrame.remove(Main.Ship_Shop_Engine_Confirmation);
			
			Main.mainFrame.add(Main.ShipShopEnginesMenu);
			Main.ShipShopEnginesMenu.setVisible(true);
			Main.ShipShopEnginesMenu.setEnabled(true);
			Main.ShipShopEnginesMenu.setFocusable(true);
			Main.ShipShopEnginesMenu.requestFocusInWindow();
		}
		//Alex Banke: Changes focus back to Engines Menu, and equips the upgrade selected
		// by the user
		else if(eventId == 3)
		{
			Main.Ship_Shop_Engine_Confirmation.setVisible(false);
			Main.Ship_Shop_Engine_Confirmation.setEnabled(false);
			Main.Ship_Shop_Engine_Confirmation.setFocusable(false);
			Main.mainFrame.remove(Main.Ship_Shop_Engine_Confirmation);
			if(Main.ShipShopEnginesMenu.selectionOvalX == 340)
			{
				Main.Player1.Ship.Ship_Engine.update_equipped_engine(0);
				Main.Player1.Ship.update_parts();
				Main.Player1.set_current_ship_image();
			}
			else if(Main.ShipShopEnginesMenu.selectionOvalX == 540)
			{
				Main.Player1.Ship.Ship_Engine.update_equipped_engine(1);
				Main.Player1.Ship.update_parts();
				Main.Player1.set_current_ship_image();
			}
			else if(Main.ShipShopEnginesMenu.selectionOvalX == 740)
			{
				Main.Player1.Ship.Ship_Engine.update_equipped_engine(2);
				Main.Player1.Ship.update_parts();
				Main.Player1.set_current_ship_image();
			}

			Main.mainFrame.add(Main.ShipShopEnginesMenu);
			Main.ShipShopEnginesMenu.setVisible(true);
			Main.ShipShopEnginesMenu.setEnabled(true);
			Main.ShipShopEnginesMenu.setFocusable(true);
			Main.ShipShopEnginesMenu.requestFocusInWindow();
		}
	}
}