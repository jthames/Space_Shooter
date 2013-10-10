/**************************************************************************
***************************************************************************
* 	
*     ============    Team 2  -  Project 6: Space Shooter    ============
*     	
*	FILE NAME: Ship_Shop_Hull_Confirmation.java
*	AUTHOR(S): Alexander Banke
*	DATE OF FIRST VERSION: 11/01/2012
*	DATE LAST MODIFIED: 11/01/2012
*	UNIT TESTING COMPLETED: Yes
*	STATUS OF UNIT TESTING: No Problems
*	INTEGRATION TESTING COMPLETED: Yes
*	PURPOSE OF FILE IN THE SYSTEM: This file enables the user to confirm
*   they want to purchase or equip an Thruster
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

public class Ship_Shop_Hull_Confirmation extends JPanel 
{
	// Alex Banke: for information on this class please see Ship_Shop_Engine_Confirmation
	// for the comments listed in their, it is the exact same minus this one being for Hulls
	private static Dimension windowSize = new Dimension(600,300);
	
	//TODO: make the selectionOval its own class
	private static int selectionOvalWidth = 20;
	private static int selectionOvalHeight = 20;
	private static int selectionOvalX = 355;
	private static int selectionOvalY = 450;


    	
	
	public Ship_Shop_Hull_Confirmation()
	{
		System.out.println("Ship Shop Hulls Confirmation menu created");
        this.setSize(windowSize);
		
		
		this.addKeyListener(new Ship_Shop_Hull_Confirmation_KeyAdapter(this));
		
		this.setLayout(null);

	}
	public void paintComponent(Graphics g)
    {
		BufferedImage spriteSheet = null,Hull;
    	BufferedImageLoader loader = new BufferedImageLoader();
    	try {
			spriteSheet = loader.loadImage("images/Ship_Shop/shipshopparts.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// the following two lines are needed because calling the paint overrides the background color
		this.setBackground(Color.black);
		g.fillRect(265, 200, 600, 300);
		g.setColor(Color.white);
	
		if(Main.ShipShopHullsMenu.selectionOvalX == 340)
		{
		  Hull = spriteSheet.getSubimage(121, 0, 15, 35);
	      g.drawImage(Hull,515, 250, 60, 140,this);
	      if(Main.Player1.Ship.Ship_Hull.check_purchased_Hulls(0) == 1)
	     	{
	    	  g.setFont(new Font("Serif",Font.PLAIN,48));
			  g.drawString("Equip This Hull?",400,235);
			  g.setFont(new Font("Serif",Font.PLAIN,25));
	    	  g.drawString("Equip Part", 315, 494);
			}
		  else
		  {
		    g.setFont(new Font("Serif",Font.PLAIN,48));
			g.drawString("Confirm Your Hull Purchase",265,235);
			g.setFont(new Font("Serif",Font.PLAIN,25));
		    g.drawString("Buy and Equip Part", 265, 494);
		  }
		  }
		else if(Main.ShipShopHullsMenu.selectionOvalX == 540)
		{ 
			if(Main.Player1.Ship.Ship_Hull.check_purchased_Hulls(1) == 1)
	     	{
				  g.setFont(new Font("Serif",Font.PLAIN,48));
				  g.drawString("Equip This Hull?",400,235);
				  g.setFont(new Font("Serif",Font.PLAIN,25));
		    	  g.drawString("Equip Part", 315, 494);
			}
		   else
		   {
			    g.setFont(new Font("Serif",Font.PLAIN,48));
				g.drawString("Confirm Your Hull Purchase",265,235);
				g.setFont(new Font("Serif",Font.PLAIN,25));
			    g.drawString("Buy and Equip Part", 265, 494);
			  }
			Hull = spriteSheet.getSubimage(142, 0, 15, 35);
	      g.drawImage(Hull,500, 250, 60, 140,this);
		
		}
		else if(Main.ShipShopHullsMenu.selectionOvalX == 740)
		{ 
			if(Main.Player1.Ship.Ship_Hull.check_purchased_Hulls(2) == 1)
	     	{
				  g.setFont(new Font("Serif",Font.PLAIN,48));
				  g.drawString("Equip This Hull?",400,235);
				  g.setFont(new Font("Serif",Font.PLAIN,25));
		    	  g.drawString("Equip Part", 315, 494);
			}
		   else
		   {
			    g.setFont(new Font("Serif",Font.PLAIN,48));
				g.drawString("Confirm Your Hull Purchase",265,235);
				g.setFont(new Font("Serif",Font.PLAIN,25));
			    g.drawString("Buy and Equip Part", 265, 494);
			  }
			Hull = spriteSheet.getSubimage(158, 0, 15, 35);
	        g.drawImage(Hull,515, 250, 60, 140,this);
		
		}
		
		g.drawString("Cancel",750, 494);
		
	    g.drawOval(selectionOvalX, selectionOvalY, selectionOvalHeight, selectionOvalWidth);
	
        
    }
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
		
	public int getSelection()
	{
		if(Main.ShipShopHullsMenu.selectionOvalX == 340)
		 { 
			if(Main.Player1.Ship.Ship_Hull.check_purchased_Hulls(0) == 1)	
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
		else if(Main.ShipShopHullsMenu.selectionOvalX == 540)
		 { 
			if(Main.Player1.Ship.Ship_Hull.check_purchased_Hulls(1) == 1)	
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
	      if(Main.Player1.Ship.Ship_Hull.check_purchased_Hulls(2) == 1)	
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


