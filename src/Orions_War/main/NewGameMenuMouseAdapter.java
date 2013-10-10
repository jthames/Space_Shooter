/**************************************************************************
 ***************************************************************************
 * 	
 *     ============    Team 2  -  Project 6: Space Shooter    ============
 *     	
 *	FILE NAME: NewGameMenuMouseAdapter.java
 *	AUTHOR(S): Christopher Margol
 *	DATE OF FIRST VERSION: 11/01/2012
 *	DATE LAST MODIFIED: 11/01/2012
 *	UNIT TESTING COMPLETED: Yes
 *	STATUS OF UNIT TESTING: No Problems
 *	INTEGRATION TESTING COMPLETED: Yes
 *	PURPOSE OF FILE IN THE SYSTEM: This file enables us to deal with
 *   everything used the mouse on the main screen
 *
 ***************************************************************************
 **************************************************************************/
package Orions_War.main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NewGameMenuMouseAdapter extends MouseAdapter
{
	private NewGameMenu newGameMenu;
	
	public NewGameMenuMouseAdapter(NewGameMenu newGameMenu)
	{
		this.newGameMenu = newGameMenu;
	}
	
	public void mousePressed(MouseEvent e)
	{
		System.out.println("mouse pressed");
		newGameMenu.requestFocusInWindow();
	}
}
