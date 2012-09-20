/*
 SpaceObject.java
 
 Christopher Margol
 
 */

public class SpaceObject 
{
	//defines some variables used
	static double playfieldHeight;
	static double playfieldWidth;
	double xPosition, yPosition, xVelocity, yVelocity, radius;

	SpaceObject(double xPos, double yPos, double xVel, double yVel, double radius)
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
		//moves an object, if off screen wraps around.
		xPosition = xPosition + xVelocity;
		yPosition = yPosition + yVelocity;
		
		if(xPosition > 1200)
			xPosition -= 1200;
		if(yPosition > 800)
			yPosition -= 800;
		if(xPosition < 0)
			xPosition += 1200;
		if(yPosition < 0)
			yPosition += 800;
			
		
	}
	
	boolean overlapping(SpaceObject rhs)
	{
		//checks if the radius of the objects are overlapping
		if(java.lang.Math.sqrt(( xPosition - rhs.xPosition) *(xPosition - rhs.xPosition) +   (yPosition - rhs.yPosition) * (yPosition - rhs.yPosition)) < radius + rhs.radius)
				return true;
				
		return false;
	}
	
}
