/*
 LargeComet.java
 
 
 
 Christopher Margol
 
 
 
 */

import java.util.Vector;


public class LargeComet extends Comet
{
	final static double largeCometRadius = 40;
	
	LargeComet(double xPos, double yPos, double xVel, double yVel)
	{
		super(xPos, yPos, xVel, yVel, largeCometRadius);
	}
	
	public  Vector<Comet> explode()
	{
		Vector<Comet> temp = new Vector<Comet>();
		temp.add(new MediumComet(xPosition, yPosition, (double)rand.nextInt()%7, (double)rand.nextInt()%7));
		temp.add(new MediumComet(xPosition, yPosition, (double)rand.nextDouble()%7, (double)rand.nextInt()%7));
		return temp;
	}

}