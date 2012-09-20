/*
 Shot.java
 
 Christopher Margol
 
 */
public class Shot extends SpaceObject
{
	final static double ShotRadius = 3;
	private int age;
	
	public Shot(double xPos, double yPos, double xVel, double yVel)
	{
		//creates space object
		super(xPos, yPos, xVel, yVel, ShotRadius);
		//age set to 0
		age = 0;
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
}
