package Orions_War.main;



public class HighScoreMenuEventHandler 
{
	
	// event 1: play game
	// event 2: view highScores
	// event 3: options
	// event 4: exit application

	public static void handleEvent(int eventId)
	{
		
		if(eventId == 1)
		{
			System.out.println("Exit high score menu selected");
			Main.highScoreMenu.setVisible(false);
			Main.highScoreMenu.setEnabled(false);
			Main.highScoreMenu.setFocusable(false);
			
			
			Main.mainFrame.remove(Main.highScoreMenu);
			Main.mainFrame.add(Main.mainMenu);
			
			Main.mainMenu.setVisible(true);
			Main.mainMenu.setEnabled(true);
			Main.mainMenu.setFocusable(true);
			Main.mainMenu.requestFocusInWindow();
			
		}
		
		else if(eventId == 2)
		{
		}
		
		else if(eventId == 3)
		{
		}
		
		else if(eventId == 4)
		{
		}
		else if(eventId == 5)
		{

		}
		
		
		
	}
	
	
}
	