/**************************************************************************
 ***************************************************************************
 * 	
 *     ============    Team 2  -  Project 6: Space Shooter    ============
 *     	
 *	FILE NAME: Save_Confirmation_PopUp_KeyAdapter.java
 *	AUTHOR(S): Christopher Margol
 *	DATE OF FIRST VERSION: 11/01/2012
 *	DATE LAST MODIFIED: 11/01/2012
 *	UNIT TESTING COMPLETED: Yes
 *	STATUS OF UNIT TESTING: No Problems
 *	INTEGRATION TESTING COMPLETED: Yes
 *	PURPOSE OF FILE IN THE SYSTEM: This file enables us to deal with
 *   keys pressed in the save confirmation screen
 *
 ***************************************************************************
 **************************************************************************/
package Orions_War.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;


//Uses Key Adapter in order to listen for keys
public class Save_Confirmation_PopUp_KeyAdapter extends KeyAdapter
{
    private Save_Confirmation_PopUp Save_Confirmation_PopUp;
	
	public Save_Confirmation_PopUp_KeyAdapter(Save_Confirmation_PopUp Save_Confirmation_PopUp)
	{
		this.Save_Confirmation_PopUp = Save_Confirmation_PopUp;
	}
	
	public void keyPressed(KeyEvent e)
	{
		int keycode = e.getKeyCode();
		
		System.out.println("key pressed: ");
		
		switch(keycode)
		{
		
		case KeyEvent.VK_ENTER:
			System.out.println("enter");
			System.out.println(Save_Confirmation_PopUp.getSelection());
			Sounds.select.play();
			try {
				Save_Confirmation_PopUp_MenuEventHandler.handleEvent(Save_Confirmation_PopUp.getSelection());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		}
	}
	
}