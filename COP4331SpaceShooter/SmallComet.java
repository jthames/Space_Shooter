/*
 SmallComet.java
 
 Christopher Margol
 */
import java.util.Vector;



public class SmallComet extends Comet
{
	final static double smallCometRadius = 20;
	
	public SmallComet(double xPos, double yPos, double xVel, double yVel)
	{
		super(xPos, yPos, xVel, yVel, smallCometRadius);
	}

	public Vector<Comet> explode()
	{
		//returns empty vector no other comets are created when small comet explodes
		return new Vector<Comet>();
	}
}
