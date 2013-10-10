/**************************************************************************
 ***************************************************************************
 * 	
 *     ============    Team 2  -  Project 6: Space Shooter    ============
 *     	
 *	FILE NAME: LoadGameMenu.java
 *	AUTHOR(S): Christopher Margol
 *	DATE OF FIRST VERSION: 11/01/2012
 *	DATE LAST MODIFIED: 11/01/2012
 *	UNIT TESTING COMPLETED: Yes
 *	STATUS OF UNIT TESTING: No Problems
 *	INTEGRATION TESTING COMPLETED: Yes
 *	PURPOSE OF FILE IN THE SYSTEM: This file enables us to deal with
 *   everything used for loading the game menu
 *
 ***************************************************************************
 **************************************************************************/
package Orions_War.main;

import java.awt.BorderLayout;
import java.awt.Color; 
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class LoadGameMenu extends JPanel 
{
	private static Color backgroundColor = Color.black;
	private static Color textColor = Color.white;
	
	private static String title = "Load a Save";
	private static String retMain = "Return to Main Menu";
	
	private static Dimension windowSize = new Dimension(1000,804);
	
	//private static JTextArea fileDisplay = new JTextArea();
	//private static JPanel loaderPanel = new JPanel();
	private static JScrollPane scroller = new JScrollPane();
	
	private static File saveManifest = null;
	
	private static ArrayList<File> saveArray = new ArrayList<File>();
	
	private static ArrayList<String> fileNameArray = new ArrayList<String>();
	
	public static SelectionOval selector = new SelectionOval(40,94,94,314,20);
	
	public static ListDisplay listDisplay = null;
	
	
	
	public LoadGameMenu()
	{
		
		this.setBackground(backgroundColor);
		this.setSize(windowSize);
		this.setOpaque(true);
		this.setVisible(true);
		this.setFocusable(true);
		this.addKeyListener(new LoadGameMenuKeyAdapter(this));
		
		//added so that manual position of JComponents would be feasible
		this.setLayout(null);
		
		//loaderPanel.setLayout(new BorderLayout());
		//loaderPanel.add(fileDisplay, BorderLayout.NORTH);
		//fileDisplay.setVisible(true);
		//scroller.add(fileDisplay);
		
		//this.add(fileDisplay);
		//fileDisplay.setEditable(false);
		//fileDisplay.setBounds(50,110,150,150);
		//fileDisplay.repaint();
		
		
		//this.add(scroller);
		//scroller.setBounds(50,110,150,150);
		//scroller.repaint();
		this.getSaves();
		
		int temp = saveArray.size() * 20 + 94;
		selector = new SelectionOval(40,94,94,temp,20);
		
		
		listDisplay = new ListDisplay(fileNameArray, 120, 50);
		
		

	}
	
	public void paintComponent(Graphics g)
    {

		// the following two lines are needed because calling the paint overrides the background color
		ImageIcon icon = new ImageIcon("images/LoadGameScreen.png");
		Image img1 = icon.getImage();
	
		g.setColor(backgroundColor);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(img1,0,0,1000,800,this);
		g.setColor(Color.white);
		
		selector.drawSelector(g);
		
		g.drawString(title, 50, 50);
		g.drawString(retMain, 50, 100);
	    	
		listDisplay.drawStrings(g);
		
    }
	
	public int getSelection()
	{
		if(selector.getY() == 94) return 1;
		else if(selector.getY() > 94)
		{
			//System.out.println("selector.getY() = "+selector.getY());
			//System.out.println(listDisplay.getSelected(selector.getY()));
			sendFile(listDisplay.getSelected(selector.getY()));
			return 2;
		}
		//else if(selectionOvalY == 114) return 2;
		//else if(selectionOvalY == 134) return 3;
		//else if(selectionOvalY == 154) return 4;
		return 0;
	}
	
	public void getSaves()
	{
		saveManifest = new File(System.getProperty("user.dir")+"/saves/List_Of_Saves.txt");
		if(saveManifest == null) System.out.println("file null");
		System.out.println(saveManifest);
		Scanner saveReader = null;
		try
		{
			saveReader = new Scanner(saveManifest);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		int numFilesToLoad = saveReader.nextInt();
		//fileDisplay.setRows(numFilesToLoad);
		for(int i = 0; i < numFilesToLoad; i++)
		{
			if(saveReader.hasNext()) {
				String tempString = saveReader.next();
				//System.out.println(tempString);
				fileNameArray.add(tempString);
				//fileDisplay.append(tempString+"\n");
				saveArray.add(new File(System.getProperty("user.dir")+"/saves/"+tempString+".txt"));
			}
			
			//fileNameArray.add(saveReader.next());
			
			//System.out.println(saveArray.toString());
			
		}
		
		saveReader.close();
	}
	
	public void sendFile(String saveName)
	{
		File fileToSend = null;
		fileToSend = saveArray.get(fileNameArray.indexOf(saveName));
		System.out.println("file to send: "+fileToSend);
		Player.loadSave(fileToSend);
		Player.printPlayer();
	}
	
	
}
