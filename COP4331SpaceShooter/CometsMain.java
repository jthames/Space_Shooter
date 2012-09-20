import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.*;
import java.io.*;

/**
 * This class is primarily responsible for organizing the game of Comets.  
 * The source code is provided to you and you must not modify it in any way.
 * @author Ben Douglass and Yiu Yu Ho
 */
public class CometsMain implements KeyListener
{
	// GUI Data
	private JFrame frame; // The window itself
	private JPanel playArea;  // The area where the game takes place
	
	
	/*
	 * Needs to be changed so that these are set to getting the dimensions of the computer
	 */
	private final int playWidth = 1200; // The width of the play area (in pixels)
	private final int playHeight = 800; // The height of the play area (in pixels)
	
	// Game Data
	private Ship ship; // The ship in play
	private Vector<Shot> shots; // The shots fired by the player
	private Vector<Comet> comets; // The comets floating around
	
	private boolean shipDead; // Whether or not the ship has been blown up
	private long shipTimeOfDeath; // The time at which the ship blew up
	
	// Keyboard data
	// Indicates whether the player is currently holding the accelerate, turn
	// left, or turn right buttons, respectively
	private boolean accelerateHeld = false;
	private boolean turnLeftHeld = false;
	private boolean turnRightHeld = false;
	
	// Indicates whether the player struck the fire key
	private boolean firing = false;
	
	// Set up the game and play!
	public CometsMain()
	{
		// Get everything set up
		configureGUI();
		configureGameData();
		
		// Display the window so play can begin
		frame.setVisible(true);
		
		// Start the gameplay
		playGame();
	}

	// Set up the game window
	private void configureGUI()
	{
		// Create the window object
		frame = new JFrame("Comets");
		frame.setSize(playWidth+20, playHeight+35);
		
		//Leave it non Resizable makes it easier
		frame.setResizable(false);
		
		// The program should end when the window is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Set the window's layout manager
		frame.setLayout(new FlowLayout());
		
		// Create the play area
		
		/*
		 * See if possible to add two extra panels here or if new "windows" need to be made.
		 */
		playArea = new JPanel();
		playArea.setPreferredSize(new Dimension(playWidth, playHeight));
		playArea.setBackground(Color.BLACK);
		playArea.setFocusable(false);
		frame.add(playArea);
		
		//Make the frame listen to keystrokes
		frame.addKeyListener(this);
	}
	
	// Set up the initial positions of all space objects
	private void configureGameData()
	{
		// Configure the play area size   : Might have to reduce if possible to add the panels in on the side 
		SpaceObject.playfieldWidth = playWidth;
		SpaceObject.playfieldHeight = playHeight;
		
		// Create the ship
		ship = new Ship(playWidth/2, playHeight/2, 0, 0);
		
		// Create the shot vector (initially, there shouldn't be any shots on the screen)
		shots = new Vector<Shot>();
		
		// Read the comets from comets.cfg
		comets = new Vector<Comet>();
		
		
		try
		{
			Scanner fin = new Scanner(new File("comets.in"));
			
			// Loop through each line of the file to read a comet
			
			
			/*
			 * Chris: Should change this code to randomly made comets? 
			 * also add random npc here. 
			 */
			while(fin.hasNext())
			{
				String cometType = fin.next();
				double xpos = fin.nextDouble();
				double ypos = fin.nextDouble();
				double xvel = fin.nextDouble();
				double yvel = fin.nextDouble();
				
				if(cometType.equals("Large")) comets.add(new LargeComet(xpos, ypos, xvel, yvel));
				else if(cometType.equals("Medium")) comets.add(new MediumComet(xpos, ypos, xvel, yvel));
				else if(cometType.equals("Small")) comets.add(new SmallComet(xpos, ypos, xvel, yvel));
			}
		}
		// If the file could not be read correctly for whatever reason, abort
		// the program
		catch(FileNotFoundException e)
		{
			System.err.println("Unable to locate comets.cfg");
			System.exit(0);
		}
		catch(Exception e)
		{
			System.err.println("comets.in is not in a proper format");
			System.exit(0);
		}
	}
	
	// The main game loop. This method coordinates everything that happens in
	// the game. 
	private void playGame()
	{
		while(true)
		{
			// Measure the current time in an effort to keep up a consistent
			// frame rate
			long time = System.currentTimeMillis();
			
			// If the ship has been dead for more than 3 seconds, revive it
			
			//Chris: New revive system: load last save? 
			if(shipDead && shipTimeOfDeath + 3000 < time)
			{
				shipDead = false;
				ship = new Ship(playWidth/2, playHeight/2, 0, 0);
			}
			
			// Process game events, move all the objects floating around,
			// and update the display
			if(!shipDead) handleKeyEntries();
			handleCollisions();
			moveSpaceObjects();
			drawObjects();
			
			// Sleep until it's time to draw the next frame 
			// (i.e. 32 ms after this frame started processing)
			try
			{
				long delay = Math.max(0, 32-(System.currentTimeMillis()-time));				
				Thread.sleep(delay);
			}
			catch(InterruptedException e)
			{
			}
		}
	}//ends private void playGame()
	
	private void drawObjects()
	{
		Graphics g = playArea.getGraphics();
		
		Image bufferImage = frame.createImage(playWidth, playHeight);
		Graphics T = bufferImage.getGraphics();
		
		T.setColor(Color.black);
		T.fillRect(0, 0, playWidth, playHeight);
		
		T.setColor(Color.white);
		if(!shipDead) drawShip(T, ship);
		
		T.setColor(Color.red);
		for(Shot s : shots) drawSpaceObject(T, s);
		
		T.setColor(Color.cyan);
		for(Comet c : comets) drawSpaceObject(T, c);
		
		g.drawImage(bufferImage, 0, 0, frame);
	}
	
	// Draws this ship s to the specified graphics context
	private void drawShip(Graphics g, Ship s)
	{	
		// Figure out where the ship should be drawn
		int radius = (int)s.getRadius();
		int xCenter = (int)s.getXPosition();
		int yCenter = (int)s.getYPosition();
		double gunTurretLength = s.getGunTurretLength();
		
		// Draw the ship body
		g.drawOval(xCenter - radius, yCenter - radius, radius*2, radius*2);
		
		// Draw the gun turret
		int guntipXoffset = (int)(gunTurretLength * Math.sin(s.getAngle()));
		int guntipYoffset = (int)(gunTurretLength * Math.cos(s.getAngle()));
		g.drawLine(xCenter, yCenter, xCenter + guntipXoffset, yCenter + guntipYoffset);
	}	
	
	// Draws the space object s to the the specified graphics context
	private void drawSpaceObject(Graphics g, SpaceObject s)
	{
		// Figure out where the object should be drawn
		int radius = (int)s.getRadius();
		int xCenter = (int)s.getXPosition();
		int yCenter = (int)s.getYPosition();
		
		// Draw the object
		g.drawOval(xCenter - radius, yCenter - radius, radius*2, radius*2);
	}
	
	// Check which keys have been pressed and respond accordingly
	private void handleKeyEntries()
	{
		// Ship movement keys
		if(accelerateHeld) ship.accelerate();
		
		// Ship rotation must be handled between erasing the ship at its old position
		// and drawing it at its new position so that artifacts aren't left on the screen
		if(turnLeftHeld) ship.rotateLeft();
		if(turnRightHeld) ship.rotateRight();

		// Shooting the cannon
		if(firing)
		{
			firing = false;
			shots.add(ship.fire());
		}
	}	
	
	// Deal with objects hitting each other
	// Removes shots and comets that are destroyed, as well as shots that are too old.
	private void handleCollisions()
	{		
		boolean[] shotsAlive = new boolean[shots.size()];
		boolean[] cometsAlive = new boolean[comets.size()];
		
		//Shots and Comets for the next iteration
		Vector<Shot> newShots = new Vector<Shot>();
		Vector<Comet> newComets = new Vector<Comet>();
		
		Arrays.fill(shotsAlive, true);
		Arrays.fill(cometsAlive, true);
		
		// Deal with shots blowing up comets
		for(int i = 0; i < shots.size(); i++) if(shotsAlive[i])
		{
			Shot s = shots.elementAt(i);
			for(int j = 0; j < comets.size(); j++) if(cometsAlive[j])
			{
				Comet c = comets.elementAt(j);
				
				// If a shot has hit a comet, destroy both the shot and comet
				if(s.overlapping(c))
				{
					// mark both as dead
					shotsAlive[i] = false;
					cometsAlive[j] = false;
					
					// New Comets spawn for the next frame
					// Keep this?
					newComets.addAll(c.explode());					
					break;
				}
			}
		}
		
		// Deal with comets blowing up the ship
		if(!shipDead)
		{
			for(int j = 0; j < comets.size(); ++j) if(cometsAlive[j])
			{
				Comet c = comets.elementAt(j);
				// If the ship hit a comet, kill the ship and mark down the time 
				if(c.overlapping(ship))
				{
					shipTimeOfDeath = System.currentTimeMillis();
					shipDead = true;
					break;
				}
			}			
		}
		
		//Deals with shots blowing up ship, in this case both shot and ship dies.
		if(!shipDead)
		{
			for(int i = 0; i < shots.size(); ++i) if(shotsAlive[i])
			{
				Shot s = shots.elementAt(i);
				if(s.overlapping(ship))
				{
					shipTimeOfDeath = System.currentTimeMillis();
					shipDead = true;
					shotsAlive[i] = false;
					break;
				}
			}
		}
		
		for(int i = 0; i < shots.size(); ++i) if(shotsAlive[i]) 
		{
			Shot s = shots.elementAt(i);
			if(s.getAge() < 90) newShots.add(s);
		}
		
		for(int j = 0; j < comets.size(); ++j) if(cometsAlive[j]) newComets.add(comets.elementAt(j));
		
		shots = newShots;
		comets = newComets;
	}//ends private void handleCollisions()
	
	// Deal with moving all the objects that are floating around
	private void moveSpaceObjects()
	{	
		// Handle the movements of all objects in the field
		if(!shipDead) ship.move();
		for(Shot s : shots) s.move();
		for(Comet c : comets) c.move();
	}

	// Deals with keyboard keys being pressed
	public void keyPressed(KeyEvent key)
	{
		// Mark down which important keys have been pressed
		if(key.getKeyCode() == KeyEvent.VK_UP) this.accelerateHeld = true;
		if(key.getKeyCode() == KeyEvent.VK_LEFT) this.turnLeftHeld = true;
		if(key.getKeyCode() == KeyEvent.VK_RIGHT) this.turnRightHeld = true;
		if(key.getKeyCode() == KeyEvent.VK_SPACE && !shipDead) this.firing = true;
	}

	// Deals with keyboard keys being released
	public void keyReleased(KeyEvent key)
	{
		// Mark down which important keys are no longer being pressed
		if(key.getKeyCode() == KeyEvent.VK_UP) this.accelerateHeld = false;
		if(key.getKeyCode() == KeyEvent.VK_LEFT) this.turnLeftHeld = false;
		if(key.getKeyCode() == KeyEvent.VK_RIGHT) this.turnRightHeld = false;
	}

	// This method is not actually used, but is required by the KeyListener interface
	public void keyTyped(KeyEvent key)
	{
	}
	
	public static void main(String[] args)
	{
		// A GUI program begins by creating an instance of the GUI
		// object. The program is event driven from that point on.
		new CometsMain();
	}
}
