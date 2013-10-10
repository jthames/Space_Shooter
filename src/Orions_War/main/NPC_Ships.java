/**************************************************************************
 ***************************************************************************
 * 	
 *     ============    Team 2  -  Project 6: Space Shooter    ============
 *     	
 *	FILE NAME: NPC_Ships.java
 *	AUTHOR(S): Christopher Margol
 *	DATE OF FIRST VERSION: 11/01/2012
 *	DATE LAST MODIFIED: 11/01/2012
 *	UNIT TESTING COMPLETED: Yes
 *	STATUS OF UNIT TESTING: No Problems
 *	INTEGRATION TESTING COMPLETED: Yes
 *	PURPOSE OF FILE IN THE SYSTEM: This file enables us to deal with
 *   everything used for a single NPC_Ship
 *
 ***************************************************************************
 **************************************************************************/
package Orions_War.main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;

public class NPC_Ships extends Enemy_Space_Objects {

	final static double ShipRadius = 8000;
	public static double current_yVel, current_acceleration,current_max_speed;
	public static int current_health, current_damage;
	public int type;
	volatile public  BufferedImage enemy_ship = null,weapon = null;
	volatile public  BufferedImageLoader loader = new BufferedImageLoader();
	public Enemy_Shot shot;
	
	
	NPC_Ships(int type,double xPos, double yPos, double xVel, double yVel, double radius)
	{
		super(xPos, yPos, xVel, yVel, radius);
	    this.type = type;
	    current_yVel = yVel;
		set_up_ship();
		set_the_Enemy_Shots_image();
		
	    shot = new Enemy_Shot(type,xPos,yPos,xVel,yVel);
	}

	public void set_up_ship()
	{      BufferedImageLoader loader = new BufferedImageLoader();
	   //Level 1 type Enemy Ship
	   if(type == 0)
	   {
		   try {
			 	  enemy_ship = loader.loadImage("images/Ship_Shop/Enemy_Ships_1.png");
			 	 } catch (IOException e) {
			 				// TODO Auto-generated catch block
			 				e.printStackTrace();
			 			}
		   current_max_speed = 25;
		   current_health = 150;
		   current_damage = 100;
	   }
	   else if(type == 1)
	   {
		   try {
			   enemy_ship = loader.loadImage("images/Ship_Shop/Enemy_Ships_2.png");
			 	 } catch (IOException e) {
			 				// TODO Auto-generated catch block
			 				e.printStackTrace();
			 			}
			
		   current_max_speed = 45;
		   current_health = 200;
		   current_damage = 150;
		  
	   }
	   //Level 3 type of Enemy Ship
	   else
	   {
		   try {
			   enemy_ship  = loader.loadImage("images/Ship_Shop/Enemy_Ships_3.png");
			 	 } catch (IOException e) {
			 				// TODO Auto-generated catch block
			 				e.printStackTrace();
			 			}
			
		   current_max_speed = 65;
		   current_health = 250;
		   current_damage = 200;

	   }
	}
	
	public Enemy_Shot getShot()
	{
		return shot;
	}
	
	public static void accelerateY()
	{
		// Also add thruster boost to x or y velocity
		
		current_yVel += 0.1;
		
		if(current_yVel >current_max_speed)
		{
			current_yVel = current_max_speed;
		}
	}
	
	
	
	public static void deacceleateY()
	{
		current_yVel -= 0.1;
		
		if(current_yVel < -current_max_speed)
		{
			current_yVel = -current_max_speed;
		}
	}
	public void set_the_Enemy_Shots_image()
	{
	
		if(type == 0)
		{
			try {
				weapon = loader.loadImage("images/Ship_Shop/Enemy_Shot_1.png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		}
		else if(type == 1)
		{
			try {
				weapon = loader.loadImage("images/Ship_Shop/Enemy_Shot_2.png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		else if(type == 2)
		{
			try {
				weapon = loader.loadImage("images/Ship_Shop/Enemy_Shot_3.png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	boolean overlapping(Player_Ship rhs)
	{
		//checks if the radius of the objects are overlapping
		if(java.lang.Math.sqrt(( xPosition - rhs.xPosition) *(xPosition -  rhs.xPosition) +   (yPosition - rhs.yPosition) * (yPosition - rhs.yPosition)) <= radius + rhs.radius)
				{
				return true;
				}
				
		return false;
	}
	



}
