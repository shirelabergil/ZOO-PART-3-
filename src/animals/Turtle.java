package animals;

import java.awt.Color;
import java.awt.Graphics;

import diet.Carnivore;
import diet.Herbivore;
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;


/**
 * This class defines the characteristics and behavior of the turtle.
 * @author 
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 */
public class Turtle extends Herbivore {
	
    /**
     * the turtle age 
     */
	private int age =1;
	
	/**
	 * the turtle's default location
	 */
	private static Point defaultpoint = new Point(80,0);
	
	public Turtle(int size, int horSpeed, int verSpeed, String col,ZooPanel pan ) {
		super("Turtle", defaultpoint, 0.5*size,  new Herbivore("Turtle", defaultpoint), size, horSpeed, verSpeed, col , pan );
		this.thread=new Thread(this);
	}
	
	
	/**
	 *  The constructor  initializes the fields of the turtle according to the parameters entered.
	 *  
	 * @param name 
	 *        The name of the turtle
	 *        
	 * @param age 
	 * 		  The age of the turtle
	 */
	public Turtle(String name, int age, Point p) {
		
		super(name, (Point.checkBoundaries(p) ? p : defaultpoint ));
		this.setWeight(1);
	
		if (checkAge(age)) {
		
			this.age = age;
		}
		
		MessageUtility.logConstractor(this.getClasssName(), this.getName());
	}
	
	/**
	 * The second constructor initializes the fields of the turtle according to the parameters entered.
	 * 
	 * @param name 
	 * 		  The name of the turtle 
	 */
	public Turtle(String name) {
		
			super(name, defaultpoint); 
			this.setWeight(1);
			MessageUtility.logConstractor(this.getClasssName(),this.getName());
			
		}
	
	/**
	 * The third constructor initializes the fields of the turtle according to the parameters entered.
	 * 
	 * @param name
	 * 	      the name of the turtle
	 * 
	 * @param p
	 * 		  the location of the turtle 
	 */
	public Turtle(String name , Point p ) {
		
		super(name, (Point.checkBoundaries(p) ? p : defaultpoint ));
		MessageUtility.logConstractor(this.getClasssName(), this.getName());
	}
	
	/**
	 *  The method checks if the age of the turtle is correct.
	 *  
	 * @param age 
	 *        the age of the turtle
	 *        
	 * @return true or false ( if the age of the turtle is correct.)
	 */
	public boolean checkAge(int age) {
		
			if (  age >= 0 && age <= 500) {
			
				MessageUtility.logBooleanFunction(this.getName(), "checkAge", age, true);
				return true;
				}
				MessageUtility.logBooleanFunction(this.getName(), "checkAge", age, false);
				return false;
			}
	
	/**
	 * The method changes the age of the turtle
	 * 
	 * @param age 
	 *        the new age of the turtle
	 *        
	 * @return true or false(whether the age were change or not)
	 */
	public boolean setAge(int age) {
		
		if(checkAge(age)) {
			this.age = age;
			MessageUtility.logSetter(this.getName(), "setAge", age, checkAge(age));
			return true;
		}
		
		MessageUtility.logSetter(this.getName(), "setAge", age, checkAge(age));
		return false;
	}
	
	/**
	 * The method checks the age of the turtle
	 * 
	 * @return The age of the turtle
	 */
	public int getAge() {
		
		MessageUtility.logGetter(this.getName(),"getAge",this.age);
		return this.age;
	}
	
	
}
