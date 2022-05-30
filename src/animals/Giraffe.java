package animals;

import java.awt.Color;
import java.awt.Graphics;

import diet.Herbivore;
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;


/**
 * This class defines the characteristics and behavior of the Giraffe.
 * @author 
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 */
public class Giraffe extends Herbivore {
	
	/**
	 * The length of the giraffe's length
	 */
	private double neckLength =1.5;
	
	/**
	 * the giraffe's default location
	 */
	private static Point defaultpoint = new Point(50,0);
	
	public Giraffe(int size, int horSpeed, int verSpeed, String col,ZooPanel pan ) {
		super("Giraffe", defaultpoint, 2.2*size,  new Herbivore("Giraffe", defaultpoint), size, horSpeed, verSpeed, col , pan );
		this.thread=new Thread(this);
	}
	
	
	/**
	 *  The constructor  initializes the fields of the Giraffe according to the parameters entered.
	 *  
	 * @param name 
	 * 		  The name of the Giraffe
	 * 
	 * @param length
	 * 		  The length of the neck
	 */
	public Giraffe(String name, double length, Point p) {
		
			super(name, (Point.checkBoundaries(p) ? p : defaultpoint ));
			this.setWeight(450);
		
			if (checkNeckLength( length)) {
			
				this.neckLength = length;
			}
			
			MessageUtility.logConstractor(this.getClasssName(), this.getName());
		}
	
	/**
	 *  The second constructor  initializes the fields of the Giraffe according  to the parameters entered.
	 *  
	 * @param name 
	 * 		  The name of the Giraffe
	 */
	public Giraffe(String name) {
		
		super(name, defaultpoint ); 
		this.setWeight(450);
		MessageUtility.logConstractor(this.getClasssName(), this.getName());
	}
	
	/**
	 * The method checks if the length oh the neck is correct.
	 * 
	 * @param length
	 *        The length of the neck
	 *        
	 * @return true or false ( if the length oh the neck is correct)
	 */
    public boolean checkNeckLength(double length) {
		
		if ( length >= 1 && length <= 2.5) {
			
				MessageUtility.logBooleanFunction(this.getName(), "checkNeckLength", length, true);
				return true;
			}
		
			MessageUtility.logBooleanFunction(this.getName(), "checkNeckLength", length, false);
			return false;
		}
    
    /**
	 * The method changes the length of the neck
	 * 
	 * @param length
	 * 		  the new length of the neck
	 * 
	 * @return true or false(Whether the length of the neck were changed or not)
	 */
	public boolean setNeckLength(double length) {
		
		if(checkNeckLength(length)) {
			this.neckLength = length;
			MessageUtility.logSetter(this.getName(), "setNeckLength", length, checkNeckLength(length));
			return true;
		}
		
		MessageUtility.logSetter(this.getName(), "setNeckLength", length, checkNeckLength(length));
		return false;
	}
	
	/**
	 * The method checks what is the length of the neck
	 * 
	 * @return the length of the neck
	 */
	public double getNeckLength() {
		
		MessageUtility.logGetter(this.getName(),"getNeckLength",this.neckLength);
		return this.neckLength;
	}
	
	
}
