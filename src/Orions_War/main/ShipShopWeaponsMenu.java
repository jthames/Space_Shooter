/**************************************************************************
***************************************************************************
* 	
*     ============    Team 2  -  Project 6: Space Shooter    ============
*     	
*	FILE NAME: ShipShopWeaponsMenu.java
*	AUTHOR(S): Alexander Banke
*	DATE OF FIRST VERSION: 11/01/2012
*	DATE LAST MODIFIED: 11/01/2012
*	UNIT TESTING COMPLETED: Yes
*	STATUS OF UNIT TESTING: No Problems
*	INTEGRATION TESTING COMPLETED: Yes
*	PURPOSE OF FILE IN THE SYSTEM: This file enables the visualization of the Weapons
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
public class ShipShopWeaponsMenu extends JPanel
{

//Alex Banke: Sets up the use of the window and selection oval
	private static Dimension windowSize = new Dimension(1000,804);
	
	//TODO: make the selectionOval its own class
	private static int selectionOvalWidth = 12;
	private static int selectionOvalHeight = 12;
	public static int selectionOvalX = 210;
	public static int selectionOvalY = 3;
	private Image img;
	
	
	
	public ShipShopWeaponsMenu()
	{
        //Alex Banke: Creates the Background image for the weapons area 
        ImageIcon icon = new ImageIcon("images/Ship_Shop/Ship_ShopMenu_Weapons.png");		
		img = icon.getImage();	
		//Alex Banke: Adds the ability to move and navigate choices
		this.addKeyListener(new ShipShopWeaponsKeyAdapter(this));


	}
	public void paintComponent(Graphics g)
    {
		//Alex Banke: Declares the images used for displaying the upgrades
		BufferedImage spriteSheet = null,Weapon1,Weapon2,Weapon3;
		//Alex Banke: Creates a new ImageLoader to grab the sprite sheet
    	BufferedImageLoader loader = new BufferedImageLoader();
    	//Alex Banke: Attempts to find the sprite sheet
    	try {
			spriteSheet = loader.loadImage("images/Ship_Shop/Weapon_Sprite_Sheet.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawRect(0, 0, 1000, 800);
		
		g.drawImage(img, 0, 0,1000,800, this);
		g.setColor(Color.white);
		//Alex Banke: The next 13 lines of code display, the users credits, score, level they are on 
		// the upgrade descriptions as well as their current weapon damage.
		g.setFont(new Font("Serif",Font.PLAIN,36));
		g.drawString("$"+ Main.Player1.credits,250, 575);
		g.drawString(""+ Main.Player1.score, 10, 275);
		g.setFont(new Font("Serif",Font.PLAIN,60));
		g.drawString(""+ Main.Player1.progress, 100, 385);
		g.setFont(new Font("Serif",Font.PLAIN,20));
		g.drawString(""+ Main.Player1.Ship.current_damage,865,640);
		g.setFont(new Font("Courier",Font.PLAIN,20));
		g.drawString("Level 1 Upgrade",275,300);
		g.drawString("Level 2 Upgrade",475,300);
		g.drawString("Level 3 Upgrade",675,300);
		g.setFont(new Font("Courier",Font.PLAIN,35));
		g.drawString("Select your Weapon Upgrade", 300, 250);
		
		//Alex Banke: The weapon images get grabbed from the sprite sheet
		// and then are drawn to the screen
		Weapon1 = spriteSheet.getSubimage(2, 0, 7, 21);
        g.drawImage(Weapon1,343, 310, 21, 63,this);
        Weapon2 = spriteSheet.getSubimage(30, 1, 7, 21);
        g.drawImage(Weapon2, 545, 310, 21, 63,this);
        Weapon3 = spriteSheet.getSubimage(16, 1, 7, 21);       
        g.drawImage(Weapon3, 742, 310, 21, 63,this);
       
        //Alex Banke: Selection oval is created
        g.setColor(Color.white);
		g.drawOval(selectionOvalX, selectionOvalY, selectionOvalHeight, selectionOvalWidth);
	    
		
		//Alex Banke: Checks to see where the seleciton oval is to determine the upgrade 
		// being highlighted.
        if(selectionOvalX == 340)
        {
        	//Alex Banke: Updates the text on the screen to show the cost of the weapon
        	// and the power that it has.
        	g.setColor(Color.white);
    		g.setFont(new Font("Serif",Font.PLAIN,36));
        	g.drawString("$"+Main.Player1.Ship.Ship_Weapon.Weapon_Cost.get(0),250,650);
        	g.setFont(new Font("Serif",Font.PLAIN,20));
        	g.drawString(""+(Main.Player1.Ship.Ship_Weapon.Power.get(0)), 865, 685);
        	
        	//Alex Banke: Checks to see if the user already owns and if true then it tells them if they
        	// have the weapon equipped or unequipped.
        	if(Main.Player1.Ship.Ship_Weapon.check_purchased_Weapons(0) == 1)
        	{
        		g.setFont(new Font("Serif",Font.PLAIN,24));	
    		    g.drawString("Upgrade Purchased",200,710);
    		    if(Main.Player1.Ship.Ship_Weapon.getCurrentWeapon() == 0)
    		    {
    		    	g.drawString("Upgrade Equipped",200,750);
    		    }
    		    else 
    		    	g.drawString("Upgrade Unequipped",200, 750);
        	}
        	//Alex Banke: If false then they don't own the weapon and now it checks
        	// to see if the users credits are more than the weapons cost, and if they do 
        	// a green number displays, if they don't then a red number, and if they are equal a white number.
    		else
    		{

        	if(Main.Player1.Ship.Ship_Weapon.Weapon_Cost.get(0) < Main.Player1.credits)
        	{
        		g.setColor(Color.green);
        		g.setFont(new Font("Serif",Font.PLAIN,36));
        		g.drawString("$" + (Main.Player1.credits - Main.Player1.Ship.Ship_Weapon.Weapon_Cost.get(0)),250,725);
        	}
        	else if(Main.Player1.Ship.Ship_Weapon.Weapon_Cost.get(0) > Main.Player1.credits)
        	{
        		g.setColor(Color.red);
        		g.setFont(new Font("Serif",Font.PLAIN,36));
        		g.drawString("$" + (Main.Player1.credits - Main.Player1.Ship.Ship_Weapon.Weapon_Cost.get(0)),250,725);
        	}
        	else if(Main.Player1.Ship.Ship_Weapon.Weapon_Cost.get(0) == Main.Player1.credits)
        	{
        		g.setColor(Color.white);
        		g.setFont(new Font("Serif",Font.PLAIN,36));
        		g.drawString("$0",250,725);
        	}
    		}
        	//Alex Banke: To help the user decide if they want to buy the item the program calculates
        	// the benefit of buying that upgrade, and displays a red,green, or white number depending
        	// on the benefit
        	if((Main.Player1.Ship.Ship_Weapon.Power.get(0)) > Main.Player1.Ship.current_damage)
        	{
        		g.setColor(Color.green);
        		g.setFont(new Font("Serif",Font.PLAIN,20));
        		g.drawString("+ " +((Main.Player1.Ship.Ship_Weapon.Power.get(0)) - Main.Player1.Ship.current_damage), 850, 730);
        	}
        	else if((Main.Player1.Ship.Ship_Weapon.Power.get(0))  < Main.Player1.Ship.current_damage)
        	{
        		g.setColor(Color.red);
        		g.setFont(new Font("Serif",Font.PLAIN,20));
        		g.drawString("- " + -1 *((Main.Player1.Ship.Ship_Weapon.Power.get(0)) - Main.Player1.Ship.current_damage), 850, 730);
        	}
        	else if((Main.Player1.Ship.Ship_Weapon.Power.get(0)) == Main.Player1.Ship.current_damage)
        	{
        		g.setColor(Color.white);
        		g.setFont(new Font("Serif",Font.PLAIN,20));
        		g.drawString("0", 865, 730);
        	}
        }
        //Alex Banke: See line 107 for description
        else if(selectionOvalX == 540)
        {
        	//Alex Banke: See line 111 for description
        	g.setColor(Color.white);
    		g.setFont(new Font("Serif",Font.PLAIN,36));
        	g.drawString("$"+Main.Player1.Ship.Ship_Weapon.Weapon_Cost.get(1),250,650);
        	g.setFont(new Font("Serif",Font.PLAIN,20));
        	g.drawString(""+(Main.Player1.Ship.Ship_Weapon.Power.get(1)), 865, 685);
        	
        	//Alex Banke: See line 119 for description
        	if(Main.Player1.Ship.Ship_Weapon.check_purchased_Weapons(1) == 1)
        	{
        		g.setFont(new Font("Serif",Font.PLAIN,24));	
    		    g.drawString("Upgrade Purchased",200,710);
    		    if(Main.Player1.Ship.Ship_Weapon.getCurrentWeapon() == 1)
    		    {
    		    	g.drawString("Upgrade Equipped",200,750);
    		    }
    		    else 
    		    	g.drawString("Upgrade Unequipped",200, 750);
        	}
        	//Alex Banke: See line 132 for description
    		else
    		{
        	
        	if((Main.Player1.Ship.Ship_Weapon.Weapon_Cost.get(1)) < Main.Player1.credits)
        	{
        		g.setColor(Color.green);
        		g.setFont(new Font("Serif",Font.PLAIN,36));
        		g.drawString("$" + (Main.Player1.credits - Main.Player1.Ship.Ship_Weapon.Weapon_Cost.get(1)),250,725);
        	}
        	else if(Main.Player1.Ship.Ship_Weapon.Weapon_Cost.get(1) > Main.Player1.credits)
        	{
        		g.setColor(Color.red);
        		g.setFont(new Font("Serif",Font.PLAIN,36));
        		g.drawString("$" + (Main.Player1.credits - Main.Player1.Ship.Ship_Weapon.Weapon_Cost.get(1)),250,725);
        	}
        	else if(Main.Player1.Ship.Ship_Weapon.Weapon_Cost.get(1) == Main.Player1.credits)
        	{
        		g.setColor(Color.white);
        		g.setFont(new Font("Serif",Font.PLAIN,36));
        		g.drawString("$0",250,725);
        	}
    		
    		}
        	//Alex Banke: See line 157 for description
        	if((Main.Player1.Ship.Ship_Weapon.Power.get(1)) > Main.Player1.Ship.current_damage)
        	{
        		g.setColor(Color.green);
        		g.setFont(new Font("Serif",Font.PLAIN,20));
        		g.drawString("+ " +((Main.Player1.Ship.Ship_Weapon.Power.get(1)) - Main.Player1.Ship.current_damage), 850, 730);
        	}
        	else if((Main.Player1.Ship.Ship_Weapon.Power.get(1)) < Main.Player1.Ship.current_damage)
        	{
        		g.setColor(Color.red);
        		g.setFont(new Font("Serif",Font.PLAIN,20));
        		g.drawString("- " + -1 *((Main.Player1.Ship.Ship_Weapon.Power.get(1)) - Main.Player1.Ship.current_damage), 850, 730);
        	}
        	else if((Main.Player1.Ship.Ship_Weapon.Power.get(1)) == Main.Player1.Ship.current_damage)
        	{
        		g.setColor(Color.white);
        		g.setFont(new Font("Serif",Font.PLAIN,20));
        		g.drawString("0", 865, 730);
        	}
        }
        //Alex Banke: See line 107 for description
        else if(selectionOvalX == 740)
        {
        	//Alex Banke: See line 111 for description
        	g.setColor(Color.white);
    		g.setFont(new Font("Serif",Font.PLAIN,36));
        	g.drawString("$"+Main.Player1.Ship.Ship_Weapon.Weapon_Cost.get(2),250,650);
        	g.setFont(new Font("Serif",Font.PLAIN,20));
        	g.drawString(""+(Main.Player1.Ship.Ship_Weapon.Power.get(2)), 865, 685);
        	
        	//Alex Banke: See line 119 for description
        	if(Main.Player1.Ship.Ship_Weapon.check_purchased_Weapons(2) == 1)
        	{
        		g.setFont(new Font("Serif",Font.PLAIN,24));	
    		    g.drawString("Upgrade Purchased",200,710);
    		    if(Main.Player1.Ship.Ship_Weapon.getCurrentWeapon() == 2)
    		    {
    		    	g.drawString("Upgrade Equipped",200,750);
    		    }
    		    else 
    		    	g.drawString("Upgrade Unequipped",200, 750);
        	}
        	//Alex Banke: See line 132 for description
    		else
    		{
    		 if(Main.Player1.Ship.Ship_Weapon.Weapon_Cost.get(2) < Main.Player1.credits)
        	{
        		g.setColor(Color.green);
        		g.setFont(new Font("Serif",Font.PLAIN,36));
        		g.drawString("$" + (Main.Player1.credits - Main.Player1.Ship.Ship_Weapon.Weapon_Cost.get(2)),250,725);
        	}
        	else if(Main.Player1.Ship.Ship_Weapon.Weapon_Cost.get(2) > Main.Player1.credits)
        	{
        		g.setColor(Color.red);
        		g.setFont(new Font("Serif",Font.PLAIN,36));
        		g.drawString("$" + (Main.Player1.credits - Main.Player1.Ship.Ship_Weapon.Weapon_Cost.get(2)),250,725);
        	}
        	else if(Main.Player1.Ship.Ship_Weapon.Weapon_Cost.get(2) == Main.Player1.credits)
        	{
        		g.setColor(Color.white);
        		g.setFont(new Font("Serif",Font.PLAIN,36));
        		g.drawString("$0",250,725);
        	}
    	
    		}
        	//Alex Banke: See line 157 for description
        	if((Main.Player1.Ship.Ship_Weapon.Power.get(2)) > Main.Player1.Ship.current_damage)
        	{
        		g.setColor(Color.green);
        		g.setFont(new Font("Serif",Font.PLAIN,20));
        		g.drawString("+ " + ((Main.Player1.Ship.Ship_Weapon.Power.get(2)) - Main.Player1.Ship.current_damage), 850, 730);
        	}
        	else if((Main.Player1.Ship.Ship_Weapon.Power.get(2)) < Main.Player1.Ship.current_damage)
        	{
        		g.setColor(Color.red);
        		g.setFont(new Font("Serif",Font.PLAIN,20));
        		g.drawString("- " + -1 *((Main.Player1.Ship.Ship_Weapon.Power.get(2)) - Main.Player1.Ship.current_damage), 850, 730);
        	}
        	else if((Main.Player1.Ship.Ship_Weapon.Power.get(2)) == Main.Player1.Ship.current_damage)
        	{
        		g.setColor(Color.white);
        		g.setFont(new Font("Serif",Font.PLAIN,20));
        		g.drawString("0", 865, 730);
        	}
        }
    }
	
    //Alex Banke: Moves the selector and if it hits the top of the menu, it sends it to the bottom 
	// of the menu
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
	//Alex Banke: Works like moveSelectionOvalUp but in reverse
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
	//Alex Banke: Moves the selector to the right until it hits the right most
	// option and then sends it back to the top of the screen.
	public void moveSelectionOvalRight()
	{
		if(selectionOvalX == 210 && selectionOvalY <= 147)
		{
			selectionOvalX = 340;
			selectionOvalY = 400;
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
	//Alex Banke: moves the selector to the left and if its at the left most option it sends it to the right
	// most option
	public void moveSelectionOvalLeft()
	{
		if(selectionOvalX == 210 && selectionOvalY <= 147)
		{
			selectionOvalX = 740;
			selectionOvalY = 400;
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
	//Alex Banke: Gets the users choice
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
			if(Main.Player1.Ship.Ship_Weapon.Weapon_Cost.get(0) <= Main.Player1.credits || Main.Player1.Ship.Ship_Weapon.check_purchased_Weapons(0) == 1)
			return 9;
			}
		else if(selectionOvalX == 540)
			{
			if(Main.Player1.Ship.Ship_Weapon.Weapon_Cost.get(1) <= Main.Player1.credits || Main.Player1.Ship.Ship_Weapon.check_purchased_Weapons(1) == 1)
			return 10;
			}
		else if(selectionOvalX == 740)
			{
			if(Main.Player1.Ship.Ship_Weapon.Weapon_Cost.get(2) <= Main.Player1.credits || Main.Player1.Ship.Ship_Weapon.check_purchased_Weapons(2) == 1)
			return 11;
			}
		return 0;
	}
}