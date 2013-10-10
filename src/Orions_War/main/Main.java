/**************************************************************************
 ***************************************************************************
 * 	
 *     ============    Team 2  -  Project 6: Space Shooter    ============
 *     	
 *	FILE NAME: Main.java
 *	AUTHOR(S): Christopher Margol
 *	DATE OF FIRST VERSION: 11/01/2012
 *	DATE LAST MODIFIED: 11/01/2012
 *	UNIT TESTING COMPLETED: Yes
 *	STATUS OF UNIT TESTING: No Problems
 *	INTEGRATION TESTING COMPLETED: Yes
 *	PURPOSE OF FILE IN THE SYSTEM: This file enables us to deal with
 *   everything used for intiating all the data.
 *
 ***************************************************************************
 **************************************************************************/
package Orions_War.main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Color; 
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.Image;
import javax.swing.ImageIcon;


import java.util.ArrayList;

public class Main
{
	
    public static void main(String[] args) 
    {
    	
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                createAndShowGUI(); 
            }
        });
        
    }
    
    public static JFrame mainFrame;
    public static MainMenu mainMenu;
    public static HighScoreMenu highScoreMenu;
    public static NewGameMenu newGameMenu;
    public static ShipShopMenu ShipShopMenu;
    public static LoadGameMenu loadGameMenu;
    public static ShipShopEnginesMenu ShipShopEnginesMenu;
    public static ShipShopThrustersMenu ShipShopThrustersMenu;
    public static ShipShopWeaponsMenu ShipShopWeaponsMenu;
    public static ShipShopHullsMenu ShipShopHullsMenu;
    public static Player Player1;
    public static Credits_Menu Credits_Menu;
    public static Ship_Shop_Engine_Confirmation Ship_Shop_Engine_Confirmation;
    public static Ship_Shop_Thruster_Confirmation Ship_Shop_Thruster_Confirmation;
    public static Ship_Shop_Hull_Confirmation Ship_Shop_Hull_Confirmation;
    public static Ship_Shop_Weapon_Confirmation Ship_Shop_Weapon_Confirmation;
    public static Game_Screen Game_Screen;
    public static Game_Screen2 Game_Screen2;
    public static Game_Screen3 Game_Screen3;
    public static Game_Screen4 Game_Screen4;
    public static Game_Screen5 Game_Screen5;
    public static Save_Confirmation_PopUp Save_Confirmation_PopUp;
    public static Sounds Sounds;
    public static int played = 0;
    private static void createAndShowGUI() 
    {
    	System.out.println("creating GUI");
    	
    	mainFrame = new JFrame();
    	mainFrame.setSize(new Dimension(1000,800));
    	mainFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("images/spacebackgrouBIG.png"));
    	mainFrame.setResizable(false);
    	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("Orion's War - isShotAlive?");
    	mainMenu = new MainMenu();
    	newGameMenu = new NewGameMenu();
    	highScoreMenu = new HighScoreMenu();
    	ShipShopMenu = new ShipShopMenu();
    	loadGameMenu = new LoadGameMenu();
    	ShipShopEnginesMenu = new ShipShopEnginesMenu();
    	ShipShopThrustersMenu = new ShipShopThrustersMenu();
    	ShipShopWeaponsMenu = new ShipShopWeaponsMenu();
    	ShipShopHullsMenu = new ShipShopHullsMenu();
    	Ship_Shop_Engine_Confirmation = new Ship_Shop_Engine_Confirmation();
    	Ship_Shop_Thruster_Confirmation = new Ship_Shop_Thruster_Confirmation();
    	Ship_Shop_Hull_Confirmation = new Ship_Shop_Hull_Confirmation();
    	Ship_Shop_Weapon_Confirmation = new Ship_Shop_Weapon_Confirmation();
    	Game_Screen = new Game_Screen();
    	Game_Screen2 = new Game_Screen2();
    	Game_Screen3 = new Game_Screen3();
    	Game_Screen4 = new Game_Screen4();
    	Game_Screen5 = new Game_Screen5();
    	Credits_Menu = new Credits_Menu();
    	Save_Confirmation_PopUp = new Save_Confirmation_PopUp();
    	Sounds = new Sounds();
    	Player1 = new Player();
    	
    	
    	
    	
    	
    	
    	mainFrame.setVisible(true);
    	
   

    	mainFrame.add(mainMenu);	
    }
    

    
}
    