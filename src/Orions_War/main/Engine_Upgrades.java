/**************************************************************************
***************************************************************************
* 	
*     ============    Team 2  -  Project 6: Space Shooter    ============
*     	
*	FILE NAME: Engine_Upgrades.java
*	AUTHOR(S): Alexander Banke
*	DATE OF FIRST VERSION: 11/01/2012
*	DATE LAST MODIFIED: 11/01/2012
*	UNIT TESTING COMPLETED: Yes
*	STATUS OF UNIT TESTING: No Problems
*	INTEGRATION TESTING COMPLETED: Yes
*	PURPOSE OF FILE IN THE SYSTEM: This file enables us to deal with
*   everything used for updating engines, whether purchased equipped etc
*
***************************************************************************
**************************************************************************/

package Orions_War.main;

import java.awt.Color; 
import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import java.util.ArrayList;

public class Engine_Upgrades 
{
	// Alex Banke: This class works exactly as Weapon_Upgrades
	// if you have any questions look at the comments in Weapon_Upgrades
   public static ArrayList<Integer> Engine_Cost = new ArrayList<Integer>();
   public static ArrayList<Integer> Max_Speed = new ArrayList<Integer>();
   public static int current_Engine[] = new int[3];
   public static int purchased_Engine[] = new int[3];
   
   public void initialize_stats()
   {
	   Engine_Cost.add(10000);
	   Engine_Cost.add(15000);
	   Engine_Cost.add(20000);
	   Max_Speed.add(50);
	   Max_Speed.add(100);
	   Max_Speed.add(150);
	   current_Engine[0] = 0;
	   current_Engine[1] = 0;
	   current_Engine[2] = 0;
	   purchased_Engine[0] = 0;
	   purchased_Engine[1] = 0;
	   purchased_Engine[2] = 0;
   }
   
   public int getCurrentEngine()
   {
	   for(int x = 0; x < 3; x++)
	   {
		   if(current_Engine[x] == 1)
		   {
			   return x;
		   }
	   
	   }
	   return -1; 
   }
   public int check_purchased_engines(int n)
   {
	  if(purchased_Engine[n] == 1)
		{
		  return 1;
		}
	  else
		  return 0;
   }
   
   public void update_purhcased_Engines(int n)
   {
	   purchased_Engine[n] = 1;
	   update_equipped_engine(n);
   }
   
   public void update_equipped_engine(int n)
   {
	  
	  for(int x = 0;x < 3; x++)
	  {
		current_Engine[x] = 0; 
	  }
	   current_Engine[n] = 1;
	  
   }
   
   public double update_Engine()
   {
	   if(getCurrentEngine() != -1)
	   return (double)Max_Speed.get(getCurrentEngine());
	   else
	   return 0.0;
   }
   
}