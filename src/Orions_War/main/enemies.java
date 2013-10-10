/**************************************************************************
 ***************************************************************************
 * 	
 *     ============    Team 2  -  Project 6: Space Shooter    ============
 *     	
 *	FILE NAME: enemies.java
 *	AUTHOR(S): Christopher Margol
 *	DATE OF FIRST VERSION: 11/01/2012
 *	DATE LAST MODIFIED: 11/01/2012
 *	UNIT TESTING COMPLETED: Yes
 *	STATUS OF UNIT TESTING: No Problems
 *	INTEGRATION TESTING COMPLETED: Yes
 *	PURPOSE OF FILE IN THE SYSTEM: This file enables us to deal with
 *   everything used for all enemy ships it is just an array of NPC ships
 *
 ***************************************************************************
 **************************************************************************/
package Orions_War.main;

import java.awt.Graphics;
import java.util.ArrayList;

public class enemies 
{	
	volatile public static ArrayList<NPC_Ships> enemies;
	
	public static int set = 0;
	public enemies()
	{
		enemies = new ArrayList<NPC_Ships>();	
	}
	
	public static void add(NPC_Ships NPC)
	{
		enemies.add(NPC);
	}
	
	public static void moveAll()
	{
		for(int i=0; i < enemies.size(); i++)
			enemies.get(i).move();
	}
	
	public static void spawnenemies1()
	{
		
		Runnable r1 = new Runnable()
		{
			public void run(){
				for(int i=0; i < 3; i++)
				{
					add(new NPC_Ships(0, -5, 200, 6, -1, 15));
					add(new NPC_Ships(0, -30, 250, 6, -1, 15));
					add(new NPC_Ships(0, 15, 300, 6, -1, 15));
					
					
					
					try {
						Thread.sleep(800);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(3000);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int i=0; i < 3; i++)
				{
					add(new NPC_Ships(0, 980, 250, -5, -1, 15));
					add(new NPC_Ships(0, 1005, 300, -5, -1, 15));
					add(new NPC_Ships(0, 1030, 350, -5, -1, 15));
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					Thread.sleep(5000);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int i=0; i < 3; i++)
				{
					add(new NPC_Ships(0, 450-80*i, 10, 0, 3, 15));
					add(new NPC_Ships(0, 550+80*i, 10, 0, 3, 15));
					try {
						Thread.sleep(600);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int j =0; j < enemies.size(); j++)
				{
					if(enemies.get(j).xPosition>500)
						enemies.get(j).update_velocities(4 , 1 );
					else 
						enemies.get(j).update_velocities(-4, 1);
				}
				
				
				for(int i=0; i < 3; i++)
				{
					add(new NPC_Ships(0, 210+80*i, 10, 0, 3, 15));
					add(new NPC_Ships(0, 790-80*i, 10, 0, 3, 15));
					try {
						Thread.sleep(600);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int j =0; j < enemies.size(); j++)
				{
					if(enemies.get(j).xPosition>500)
						enemies.get(j).update_velocities(4 , -2);
					else 
						enemies.get(j).update_velocities(-4, -2);
				}
			}
			
		};
		
		
		
		
		Thread r = new Thread(r1);
		r.run();
		
	}
	
	public static void spawnenemies2()
	{
		Runnable r = new Runnable()
		{
			public void run(){
				for(int i=0; i < 4; i++)
				{
					add(new NPC_Ships(1, -5, 100, 7, 0, 25));
					add(new NPC_Ships(1, 1055, 250,-7, 0, 25));
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					Thread.sleep(3500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int i=0; i < 4; i++)
				{
					add(new NPC_Ships(1, -5, 500, 4, -2, 25));
					add(new NPC_Ships(1, 1049, 100,-4, 2, 25));
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					Thread.sleep(3500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int i=0; i < 4; i++)
				{
					add(new NPC_Ships(1, -5, 500, 4, -2, 25));
					add(new NPC_Ships(1, 1049, 100,-4, 2, 25));
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					Thread.sleep(5500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j =0; j < enemies.size(); j++)
				{
					if(enemies.get(j).xPosition>500)
						enemies.get(j).update_velocities(4 , 1 );
					else 
						enemies.get(j).update_velocities(-4, 1);
				}
				try {
					Thread.sleep(4500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int i=0; i < 4; i++)
				{
					add(new NPC_Ships(1, -5, 300, 6, 0, 25));
					add(new NPC_Ships(1, -45, 400, 6, 0, 25));
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(3500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int i=0; i < 12; i++)
				{
					add(new NPC_Ships(0, -5, 200, 9, 0, 15));
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(3500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int i=0; i < 14; i++)
				{
					add(new NPC_Ships(0, -5, 100, 9, 0, 15));
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(3500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int i=0; i < 3; i++)
				{
					add(new NPC_Ships(2, 210+80*i, 10, 0, 3, 35));
					add(new NPC_Ships(2, 790-80*i, 10, 0, 3, 35));
					try {
						Thread.sleep(600);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					Thread.sleep(3500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int j =0; j < enemies.size(); j++)
				{
					if(enemies.get(j).xPosition>500)
						enemies.get(j).update_velocities(4 , -4);
					else 
						enemies.get(j).update_velocities(-4, -4);
				}
			}
			
			
			
			
			
			
		};
		
		Thread r1 = new Thread(r);
		r1.run();
	}
	
	public static void spawnenemies3()
	{
		Runnable r2 = new Runnable()
		{
			public void run(){
				for(int i=0; i < 4; i++)
				{
					add(new NPC_Ships(2, -5, 100, 7, 0, 35));
					add(new NPC_Ships(2, 1055, 250,-7, 0, 35));
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					Thread.sleep(3500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int i=0; i < 4; i++)
				{
					add(new NPC_Ships(0, -5, 500, 4, -2, 35));
					add(new NPC_Ships(0, 1049, 100,-4, 2, 35));
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					Thread.sleep(3500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int i=0; i < 4; i++)
				{
					add(new NPC_Ships(2, -5, 500, 4, -2, 35));
					add(new NPC_Ships(2, 1049, 100,-4, 2, 35));
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					Thread.sleep(5500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j =0; j < enemies.size(); j++)
				{
					if(enemies.get(j).xPosition>500)
						enemies.get(j).update_velocities(4 , 1 );
					else 
						enemies.get(j).update_velocities(-4, 1);
				}
				try {
					Thread.sleep(4500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int i=0; i < 4; i++)
				{
					add(new NPC_Ships(0, -5, 300, 6, 0, 15));
					add(new NPC_Ships(2, -45, 400, 6, 0, 25));
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(3500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int i=0; i < 12; i++)
				{
					add(new NPC_Ships(1, -5, 200, 9, 0, 25));
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(3500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int i=0; i < 14; i++)
				{
					add(new NPC_Ships(1, -5, 100, 9, 0, 25));
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(3500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int i=0; i < 5; i++)
				{
					add(new NPC_Ships(2, 50+80*i, 10, 0, 3, 35));
					add(new NPC_Ships(2, 960-80*i, 10, 0, 3, 35));
					try {
						Thread.sleep(600);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					Thread.sleep(3500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int j =0; j < enemies.size(); j++)
				{
					if(enemies.get(j).xPosition>500)
						enemies.get(j).update_velocities(4 , -4);
					else 
						enemies.get(j).update_velocities(-4, -4);
				}
			}
		};
		
		Thread r = new Thread(r2);
		r.run();
	}
	
	
	public static void spawnenemies4()
	{
		Runnable r2 = new Runnable()
		{
			public void run(){
				for(int i=0; i < 4; i++)
				{
					add(new NPC_Ships(2, -5, 100, 7, 0, 35));
					add(new NPC_Ships(2, 1055, 250,-7, 0, 35));
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					Thread.sleep(3500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int i=0; i < 4; i++)
				{
					add(new NPC_Ships(0, -5, 500, 4, -2, 15));
					add(new NPC_Ships(0, 1049, 100,-4, 2, 15));
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					Thread.sleep(3500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int i=0; i < 4; i++)
				{
					add(new NPC_Ships(2, -5, 500, 4, -2, 35));
					add(new NPC_Ships(2, 1049, 100,-4, 2, 35));
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					Thread.sleep(5500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j =0; j < enemies.size(); j++)
				{
					if(enemies.get(j).xPosition>500)
						enemies.get(j).update_velocities(4 , 1 );
					else 
						enemies.get(j).update_velocities(-4, 1);
				}
				try {
					Thread.sleep(4500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int i=0; i < 4; i++)
				{
					add(new NPC_Ships(0, -5, 300, 6, 0, 15));
					add(new NPC_Ships(2, -45, 400, 6, 0, 35));
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(3500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int i=0; i < 12; i++)
				{
					add(new NPC_Ships(1, -5, 200, 9, 0, 25));
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(3500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int i=0; i < 14; i++)
				{
					add(new NPC_Ships(1, -5, 100, 9, 0, 25));
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(3500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int i=0; i < 5; i++)
				{
					add(new NPC_Ships(2, 50+80*i, 10, 0, 3, 35));
					add(new NPC_Ships(2, 960-80*i, 10, 0, 3, 35));
					try {
						Thread.sleep(600);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					Thread.sleep(3500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int j =0; j < enemies.size(); j++)
				{
					if(enemies.get(j).xPosition>500)
						enemies.get(j).update_velocities(4 , -4);
					else 
						enemies.get(j).update_velocities(-4, -4);
				}
			}
			
		}; 
		
		Thread r = new Thread(r2);
		r.run();
	}
	
	public static void spawnenemies5()
	{
		Runnable r2 = new Runnable()
		{
			public void run(){
				for(int i=0; i < 4; i++)
				{
					add(new NPC_Ships(2, -5, 100, 7, 0, 35));
					add(new NPC_Ships(2, 1055, 250,-7, 0, 35));
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					Thread.sleep(3500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int i=0; i < 4; i++)
				{
					add(new NPC_Ships(2, -5, 500, 4, -2, 35));
					add(new NPC_Ships(2, 1049, 100,-4, 2, 35));
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					Thread.sleep(3500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int i=0; i < 4; i++)
				{
					add(new NPC_Ships(2, -5, 500, 4, -2, 35));
					add(new NPC_Ships(2, 1049, 100,-4, 2, 35));
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					Thread.sleep(5500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j =0; j < enemies.size(); j++)
				{
					if(enemies.get(j).xPosition>500)
						enemies.get(j).update_velocities(4 , 1 );
					else 
						enemies.get(j).update_velocities(-4, 1);
				}
				try {
					Thread.sleep(4500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int i=0; i < 4; i++)
				{
					add(new NPC_Ships(2, -5, 300, 6, 0, 35));
					add(new NPC_Ships(2, -45, 400, 6, 0, 35));
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(3500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int i=0; i < 12; i++)
				{
					add(new NPC_Ships(2, -5, 200, 9, 0, 35));
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(3500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int i=0; i < 14; i++)
				{
					add(new NPC_Ships(2, -5, 100, 9, 0, 35));
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(3500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int i=0; i < 5; i++)
				{
					add(new NPC_Ships(2, 50+80*i, 10, 0, 3, 35));
					add(new NPC_Ships(2, 960-80*i, 10, 0, 3, 35));
					try {
						Thread.sleep(600);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					Thread.sleep(3500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int j =0; j < enemies.size(); j++)
				{
					if(enemies.get(j).xPosition>500)
						enemies.get(j).update_velocities(4 , -4);
					else 
						enemies.get(j).update_velocities(-4, -4);
				}
			}
		};
		
		Thread r = new Thread(r2);
		r.run();
	}
	
	public static void drawAll(Graphics g)
	{
		for(int i=0; i < enemies.size(); i++)
		{
		
			g.drawImage(enemies.get(i).enemy_ship,(int) enemies.get(i).xPosition, (int) enemies.get(i).yPosition, enemies.get(i).enemy_ship.getWidth(),enemies.get(i).enemy_ship.getHeight(),Main.Game_Screen);
		}
	}
	
	public static void handleOffScreen()
	{
		for(int i=0; i < enemies.size(); i++)
		{
			if(enemies.get(i).xPosition > 1050 || enemies.get(i).xPosition < -50)
			{
				enemies.remove(i);
			
			}
		}
		for(int x = 0; x < Main.Game_Screen.Enemy_Shots.size(); x++)
		{
			if(Main.Game_Screen.Enemy_Shots.get(x).getYPosition()>800)
			{
				Main.Game_Screen.Enemy_Shots.remove(x);
			}
		}
		for(int y = 0; y < Main.Game_Screen.Enemy_Shots2.size(); y++)
		{
			if(Main.Game_Screen.Enemy_Shots2.get(y).getYPosition()>800)
			{
				Main.Game_Screen.Enemy_Shots2.remove(y);
			}
		}
		
	}
}
