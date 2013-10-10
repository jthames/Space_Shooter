package Orions_War.main;

import java.awt.Graphics;
import java.util.ArrayList;

public class ListDisplay 
{
	private int numRowsVisible = 10;
	private int pixelSeparation = 20;
	
	private int currentDisplayStart = 0;
	private int currentDisplayEnd = 9;
	
	private int numItems = 10;
	
	private ArrayList<String> fileList = null;
	
	private int[] yCoordList;
	
	private int startCoord = 94;
	
	private int xOffset = 40;
	
	public ListDisplay()
	{
		buildCoordList();
	}
	
	public ListDisplay(ArrayList<String> listOfFiles, int startAt, int offsetX)
	{
		fileList = listOfFiles;
		startCoord = startAt;
		xOffset = offsetX;
		numItems = listOfFiles.size();
		
		buildCoordList();
	}
	
	public void changeNumItems(int numberOfItems)
	{
		numItems = numberOfItems;
	}
	
	public boolean shiftDown()
	{
		System.out.println("shifting list display down");
		if(currentDisplayEnd < numItems - 1)
		{
			currentDisplayStart++;
			currentDisplayEnd++;
			return true;
		}
		return false;
	}
	
	public void buildCoordList()
	{
		yCoordList = new int[numRowsVisible];
		int i;
		for(i = 0; i < numRowsVisible; i++)
		{
			yCoordList[i] = startCoord + (i*pixelSeparation);
		}
	}
	
	public boolean shiftUp()
	{
		System.out.println("shifting list display up");
		if(currentDisplayStart > 0)
		{
			currentDisplayStart--;
			currentDisplayEnd--;
			return true;
		}
		
		return false;
	}
	
	public void drawStrings(Graphics g)
	{
		int i;
		System.out.println("currentDisplayStart = "+currentDisplayStart);
		System.out.println("currentDisplayEnd = "+currentDisplayEnd);
		for(i = currentDisplayStart; i < currentDisplayEnd+1; i++)
		{
			if(i < fileList.size())
				g.drawString(fileList.get(i), xOffset, yCoordList[i-currentDisplayStart]);
			//else
				//g.drawString("null"+i, xOffset, yCoordList[i-currentDisplayStart]);
		}
	}
	
	public String getSelected(int yCoord)
	{
		int i;
		for(i = currentDisplayStart; i < currentDisplayEnd+1; i++)
		{
			if((i < fileList.size()) && yCoord == yCoordList[i-currentDisplayStart] - 6)
				return fileList.get(i);
		}
		return "not found";
	}
	
}
