/**************************************************************************
***************************************************************************
* 	
*     ============    Team 2  -  Project 6: Space Shooter    ============
*     	
*	FILE NAME: BufferedImageLoader.java
*	AUTHOR(S): Alexander Banke
*	DATE OF FIRST VERSION: 11/01/2012
*	DATE LAST MODIFIED: 11/01/2012
*	UNIT TESTING COMPLETED: Yes
*	STATUS OF UNIT TESTING: No Problems
*	INTEGRATION TESTING COMPLETED: Yes
*	PURPOSE OF FILE IN THE SYSTEM: This file enables us to use sprite
*   Sheets to grab sub images from them.
*
***************************************************************************
**************************************************************************/
package Orions_War.main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class BufferedImageLoader
{
	// Alex Banke: Loads the spritesheet into the BufferedImage
  public BufferedImage loadImage(String Path_To_SpriteSheet) throws IOException
  {
	  BufferedImage img = ImageIO.read(new File(Path_To_SpriteSheet));
	  return img;
  }
	
	
	
}
