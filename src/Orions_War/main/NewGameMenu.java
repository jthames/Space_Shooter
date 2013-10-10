/**************************************************************************
 ***************************************************************************
 * 	
 *     ============    Team 2  -  Project 6: Space Shooter    ============
 *     	
 *	FILE NAME: NewGameMenu.java
 *	AUTHOR(S): Christopher Margol
 *	DATE OF FIRST VERSION: 11/01/2012
 *	DATE LAST MODIFIED: 11/01/2012
 *	UNIT TESTING COMPLETED: Yes
 *	STATUS OF UNIT TESTING: No Problems
 *	INTEGRATION TESTING COMPLETED: Yes
 *	PURPOSE OF FILE IN THE SYSTEM: This file enables us to deal with
 *   everything used for updating weapons, whether purchased equipped etc
 *
 ***************************************************************************
 **************************************************************************/
package Orions_War.main;

import java.awt.Color; 
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class NewGameMenu extends JPanel 
{
	private static Color backgroundColor = Color.black;
	private static Color textColor = Color.white;
	
	private static String title = "Create New Game";
	private static String chooseName = "Choose name:";
	private static String retMain = "Return to main menu";
	private static String start = "Start";
	
	private static boolean displayDupeWarning = false, displayBlankWarning= false;
	private static String dupeWarning = "That name already exists! Choose another one.";
	
	private static JTextField nameField = new JTextField();
	
	private static Dimension windowSize = new Dimension(1000,800);
	private static Image img1;
	
	public static SelectionOval selector = new SelectionOval(40,124,124,144,20);
	
	public NewGameMenu()
	{
		System.out.println("new game menu created");
        ImageIcon icon = new ImageIcon("images/spacefieldposs.png");
		
		img1 = icon.getImage();
		
		this.setBackground(backgroundColor);
		this.setSize(windowSize);
		this.setOpaque(true);
		
		//NOTE: for focusing, these must not be set in the constructor. Undesirable focus behavior results from doing so
		//this.setVisible(true); // needed to focus
		//this.setFocusable(true); // needed to focus
		//this.setEnabled(true); // needed to focus
		this.addKeyListener(new NewGameMenuKeyAdapter(this));
		this.addMouseListener(new NewGameMenuMouseAdapter(this));
		//System.out.println("requesting focus: " + this.requestFocus());
		//System.out.println("requesting focus: " + this.requestFocus());
		
		//added so that manual position of JComponents would be feasible
		this.setLayout(null);

		
		this.add(nameField);
		nameField.setBounds(150, 75, 200, 20);
		nameField.repaint();

	}
	
	public void paintComponent(Graphics g)
    {
		// the following two lines are needed because calling the paint overrides the background color
		g.drawImage(img1, 0, 0, 1000,800, this);
		
		g.setColor(textColor);
		
		selector.drawSelector(g);
		
		g.drawString(title, 50, 50);
		
		g.drawString(chooseName, 50, 90);
		g.drawString(retMain, 50, 130);
		g.drawString(start, 50, 150);
		
		if(displayDupeWarning)
		{
			displayDupeWarning = false;
			g.drawString(dupeWarning, 360, 90);
		}
		if(displayBlankWarning)
		{
		     displayBlankWarning = false;
			g.drawString("You must enter a name that isn't blank",360,90);
        
		}
		}
	
	public int getSelection()
	{
		if(selector.getY() == 124) return 1;
		else if(selector.getY() == 144) return 2;
		//else if(selectionOvalY == 134) return 3;
		//else if(selectionOvalY == 154) return 4;
		//else if(selectionOvalY == 174) return 5;
		return 0;
	}
	
	public String getNewName()
	{
		System.out.println("getting text from namefield: "+nameField.getText());
		return nameField.getText();
	}
	
	public boolean checkDuplicateSave(String name)
	{
		File saveManifest = null;
		
		saveManifest = new File(System.getProperty("user.dir") +"/saves/List_Of_Saves.txt");
		if(saveManifest == null) System.out.println("file null");
		
		Scanner manifestReader = null;
		try
		{
			manifestReader = new Scanner(saveManifest);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		int numEntries = manifestReader.nextInt();
		if(manifestReader.hasNext())
		for(int i = 0; i < numEntries; i++)
		{
			
			String temp = manifestReader.next();
			System.out.println("name: "+name);
			System.out.println("temp: "+temp);
			if(name.equals(temp))
			{
				System.out.println("name is equal to temp");
				displayDupeWarning = true;
				repaint();
				return true;
			}
			else if(name.equals(""))
			{
				System.out.println("name is blank");
				displayBlankWarning = true;
				repaint();
				return true;
			}
		}
		
		manifestReader.close();
		
		return false;
	}
}
