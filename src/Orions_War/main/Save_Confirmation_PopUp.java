/**************************************************************************
 ***************************************************************************
 * 	
 *     ============    Team 2  -  Project 6: Space Shooter    ============
 *     	
 *	FILE NAME: Weapon_Upgrades.java
 *	AUTHOR(S): Christopher Margol
 *	DATE OF FIRST VERSION: 11/01/2012
 *	DATE LAST MODIFIED: 11/01/2012
 *	UNIT TESTING COMPLETED: Yes
 *	STATUS OF UNIT TESTING: No Problems
 *	INTEGRATION TESTING COMPLETED: Yes
 *	PURPOSE OF FILE IN THE SYSTEM: File purpose to save any new user 
 *   
 *
 ***************************************************************************
 **************************************************************************/
package Orions_War.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Save_Confirmation_PopUp extends JPanel 
{

	private static Dimension windowSize = new Dimension(600,300);
	
	//TODO: make the selectionOval its own class
	private static int selectionOvalWidth = 20;
	private static int selectionOvalHeight = 20;
	private static int selectionOvalX = 564;
	private static int selectionOvalY = 450;


    	
	
	public Save_Confirmation_PopUp()
	{
		System.out.println("Save Confirmation menu created");
        this.setSize(windowSize);
		
		
		this.addKeyListener(new Save_Confirmation_PopUp_KeyAdapter(this));
		
		this.setLayout(null);

	}
	public void paintComponent(Graphics g)
    {	
    	
		// the following two lines are needed because calling the paint overrides the background color
		this.setBackground(Color.black);
		g.fillRect(265, 200, 600, 300);
		g.setColor(Color.white);
		g.setFont(new Font("Serif",Font.PLAIN,48));
		g.drawString("Your Game Has Been Saved", 290, 250);
		g.setFont(new Font("Serif",Font.PLAIN,36));
		g.drawString("Confirm", 515, 435);
	    g.drawOval(selectionOvalX, selectionOvalY, selectionOvalHeight, selectionOvalWidth);
	
        
    }
	
		
	public int getSelection()
	{
	
		if(selectionOvalX == 564) 		 
		   return 1;
		else
		   return 0;
	}
	}