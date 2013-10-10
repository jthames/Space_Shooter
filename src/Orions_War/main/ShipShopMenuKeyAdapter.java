/**************************************************************************
***************************************************************************
* 	
*     ============    Team 2  -  Project 6: Space Shooter    ============
*     	
*	FILE NAME: ShipShopMenuKeyAdapter.java
*	AUTHOR(S): Alexander Banke, Thaddeus Latsa
*	DATE OF FIRST VERSION: 11/01/2012
*	DATE LAST MODIFIED: 11/30/2012
*	UNIT TESTING COMPLETED: Yes
*	STATUS OF UNIT TESTING: No Problems
*	INTEGRATION TESTING COMPLETED: Yes
*	PURPOSE OF FILE IN THE SYSTEM: This file enables us to move around in the Ship_Shop_Menu
*
***************************************************************************
**************************************************************************/
package Orions_War.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

public class ShipShopMenuKeyAdapter extends KeyAdapter
{
	private ShipShopMenu ShipShopMenu;
	
	public ShipShopMenuKeyAdapter(ShipShopMenu ShipShopMenu)
	{
		this.ShipShopMenu = ShipShopMenu;
	}
	//Alex Banke: Checks to see what key the user pressed so the selection oval moves.
	public void keyPressed(KeyEvent e)
	{
		int keycode = e.getKeyCode();
		
		System.out.println("key pressed: ");
		
		switch(keycode)
		{
		case KeyEvent.VK_UP:
			System.out.println("up");
			Sounds.move.play();
			ShipShopMenu.moveSelectionOvalUp();
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("down");
			Sounds.move.play();
			ShipShopMenu.moveSelectionOvalDown();
			break;
		case KeyEvent.VK_ENTER:
			System.out.println("enter");
			System.out.println(ShipShopMenu.getSelection());
			//Thadd: Added sound for pressing enter
			Sounds.select.play();
			try {
				ShipShopMenuEventHandler.handleEvent(ShipShopMenu.getSelection());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			break;
		}
	}
	
	
}