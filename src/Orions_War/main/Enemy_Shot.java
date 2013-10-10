/**************************************************************************
 ***************************************************************************
 * 	
 *     ============    Team 2  -  Project 6: Space Shooter    ============
 *     	
 *	FILE NAME: Enemy_Shot.java
 *	AUTHOR(S): Christopher Margol
 *	DATE OF FIRST VERSION: 11/01/2012
 *	DATE LAST MODIFIED: 11/01/2012
 *	UNIT TESTING COMPLETED: Yes
 *	STATUS OF UNIT TESTING: No Problems
 *	INTEGRATION TESTING COMPLETED: Yes
 *	PURPOSE OF FILE IN THE SYSTEM: This file enables us to deal with
 *   everything used for enemy shots
 *
 ***************************************************************************
 **************************************************************************/
package Orions_War.main;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Enemy_Shot extends Space_Objects
{
	final static double Enemy_ShotRadius =25;
	private int age;
	volatile public BufferedImage weapon = null;
	volatile public BufferedImageLoader loader = new BufferedImageLoader();
	public static int type,damage;
	public Enemy_Shot(int type,double xPos, double yPos, double xVel, double yVel) 
	{
	
			super(xPos, yPos, xVel, yVel, Enemy_ShotRadius);
			age = 0;
			this.type = type;
			set_shot();
				
			
		}

	public void move()
	{
		this.yPosition += this.yVelocity;
		age++;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void set_shot()
	{
		if(type == 0)
		{
			try {
				weapon = loader.loadImage("images/Ship_Shop/Enemy_Shot_1.png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			damage = 1;
			
		}
		else if(type == 1)
		{
			try {
				weapon = loader.loadImage("images/Ship_Shop/Enemy_Shot_2.png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			damage = 2;
		}
		else if(type == 2)
		{
			try {
				weapon = loader.loadImage("images/Ship_Shop/Enemy_Shot_3.png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			damage = 3;
		}
		
	}

	boolean overlapping(Player_Ship rhs)
	{
		//checks if the radius of the objects are overlapping
		if(java.lang.Math.sqrt(( xPosition - rhs.xPosition) *(xPosition -  rhs.xPosition) +   (yPosition - rhs.yPosition) * (yPosition - rhs.yPosition)) <= Enemy_ShotRadius + rhs.radius)
				{
				return true;
				}
				
		return false;
	}
	

}
