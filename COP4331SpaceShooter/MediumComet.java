/*
 MediumComet.java
 
 Christopher Margol
 */

import java.util.Vector;


public class MediumComet extends Comet
{
	//constant final medium class raidus is 30
	final static double mediumCometRadius = 30;
	
	MediumComet(double xPos, double yPos, double xVel, double yVel)
	{
		super(xPos, yPos, xVel, yVel, mediumCometRadius);
	}
	
	
	//creates 3 small comments when medium comet is destroyed
	public Vector<Comet> explode()
	{
		Vector<Comet> temp = new Vector<Comet>();
		
		temp.add(new SmallComet(xPosition, yPosition, (double)rand.nextInt()%7, (double)rand.nextInt()%7));
		temp.add(new SmallComet(xPosition, yPosition, (double)rand.nextInt()%7, (double)rand.nextInt()%7));
		temp.add(new SmallComet(xPosition, yPosition, (double)rand.nextInt()%7, (double)rand.nextInt()%7));
		return temp;
	}
	
	
	
}
