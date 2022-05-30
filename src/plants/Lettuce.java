package plants;

import graphics.ZooFrame;
import graphics.ZooPanel;
import utilities.MessageUtility;


public class Lettuce extends Plant {
	public Lettuce (ZooPanel p , ZooFrame z) {
		
		super(p , z);
		MessageUtility.logConstractor("Lettuce", "Lettuce");
	}
}
