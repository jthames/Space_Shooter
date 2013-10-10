/**************************************************************************
***************************************************************************
* 	
*     ============    Team 2  -  Project 6: Space Shooter    ============
*     	
*	FILE NAME: Ship_Shop_Engine_Confirmation.java
*	AUTHOR(S): Alexander Banke
*	DATE OF FIRST VERSION: 11/01/2012
*	DATE LAST MODIFIED: 11/01/2012
*	UNIT TESTING COMPLETED: Yes
*	STATUS OF UNIT TESTING: No Problems
*	INTEGRATION TESTING COMPLETED: Yes
*	PURPOSE OF FILE IN THE SYSTEM: This file enables the user to confirm
*   they want to purchase or equip an Engine
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

public class Ship_Shop_Engine_Confirmation extends JPanel 
{

	private static Dimension windowSize = new Dimension(600,300);

	private static int selectionOvalWidth = 20;
	private static int selectionOvalHeight = 20;
	private static int selectionOvalX = 355;
	private static int selectionOvalY = 450;


    	
	
	public Ship_Shop_Engine_Confirmation()
	{
	    // Alex Banke: Sets up the window for the menu, and the ability to make choices
        this.setSize(windowSize);
		this.addKeyListener(new Ship_Shop_Engine_Confirmation_KeyAdapter(this));
		this.setLayout(null);

	}
	public void paintComponent(Graphics g)
    {
		// Alex Banke: Creates Buffered images that will display the engine upgrade
		// the user wants to buy or equip
		BufferedImage spriteSheet = null,engine;
    	BufferedImageLoader loader = new BufferedImageLoader();
    	try {
			spriteSheet = loader.loadImage("images/Ship_Shop/shipshopparts.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		this.setBackground(Color.black);
		g.fillRect(265, 200, 600, 300);
		g.setColor(Color.white);
	    // Alex Banke: The program first checks to see what upgrade the user wants to confirm
		// buying, grabs the image and then checks if the user has already purchased the engine or not
		// this way the correct text of equipping or purchasing is displayed.
		if(Main.ShipShopEnginesMenu.selectionOvalX == 340)
		{
		  engine = spriteSheet.getSubimage(80, 4, 19, 30);
	      g.drawImage(engine,515, 250, 76, 120,this);
	      if(Main.Player1.Ship.Ship_Engine.check_purchased_engines(0) == 1)
	     	{
	    	  g.setFont(new Font("Serif",Font.PLAIN,48));
			  g.drawString("Equip This Engine?",400,235);
			  g.setFont(new Font("Serif",Font.PLAIN,25));
	    	  g.drawString("Equip Part", 315, 494);
			}
		  else
		  {
		    g.setFont(new Font("Serif",Font.PLAIN,48));
			g.drawString("Confirm Your Engine Purchase",265,235);
			g.setFont(new Font("Serif",Font.PLAIN,25));
		    g.drawString("Buy and Equip Part", 265, 494);
		  }
		  }
		else if(Main.ShipShopEnginesMenu.selectionOvalX == 540)
		{ 
			if(Main.Player1.Ship.Ship_Engine.check_purchased_engines(1) == 1)
	     	{
				  g.setFont(new Font("Serif",Font.PLAIN,48));
				  g.drawString("Equip This Engine?",400,235);
				  g.setFont(new Font("Serif",Font.PLAIN,25));
		    	  g.drawString("Equip Part", 315, 494);
			}
		   else
		   {
			    g.setFont(new Font("Serif",Font.PLAIN,48));
				g.drawString("Confirm Your Engine Purchase",265,235);
				g.setFont(new Font("Serif",Font.PLAIN,25));
			    g.drawString("Buy and Equip Part", 265, 494);
			  }
			engine = spriteSheet.getSubimage(46, 5, 25, 29);
	      g.drawImage(engine,500, 250, 100, 116,this);
		
		}
		else if(Main.ShipShopEnginesMenu.selectionOvalX == 740)
		{ 
			if(Main.Player1.Ship.Ship_Engine.check_purchased_engines(2) == 1)
	     	{
				  g.setFont(new Font("Serif",Font.PLAIN,48));
				  g.drawString("Equip This Engine?",400,235);
				  g.setFont(new Font("Serif",Font.PLAIN,25));
		    	  g.drawString("Equip Part", 315, 494);
			}
		   else
		   {
			    g.setFont(new Font("Serif",Font.PLAIN,48));
				g.drawString("Confirm Your Engine Purchase",265,235);
				g.setFont(new Font("Serif",Font.PLAIN,25));
			    g.drawString("Buy and Equip Part", 265, 494);
			  }
			engine = spriteSheet.getSubimage(2, 5, 26, 30);
	        g.drawImage(engine,515, 250, 104, 120,this);
		
		}
		
		g.drawString("Cancel",750, 494);
		
	    g.drawOval(selectionOvalX, selectionOvalY, selectionOvalHeight, selectionOvalWidth);
	
        
    }
	
	// Alex Banke: Moves the oval till the right most option and then moves it to the leftmost option
	public void moveSelectionOvalRight()
	{
       if(selectionOvalX == 773)
		{
		 selectionOvalX = 355;
		 repaint();
		 return;
		}
	   else
		selectionOvalX += 418;
		repaint();
	}	
	// Alex Banke: Moves the oval till the left most option and then moves it to the rightmost option
	public void moveSelectionOvalLeft()
	{
		if(selectionOvalX == 355)
		  {
			selectionOvalX = 773;
			repaint();
			return;
	      }
	    else
		selectionOvalX -= 418;
			 repaint();
	}	
		// Alex Banke: In a confirmation menu, get selection works similar to getSelection in a normal menu
	    // however, it has to take into thought of whether or not the User has already purchased that upgrade or not
	    // so it must check first.
	public int getSelection()
	{
		if(Main.ShipShopEnginesMenu.selectionOvalX == 340)
		 { 
			if(Main.Player1.Ship.Ship_Engine.check_purchased_engines(0) == 1)	
			 {
				if(selectionOvalX == 355) 		 
			     return 3;
		        else if(selectionOvalX == 773)
                 return 2;
		        else
		        return 0;
			 }
			else
			{
				if(selectionOvalX == 355) 		 
				     return 1;
			    else if(selectionOvalX == 773)
	                 return 2;
			        else
			        return 0;
			}
		 }
		else if(Main.ShipShopEnginesMenu.selectionOvalX == 540)
		 { 
			if(Main.Player1.Ship.Ship_Engine.check_purchased_engines(1) == 1)	
			 {
				if(selectionOvalX == 355) 		 
			     return 3;
		        else if(selectionOvalX == 773)
                return 2;
		        else
		        return 0;
			 }
			else
			{
				if(selectionOvalX == 355) 		 
				     return 1;
			        else if(selectionOvalX == 773)
	                 return 2;
			        else
			        return 0;
			}
		 }
		else
		{
	      if(Main.Player1.Ship.Ship_Engine.check_purchased_engines(2) == 1)	
		    {
			  if(selectionOvalX == 355) 		 
				return 3;
			  else if(selectionOvalX == 773)
	            return 2;
			  else
			    return 0;
		     }
		  else
			{
			  if(selectionOvalX == 355) 		 
			     return 1;
			  else if(selectionOvalX == 773)
		         return 2;
		      else
				 return 0;
				}
			 }
		}
	}


