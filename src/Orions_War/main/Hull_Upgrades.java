/**************************************************************************
***************************************************************************
* 	
*     ============    Team 2  -  Project 6: Space Shooter    ============
*     	
*	FILE NAME: hulls_Upgrades.java
*	AUTHOR(S): Alexander Banke
*	DATE OF FIRST VERSION: 11/01/2012
*	DATE LAST MODIFIED: 11/01/2012
*	UNIT TESTING COMPLETED: Yes
*	STATUS OF UNIT TESTING: No Problems
*	INTEGRATION TESTING COMPLETED: Yes
*	PURPOSE OF FILE IN THE SYSTEM: This file enables us to deal with
*   everything used for updating hulls, whether purchased equipped etc
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

public class Hull_Upgrades 
{
	// Alex Banke: This class works exactly as Weapon_Upgrades
	// if you have any questions look at the comments in Weapon_Upgrades
   public static ArrayList<Integer> Hull_Cost = new ArrayList<Integer>();
   public static ArrayList<Integer> Health = new ArrayList<Integer>();
   public static int current_hull[] = new int[3];
   public static int purchased_hull[] = new int[3];
   
   public void initialize_stats()
   {
	   Hull_Cost.add(10000);
	   Hull_Cost.add(15000);
	   Hull_Cost.add(20000);
	   Health.add(50);
	   Health.add(100);
	   Health.add(150);
	   current_hull[0] = 0;
	   current_hull[1] = 0;
	   current_hull[2] = 0;
	   purchased_hull[0] = 0;
	   purchased_hull[1] = 0;
	   purchased_hull[2] = 0;
   }
   
   public int getCurrentHull()
   {
	   for(int x = 0; x < 3; x++)
	   {
		   if(current_hull[x] == 1)
		   {
			   return x;
		   }
	   
	   }
	   return -1; 
   }
   
   public void update_purhcased_Hulls(int n)
   {
	   purchased_hull[n] = 1;
	   update_equipped_Hull(n);
   }
   
   public void update_equipped_Hull(int n)
   {
	  
	  for(int x = 0;x < 3; x++)
	  {
		current_hull[x] = 0; 
	  }
	   current_hull[n] = 1;
	  
   }
   public int update_Hull()
   {
	   if(getCurrentHull() != -1)
	   return Health.get(getCurrentHull());
	   else
	   return 0;
   }

   public int check_purchased_Hulls(int n)
   {
	  if(purchased_hull[n] == 1)
		{
		  return 1;
		}
	  else
		  return 0;
   }
   
}
