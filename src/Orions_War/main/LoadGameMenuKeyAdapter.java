/**************************************************************************
 ***************************************************************************
 * 	
 *     ============    Team 2  -  Project 6: Space Shooter    ============
 *     	
 *	FILE NAME: LoadGameMenuKeyAdapter.java
 *	AUTHOR(S): Christopher Margol
 *	DATE OF FIRST VERSION: 11/01/2012
 *	DATE LAST MODIFIED: 11/01/2012
 *	UNIT TESTING COMPLETED: Yes
 *	STATUS OF UNIT TESTING: No Problems
 *	INTEGRATION TESTING COMPLETED: Yes
 *	PURPOSE OF FILE IN THE SYSTEM: This file enables us to deal with
 *   everything used for switching to the load game menu
 *
 ***************************************************************************
 **************************************************************************/
package Orions_War.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

public class LoadGameMenuKeyAdapter extends KeyAdapter
{
	private LoadGameMenu loadGameMenu;
	
	public LoadGameMenuKeyAdapter(LoadGameMenu loadGameMenu)
	{
		this.loadGameMenu = loadGameMenu;
	}
	
	public void keyPressed(KeyEvent e)
	{
		int keycode = e.getKeyCode();
		
		System.out.println("key pressed: ");
		
		switch(keycode)
		{
		case KeyEvent.VK_UP:
			System.out.println("up");
			LoadGameMenu.selector.moveUp();
			loadGameMenu.repaint();
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("down");
			LoadGameMenu.selector.moveDown();
			loadGameMenu.repaint();
			break;
		case KeyEvent.VK_ENTER:
			System.out.println("enter");
			System.out.println(loadGameMenu.getSelection());
			Sounds.select.play();
			try {
				LoadGameMenuEventHandler.handleEvent(loadGameMenu.getSelection());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		}
	}
	
	
}