/**************************************************************************
 ***************************************************************************
 * 	
 *     ============    Team 2  -  Project 6: Space Shooter    ============
 *     	
 *	FILE NAME: Credits_MenuKeyAdapter.java
 *	AUTHOR(S): Christopher Margol
 *	DATE OF FIRST VERSION: 11/01/2012
 *	DATE LAST MODIFIED: 11/01/2012
 *	UNIT TESTING COMPLETED: Yes
 *	STATUS OF UNIT TESTING: No Problems
 *	INTEGRATION TESTING COMPLETED: Yes
 *	PURPOSE OF FILE IN THE SYSTEM: This file enables us to deal with
 *   everything used keys for credit screen
 *
 ***************************************************************************
 **************************************************************************/
package Orions_War.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Credits_MenuKeyAdapter extends KeyAdapter
{
	private Credits_Menu Credits_Menu;
	
	public Credits_MenuKeyAdapter(Credits_Menu Credits_Menu)
	{
		this.Credits_Menu = Credits_Menu;
	}
	
	public void keyPressed(KeyEvent e)
	{
		int keycode = e.getKeyCode();
		
		System.out.println("key pressed: ");
		
		switch(keycode)
		{
		case KeyEvent.VK_ENTER:
			System.out.println("enter");
			System.out.println(Credits_Menu.getSelection());
			Sounds.select.play();
			Credits_MenuEventHandler.handleEvent(Credits_Menu.getSelection());
			break;
		}
	}
	
	
}