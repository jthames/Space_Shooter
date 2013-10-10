package Orions_War.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameLoop extends JPanel
{
	/*
	private static Color backGroundColor = Color.black;
	private static Color textColor = Color.white;
	
	private static String testString = "Game Panel";
	
	private static Thread thread;
	private static int sleepTime = 20; // 20 milliseconds sleep time
	*/
	
	public GameLoop()
	{
		/*
		 * System.out.println("created game loop");
		 
		
		this.setBackground(backGroundColor);
		this.setVisible(true);
		this.setOpaque(true);
		this.setSize(new Dimension(1283,1038));
	}
	
	public void paintComponent(Graphics g)
	{
		System.out.println("drawing game area");
		
		g.setColor(backGroundColor);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g.setColor(textColor);
		
		g.drawLine(25, 50, 25, 550);
		g.drawLine(400, 50, 400, 550);
		g.drawLine(775, 50, 775, 550);
		
		g.drawLine(25, 50, 775, 50);
		g.drawLine(25, 550, 775, 550);
		
		//g.drawLine(0, 0, 800, 600);
		
		
		
	}

	@Override
	public void run() 
	{
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		
		while(true)
		{
		
			try
		    {
		        Thread.sleep (sleepTime);
		    }
		    catch (InterruptedException ex){}
			
			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		}
		// TODO Auto-generated method stub
		
	}
	*/
		
		
		//This Code is currently not in use!!!
}
}
