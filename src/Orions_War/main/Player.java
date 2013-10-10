/**************************************************************************
 ***************************************************************************
 * 	
 *     ============    Team 2  -  Project 6: Space Shooter    ============
 *     	
 *	FILE NAME: Player.java
 *	AUTHOR(S): Christopher Margol
 *	DATE OF FIRST VERSION: 11/01/2012
 *	DATE LAST MODIFIED: 11/01/2012
 *	UNIT TESTING COMPLETED: Yes
 *	STATUS OF UNIT TESTING: No Problems
 *	INTEGRATION TESTING COMPLETED: Yes
 *	PURPOSE OF FILE IN THE SYSTEM: This file enables us to deal with
 *   everything used for the player such as their ship and currency
 *
 ***************************************************************************
 **************************************************************************/

package Orions_War.main;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public class Player 
{
	
	public static String playerName = "Default";
	
	public static int progress = 1;
	
	/*Integration of the credits and experience variable. 
	 * Yielding result is now current_credits and max_credits.
	 * This is for simplifying the high score tracker, we will just follow
	 * tracking the credits.
	 */
	public static int credits = 0;
	public static int score = 0;
	public static int shipHealth = 100;
	public static int shipDamage = 50;
	public static double acceleration = 1;
	public static double maxSpeed = 25;
	public static BufferedImage ship = null;
	public static Player_Ship Ship = new Player_Ship(500,790,25,25,shipHealth,shipDamage,acceleration,maxSpeed);
	
	
	public void saveGame() throws IOException
	{
		System.out.println("in savegame...");
		System.out.println(System.getProperty("user.dir"));
		
		
		File saveManifest = null;
		File saveCurrent = null;
		File updateCurrent = null;
		File updatedManifest = null;
		if(Main.newGameMenu.hasFocus())
		{  
			playerName = Main.newGameMenu.getNewName();
			while(playerName.equalsIgnoreCase(""))
			{
				
			}
			
		    saveCurrent = new File(System.getProperty("user.dir")+"/saves/", playerName+".txt");
		
		System.out.println(saveCurrent);
		
		saveCurrent.createNewFile();
		
		
		saveManifest = new File(System.getProperty("user.dir")+ "/saves/List_Of_Saves.txt");
		if(saveManifest == null) System.out.println("file null");
		
		
		Scanner manifestReader = null;
		PrintWriter manifestWriter = null;
		PrintWriter saveWriter = null;
		
		try 
		{
			manifestReader = new Scanner(saveManifest);
			saveWriter = new PrintWriter(saveCurrent);
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int numSaves = manifestReader.nextInt();
		int counter = numSaves;
		ArrayList<String> saveNames = new ArrayList<String>();
		
		for(int i = 0; i < numSaves; i++)
		{
			if(manifestReader.hasNext())
			{
			 saveNames.add(manifestReader.next());
			}
		}
		 saveNames.add(playerName);
		 counter++;
		
		saveManifest.delete();
		
		updatedManifest = new File(System.getProperty("user.dir")+"/saves", "List_Of_Saves.txt");
		
		
		try 
		{
			manifestWriter = new PrintWriter(updatedManifest);
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		numSaves = counter;
		manifestWriter.println(numSaves);
		for(int i = 0; i < numSaves; i++)
		{
			manifestWriter.print(saveNames.get(i));
			if((numSaves - i) > 1) manifestWriter.println();
		}
		
		saveWriter.println(playerName);
		saveWriter.println(progress);
		saveWriter.println(credits);
		saveWriter.println(score);
		saveWriter.println(shipHealth);
		saveWriter.println(shipDamage);
		saveWriter.println(acceleration);
		saveWriter.println(maxSpeed);
		
		int numItems = 3;
		int j = 0;
		
		for(j = 0; j < numItems; j++)
		{
			saveWriter.println(Ship.Ship_Engine.current_Engine[j]);
		}
		
		for(j = 0; j < numItems; j++)
		{
			saveWriter.println(Ship.Ship_Engine.purchased_Engine[j]);
		}
		
		for(j = 0; j < numItems; j++)
		{
			saveWriter.println(Ship.Ship_Thrusters.current_Thruster[j]);
		}
		
		for(j = 0; j < numItems; j++)
		{
			saveWriter.println(Ship.Ship_Thrusters.purchased_Thruster[j]);
		}
		
		for(j = 0; j < numItems; j++)
		{
			saveWriter.println(Ship.Ship_Hull.current_hull[j]);
		}
		
		for(j = 0; j < numItems; j++)
		{
			saveWriter.println(Ship.Ship_Hull.purchased_hull[j]);
		}
		
		for(j = 0; j < numItems; j++)
		{
			saveWriter.println(Ship.Ship_Weapon.current_Weapon[j]);
		}
		
		for(j = 0; j < numItems; j++)
		{
			saveWriter.println(Ship.Ship_Weapon.purchased_Weapon[j]);
		}
		
		
		manifestReader.close();
		manifestWriter.close();
		saveWriter.close();
		
		System.out.println("finished saving file");
		}
		else
		{
			
		   
		  updateCurrent = new File(System.getProperty("user.dir")+"/saves/", playerName+".txt");
		  
		
	
		PrintWriter saveWriter = null;
		
		try 
		{
			
			saveWriter = new PrintWriter(updateCurrent);
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		saveWriter.println(playerName);
		saveWriter.println(progress);
		saveWriter.println(credits);
		saveWriter.println(score);
		saveWriter.println(shipHealth);
		saveWriter.println(shipDamage);
		saveWriter.println(acceleration);
		saveWriter.println(maxSpeed);
		
		int numItems = 3;
		int j = 0;
		
		for(j = 0; j < numItems; j++)
		{
			saveWriter.println(Ship.Ship_Engine.current_Engine[j]);
		}
		
		for(j = 0; j < numItems; j++)
		{
			saveWriter.println(Ship.Ship_Engine.purchased_Engine[j]);
		}
		
		for(j = 0; j < numItems; j++)
		{
			saveWriter.println(Ship.Ship_Thrusters.current_Thruster[j]);
		}
		
		for(j = 0; j < numItems; j++)
		{
			saveWriter.println(Ship.Ship_Thrusters.purchased_Thruster[j]);
		}
		
		for(j = 0; j < numItems; j++)
		{
			saveWriter.println(Ship.Ship_Hull.current_hull[j]);
		}
		
		for(j = 0; j < numItems; j++)
		{
			saveWriter.println(Ship.Ship_Hull.purchased_hull[j]);
		}
		
		for(j = 0; j < numItems; j++)
		{
			saveWriter.println(Ship.Ship_Weapon.current_Weapon[j]);
		}
		
		for(j = 0; j < numItems; j++)
		{
			saveWriter.println(Ship.Ship_Weapon.purchased_Weapon[j]);
		}

		saveWriter.close();
		
		System.out.println("finished saving file");
		
		}
		
	}
	
	public void Update_Player_Name(String name)
	{
		playerName = name;
	}
	
	public static void loadSave(File saveFile)
	{
		Scanner saveReader = null;
		try
		{
			saveReader = new Scanner(saveFile);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		System.out.println(playerName);

		playerName = saveReader.nextLine();
		System.out.println(playerName);
		
		progress = saveReader.nextInt();
		System.out.println(progress);
		
		credits = saveReader.nextInt();
		System.out.println(credits);
		
		score = saveReader.nextInt();
		System.out.println(score);
		
		shipHealth = saveReader.nextInt();
		System.out.println(shipHealth);
		
		shipDamage = saveReader.nextInt();
		System.out.println(shipDamage);
		
		acceleration = Double.valueOf(saveReader.next());
		System.out.println(acceleration);
		
		maxSpeed = Double.valueOf(saveReader.next());
		System.out.println(maxSpeed);
		
		Ship.Ship_Engine.current_Engine[0] = saveReader.nextInt();
		Ship.Ship_Engine.current_Engine[1] = saveReader.nextInt();
		Ship.Ship_Engine.current_Engine[2] = saveReader.nextInt();
			
		Ship.Ship_Engine.purchased_Engine[0] = saveReader.nextInt();
		Ship.Ship_Engine.purchased_Engine[1] = saveReader.nextInt();
		Ship.Ship_Engine.purchased_Engine[2] = saveReader.nextInt();
			
		Ship.Ship_Thrusters.current_Thruster[0] = saveReader.nextInt();
		Ship.Ship_Thrusters.current_Thruster[1] = saveReader.nextInt();
		Ship.Ship_Thrusters.current_Thruster[2] = saveReader.nextInt();
			
		Ship.Ship_Thrusters.purchased_Thruster[0] = saveReader.nextInt();
		Ship.Ship_Thrusters.purchased_Thruster[1] = saveReader.nextInt();
		Ship.Ship_Thrusters.purchased_Thruster[2] = saveReader.nextInt();
		
		Ship.Ship_Hull.current_hull[0] = saveReader.nextInt();
		Ship.Ship_Hull.current_hull[1] = saveReader.nextInt();
		Ship.Ship_Hull.current_hull[2] = saveReader.nextInt();
		
		Ship.Ship_Hull.purchased_hull[0] = saveReader.nextInt();
		Ship.Ship_Hull.purchased_hull[1] = saveReader.nextInt();
		Ship.Ship_Hull.purchased_hull[2] = saveReader.nextInt();
		
		Ship.Ship_Weapon.current_Weapon[0] = saveReader.nextInt();
		Ship.Ship_Weapon.current_Weapon[1] = saveReader.nextInt();
		Ship.Ship_Weapon.current_Weapon[2] = saveReader.nextInt();
		
		Ship.Ship_Weapon.purchased_Weapon[0] = saveReader.nextInt();
		Ship.Ship_Weapon.purchased_Weapon[1] = saveReader.nextInt();
		Ship.Ship_Weapon.purchased_Weapon[2] = saveReader.nextInt();
		
		set_current_ship_image();
		Ship.update_parts();
		
		saveReader.close();
	}
	
	public static void printPlayer()
	{
		System.out.println();
		System.out.println("Currently loaded player:"+playerName);
		System.out.println("Progress value: "+progress);
		System.out.println("Credit value: "+credits);
		System.out.println("Score vale:" + score);
		System.out.println("Ship health: "+shipHealth);
		System.out.println("Ship damage: "+shipDamage);
		System.out.println("Ship acceleration: "+acceleration);
		System.out.println("Ship max speed: "+maxSpeed);
	}
	
	public static void set_current_ship_image()
	{  
	  BufferedImage spriteSheet = null;
			 BufferedImageLoader loader = new BufferedImageLoader();

			 try {
			 				spriteSheet = loader.loadImage("images/Ship_Shop/Ship_Combinations.png");
			 			} catch (IOException e) {
			 				// TODO Auto-generated catch block
			 				e.printStackTrace();
			 			}
			 	    	 

			 if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 0 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 0 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 0)
			 {
			   ship = spriteSheet.getSubimage(7,675,125,150);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 0 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 0 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 1)
			 {
			  ship = spriteSheet.getSubimage(7,854,135,138);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 0 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 0 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 2)
			 {
			  ship = spriteSheet.getSubimage(8,1012,138,151);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 0 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 0 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == -1)
			 {
			   ship = spriteSheet.getSubimage(634,358,106,131);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 0 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 0)
			 {
			   ship = spriteSheet.getSubimage(226,684,122,134);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 0 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 1)
			 {
			   ship = spriteSheet.getSubimage(217,847,132,134);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 0 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 2)
			 {
			   ship = spriteSheet.getSubimage(215,1007,136,149);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 0 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == -1)
			 {
			   ship = spriteSheet.getSubimage(634,357,106,132);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 2 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 0 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 0)
			 {
			   ship = spriteSheet.getSubimage(445,691,127,128);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 2 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 0 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 1)
			 {
			  ship = spriteSheet.getSubimage(443,851,126,141);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 2 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 0 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 2)
			 {
			  ship = spriteSheet.getSubimage(422,1011,139,151);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 2 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 0 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == -1)
			 {
			   ship = spriteSheet.getSubimage(633,511,109,134);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == -1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 0 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 0)
			 {
			  ship = spriteSheet.getSubimage(631,882,123,89);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == -1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 0 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 1)
			 {
			  ship = spriteSheet.getSubimage(632,1053,126,112);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == -1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 0 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 2)
			 {
			  ship = spriteSheet.getSubimage(626,1222,136,108);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == -1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 0 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == -1)
			 {
			  ship = spriteSheet.getSubimage(628,17,107,83);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 0 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 0)
			 {
			  ship = spriteSheet.getSubimage(13,1183,122,138);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 0 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 1)
			 {
			  ship = spriteSheet.getSubimage(9,1351,124,135);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 0 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 2)
			 {
			  ship = spriteSheet.getSubimage(632,1347,136,151);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 0 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == -1)
			 {
			  ship = spriteSheet.getSubimage(851,187,109,134);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 0)
			 {
			  ship = spriteSheet.getSubimage(220,1176,120,135);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 1)
			 {
			  ship = spriteSheet.getSubimage(218,1343,122,141);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 2)
			 {
			  ship = spriteSheet.getSubimage(836,1340,139,152);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == -1)
			 {
			  ship = spriteSheet.getSubimage(852,357,105,136);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 2 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 0)
			 {
			  ship = spriteSheet.getSubimage(433,1177,119,134);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 2 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 1)
			 {
			  ship = spriteSheet.getSubimage(427,1346,129,142);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 2 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 2)
			 {
			  ship = spriteSheet.getSubimage(1039,1342,148,152);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 2 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == -1)
			 {
			  ship = spriteSheet.getSubimage(847,519,113,127);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == -1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 0)
			 {
			  ship = spriteSheet.getSubimage(845,877,132,85);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == -1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 1)
			 {
			  ship = spriteSheet.getSubimage(845,1053,136,109);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == -1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 2)
			 {
			  ship = spriteSheet.getSubimage(840,1217,136,115);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == -1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == -1)
			 {
			  ship = spriteSheet.getSubimage(847,13,115,87);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 0 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 2 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 0)
			 {
			  ship = spriteSheet.getSubimage(8,1518,131,139);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 0 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 2 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 1)
			 {
			  ship = spriteSheet.getSubimage(635,1509,129,137);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 0 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 2 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 2)
			 {
			  ship = spriteSheet.getSubimage(2,1680,144,142);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 0 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 2 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == -1)
			 {
			  ship = spriteSheet.getSubimage(1083,186,110,135);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 2 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 0)
			 {
			  ship = spriteSheet.getSubimage(219,1512,121,142);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 2 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 1)
			 {
			   ship = spriteSheet.getSubimage(843,1503,127,136);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 2 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 2)
			 {
			  ship = spriteSheet.getSubimage(205,1670,148,149);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 2 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == -1)
			 {
			  ship = spriteSheet.getSubimage(1085,357,106,134);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 2 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 2 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 0)
			 {
			  ship = spriteSheet.getSubimage(432,1516,121,131);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 2 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 2 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 1)
			 {
			  ship = spriteSheet.getSubimage(1049,1505,135,142);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 2 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 2 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 2)
			 {
			 ship = spriteSheet.getSubimage(416,1671,144,152);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 2 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 2 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == -1)
			 {
			 ship = spriteSheet.getSubimage(1085,515,108,131);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == -1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 2 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 0)
			 {
			  ship = spriteSheet.getSubimage(1061,878,123,89); 
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == -1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 2 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 1)
			 {
			 ship = spriteSheet.getSubimage(1061,1058,127,107);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == -1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 2 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 2)
			 {
			 ship = spriteSheet.getSubimage(1053,1220,137,117);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == -1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == 2 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == -1)
			 {
			 ship = spriteSheet.getSubimage(1088,9,108,91);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 0 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == -1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 0)
			 {
			 ship = spriteSheet.getSubimage(25,189,128,138);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 0 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == -1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 1)
			 {
			 ship = spriteSheet.getSubimage(23,357,126,138);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 0 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == -1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 2)
			 {
			 ship = spriteSheet.getSubimage(16,519,141,149);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 0 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == -1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == -1)
			 {
			 ship = spriteSheet.getSubimage(34,4,111,137);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == -1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 0)
			 {
			 ship = spriteSheet.getSubimage(230,182,127,143);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == -1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 1)
			 {
			 ship = spriteSheet.getSubimage(231,350,128,136);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == -1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 2)
			 {
			 ship = spriteSheet.getSubimage(218,510,147,152);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == -1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == -1)
			 {
			 ship = spriteSheet.getSubimage(242,9,108,134);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 2 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == -1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 0)
			 {
			 ship = spriteSheet.getSubimage(446,184,126,140);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 2 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == -1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 1)
			 {
			 ship = spriteSheet.getSubimage(439,355,133,144);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 2 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == -1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 2)
			 {
			 ship = spriteSheet.getSubimage(434,513,138,156);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == 2 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == -1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == -1)
			 {
			 ship = spriteSheet.getSubimage(448,6,118,137);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == -1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == -1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 0)
			 {
			 ship = spriteSheet.getSubimage(636,720,119,89);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == -1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == -1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 1)
			 {
			 ship = spriteSheet.getSubimage(842,727,125,110);
			 }//
			 else if(Main.Player1.Ship.Ship_Hull.getCurrentHull() == -1 && Main.Player1.Ship.Ship_Engine.getCurrentEngine() == -1 && Main.Player1.Ship.Ship_Thrusters.getCurrentThruster() == 2)
			 {
			 ship = spriteSheet.getSubimage(1048,707,140,112);
			 }
			 else
			 {
			 ship = spriteSheet.getSubimage(644,1716,108,85);
			 }	    		    
	}
	
}
