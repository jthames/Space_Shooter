/*
 Comet.java
 
 Christopher Margol
 
 */

import java.util.*;

public abstract class Comet extends SpaceObject
{
	//creates a random object used for generating random velocities
	Random rand = new Random();
	
	public Comet(double xPos, double yPos, double xVel, double yVel, double radius)
	{
		super(xPos, yPos, xVel, yVel, radius);
	}
	
	public abstract Vector<Comet> explode();
	
}
