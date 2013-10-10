/**************************************************************************
***************************************************************************
* 	
*     ============    Team 2  -  Project 6: Space Shooter    ============
*     	
*	FILE NAME:  ShipShopMenu.java
*	AUTHOR(S): Alexander Banke
*	DATE OF FIRST VERSION: 11/01/2012
*	DATE LAST MODIFIED: 11/01/2012
*	UNIT TESTING COMPLETED: Yes
*	STATUS OF UNIT TESTING: No Problems
*	INTEGRATION TESTING COMPLETED: Yes
*	PURPOSE OF FILE IN THE SYSTEM: This file changes the display of the ship shop
***************************************************************************
**************************************************************************/

package Orions_War.main;

import java.awt.Color; 
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.image.BufferedImage;
import java.io.IOException;



@SuppressWarnings("serial")
public class ShipShopMenu extends JPanel 
{
	//Alex Banke: Sets up the selction oval and the colors of the graphics used.
	
	private static Color backgroundColor = Color.black;
	private static Color textColor = Color.white;
	private static Dimension windowSize = new Dimension(1000,804);
	private static int selectionOvalWidth = 12;
	private static int selectionOvalHeight = 12;
	private static int selectionOvalX = 210;
	private static int selectionOvalY = 3;
	private Image img;

	
	public ShipShopMenu()
	{
	    //Alex Banke: Sets the background to be black so it blends with the background
		// of the ship shop 
		this.setBackground(backgroundColor);
       //Alex Banke: Gets the image used for the background, and sets up movement ability for the shop
        ImageIcon icon = new ImageIcon("images/Ship_Shop/Ship_ShopMenu_Main.png");
		img = icon.getImage();
		this.setSize(windowSize);
		this.addKeyListener(new ShipShopMenuKeyAdapter(this));
		//Alex Banke: Grabs the players current ship they own.
		Main.Player1.set_current_ship_image();
		
		this.setLayout(null);

	}
	
	public void paintComponent(Graphics g)
    {
		
		//Alex Banke: The next 16 lines set up the display of the ship shop
		// They display the users current: score, credits, level they are on, weapon damage,
		// Acceleration, Max_Speed, Health and current Ship they own.
		g.setColor(backgroundColor);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(img, 0, 0, 1000,800, this);
		g.setColor(textColor);
		g.setFont(new Font("Serif",Font.PLAIN,36));
		g.drawString("$"+ Main.Player1.credits,250, 575);
		g.drawString(""+ Main.Player1.score, 10, 300);
		g.setFont(new Font("Serif",Font.PLAIN,60));
		g.drawString(""+ Main.Player1.progress, 100, 415);
		g.setFont(new Font("Serif",Font.PLAIN,20));
		g.drawString(""+ Main.Player1.Ship.current_max_speed,900,425);
		g.drawString(""+ Main.Player1.Ship.current_health,900,447);
		g.drawString(""+ Main.Player1.Ship.current_acceleration,900,470);
		g.drawString(""+ Main.Player1.Ship.current_damage,900,494);
		
		g.drawImage(Main.Player1.ship,780,550, (Main.Player1.ship.getWidth()), (Main.Player1.ship.getHeight()),this);
		g.drawOval(selectionOvalX, selectionOvalY, selectionOvalHeight, selectionOvalWidth);
	
	
    }

    //Alex Banke: Moves the selector up until it hits the top choice
	// and then moves down to the bottom choice
	public void moveSelectionOvalUp()
	{
		if(selectionOvalY == 3)
		{
			selectionOvalY = 147;
			repaint();
			return;
		}
		else 
     	selectionOvalY -= 24;
	    repaint();
     		
     	}
	//Alex Banke: Works like SelecitonOvalUp but in reverse
	public void moveSelectionOvalDown()
	{
		if(selectionOvalY == 147)
		{
			selectionOvalY = 3;
			repaint();
			return;
		}
		else
			selectionOvalY +=24;
		repaint();
			
	}
	//Alex Banke: Grabs the users selection
	public int getSelection()
	{
		if(selectionOvalY == 3) 
			return 1;
		else if(selectionOvalY == 27)
            return 2;
		else if(selectionOvalY == 51) 
			return 3;
		else if(selectionOvalY == 75) 
			return 4;
		else if(selectionOvalY == 99) 
			return 5;
		else if(selectionOvalY == 123) 
			return 6;
		else if(selectionOvalY == 147) 
			return 7;
		else
		return 0;
	}
}
