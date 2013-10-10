
/**************************************************************************
***************************************************************************
* 	
*     ============    Team 2  -  Project 6: Space Shooter    ============
*     	
*	FILE NAME: Ship_Shop_Weapon_Confirmation_MenuEventHandler.java
*	AUTHOR(S): Alexander Banke
*	DATE OF FIRST VERSION: 11/01/2012
*	DATE LAST MODIFIED: 11/01/2012
*	UNIT TESTING COMPLETED: Yes
*	STATUS OF UNIT TESTING: No Problems
*	INTEGRATION TESTING COMPLETED: Yes
*	PURPOSE OF FILE IN THE SYSTEM: This file enables us to buy and equip
*   Weapons to the user
*
***************************************************************************
**************************************************************************/

package Orions_War.main;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class Ship_Shop_Weapon_Confirmation_MenuEventHandler
{
   //Alex Banke: If you have questions on how this class works
   // see the comments in Ship_Shop_Engines_Confirmation_MenuEventHandler
   // it is the same functionality except with Weapons
	
	
	public static void handleEvent(int eventId)
	{
		
		if(eventId == 1)
		{
			Main.Ship_Shop_Weapon_Confirmation.setVisible(false);
			Main.Ship_Shop_Weapon_Confirmation.setEnabled(false);
			Main.Ship_Shop_Weapon_Confirmation.setFocusable(false);
			Main.mainFrame.remove(Main.Ship_Shop_Weapon_Confirmation);
			if(Main.ShipShopWeaponsMenu.selectionOvalX == 340)
			{
				Main.Player1.Ship.Ship_Weapon.update_purhcased_Weapons(0);
				Main.Player1.credits -= Main.Player1.Ship.Ship_Weapon.Weapon_Cost.get(0);
				Main.Player1.Ship.update_parts();
				Main.Player1.set_current_ship_image();
			}
			else if(Main.ShipShopWeaponsMenu.selectionOvalX == 540)
			{
				Main.Player1.Ship.Ship_Weapon.update_purhcased_Weapons(1);
				Main.Player1.credits -= Main.Player1.Ship.Ship_Weapon.Weapon_Cost.get(1);
				Main.Player1.Ship.update_parts();
				Main.Player1.set_current_ship_image();
			}
			else if(Main.ShipShopWeaponsMenu.selectionOvalX == 740)
			{
				Main.Player1.Ship.Ship_Weapon.update_purhcased_Weapons(2);
				Main.Player1.credits -= Main.Player1.Ship.Ship_Weapon.Weapon_Cost.get(2);
				Main.Player1.Ship.update_parts();
				Main.Player1.set_current_ship_image();
			}
			
			
			
			Main.mainFrame.add(Main.ShipShopWeaponsMenu);
			Main.ShipShopWeaponsMenu.setVisible(true);
			Main.ShipShopWeaponsMenu.setEnabled(true);
			Main.ShipShopWeaponsMenu.setFocusable(true);
			Main.ShipShopWeaponsMenu.requestFocusInWindow();
		}
		else if(eventId == 2)
		{
			Main.Ship_Shop_Weapon_Confirmation.setVisible(false);
			Main.Ship_Shop_Weapon_Confirmation.setEnabled(false);
			Main.Ship_Shop_Weapon_Confirmation.setFocusable(false);
			Main.mainFrame.remove(Main.Ship_Shop_Weapon_Confirmation);
			
			Main.mainFrame.add(Main.ShipShopWeaponsMenu);
			Main.ShipShopWeaponsMenu.setVisible(true);
			Main.ShipShopWeaponsMenu.setEnabled(true);
			Main.ShipShopWeaponsMenu.setFocusable(true);
			Main.ShipShopWeaponsMenu.requestFocusInWindow();
		}
		else if(eventId == 3)
		{
			Main.Ship_Shop_Weapon_Confirmation.setVisible(false);
			Main.Ship_Shop_Weapon_Confirmation.setEnabled(false);
			Main.Ship_Shop_Weapon_Confirmation.setFocusable(false);
			Main.mainFrame.remove(Main.Ship_Shop_Weapon_Confirmation);
			if(Main.ShipShopWeaponsMenu.selectionOvalX == 340)
			{
				Main.Player1.Ship.Ship_Weapon.update_equipped_Weapon(0);
				Main.Player1.Ship.update_parts();
				Main.Player1.set_current_ship_image();
			}
			else if(Main.ShipShopWeaponsMenu.selectionOvalX == 540)
			{
				Main.Player1.Ship.Ship_Weapon.update_equipped_Weapon(1);
				Main.Player1.Ship.update_parts();
				Main.Player1.set_current_ship_image();
			}
			else if(Main.ShipShopWeaponsMenu.selectionOvalX == 740)
			{
				Main.Player1.Ship.Ship_Weapon.update_equipped_Weapon(2);
				Main.Player1.Ship.update_parts();
				Main.Player1.set_current_ship_image();
			}

			Main.mainFrame.add(Main.ShipShopWeaponsMenu);
			Main.ShipShopWeaponsMenu.setVisible(true);
			Main.ShipShopWeaponsMenu.setEnabled(true);
			Main.ShipShopWeaponsMenu.setFocusable(true);
			Main.ShipShopWeaponsMenu.requestFocusInWindow();
		}
	}
}