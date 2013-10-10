/**************************************************************************
***************************************************************************
* 	
*     ============    Team 2  -  Project 6: Space Shooter    ============
*     	
*	FILE NAME: Ship_Shop_Hull_Confirmation_KeyAdapter.java
*	AUTHOR(S): Alexander Banke, Thaddeus Latsa
*	DATE OF FIRST VERSION: 11/01/2012
*	DATE LAST MODIFIED: 11/30/2012
*	UNIT TESTING COMPLETED: Yes
*	STATUS OF UNIT TESTING: No Problems
*	INTEGRATION TESTING COMPLETED: Yes
*	PURPOSE OF FILE IN THE SYSTEM: This file allows the user to purchase
*   and equip Hulls to their ship.
***************************************************************************
**************************************************************************/

package Orions_War.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ship_Shop_Hull_Confirmation_KeyAdapter extends KeyAdapter
{
    private Ship_Shop_Hull_Confirmation Ship_Shop_Hull_Confirmation;
	
	public Ship_Shop_Hull_Confirmation_KeyAdapter(Ship_Shop_Hull_Confirmation Ship_Shop_Hull_Confirmation)
	{
		this.Ship_Shop_Hull_Confirmation = Ship_Shop_Hull_Confirmation;
	}
	
	public void keyPressed(KeyEvent e)
	{
		int keycode = e.getKeyCode();
		
		System.out.println("key pressed: ");
		
		switch(keycode)
		{
		
		case KeyEvent.VK_LEFT:
			System.out.println("left");
			Sounds.move.play();
			Ship_Shop_Hull_Confirmation.moveSelectionOvalLeft();
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("right");
			Sounds.move.play();
			Ship_Shop_Hull_Confirmation.moveSelectionOvalRight();
			break;
		case KeyEvent.VK_ENTER:
			System.out.println("enter");
			System.out.println(Ship_Shop_Hull_Confirmation.getSelection());
			Sounds.buy.play();
			Ship_Shop_Hull_Confirmation_MenuEventHandler.handleEvent(Ship_Shop_Hull_Confirmation.getSelection());
			break;
		}
	}
	
}