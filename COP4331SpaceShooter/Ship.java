/*
 Ship.java
 
 
 Christopher Margol
 
 
 */
public class Ship extends SpaceObject
{
	//constant declaration
	final static double ShipRadius = 10;
	final static double maxShipSpeed = 10;
	final static double shipTurningRate = java.lang.Math.PI/32;
	
	
	private double angle;
	private double gunTurret = 15;
	
	//Creation of ship
	Ship(double xPos, double yPos, double xVel, double yVel)
	{
		super(xPos, yPos, xVel, yVel, ShipRadius);
		angle = 0;
	}
	
	
	public double getAngle()
	{
		return angle;
	}
	
	public double getGunTurretLength()
	{
		return gunTurret;
	}
	
	public void rotateLeft()
	{
		angle += shipTurningRate;
	}
	
	public void rotateRight()
	{
		angle -= shipTurningRate;
	}
	
	public void accelerate()
	{
		//velocity is added to to the acceleration
		xVelocity += 0.1 * java.lang.Math.sin(angle);
		yVelocity += 0.1 * java.lang.Math.cos(angle);
		
		if(java.lang.Math.sqrt(xVelocity * xVelocity + yVelocity * yVelocity) > 10)
		{
			//set to 10 when velocity is 10 or greatr
			xVelocity = 10* java.lang.Math.sin(angle);
			yVelocity = 10* java.lang.Math.cos(angle);
		}
	}
	
	public Shot fire()
	{
		//creates a shot at the gun tip
		return new Shot(xPosition + gunTurret*java.lang.Math.sin(angle), yPosition + gunTurret*java.lang.Math.cos(angle), 3*java.lang.Math.sin(angle) + xVelocity, 3*java.lang.Math.cos(angle) +  yVelocity );	
	}
}
