/**************************************************************************
 ***************************************************************************
 * 	
 *     ============    Team 2  -  Project 6: Space Shooter    ============
 *     	
 *	FILE NAME: Game_Screen2.java
 *	AUTHOR(S): Christopher Margol
 *	DATE OF FIRST VERSION: 11/01/2012
 *	DATE LAST MODIFIED: 11/01/2012
 *	UNIT TESTING COMPLETED: Yes
 *	STATUS OF UNIT TESTING: No Problems
 *	INTEGRATION TESTING COMPLETED: Yes
 *	PURPOSE OF FILE IN THE SYSTEM: This file enables us to deal with
 *   everything used for level 2
 *
 ***************************************************************************
 **************************************************************************/
package Orions_War.main;


import java.awt.Color; 
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import java.awt.Font;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@SuppressWarnings("serial")
public class Game_Screen2 extends JPanel implements KeyListener
{
	public static double current_yVel, current_xVel;
	private static Color backgroundColor = Color.black;
	private static Color textColor = Color.white;

	
	

	
	private static Dimension windowSize = new Dimension(1000,800);
	private static Image img1;
	
	//TODO: make the selectionOval its own class
	private static int selectionOvalWidth = 3;
	private static int selectionOvalHeight = 3;
	public static int Ship_Pos_X = 400,Ship_Pos_Y = 700;
	public static Random generator;
	volatile public static ArrayList<Shot> shots = new ArrayList <Shot>();
	public static  int xPosition = 0;
	public static int count =0;
	volatile public static ArrayList <Asteroids> Enemy_Asteroids = new ArrayList <Asteroids>();
    volatile public static ArrayList <NPC_Ships> Enemy_NPC_Ships = new ArrayList <NPC_Ships>();
    volatile public static ArrayList <Enemy_Shot> Enemy_Shots = new ArrayList<Enemy_Shot>();
    volatile public static ArrayList <Enemy_Shot> Enemy_Shots2 = new ArrayList<Enemy_Shot>();
	volatile public static ArrayList<Shot> newShots = new ArrayList<Shot>();
	volatile public static ArrayList<NPC_Ships> newEnemies = new ArrayList<NPC_Ships>();
	volatile public static ArrayList<Enemy_Shot> newEnemyShots = new ArrayList<Enemy_Shot>();
    volatile public static ArrayList<Asteroids> newAsteroids = new ArrayList<Asteroids>();
	public static boolean Ship_Alive = true,levelFinished = false;
	public static File level = null;
	public static  Scanner sc = null;
	public static int level_score = 0;
	public Thread thr1,thr2,thr3,thr4,thr5,thr10,thr13,thr15;
	// These are the bool fields that correspond to in game key presses
	private boolean upPress, downPress, leftPress, rightPress, spacePress, escPressed;
	public static Player_Ship cur_ship = Main.Player1.Ship;
	public static int all_spawned = 0;
	
	public Game_Screen2()
	{
	    cur_ship.xPosition = Ship_Pos_X;
	    cur_ship.yPosition = Ship_Pos_Y;
		System.out.println("Game Screen created");
        ImageIcon icon = new ImageIcon("images/spacefield.png");
		
		img1 = icon.getImage();

		this.setBackground(backgroundColor);
		this.setSize(windowSize);
		this.setOpaque(true);
		
		//NOTE: for focusing, these must not be set in the constructor. Undesirable focus behavior results from doing so
		//this.setVisible(true); // needed to focus
		//this.setFocusable(true); // needed to focus
		//this.setEnabled(true); // needed to focus
		
		this.addKeyListener(this);
		//this.addMouseListener(new NewGameMenuMouseAdapter(this));
		//System.out.println("requesting focus: " + this.requestFocus());
		
		//added so that manual position of JComponents would be feasible
		this.setLayout(null);
		
		
		upPress = false;
		downPress = false;
		leftPress = false;
		rightPress = false;
		spacePress = false;
		escPressed = false;
		
		
	}
	
	 
	 
	 
//Need to figure out how to do double buffering.. 
	 
	 /*
	  * Double Buffering: We create image before displaying it
	  * 
	  * Thoughts: Need function to load next image and always display one screen previous
	  * 
	  * 
	  * 
	  * Draw ship graphics image then display graphics repeatedly (this way we can just add things to buffered graphics image and then display those)
	  * 
	  */
	public void play() throws FileNotFoundException
	{
		System.setProperty("sun.java2d.pmoffscreen", "false");
		  System.setProperty("org.apache.pivot.wtk.disablevolatilebuffer",
                "false");
		  
		  	
		  	enemies NPC = new enemies();
		  	
		  	//enemies.spawnenemies1();
		 	//this.setVisible(true);
		 
			//this.setEnabled(true);
			//this.setFocusable(true);
		
			Graphics g = Main.Game_Screen2.getGraphics();
		    g.drawImage(img1, 0, 0, 1010,805, Main.Game_Screen2);
			g.drawImage(Main.Player1.ship,Ship_Pos_X,Ship_Pos_Y, (Main.Player1.ship.getWidth())/2,(Main.Player1.ship.getHeight())/2,this);
		      Toolkit.getDefaultToolkit().sync();
			//this.requestFocusInWindow();

		     Sounds.Background.startLoop();
		
		Runnable r1 = new Runnable()
		{ 		
			public void run()
			{Main.Game_Screen2.setDoubleBuffered(true);
			
				while(!levelFinished && Ship_Alive)
				{
					Graphics g = Main.Game_Screen2.getGraphics();
				
					g.drawImage(img1, 0, 0, 1000,800, Main.Game_Screen2);
					g.drawImage(Main.Player1.ship,Ship_Pos_X,Ship_Pos_Y, (Main.Player1.ship.getWidth())/2,(Main.Player1.ship.getHeight())/2,Main.Game_Screen2);
					
	                g.setColor(Color.white);
					g.setFont(new Font("Serif",Font.PLAIN,20));
					g.drawString("Current Health: " + Main.Player1.Ship.current_health, 800, 700);
					g.drawString("Current Score: " + level_score,800,750);
					deal_with_enemy_shots_fired(g);
					deal_with_shots_fired(g);
					enemies.drawAll(g);
					//deal_with_enemy_shots_fired2(g);
					spawn_the_asteroids(g);
					//AsteroidHandler.drawAll(g);
					Toolkit.getDefaultToolkit().sync();
					try
					{
						Thread.sleep(30);
					}
						catch(InterruptedException e)
						{
						}
				}
			}
			
		};
		
		Runnable r2 = new Runnable()
		{
			public void run()
			{
				while(!levelFinished && Ship_Alive)
				{
					HandlekeyActions2();
				try
				{

					Thread.sleep(125);	
				}
					catch(InterruptedException e)
					{
					}
				}
			}
		};
		
		Runnable r3 = new Runnable()
		{
			public void run()
			{
				while(!levelFinished && Ship_Alive)
				{
					HandlekeyActions();	
				try
				{
					Thread.sleep(30);	
				}
					catch(InterruptedException e)
					{
					}
				}
			}
		};
		
		Runnable r4 = new Runnable()
		{
			public void run()
			{
				while(!levelFinished && Ship_Alive)
				{
				Graphics g = Main.Game_Screen2.getGraphics();
					updateShip();
					enemies.moveAll();
					enemies.handleOffScreen();
					Asteroids.moveAll();
					Asteroids.handleOffScreen();
					
					    Handle_Collisions();
						Toolkit.getDefaultToolkit().sync();				
			
					
				
				try
				{
					Thread.sleep(30);	
				}
					catch(InterruptedException e)
					{
					}
				}
			}
		};
		
		
		Runnable r5 = new Runnable()
		{
			public void run()
			{
				while(!levelFinished && Ship_Alive)
				{   int x;
				    if(!enemies.enemies.isEmpty())
					for(x = 0; x < enemies.enemies.size(); x++)
					{   
						Enemy_Shots.add(new Enemy_Shot(enemies.enemies.get(x).type,enemies.enemies.get(x).xPosition + 25,enemies.enemies.get(x).yPosition,0,15));
					}
				    
				    //Handle_Collisions();
					Toolkit.getDefaultToolkit().sync();				
				try
				{
					Thread.sleep(1500);	
				}
					catch(InterruptedException e)
					{
					}
				}
			}
		};

		
		Runnable r10 = new Runnable()
		{

			@Override
			public void run() 
			{  
			
				enemies.spawnenemies2();
				
				
				Main.Game_Screen2.setDoubleBuffered(true);				
				while(!levelFinished && Ship_Alive)
				{
					//AsteroidHandler.spawnAsteroids(1500);
					try
					{	
						Thread.sleep(30);
					}
					catch(InterruptedException e)
					{
					}
				}
				
				
			}
			
		};
		Runnable r13 = new Runnable()
		{

			@Override
			public void run() 
			{   
				
				Main.Game_Screen2.setDoubleBuffered(true);				
			    level =  new File(System.getProperty("user.dir")+"/levels/level2.txt"); 
			    System.out.println("SUCCESS");
			    System.out.println(level);
				try {
					sc = new Scanner(level);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(sc);
				while(!levelFinished && Ship_Alive)
				{  
					if(Main.Game_Screen2.all_spawned == 0)
					{	
				      int num = 0;
				      int [] nums = new int[6];
				      boolean done = false;
				      while(!done)
				      {  
				    	for(int z =0; z < 3; z++)	
				    	{  
				    	  num = sc.nextInt();
				    	  for(int y = 0; y < 6; y++)
			    		  {
			    			nums[y] = sc.nextInt();
			    		  } 
				    	  for(int x = 0; x < num; x++)
				    	  {				    			
				    		  generator = new Random(System.currentTimeMillis());
				    		  Main.Game_Screen2.xPosition = generator.nextInt(940);
				    		  Enemy_Asteroids.add(new Asteroids(nums[0],nums[1] + Main.Game_Screen2.xPosition,nums[2],nums[3],nums[4],nums[5]));
				    		  try
								{	
									Thread.sleep(1000);
								}
								catch(InterruptedException e)
								{
								}
				    	  }
				    	 }     	 
				    	  done = true;
				      }
				      
				      sc.close();
					Main.Game_Screen2.all_spawned = 1;
				  }
					
				}
				
			}
			
		};
		
		Runnable r15 = new Runnable()
		{

			@Override
			public void run() 
			{     
				Main.Game_Screen2.setDoubleBuffered(true);				
				Graphics g = Main.Game_Screen2.getGraphics();
				int set = 0;
				while((Ship_Alive && !levelFinished && set == 0) || (!Ship_Alive && !levelFinished && set == 0))
				{
				    if(!Ship_Alive)
				    {
				    	 
				    		thr1.stop();
				    	    thr2.stop();
				    		thr3.stop();
				    		thr4.stop();
				    		thr5.stop();
				    		thr10.stop();
				    		thr13.stop();
				    		
				    		 set = 1; 
				    		Main.Player1.Ship.update_parts();
				    		Ship_Alive = true;
				    		
				    		Main.Game_Screen2.setVisible(false);
				 			Main.Game_Screen2.setEnabled(false);
				 			Main.Game_Screen2.setFocusable(false);
				 			Main.mainFrame.remove(Main.Game_Screen2);
				 			Main.mainFrame.add(Main.ShipShopMenu);
				 			   
				 			Main.ShipShopMenu.setVisible(true);
				 			Main.ShipShopMenu.setEnabled(true);
				 			Main.ShipShopMenu.setFocusable(true);
				 			Main.ShipShopMenu.requestFocusInWindow();
				 			thr15.stop();
				    	 
				    	
				    }
				    else if(enemies.enemies.size() == 0 && Enemy_Asteroids.size() == 0 && Main.Game_Screen2.all_spawned == 1)
				    {
				    	thr1.stop();
			    	    thr2.stop();
			    		thr3.stop();
			    		thr4.stop();
			    		thr5.stop();
			    		thr10.stop();
			    		thr13.stop(); 
			    		Main.Player1.Ship.update_parts();
			    		Main.Game_Screen2.setVisible(false);
			 			Main.Game_Screen2.setEnabled(false);
			 			Main.Game_Screen2.setFocusable(false);
			 			Main.mainFrame.remove(Main.Game_Screen2);
			 			Main.Player1.credits += Main.Game_Screen2.level_score;
			 			Main.Player1.score +=  Main.Game_Screen2.level_score;
			 			Main.Player1.progress++;
			 			try {
							Main.Player1.saveGame();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			 			Main.mainFrame.add(Main.ShipShopMenu);
			 			Main.ShipShopMenu.setVisible(true);
			 			Main.ShipShopMenu.setEnabled(true);
			 			Main.ShipShopMenu.setFocusable(true);
			 			Main.ShipShopMenu.requestFocusInWindow();
			 			thr15.stop();
				    }
					try
					{	
						Thread.sleep(30);
					}
					catch(InterruptedException e)
					{
					}
				}
				
				
			}
			
		};
		 thr1 = new Thread(r1);
		 thr2 = new Thread(r2);
		 thr3 = new Thread(r3);
		 thr4 = new Thread(r4);
	     thr5 = new Thread(r5);
		 thr10 = new Thread(r10);
		 thr13 = new Thread(r13);
		 thr15 = new Thread(r15);
		
		thr1.start();
		thr2.start();
		thr3.start();
		thr4.start();
	    thr5.start();
		thr10.start();
		thr13.start();
		thr15.start();
	
		
	
		
	}
		
		
	private void HandlekeyActions2()
	{
		if(spacePress) fire_shot();
	}	
	private void HandlekeyActions()
	{
		// This method is called from this class every time a key is pressed
		if (upPress) moveShipUp();
		if (downPress) moveShipDown();
		if (leftPress) moveShipLeft();
		if (rightPress) moveShipRight();
		//if (spacePress) fire_shot();
		
		if(Ship_Pos_Y <= 0 && current_yVel <0)
		{
			Ship_Pos_Y = 0;
			cur_ship.yPosition = 0;
			current_yVel = 0;
			//repaint();
			return;
		}
		else if(Ship_Pos_Y >= 730 && current_yVel >0)
		{
			Ship_Pos_Y = 730;
			cur_ship.yPosition = 730;
			current_yVel = 0;
			//repaint();
			return;
		}
		
		if(Ship_Pos_X <= 0 && current_xVel < 0)
		{
			Ship_Pos_X = 0;
			cur_ship.xPosition = 0;
			current_xVel = 0;
			//repaint();
			return;
		}
		else if(Ship_Pos_X >= 940 && current_xVel > 0)
		{
			Ship_Pos_X = 940;
			cur_ship.xPosition = 940;
			current_xVel = 0;
			//repaint();
			return;
		}
	}
	public void updateShip()
	{
		Ship_Pos_X += current_xVel;
		Ship_Pos_Y += current_yVel;
		cur_ship.yPosition = Ship_Pos_Y;
		cur_ship.xPosition = Ship_Pos_X;
	}
	

	public void moveShipUp()
	{
		if(Ship_Pos_Y <= 0)
		{
			Ship_Pos_Y = 0;
			cur_ship.yPosition = 0;
			current_yVel = 0;
			//repaint();
			return;
		}
		else 
			{
			current_yVel -= 0.5 + (Main.Player1.Ship.current_acceleration -1 ) *.05;
			
			if(current_yVel < -5 - (Main.Player1.Ship.current_max_speed/50)*.5)
			{
				current_yVel = -5  - (Main.Player1.Ship.current_max_speed/50)*.5;
			};
			System.out.println("Going up");
			
			}
		
	}
	public void moveShipDown()
	{
		if(Ship_Pos_Y >= 720)
		{
			Ship_Pos_Y = 720;
			cur_ship.yPosition = 720;
			current_yVel = 0;
			//repaint();
			return;
		}
		else 
			{
			current_yVel += 0.5 + (Main.Player1.Ship.current_acceleration -1 ) *.05;
			
			
			if(current_yVel > 5 + (Main.Player1.Ship.current_max_speed/50)*.5)
			{
				current_yVel = 5 + (Main.Player1.Ship.current_max_speed/50)*.5;
			
			}
			System.out.println("Going down");
			}
	}
	public void moveShipLeft()
	{
		if(Ship_Pos_X <= 0)
		{
			Ship_Pos_X = 0;
			cur_ship.xPosition = 0;
			current_xVel = 0;
			//repaint();
			return;
		}
		else 
			{
			current_xVel -= 0.5 + (Main.Player1.Ship.current_acceleration -1 ) *.05;
			
			if(current_xVel < -5 - (Main.Player1.Ship.current_max_speed/50)*.5)
			{
				current_xVel = -5 - (Main.Player1.Ship.current_max_speed/50)*.5;
			}
			System.out.println("Going Left");
			}
		
	}
	public void moveShipRight()
	{
		if(Ship_Pos_X >= 930)
		{
			Ship_Pos_X = 930;
			cur_ship.xPosition = 930;
			current_xVel = 0;
			//repaint();
			return;
		}
		else {
			current_xVel += 0.5 + (Main.Player1.Ship.current_acceleration -1 ) *.05;
			
			if(current_xVel > 5 + (Main.Player1.Ship.current_max_speed/50)*.5)
			{
				current_xVel = 5 + (Main.Player1.Ship.current_max_speed/50)*.5;
			}
			System.out.println("Going Right");
			}
		
	}
	
	
	public void keyTyped(KeyEvent e){
		// This overrides the keyTyped method which enables keyPressed() to handle 
		// all of the movement
	}
	
	public void keyPressed(KeyEvent e)
	{
		int keycode = e.getKeyCode();
		
		System.out.println("key pressed: ");
		
		switch(keycode)
		{
		case KeyEvent.VK_UP:
			System.out.println("up");
			this.upPress = true;
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("down");
			this.downPress = true;
			break;
		case KeyEvent.VK_LEFT:
			System.out.println("left");
			this.leftPress = true;
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("right");
			this.rightPress = true;
			break;
		case KeyEvent.VK_SPACE:
			System.out.println("space");
			this.spacePress = true;
			break;
		case KeyEvent.VK_ESCAPE:
			System.out.println("escape!");
			this.escPressed = true;

		}// end switch
		
		e.consume();
		//Game_Screen2.keyAction();
		
		
	}
	
	public void keyReleased(KeyEvent e)
	{
		int keycode = e.getKeyCode();
		
		System.out.println("key released: ");
		
		switch(keycode)
		{
		case KeyEvent.VK_UP:
			System.out.println("up");
			this.upPress = false;
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("down");
			this.downPress = false;
			break;
		case KeyEvent.VK_LEFT:
			System.out.println("left");
			this.leftPress = false;
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("right");
			this.rightPress = false;
			break;
		case KeyEvent.VK_SPACE:
			System.out.println("space");
			this.spacePress = false;
			break;
			

		}
	}
	
	public void fire_shot()
	{
		shots.add(new Shot((double)Ship_Pos_X+26,(double)Ship_Pos_Y - 10, 0 ,-10));
		Sounds.shotSound.play();
	}
	
	public void deal_with_shots_fired(Graphics g)
	{
		//ArrayList<Shot> newshots = new ArrayList <Shot>();
		  //if(!shots.equals(null))
		  for(int i=0; i < shots.size(); i++) 			  
		 {  
			shots.get(i).move();			
				g.drawImage(shots.get(i).weapon,(int)shots.get(i).getXPosition(),(int)shots.get(i).getYPosition(),7,21,Main.Game_Screen2);	

		 }
	}
	
		  
	public void deal_with_enemy_shots_fired(Graphics g)
	{
		for(int i=0; i <Enemy_Shots.size(); i++) 			  
		 {  
			Enemy_Shots.get(i).move();
			g.drawImage(Enemy_Shots.get(i).weapon,(int)Enemy_Shots.get(i).getXPosition(),(int)Enemy_Shots.get(i).getYPosition(),7,21,this);	 
		    Toolkit.getDefaultToolkit().sync();
		}	  
	}
	
	public void Handle_Collisions()
	{
		newShots = new ArrayList<Shot>();
		newEnemies = new ArrayList<NPC_Ships>();
		newEnemyShots = new ArrayList<Enemy_Shot>();
	    newAsteroids = new ArrayList<Asteroids>();
		
	    boolean[] shotsAlive = new boolean[shots.size()];
	    boolean[] NPCsAlive = new boolean[enemies.enemies.size()];
		boolean[] Enemy_Shots_Alive = new boolean[Enemy_Shots.size()];
		boolean[] Enemy_Asteroids_Alive = new boolean[Enemy_Asteroids.size()];
		Arrays.fill(shotsAlive, true);
	    Arrays.fill(NPCsAlive, true);
	    Arrays.fill(Enemy_Shots_Alive, true);
	    Arrays.fill(Enemy_Asteroids_Alive, true);
	    //Deal with shots blowing up enemies
		if(shotsAlive != null)
	    for(int i = 0; i < shotsAlive.length; i++) 
			if(shotsAlive[i])
		{
			Shot s = shots.get(i);
			for(int j = 0; j < enemies.enemies.size(); j++) 
				if(NPCsAlive[j])
			{
				NPC_Ships e = enemies.enemies.get(j);
				
				// If a shot has hit a comet, destroy both the shot and comet
				if(s.overlapping(e))
				{
					 enemies.enemies.get(j).current_health -= cur_ship.current_damage;
				
					shotsAlive[i] = false;
					if(enemies.enemies.get(j).current_health <= 0)
					{
						NPCsAlive[j] = false;
					    level_score += (enemies.enemies.get(j).type + 1) * 500;
					    int k = generator.nextInt() % 10;
					    if(k > 5)
					     Sounds.Explosion1.play();
					    else if(k > 0)
					     Sounds.Explosion2.play();
					    else
					     Sounds.Wilhelm.play();
					}
					
				}
			}
		}
		if(Enemy_Shots.size() != 0)
		for(int i = 0; i < Enemy_Shots_Alive.length; i++) 
			if(Enemy_Shots_Alive[i])
		{
			Enemy_Shot s = Enemy_Shots.get(i);
				if(s.overlapping(cur_ship))
				{
					 cur_ship.current_health -= s.damage;
					Enemy_Shots_Alive[i] = false;
					if(cur_ship.current_health <= 0)
					{
						Ship_Alive = false;
					}
					
					// New Comets spawn for the next frame
					// Keep this?			
				}
			}
		
		   if(enemies.enemies.size() != 0)
		for(int i = 0; i < NPCsAlive.length; i++) 
			if(NPCsAlive[i])
		{
				if(enemies.enemies.get(i).overlapping(cur_ship))
				{
					cur_ship.current_health -= 10;
				
					NPCsAlive[i] = false;
					if(cur_ship.current_health <= 0)
					{
						Ship_Alive = false;
					}// Keep this?					
					
				}
			}
		  //Deals with Asteroids crashing into the ship
		if(Enemy_Asteroids.size() != 0)  
		for(int a = 0; a < Enemy_Asteroids_Alive.length; a++)
		  {
			  if(Enemy_Asteroids_Alive[a])
			  {
				  if(Enemy_Asteroids.get(a).overlapping(cur_ship))
				  {
					cur_ship.current_health -= 5 *(Enemy_Asteroids.get(a).type + 1);
					Enemy_Asteroids_Alive[a] = false;
					if(cur_ship.current_health <= 0)
					{
						Ship_Alive = false;
					}
				  }
			  }
		  }
		  //Deals with the The gravitational pull on the ship from the asteroids
		  if(Enemy_Asteroids.size() != 0)
			  for(int b = 0; b < Enemy_Asteroids.size(); b++)
			  	  if(Enemy_Asteroids_Alive[b])
				  {
					  if(Enemy_Asteroids.get(b).gravitate(cur_ship))
					  {
						if(Enemy_Asteroids.get(b).xPosition > Ship_Pos_X)  
						current_xVel += 1;
						
						if(Enemy_Asteroids.get(b).yPosition > Ship_Pos_Y)
						current_yVel += 1;	
						
						if(Enemy_Asteroids.get(b).xPosition < Ship_Pos_X)  
							current_xVel -= 1;
							
							if(Enemy_Asteroids.get(b).yPosition < Ship_Pos_Y)
							current_yVel -= 1;	
					  }
					
					 
				  }
		  
		  if(shots.size()!=0)
		  for(int c = 0; c < shotsAlive.length; c++) 
				if(shotsAlive[c])
			{
				Shot s = shots.get(c);
				if(Enemy_Asteroids.size() != 0)
				for(int d = 0; d < Enemy_Asteroids_Alive.length; d++) 
					if(Enemy_Asteroids_Alive[d])
				{
					Asteroids a = Enemy_Asteroids.get(d);
					
					// If a shot has hit a comet, destroy both the shot and comet
					if(s.overlapping(a))
					{
						 Enemy_Asteroids.get(d).health -= cur_ship.current_damage;
						shotsAlive[c] = false;
						if(Enemy_Asteroids.get(d).health <= 0)
						{
							Enemy_Asteroids_Alive[d] = false;
						    level_score += (Enemy_Asteroids.get(d).type + 1) * 200;
						    int k = generator.nextInt() % 10;
						    if(k > 5)
						     Sounds.Explosion1.play();
						    else
						     Sounds.Explosion2.play();
						}
						
						// New Comets spawn for the next frame
						// Keep this?					
					}
				}
			}
		  
		 //Deals with Shots not having hit anything and just existing
			if(shotsAlive != null)
		  for(int i = 0; i < shotsAlive.length; i++) 
			if(shotsAlive[i]) 
			{
			  Shot s = shots.get(i);
			  if(s.getYPosition() > 0) 
			   newShots.add(s);
			}
			//Deals with Player ship crashing into an enemy ship
		if(enemies.enemies.size() != 0)
			for(int j = 0; j < NPCsAlive.length; j++) 
			if(NPCsAlive != null && NPCsAlive[j]) 
			{
				newEnemies.add(enemies.enemies.get(j));
			}
	   // Checks to see what enemy shots are still on the screen so they can be removed properly 
		if(Enemy_Shots.size() != 0)
		for(int k = 0; k < Enemy_Shots_Alive.length; k++) 
			if(Enemy_Shots_Alive[k]) 
			{
			  Enemy_Shot s = Enemy_Shots.get(k);
			  if(s.getYPosition() < 800) 
			   newEnemyShots.add(s);
			}
		//Checks to see what Asteroids are still on the screen so they are removed properly
		if(Enemy_Asteroids.size() != 0)
		for(int m = 0; m < Enemy_Asteroids_Alive.length; m++)
		{
			if(Enemy_Asteroids_Alive[m])
			{
				Asteroids a = Enemy_Asteroids.get(m);
				if(a.getYPosition() < 800)
				{
					newAsteroids.add(a);
				}
			}
		}
		
		// All the ArrayLists used to deal with enemies and shots are updated
		// to deal with elements that are no longer on screen.
		enemies.enemies = newEnemies;
		shots = newShots;
		Enemy_Shots = newEnemyShots;
		Enemy_Asteroids = newAsteroids;
		}
		
	
	
	public void spawn_the_asteroids(Graphics g)
	{
		for(int y = 0; y < Enemy_Asteroids.size(); y++)
		{
			Enemy_Asteroids.get(y).move();
			g.drawImage(Enemy_Asteroids.get(y).sprite,(int)Enemy_Asteroids.get(y).getXPosition(),(int)Enemy_Asteroids.get(y).getYPosition(),(int)Enemy_Asteroids.get(y).sprite.getWidth(),(int)Enemy_Asteroids.get(y).sprite.getHeight(),Main.Game_Screen2);
		}
	}
	
}
