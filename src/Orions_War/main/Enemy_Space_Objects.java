/**************************************************************************
 ***************************************************************************
 * 	
 *     ============    Team 2  -  Project 6: Space Shooter    ============
 *     	
 *	FILE NAME: Enemy_Space_Objects.java
 *	AUTHOR(S): Christopher Margol
 *	DATE OF FIRST VERSION: 11/01/2012
 *	DATE LAST MODIFIED: 11/01/2012
 *	UNIT TESTING COMPLETED: Yes
 *	STATUS OF UNIT TESTING: No Problems
 *	INTEGRATION TESTING COMPLETED: Yes
 *	PURPOSE OF FILE IN THE SYSTEM: This file enables us to deal with
 *   everything used for enemy space objects, basically a copy of space objects
 *
 ***************************************************************************
 **************************************************************************/
package Orions_War.main;

public class Enemy_Space_Objects 
{
   static int playfieldHeight;
   static int playfieldWidth;
   public double xPosition, yPosition, xVelocity, yVelocity, radius;
   
   Enemy_Space_Objects(double xPos, double yPos, double xVel, double yVel, double radius)
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
		yPosition += yVelocity;
		xPosition += xVelocity;
	}

	public void update_velocities(int x, int y)
	{
		xVelocity = x;
		yVelocity = y;
	}
}
