package Orions_War.main;

import java.awt.Color; 
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

@SuppressWarnings("serial")
public class HighScoreMenu extends JPanel 
{
	private static Color backgroundColor = Color.black;
	private static Color textColor = Color.white;
	
	private static String title = "High Scores";
	private static String score1 = "Empty";
	private static String score2 = "Empty";
	private static String score3 = "Empty";
	private static String score4 = "Empty";
	private static String score5 = "Empty";

	private String retMain = "Return to Main Menu";
	
	private static Dimension windowSize = new Dimension(1000,804);
	
	public static SelectionOval selector = new SelectionOval(40,194,194,194,20);
	
	private static File highscores = null;
	
	public HighScoreMenu()
	{
		System.out.println("high score menu created");
		
		this.setBackground(backgroundColor);
		this.setSize(windowSize);
		this.setOpaque(true);

		this.addKeyListener(new HighScoreMenuKeyAdapter(this));
		
		//added so that manual position of JComponents would be feasible
		this.setLayout(null);

	}
	
	public void loadScores()
	{
		highscores = new File(System.getProperty("user.dir")+"/highscores", "SGHSDB.txt");
		if(highscores == null) System.out.println("file null");
		
		Scanner scoreReader = null;
		try
		{
			scoreReader = new Scanner(highscores);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		// this isn't currently needed since we are fixed at 5 scores currently
		int numScores = scoreReader.nextInt();
		System.out.println("first int read from highscores file:"+numScores);
		
		scoreReader.nextLine();
		
		score1 = scoreReader.nextLine();
		System.out.println("score1: "+score1);
		
		score2 = scoreReader.nextLine();
		System.out.println("score2: "+score2);
		
		score3 = scoreReader.nextLine();
		System.out.println("score3: "+score3);
		
		score4 = scoreReader.nextLine();
		System.out.println("score4: "+score4);
		
		score5 = scoreReader.nextLine();
		System.out.println("score5: "+score5);
		
		scoreReader.close();
		
	}
	
	
	public void paintComponent(Graphics g)
    {

		// the following two lines are needed because calling the paint overrides the background color
		
		g.setColor(backgroundColor);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g.setColor(textColor);
		
		selector.drawSelector(g);
		
		g.drawString(title, 50, 50);
		
		g.drawString(score1, 50, 80);
		g.drawString(score2, 50, 100);
		g.drawString(score3, 50, 120);
		g.drawString(score4, 50, 140);
		g.drawString(score5, 50, 160);
		
		//IMPORTANT: PLACEHOLDERS!!
		g.drawString(retMain, 50, 200);

    }
	
	public int getSelection()
	{
		if(selector.getY() == 194) return 1;
		//else if(selectionOvalY == 114) return 2;
		//else if(selectionOvalY == 134) return 3;
		//else if(selectionOvalY == 154) return 4;
		//else if(selectionOvalY == 174) return 5;
		return 0;
	}
}