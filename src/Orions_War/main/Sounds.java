/**************************************************************************
***************************************************************************
* 	
*     ============    Team 2  -  Project 6: Space Shooter    ============
*     	
*	FILE NAME: Sounds.java
*	AUTHOR(S): Thaddeus Latsa
*	DATE OF FIRST VERSION: 11/24/2012
*	DATE LAST MODIFIED: 11/30/2012
*	UNIT TESTING COMPLETED: Yes
*	STATUS OF UNIT TESTING: No Problems
*	INTEGRATION TESTING COMPLETED: Yes
*	PURPOSE OF FILE IN THE SYSTEM: This file enables us to use sounds
*   for the program
*
***************************************************************************
**************************************************************************/
package Orions_War.main;

public class Sounds {
	
	//Thadd: Sets up the sound variables to be used
	
	public static Sound buy;
	public static Sound move;
	public static Sound select;
	public static Sound shotSound;
	public static Sound Explosion1;
	public static Sound Explosion2;
	public static Sound Wilhelm;
	public static Sound Background;
	
	public Sounds()
	{
	    //Thadd: Associates each sound with a variable
		buy = new Sound("sounds/chaChing.wav");
	    move = new Sound("sounds/menuMoveSound.wav");
	    select = new Sound("sounds/menuSelectSound.wav");
	    shotSound = new Sound("sounds/Photon shot.wav");
	    Explosion1 = new Sound("sounds/Explosion1.wav");
	    Explosion2 = new Sound("sounds/Explosion2.wav");
	    Wilhelm = new Sound("sounds/WilhelmScream.wav");
	    Background = new Sound("sounds/spaceMission1.wav");
	    System.out.println("Loading Sounds");
	}

}