package plants;

import graphics.ZooFrame;
import graphics.ZooPanel;
import utilities.MessageUtility;


public class Cabbage extends Plant {
	
	public Cabbage(ZooPanel p , ZooFrame z)
	{
		super(p , z);
		MessageUtility.logConstractor("Cabbage", "Cabbage");
	}

}
