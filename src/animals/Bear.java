package animals;

import mobility.Point;
import animals.Animal;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

import diet.Omnivore;
import graphics.ZooPanel;
import utilities.MessageUtility;

/**
 * This class defines the characteristics and behavior of the bear.
 * @author 
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 */
public class Bear extends Omnivore {
	
	
    /**
     * The bear's fur color.
     * Initialized to default color - gray
     */
	private String furColor = "GRAY";
	
	/**
	 * the bear's default location
	 */
	private static Point defaultpoint = new Point(100,5);

	
	public Bear(int size, int horSpeed, int verSpeed, String col,ZooPanel pan ) {
		super("Bear", defaultpoint, 1.5*size,  new Omnivore("Bear", defaultpoint), size, horSpeed, verSpeed, col , pan );
		this.thread=new Thread(this);
		
	}
	
	
/**
 * The constructor initializes the fields of the bear according to the parameters entered.
 * 
 * @param name 
 * 		  the name of the bear
 * 
 * @param color 
 * 		  the color of the bear
 */     
	public Bear(String name, String color, Point p) {
		
		    super(name, (Point.checkBoundaries(p) ? p : defaultpoint ));
		    this.setWeight(308.2);
		    
			if(checkFurColor(color)) {
				
				this.furColor = color;	
			}
			
			MessageUtility.logConstractor(this.getClasssName(), this.getName());
	}
	
	/**
	 * The second constructor initializes the fields of the bear according to the parameters entered.
	 * 
	 * @param name
	 * 		  the name of the bear
	 */
	public Bear(String name) {
	
		super(name, defaultpoint ); 
		this.setWeight(308.2);
		
		MessageUtility.logConstractor(this.getClasssName(), this.getName());
	}
	
	/**
	 * The method checks if the color it received can be the color of the bear's fur.
	 * 
	 * @param color
	 *        the color of the fur
	 * @return true or false .whether the color of the fur has changed or not
	 */
	public boolean checkFurColor(String color) {
		
		if(Arrays.asList("BLACK","WHITE","GRAY").contains(color))  {
			
			MessageUtility.logBooleanFunction(this.getName(), "checkFurColor", color , true);
			return true;
		}
		
		MessageUtility.logBooleanFunction(this.getName(), "checkFurColor", color , false);
		return false;
	}
	
	/**
	 * the method changes the color of the bear's fur
	 * 
	 * @param color 
	 * 	 	  the new color
	 * 
	 * @return true/false : whether the color were changed or not 
	 */
	public boolean setFurColor(String color) {
		
		if(checkFurColor(color)) {
			this.furColor = color;
			MessageUtility.logSetter(this.getName(), "setFurColor", color, checkFurColor(color));
			return true;
		}
		
		MessageUtility.logSetter(this.getName(), "setFurColor", color, checkFurColor(color));
		return false;
	}
	
	/**
	 *  The method checks what is the bear's fur color
	 *  
	 * @return the current bear's fur color
	 */
	public String getFurColor() {
		
		MessageUtility.logGetter(this.getName(),"getFurColor",this.furColor);
		return this.furColor;
	}
	
}
