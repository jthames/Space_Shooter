/**************************************************************************
 ***************************************************************************
 * 	
 *     ============    Team 2  -  Project 6: Space Shooter    ============
 *     	
 *	FILE NAME: NewGameMenuKeyAdapter.java
 *	AUTHOR(S): Christopher Margol
 *	DATE OF FIRST VERSION: 11/01/2012
 *	DATE LAST MODIFIED: 11/01/2012
 *	UNIT TESTING COMPLETED: Yes
 *	STATUS OF UNIT TESTING: No Problems
 *	INTEGRATION TESTING COMPLETED: Yes
 *	PURPOSE OF FILE IN THE SYSTEM: This file enables us to deal with
 *   everything used for handling key for a new game
 *
 ***************************************************************************
 **************************************************************************/
package Orions_War.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

public class NewGameMenuKeyAdapter extends KeyAdapter
{
	private NewGameMenu newGameMenu;
	
	public NewGameMenuKeyAdapter(NewGameMenu newGameMenu)
	{
		this.newGameMenu = newGameMenu;
	}
	
	public void keyPressed(KeyEvent e)
	{
		int keycode = e.getKeyCode();
		
		System.out.println("key pressed: ");
		
		switch(keycode)
		{
		case KeyEvent.VK_UP:
			System.out.println("up");
			NewGameMenu.selector.moveUp();
			newGameMenu.repaint();
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("down");
			NewGameMenu.selector.moveDown();
			newGameMenu.repaint();
			break;
		case KeyEvent.VK_ENTER:
			System.out.println("enter");
			Sounds.select.play();
			System.out.println(newGameMenu.getSelection());
			try {
				NewGameMenuEventHandler.handleEvent(newGameMenu.getSelection());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		}
	}
	
	
}