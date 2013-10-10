/**************************************************************************
 ***************************************************************************
 * 	
 *     ============    Team 2  -  Project 6: Space Shooter    ============
 *     	
 *	FILE NAME: MainMenu.java
 *	AUTHOR(S): Christopher Margol
 *	DATE OF FIRST VERSION: 11/01/2012
 *	DATE LAST MODIFIED: 11/01/2012
 *	UNIT TESTING COMPLETED: Yes
 *	STATUS OF UNIT TESTING: No Problems
 *	INTEGRATION TESTING COMPLETED: Yes
 *	PURPOSE OF FILE IN THE SYSTEM: This file enables us to deal with
 *   everything used for handling all the menu options
 *
 ***************************************************************************
 **************************************************************************/
package Orions_War.main;

import java.awt.Color; 
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
import java.awt.Image;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class MainMenu extends JPanel 
{

	private static Color backgroundColor = Color.black;
	private static Color textColor = Color.white;
	
	private static String title = "Orion's War - isShotAlive?";

	private static String newGame = "Start New Game";
	private static String loadGame = "Load Game";
	private static String highScores = "Check High Scores";
	private static String ShipShop = "Visit Ship Shop";
	private static String exit = "Exit";

	private static Dimension windowSize = new Dimension(1000,800);
	
	private Image img2;
	
	public static SelectionOval selector = new SelectionOval(40,94,94,134,20);
	
	public MainMenu()
	{
		System.out.println("gameloop created");
		
		ImageIcon icon = new ImageIcon("images/spacebackgrouBIG.png");
		
		img2 = icon.getImage();
		
		this.setOpaque(true);
		this.setVisible(true);
		this.setFocusable(true);
		this.addKeyListener(new MainMenuKeyAdapter(this));
		
		//added so that manual position of JComponents would be feasible
		this.setLayout(null);
	}
	
	public void paintComponent(Graphics g)
    {
       // This line is needed for the use of the background. If you plan on changing the background
	   // speak to Alex before you do.
		
		g.drawImage(img2, 0, 0, 1000,800, this);
		g.setColor(textColor);
		
		selector.drawSelector(g);
		
		g.drawString(title, 50, 50);
		
		g.drawString(newGame, 50, 100);
		g.drawString(loadGame, 50, 120);
		g.drawString(exit, 50, 140);
    }

	/* elseif(selectionOvalY == 174) return 5; added to compensate for adding in the view ship shop option
	 * returning 5 will now exit the screen.
	 * 
	 */
	public int getSelection()
	{
		if(selector.getY() == 94) return 1;
		else if(selector.getY() == 114) return 2;
		else if(selector.getY() == 134) return 3;
		
		return 0;
	}
}
