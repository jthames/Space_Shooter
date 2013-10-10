/**************************************************************************
***************************************************************************
* 	
*     ============    Team 2  -  Project 6: Space Shooter    ============
*     	
*	FILE NAME: Sound.java
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

import javax.sound.sampled.*;
import java.io.*;



public class Sound{
	
	public AudioInputStream audio;//The sound file
	public Clip clip;//The sound player
	
	//Thadd: Using the string given the program grabs the sound associated
	// from the path.
	Sound(String filename) 
	{
		try
		{
			 audio = AudioSystem.getAudioInputStream(new File(filename)); // Get the Sound file
			 clip = AudioSystem.getClip();//Make the object that plays the sound
             clip.open(audio);
		}
		
		catch(UnsupportedAudioFileException uae) {
            System.out.println(uae);
    }
    catch(IOException ioe) {
            System.out.println(ioe);
    }
    catch(LineUnavailableException lua) {
            System.out.println(lua);
    }   
}

	//Thadd: This method plays the sound
	public void play()
	{
		//Thadd: if the clip is playing, stop it before you start again
		if(clip.isRunning())
			clip.stop();
		//Thadd: Make sure the sound starts at the beginning
		clip.setMicrosecondPosition(0);
		//Thadd: play the clip
		clip.start();	
	}
	
	public void startLoop()
	{
		clip.loop(1000);
	}
	
	public void endLoop()
	{
		clip.stop();
		clip.setMicrosecondPosition(0);
	}
}