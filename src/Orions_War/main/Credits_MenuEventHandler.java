package Orions_War.main;



public class Credits_MenuEventHandler 
{
	
	// event 1: play game
	// event 2: view highScores
	// event 3: options
	// event 4: exit application

	public static void handleEvent(int eventId)
	{
		
		if(eventId == 0)
		{
			System.out.println("Exit high score menu selected");
			Main.Credits_Menu.setVisible(false);
			Main.Credits_Menu.setEnabled(false);
			Main.Credits_Menu.setFocusable(false);
			
			
			Main.mainFrame.remove(Main.Credits_Menu);
			Main.mainFrame.dispose();
		}	
	}
	
	
}
	