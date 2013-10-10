/**************************************************************************
***************************************************************************
* 	
*     ============    Team 2  -  Project 6: Space Shooter    ============
*     	
*	FILE NAME: ShipShopWeaponsKeyAdapter.java
*	AUTHOR(S): Alexander Banke,Thaddeus Latsa
*	DATE OF FIRST VERSION: 11/01/2012
*	DATE LAST MODIFIED: 11/30/2012
*	UNIT TESTING COMPLETED: Yes
*	STATUS OF UNIT TESTING: No Problems
*	INTEGRATION TESTING COMPLETED: Yes
*	PURPOSE OF FILE IN THE SYSTEM: This file enables the movement in the 
*   Ship Shop Weapons menu
***************************************************************************
**************************************************************************/
package Orions_War.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

public class ShipShopWeaponsKeyAdapter extends KeyAdapter
{
    private ShipShopWeaponsMenu ShipShopWeaponsMenu;
	
	public ShipShopWeaponsKeyAdapter(ShipShopWeaponsMenu ShipShopWeaponsMenu)
	{
		this.ShipShopWeaponsMenu = ShipShopWeaponsMenu;
	}
	
	public void keyPressed(KeyEvent e)
	{
		int keycode = e.getKeyCode();
		
		System.out.println("key pressed: ");
		
		switch(keycode)
		{
		case KeyEvent.VK_UP:
			System.out.println("up");
			//Thadd: Added sound when moving
			Sounds.move.play();
			ShipShopWeaponsMenu.moveSelectionOvalUp();
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("down");
			//Thadd: Added sound when moving
			Sounds.move.play();
			ShipShopWeaponsMenu.moveSelectionOvalDown();
			break;
		case KeyEvent.VK_LEFT:
			System.out.println("left");
			//Thadd: Added sound when moving
			Sounds.move.play();
			ShipShopWeaponsMenu.moveSelectionOvalLeft();
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("right");
			//Thadd: Added sound when moving
			Sounds.move.play();
			ShipShopWeaponsMenu.moveSelectionOvalRight();
			break;
		case KeyEvent.VK_ENTER:
			System.out.println("enter");
			System.out.println(ShipShopWeaponsMenu.getSelection());
			//Thadd: Added sound for pressing enter.
			Sounds.select.play();
			try {
				ShipShopWeaponsMenuEventHandler.handleEvent(ShipShopWeaponsMenu.getSelection());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		}
	}
	
}

