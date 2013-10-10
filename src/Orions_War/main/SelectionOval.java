/**************************************************************************
 ***************************************************************************
 * 	
 *     ============    Team 2  -  Project 6: Space Shooter    ============
 *     	
 *	FILE NAME: Weapon_Upgrades.java
 *	AUTHOR(S): Andre? Comments made by Chris Margol
 *	DATE OF FIRST VERSION: 11/01/2012
 *	DATE LAST MODIFIED: 11/01/2012
 *	UNIT TESTING COMPLETED: Yes
 *	STATUS OF UNIT TESTING: No Problems
 *	INTEGRATION TESTING COMPLETED: Yes
 *	PURPOSE OF FILE IN THE SYSTEM: This file enables us to deal with
 *   everything used for updating weapons, whether purchased equipped etc
 *
 ***************************************************************************
 **************************************************************************/


//Not sure if this class is used in final program


/*
 Class built to handle graphics and get the correct size of the x and y coordinates of sprites
 */
package Orions_War.main;

import java.awt.Graphics;

public class SelectionOval 
{
	private int selectionOvalWidth = 3;
	private int selectionOvalHeight = 3;
	
	private int xDefault = 40;
	private int yDefault = 94;
	
	private int selectionOvalX = xDefault;
	private int selectionOvalY = yDefault;
	
	private int increment = 20;
	
	private int downLimit = 94;
	private int upLimit = 94;
	
	private boolean customIncrements = false;
	private int[] selectArray = null;
	private int currentPos = 0;
	
	
	public SelectionOval()
	{
	}
	
	public SelectionOval(int x, int y)
	{
		xDefault = x;
		yDefault = y;
		
		selectionOvalX = xDefault;
		selectionOvalY = yDefault;
	}
	
	public SelectionOval(int x, int y, int upLim, int downLim)
	{
		xDefault = x;
		yDefault = y;
		
		selectionOvalX = xDefault;
		selectionOvalY = yDefault;
		
		downLimit = downLim;
		upLimit = upLim;
	}
	
	public SelectionOval(int x, int y, int upLim, int downLim, int inc)
	{
		xDefault = x;
		yDefault = y;
		
		selectionOvalX = xDefault;
		selectionOvalY = yDefault;
		
		downLimit = downLim;
		upLimit = upLim;
		increment = inc;
	}
	
	public void setCustomIncrements(int ... numbers)
	{
		customIncrements = true;
		selectArray = new int[numbers.length];
		for(int i = 0; i < numbers.length; i++)
		{
			selectArray[i] = numbers[i];
		}
	}
	
	public void changeSize(int newHeight, int newWidth)
	{
		selectionOvalHeight = newHeight;
		selectionOvalWidth = newWidth;
	}
	
	public void drawSelector(Graphics g)
	{
		g.drawOval(selectionOvalX, selectionOvalY, selectionOvalHeight, selectionOvalWidth);
	}
	
	public void moveUp()
	{
		Sounds.move.play();
		if(customIncrements)
		{
			if(currentPos > 0)
			{
				currentPos--;
			}
			else
			{
				currentPos = selectArray[selectArray.length];
			}
		}
		else
		{
			if(((selectionOvalY - increment) < upLimit))
				selectionOvalY = downLimit;
			else
				selectionOvalY -= increment;
		}
	}
	
	public void moveDown()
	{   Sounds.move.play();
		if(customIncrements)
		{
			
			if(currentPos < selectArray.length - 1)
			{
				currentPos++;
			}
			else
			{
				currentPos = selectArray[0];
			}
		}
		
		else
		{
			if(((selectionOvalY + increment) > downLimit))
				selectionOvalY = yDefault;
			else
				selectionOvalY += increment;
		}

	}
	
	public void moveToY(int newY)
	{
		Sounds.move.play();
		selectionOvalY = newY;
	}
	
	public void moveToX(int newX)
	{
		Sounds.move.play();
		selectionOvalX = newX;
	}
	
	public int getY()
	{
		return selectionOvalY;
	}
	
	public int getX()
	{
		return selectionOvalX;
	}
}
