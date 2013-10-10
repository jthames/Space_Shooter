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
 *	PURPOSE OF FILE IN THE SYSTEM: This file is used to make a ship a space object
 *  and also give characteristics of other space objects such as asteroids and shots
 ***************************************************************************
 **************************************************************************/

package Orions_War.main;

public class Space_Objects 
{
	//store data for the positions and radius of space objects.
   static int playfieldHeight;
   static int playfieldWidth;
   public double xPosition, yPosition, xVelocity, yVelocity, radius;
   
   Space_Objects(double xPos, double yPos, double xVel, double yVel, double radius)
   {
	   xPosition = xPos;
	   yPosition = yPos;
	   xVelocity = xVel;
	   yVelocity = yVel;
	   this.radius = radius;
   }
   
   public double getRadius()
	{
		return radius;
	}
	
	public double getXPosition()
	{
		return xPosition;
	}
	
	public double getYPosition()
	{
		return yPosition;
	}
	
	public void move()
	{
		xPosition += xVelocity;
		yPosition += yVelocity;
	}

}
