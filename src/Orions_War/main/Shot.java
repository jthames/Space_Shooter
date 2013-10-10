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
 *	PURPOSE OF FILE IN THE SYSTEM: This file enables us to deal with
 *   shots shot by our ship.
 *
 ***************************************************************************
 **************************************************************************/
package Orions_War.main;


import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;


//A space object shot
public class Shot extends Space_Objects
{
	public static double ShotRadius = 5;
	private int age;
	public static BufferedImage spriteSheet = null,weapon;
	public static BufferedImageLoader loader = new BufferedImageLoader();
	
	public Shot(double xPos, double yPos, double xVel, double yVel)
	{
		super(xPos, yPos, xVel, yVel, ShotRadius);
		age = 0;
		set_the_shots_image();
	}
	
	public void move()
	{
		super.move();
		age++;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void set_the_shots_image()
	{
		try {
			spriteSheet = loader.loadImage("images/Ship_Shop/Weapon_Sprite_Sheet.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(Main.Player1.Ship.Ship_Weapon.getCurrentWeapon() == 0)
		{
		  weapon = spriteSheet.getSubimage(2, 0, 7, 21);
		}
		else if(Main.Player1.Ship.Ship_Weapon.getCurrentWeapon() == 1)
		{
		  weapon = spriteSheet.getSubimage(30, 1, 7, 21);
		}
		else if(Main.Player1.Ship.Ship_Weapon.getCurrentWeapon() == 2)
		{
		  weapon = spriteSheet.getSubimage(16, 1, 7, 21);
		}
		else
		{
			try {
				weapon = loader.loadImage("images/Ship_Shop/Basic_Shot.png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
    
	boolean overlapping(Enemy_Space_Objects rhs)
	{
		//checks if the radius of the objects are overlapping
		if(java.lang.Math.sqrt(( xPosition - rhs.xPosition) *(xPosition - rhs.xPosition) + (yPosition - rhs.yPosition) * (yPosition - rhs.yPosition)) <= ShotRadius + rhs.getRadius())
		{
				return true;
				}
				
		return false;
	}

}

