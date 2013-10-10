/**************************************************************************
 ***************************************************************************
 * 	
 *     ============    Team 2  -  Project 6: Space Shooter    ============
 *     	
 *	FILE NAME: MainMenuKeyAdapter.java
 *	AUTHOR(S): Christopher Margol
 *	DATE OF FIRST VERSION: 11/01/2012
 *	DATE LAST MODIFIED: 11/01/2012
 *	UNIT TESTING COMPLETED: Yes
 *	STATUS OF UNIT TESTING: No Problems
 *	INTEGRATION TESTING COMPLETED: Yes
 *	PURPOSE OF FILE IN THE SYSTEM: This file enables us to deal with
 *   everything used for handling the keys pressed on main menu
 *
 ***************************************************************************
 **************************************************************************/
package Orions_War.main;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainMenuKeyAdapter extends KeyAdapter
{
	private MainMenu menu;
	
	public MainMenuKeyAdapter(MainMenu mainMenu)
	{
		this.menu = mainMenu;
	}
	
	public void keyPressed(KeyEvent e)
	{
		int keycode = e.getKeyCode();
		
		System.out.println("key pressed: ");
		
		switch(keycode)
		{
		case KeyEvent.VK_UP:
			System.out.println("up");
			MainMenu.selector.moveUp();
			menu.repaint();
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("down");
			MainMenu.selector.moveDown();
			menu.repaint();
			break;
		case KeyEvent.VK_ENTER:
			System.out.println("enter");
			System.out.println(menu.getSelection());
			Sounds.select.play();
			MenuEventHandler.handleEvent(menu.getSelection());
			break;
		}
	}
	
	
}