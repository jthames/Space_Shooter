/**************************************************************************
***************************************************************************
* 	
*     ============    Team 2  -  Project 6: Space Shooter    ============
*     	
*	FILE NAME: ShipShopHullsKeyAdapter.java
*	AUTHOR(S): Alexander Banke,Thaddeus Latsa
*	DATE OF FIRST VERSION: 11/01/2012
*	DATE LAST MODIFIED: 11/30/2012
*	UNIT TESTING COMPLETED: Yes
*	STATUS OF UNIT TESTING: No Problems
*	INTEGRATION TESTING COMPLETED: Yes
*	PURPOSE OF FILE IN THE SYSTEM: This file enables the movement in the 
*   Ship Shop Hulls menu
***************************************************************************
**************************************************************************/
package Orions_War.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

public class ShipShopHullsKeyAdapter extends KeyAdapter
{
   //Alex Banke: For information on how this class works please
   // see ShipshopWeaponsKeyAdapter.
	
	private ShipShopHullsMenu ShipShopHullsMenu;
	
	public ShipShopHullsKeyAdapter(ShipShopHullsMenu ShipShopHullsMenu)
	{
		this.ShipShopHullsMenu = ShipShopHullsMenu;
	}
	
	public void keyPressed(KeyEvent e)
	{
		int keycode = e.getKeyCode();
		
		System.out.println("key pressed: ");
		
		switch(keycode)
		{
		case KeyEvent.VK_UP:
			System.out.println("up");
			Sounds.move.play();
			ShipShopHullsMenu.moveSelectionOvalUp();
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("down");
			Sounds.move.play();
			ShipShopHullsMenu.moveSelectionOvalDown();
			break;
		case KeyEvent.VK_LEFT:
			System.out.println("left");
			Sounds.move.play();
			ShipShopHullsMenu.moveSelectionOvalLeft();
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("right");
			Sounds.move.play();
			ShipShopHullsMenu.moveSelectionOvalRight();
			break;
		case KeyEvent.VK_ENTER:
			System.out.println("enter");
			System.out.println(ShipShopHullsMenu.getSelection());
			Sounds.select.play();
			try {
				ShipShopHullsMenuEventHandler.handleEvent(ShipShopHullsMenu.getSelection());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		}
	}
	
}
