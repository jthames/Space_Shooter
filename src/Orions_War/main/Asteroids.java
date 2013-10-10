/**************************************************************************
***************************************************************************
* 	
*     ============    Team 2  -  Project 6: Space Shooter    ============
*     	
*	FILE NAME: Asteroids.java
*	AUTHOR(S): Alexander Banke, Chris Margol
*	DATE OF FIRST VERSION: 11/23/2012
*	DATE LAST MODIFIED: 11/29/2012
*	UNIT TESTING COMPLETED: Yes
*	STATUS OF UNIT TESTING: problems of adding asteroids to the game
*   also needs a way to keep track of the image being used.
*	INTEGRATION TESTING COMPLETED: Yes
*	PURPOSE OF FILE IN THE SYSTEM: This file enables us to spawn and use asteroids
*   in the game. 
*
***************************************************************************
**************************************************************************/

package Orions_War.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Asteroids extends Enemy_Space_Objects
{
/*
 *  Alex Banke:
 *            Don't change how these variables are intialized and declared.
 */
	public BufferedImage sprite = null;
	volatile public static ArrayList<Asteroids> asteroids = new ArrayList<Asteroids>();
	public static Random generator = new Random();
	public static  int xPos = generator.nextInt(940);
	public static int set = 0;
	public int type;
	public int gradius;
	public static int health;
	Asteroids(int type,double xPos, double yPos, double xVel, double yVel, double radius) 
	{
		super(xPos, yPos, xVel, yVel, radius);
	    this.type = type;
	    createAsteroid(type);
	}
	//Alex Banke: Adds an Asteroid to the game.
	public static void add(Asteroids ast)
	{
		asteroids.add(ast);
	}
	//Chris Margol: Added this function to move every asteroid on the screen
	public static void moveAll()
	{
		for(int i=0; i < asteroids.size(); i++)
			asteroids.get(i).move();
	}
	//Chris Margol: Updates the image of each asteroid so it looks like asteroids are moving
	public static void drawAll(Graphics g)
	{
		for(int i=0; i < asteroids.size(); i++)
		{
		
			g.drawImage(asteroids.get(i).sprite,(int) asteroids.get(i).xPosition, (int) asteroids.get(i).yPosition, asteroids.get(i).sprite.getWidth(),asteroids.get(i).sprite.getHeight(),Main.Game_Screen);
		}
	}
	//Chris Margol: If an asteroid flies off the screen it will be removed from the array
	public static void handleOffScreen()
	{
		for(int i=0; i < asteroids.size(); i++)
		{
			if(asteroids.get(i).xPosition > 1050 || asteroids.get(i).xPosition < -50)
			{
				asteroids.remove(i);
			
			}
		}
	}
	//Alex Banke: Call this method to set the image of the asteroid and it's radius
	public void createAsteroid(int type)
	{
		BufferedImageLoader loader = new BufferedImageLoader();
		//Alex Banke: A level 1 Asteroid will be added
		if(type == 0)
		{
			try 
			{
				sprite = loader.loadImage("images/asteroidSmall01.png");
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			radius = 10;
			gradius = 30;
		    health = 50;
		}
		//Alex Banke: A level 2 Asteroid will be added
		else if(type == 1)
		{
			
			try 
			{
				sprite = loader.loadImage("images/asteroid01.png");
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			radius = 25;
			gradius = 45;
			health = 150;
		}
		//Alex Banke: A level 3 Asteroid will be added
		else if(type == 2)
		{
			
			try 
			{
				sprite = loader.loadImage("images/asteroidBig01.png");
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			radius = 50;
			gradius = 70;
			health = 500;
		}
	}
    //Alex Banke: Checks if an asteroid has collided with a player
	public boolean overlapping(Player_Ship rhs) 
	{
		if(java.lang.Math.sqrt(( xPosition - rhs.xPosition) * (xPosition -  rhs.xPosition) +   (yPosition - rhs.yPosition) * (yPosition - rhs.yPosition)) <= radius + rhs.radius)
		{
		return true;
		}
		return false;
	}
	 //Alex Banke: Checks if an asteroid's gravity is affecting the player
	public boolean gravitate(Player_Ship rhs) 
	{
		if(java.lang.Math.sqrt(( xPosition - rhs.xPosition) * (xPosition -  rhs.xPosition) +   (yPosition - rhs.yPosition) * (yPosition - rhs.yPosition)) <= gradius + rhs.radius)
		{
		return true;
		}
		return false;
	}	
	
}
