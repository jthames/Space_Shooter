package Orions_War.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HighScoreMenuKeyAdapter extends KeyAdapter
{
	private HighScoreMenu highScoreMenu;
	
	public HighScoreMenuKeyAdapter(HighScoreMenu highScoreMenu)
	{
		this.highScoreMenu = highScoreMenu;
	}
	
	public void keyPressed(KeyEvent e)
	{
		int keycode = e.getKeyCode();
		
		System.out.println("key pressed: ");
		
		switch(keycode)
		{
		case KeyEvent.VK_UP:
			System.out.println("up");
			HighScoreMenu.selector.moveUp();
			highScoreMenu.repaint();
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("down");
			HighScoreMenu.selector.moveDown();
			highScoreMenu.repaint();
			break;
		case KeyEvent.VK_ENTER:
			System.out.println("enter");
			System.out.println(highScoreMenu.getSelection());
			Sounds.select.play();
			HighScoreMenuEventHandler.handleEvent(highScoreMenu.getSelection());
			break;
		}
	}
	
	
}