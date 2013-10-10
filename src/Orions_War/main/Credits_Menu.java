/**************************************************************************
 ***************************************************************************
 * 	
 *     ============    Team 2  -  Project 6: Space Shooter    ============
 *     	
 *	FILE NAME: Credits_Menu.java
 *	AUTHOR(S): Christopher Margol
 *	DATE OF FIRST VERSION: 11/01/2012
 *	DATE LAST MODIFIED: 11/01/2012
 *	UNIT TESTING COMPLETED: Yes
 *	STATUS OF UNIT TESTING: No Problems
 *	INTEGRATION TESTING COMPLETED: Yes
 *	PURPOSE OF FILE IN THE SYSTEM: This file enables us to deal with
 *   everything used for credit menu
 *
 ***************************************************************************
 **************************************************************************/
package Orions_War.main;

import java.awt.Color; 
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class Credits_Menu extends JPanel 
{
	private static Color backgroundColor = Color.black;
	private static Color textColor = Color.white;
	

	
	public Credits_Menu()
	{
		System.out.println("high score menu created");
		
		this.setBackground(backgroundColor);
		this.setSize(new Dimension(1000,800));
		this.setOpaque(true);

		this.addKeyListener(new Credits_MenuKeyAdapter(this));
		
		//added so that manual position of JComponents would be feasible
		this.setLayout(null);

	}
	

	
	
	public void paintComponent(Graphics g)
    {

		// the following two lines are needed because calling the paint overrides the background color
		
		ImageIcon icon = new ImageIcon("images/credits.png");
		Image img1 = icon.getImage();
		
		g.setColor(backgroundColor);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());		
		g.setColor(textColor);
        g.drawImage(img1,0,0,1000,800,this);
        //IMPORTANT: PLACEHOLDERS!!
		
    }
	
	public int getSelection()
	{
		return 0;
	}
}