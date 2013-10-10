/**************************************************************************
***************************************************************************
* 	
*     ============    Team 2  -  Project 6: Space Shooter    ============
*     	
*	FILE NAME: ShipSHopHullsMenu.java
*	AUTHOR(S): Alexander Banke
*	DATE OF FIRST VERSION: 11/01/2012
*	DATE LAST MODIFIED: 11/01/2012
*	UNIT TESTING COMPLETED: Yes
*	STATUS OF UNIT TESTING: No Problems
*	INTEGRATION TESTING COMPLETED: Yes
*	PURPOSE OF FILE IN THE SYSTEM: This file enables the visualization of the Hull
*   portion of the ship shop
*
***************************************************************************
**************************************************************************/

package Orions_War.main;

import java.awt.Color; 
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;


import javax.swing.JPanel;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;


@SuppressWarnings("serial")
public class ShipShopHullsMenu extends JPanel
{


	private static Dimension windowSize = new Dimension(1000,804);
	
	//TODO: make the selectionOval its own class
	private static int selectionOvalWidth = 12;
	private static int selectionOvalHeight = 12;
	public static int selectionOvalX = 210;
	public static int selectionOvalY = 3;
	private Image img;

    	
	
	public ShipShopHullsMenu()
	{
		//Alex Banke: If you have any questions on how this class works
		// Look at the comments in ShipShopWeaponsMenu everything is
		// mirrored and done the same way except with Hulls
		
		
		System.out.println("Ship Shop Engines menu created");
		
		
        ImageIcon icon = new ImageIcon("images/Ship_Shop/Ship_ShopMenu_Hull.png");
		
		img = icon.getImage();
		/*this.setSize(windowSize);
		this.setOpaque(true);
		this.setVisible(true);
		this.setFocusable(true);
		*/
		this.addKeyListener(new ShipShopHullsKeyAdapter(this));
		
		//added so that manual position of JComponents would be feasible
		//this.setLayout(null);

	}
	public void paintComponent(Graphics g)
    {

		BufferedImage spriteSheet = null,Hull1,Hull2,Hull3;
    	BufferedImageLoader loader = new BufferedImageLoader();
    	try {
			spriteSheet = loader.loadImage("images/Ship_Shop/shipshopparts.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// the following two lines are needed because calling the paint overrides the background color
		g.drawRect(0, 0, 1000, 800);
		
		g.drawImage(img, 0, 0,1000,800, this);
		g.setColor(Color.white);
		g.setFont(new Font("Serif",Font.PLAIN,36));
		g.drawString("$"+ Main.Player1.credits,250, 575);
		g.drawString(""+ Main.Player1.score, 10, 275);
		g.setFont(new Font("Serif",Font.PLAIN,60));
		g.drawString(""+ Main.Player1.progress, 100, 385);
		g.setFont(new Font("Serif",Font.PLAIN,20));
		g.drawString(""+ Main.Player1.Ship.current_health,860,640);
		g.setFont(new Font("Courier",Font.PLAIN,20));
		g.drawString("Level 1 Upgrade",275,300);
		g.drawString("Level 2 Upgrade",475,300);
		g.drawString("Level 3 Upgrade",675,300);
		g.setFont(new Font("Courier",Font.PLAIN,35));
		g.drawString("Select your Hull Upgrade", 300, 250);
		Hull1 = spriteSheet.getSubimage(121, 0, 15, 35);
        g.drawImage(Hull1,330, 300, 45, 105,this);
        Hull2 = spriteSheet.getSubimage(142, 0, 15, 35);
        g.drawImage(Hull2, 530, 300, 45, 105,this);
        Hull3 = spriteSheet.getSubimage(158, 0, 15, 35);        
        g.drawImage(Hull3, 730, 300, 45, 105,this);
        g.setColor(Color.white);
		g.drawOval(selectionOvalX, selectionOvalY, selectionOvalHeight, selectionOvalWidth);
	
        if(selectionOvalX == 340)
        {
        	g.setColor(Color.white);
    		g.setFont(new Font("Serif",Font.PLAIN,36));
        	g.drawString("$"+Main.Player1.Ship.Ship_Hull.Hull_Cost.get(0),250,650);
        	g.setFont(new Font("Serif",Font.PLAIN,20));
        	g.drawString(""+(Main.Player1.Ship.Ship_Hull.Health.get(0)+100),860, 683);
        	
        	if(Main.Player1.Ship.Ship_Hull.check_purchased_Hulls(0) == 1)
        	{
        		g.setFont(new Font("Serif",Font.PLAIN,24));	
    		    g.drawString("Upgrade Purchased",200,710);
    		    if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 0)
    		    {
    		    	g.drawString("Upgrade Equipped",200,750);
    		    }
    		    else 
    		    	g.drawString("Upgrade Unequipped",200, 750);
        	}
    		else
    		{

        	if(Main.Player1.Ship.Ship_Hull.Hull_Cost.get(0) < Main.Player1.credits)
        	{
        		g.setColor(Color.green);
        		g.setFont(new Font("Serif",Font.PLAIN,36));
        		g.drawString("$" + (Main.Player1.credits - Main.Player1.Ship.Ship_Hull.Hull_Cost.get(0)),250,725);
        	}
        	else if(Main.Player1.Ship.Ship_Hull.Hull_Cost.get(0) > Main.Player1.credits)
        	{
        		g.setColor(Color.red);
        		g.setFont(new Font("Serif",Font.PLAIN,36));
        		g.drawString("$" + (Main.Player1.credits - Main.Player1.Ship.Ship_Hull.Hull_Cost.get(0)),250,725);
        	}
        	else if(Main.Player1.Ship.Ship_Hull.Hull_Cost.get(0) == Main.Player1.credits)
        	{
        		g.setColor(Color.white);
        		g.setFont(new Font("Serif",Font.PLAIN,36));
        		g.drawString("$0",250,725);
        	}
    		}
        	
        	if((Main.Player1.Ship.Ship_Hull.Health.get(0)+100) > Main.Player1.Ship.current_health)
        	{
        		g.setColor(Color.green);
        		g.setFont(new Font("Serif",Font.PLAIN,20));
        		g.drawString("+ " +((Main.Player1.Ship.Ship_Hull.Health.get(0)+100) - Main.Player1.Ship.current_health), 845, 730);
        	}
        	else if((Main.Player1.Ship.Ship_Hull.Health.get(0)+100)  < Main.Player1.Ship.current_health)
        	{
        		g.setColor(Color.red);
        		g.setFont(new Font("Serif",Font.PLAIN,20));
        		g.drawString("- " + -1 *((Main.Player1.Ship.Ship_Hull.Health.get(0)+100) - Main.Player1.Ship.current_health), 845, 730);
        	}
        	else if((Main.Player1.Ship.Ship_Hull.Health.get(0)+100) == Main.Player1.Ship.current_health)
        	{
        		g.setColor(Color.white);
        		g.setFont(new Font("Serif",Font.PLAIN,20));
        		g.drawString("0", 860, 730);
        	}
        }
        else if(selectionOvalX == 540)
        {
        	g.setColor(Color.white);
    		g.setFont(new Font("Serif",Font.PLAIN,36));
        	g.drawString("$"+Main.Player1.Ship.Ship_Hull.Hull_Cost.get(1),250,650);
        	g.setFont(new Font("Serif",Font.PLAIN,20));
        	g.drawString(""+(Main.Player1.Ship.Ship_Hull.Health.get(1) + 100), 860, 683);
        	
        	if(Main.Player1.Ship.Ship_Hull.check_purchased_Hulls(1) == 1)
        	{
        		g.setFont(new Font("Serif",Font.PLAIN,24));	
    		    g.drawString("Upgrade Purchased",200,710);
    		    if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 1)
    		    {
    		    	g.drawString("Upgrade Equipped",200,750);
    		    }
    		    else 
    		    	g.drawString("Upgrade Unequipped",200, 750);
        	}
    		else
    		{
        	
        	if((Main.Player1.Ship.Ship_Hull.Hull_Cost.get(1)) < Main.Player1.credits)
        	{
        		g.setColor(Color.green);
        		g.setFont(new Font("Serif",Font.PLAIN,36));
        		g.drawString("$" + (Main.Player1.credits - Main.Player1.Ship.Ship_Hull.Hull_Cost.get(1)),250,725);
        	}
        	else if(Main.Player1.Ship.Ship_Hull.Hull_Cost.get(1) > Main.Player1.credits)
        	{
        		g.setColor(Color.red);
        		g.setFont(new Font("Serif",Font.PLAIN,36));
        		g.drawString("$" + (Main.Player1.credits - Main.Player1.Ship.Ship_Hull.Hull_Cost.get(1)),250,725);
        	}
        	else if(Main.Player1.Ship.Ship_Hull.Hull_Cost.get(1) == Main.Player1.credits)
        	{
        		g.setColor(Color.white);
        		g.setFont(new Font("Serif",Font.PLAIN,36));
        		g.drawString("$0",250,725);
        	}
    		
    		}
        	if((Main.Player1.Ship.Ship_Hull.Health.get(1)+100) > Main.Player1.Ship.current_health)
        	{
        		g.setColor(Color.green);
        		g.setFont(new Font("Serif",Font.PLAIN,20));
        		g.drawString("+ " +((Main.Player1.Ship.Ship_Hull.Health.get(1) + 100) - Main.Player1.Ship.current_health), 845, 730);
        	}
        	else if((Main.Player1.Ship.Ship_Hull.Health.get(1) + 100) < Main.Player1.Ship.current_health)
        	{
        		g.setColor(Color.red);
        		g.setFont(new Font("Serif",Font.PLAIN,20));
        		g.drawString("- " + -1 *((Main.Player1.Ship.Ship_Hull.Health.get(1) + 100) - Main.Player1.Ship.current_health), 845, 730);
        	}
        	else if((Main.Player1.Ship.Ship_Hull.Health.get(1)+100) == Main.Player1.Ship.current_health)
        	{
        		g.setColor(Color.white);
        		g.setFont(new Font("Serif",Font.PLAIN,20));
        		g.drawString("0", 860, 730);
        	}
        }
        else if(selectionOvalX == 740)
        {
        	g.setColor(Color.white);
    		g.setFont(new Font("Serif",Font.PLAIN,36));
        	g.drawString("$"+Main.Player1.Ship.Ship_Hull.Hull_Cost.get(2),250,650);
        	g.setFont(new Font("Serif",Font.PLAIN,20));
        	g.drawString(""+(Main.Player1.Ship.Ship_Hull.Health.get(2) + 100), 860, 683);
        	
        	if(Main.Player1.Ship.Ship_Hull.check_purchased_Hulls(2) == 1)
        	{
        		g.setFont(new Font("Serif",Font.PLAIN,24));	
    		    g.drawString("Upgrade Purchased",200,710);
    		    if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 2)
    		    {
    		    	g.drawString("Upgrade Equipped",200,750);
    		    }
    		    else 
    		    	g.drawString("Upgrade Unequipped",200, 750);
        	}
    		else
    		{
    		 if(Main.Player1.Ship.Ship_Hull.Hull_Cost.get(2) < Main.Player1.credits)
        	{
        		g.setColor(Color.green);
        		g.setFont(new Font("Serif",Font.PLAIN,36));
        		g.drawString("$" + (Main.Player1.credits - Main.Player1.Ship.Ship_Hull.Hull_Cost.get(2)),250,725);
        	}
        	else if(Main.Player1.Ship.Ship_Hull.Hull_Cost.get(2) > Main.Player1.credits)
        	{
        		g.setColor(Color.red);
        		g.setFont(new Font("Serif",Font.PLAIN,36));
        		g.drawString("$" + (Main.Player1.credits - Main.Player1.Ship.Ship_Hull.Hull_Cost.get(2)),250,725);
        	}
        	else if(Main.Player1.Ship.Ship_Hull.Hull_Cost.get(2) == Main.Player1.credits)
        	{
        		g.setColor(Color.white);
        		g.setFont(new Font("Serif",Font.PLAIN,36));
        		g.drawString("$0",250,725);
        	}
    	
    		}
    		
        	if((Main.Player1.Ship.Ship_Hull.Health.get(2)+100) > Main.Player1.Ship.current_health)
        	{
        		g.setColor(Color.green);
        		g.setFont(new Font("Serif",Font.PLAIN,20));
        		g.drawString("+ " + ((Main.Player1.Ship.Ship_Hull.Health.get(2)+100) - Main.Player1.Ship.current_health), 845, 730);
        	}
        	else if((Main.Player1.Ship.Ship_Hull.Health.get(2)+100) < Main.Player1.Ship.current_health)
        	{
        		g.setColor(Color.red);
        		g.setFont(new Font("Serif",Font.PLAIN,20));
        		g.drawString("- " + -1 *((Main.Player1.Ship.Ship_Hull.Health.get(2)+100) - Main.Player1.Ship.current_health), 845, 730);
        	}
        	else if((Main.Player1.Ship.Ship_Hull.Health.get(2)+100) == Main.Player1.Ship.current_health)
        	{
        		g.setColor(Color.white);
        		g.setFont(new Font("Serif",Font.PLAIN,20));
        		g.drawString("0", 860, 730);
        	}
        }
    }
	

	public void moveSelectionOvalUp()
	{
		if(selectionOvalY == 3 || selectionOvalY > 147 )
		{
			selectionOvalY = 147;
			selectionOvalX = 210;
			selectionOvalWidth = 12;
			selectionOvalHeight = 12;
			repaint();
			return;
		}
		else 
     	selectionOvalY -= 24;
	    repaint();
     		
     	}
	public void moveSelectionOvalDown()
	{
		if(selectionOvalY >= 147 && selectionOvalX > 210)
		{
			selectionOvalY = 3;
			selectionOvalX = 210;
			selectionOvalWidth = 12;
			selectionOvalHeight = 12;
			repaint();
			return;
		}
		else if(selectionOvalY >= 147)
		{
			selectionOvalY = 3;
			repaint();
			return;
		}
		
		else
			selectionOvalY +=24;
		repaint();
			
	}
	public void moveSelectionOvalRight()
	{
		if(selectionOvalX == 210 && selectionOvalY <= 147)
		{
			selectionOvalX = 340;
			selectionOvalY = 430;
			selectionOvalWidth = 20;
			selectionOvalHeight = 20;
			repaint();
			return;
		}
		else if(selectionOvalX == 740)
		{
			selectionOvalX = 210;
			selectionOvalY = 3;
			selectionOvalWidth = 12;
			selectionOvalHeight = 12;
			repaint();
			return;
		}
		else
			selectionOvalX +=200;
		repaint();
			
	}
	public void moveSelectionOvalLeft()
	{
		if(selectionOvalX == 210 && selectionOvalY <= 147)
		{
			selectionOvalX = 740;
			selectionOvalY = 430;
			selectionOvalWidth = 20;
			selectionOvalHeight = 20;
			repaint();
			return;
		}
		else if(selectionOvalX == 340)
		{
			selectionOvalX = 210;
			selectionOvalY = 3;
			selectionOvalWidth = 12;
			selectionOvalHeight = 12;
			repaint();
			return;
		}
		else
	    {
		  selectionOvalX -=200;
	    }
		repaint();
			
	}
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
		else if(selectionOvalX == 340)
		{
			if(Main.Player1.Ship.Ship_Hull.Hull_Cost.get(0) <= Main.Player1.credits || Main.Player1.Ship.Ship_Hull.check_purchased_Hulls(0) == 1)
			return 9;
			}
		else if(selectionOvalX == 540)
			{
			if(Main.Player1.Ship.Ship_Hull.Hull_Cost.get(1) <= Main.Player1.credits || Main.Player1.Ship.Ship_Hull.check_purchased_Hulls(1) == 1)
			return 10;
			}
		else if(selectionOvalX == 740)
			{
			if(Main.Player1.Ship.Ship_Hull.Hull_Cost.get(2) <= Main.Player1.credits || Main.Player1.Ship.Ship_Hull.check_purchased_Hulls(2) == 1)
			return 11;
			}
		return 0;
	}
}