package animals;
import diet.Carnivore;
import diet.Herbivore;
import food.EFoodType;
import food.IEdible;
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;


/**
 * This class defines the characteristics and behavior of the lion.
 * 
 * @author 
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 */
public class Lion extends Carnivore {
	
	/**
	 * The number of the lion's scars
	 */
	private int scarCount;
	
	/**
	 * the lion's default location
	 */
	private static Point defaultpoint = new Point(20,0);
	
	public Lion(int size, int horSpeed, int verSpeed, String col,ZooPanel pan ) {
		
		super("Lion", defaultpoint, 0.8*size,  new Carnivore("Lion", defaultpoint), size, horSpeed, verSpeed, col , pan );
		
		//this.thread=new Thread(this);
		
	}
	
	/**
	 *  The constructor initializes the fields of the lion according to the parameters entered.
	 *  
	 * @param name
	 * 	      The name of the lion
	 * 
	 * @param location 
	 * 		  the location of the lion
	 */
	public Lion(String name, Point location ) {
		
		super(name, (Point.checkBoundaries(location) ? location : defaultpoint ));
		this.setWeight(408.2);
		scarCount = 0;
		
		MessageUtility.logConstractor(this.getClasssName(), this.getName());
	}
	
	/**
	 *  The second constructor initializes the fields of the lion according to the parameters entered.
	 *  
	 * @param name
	 * 		  The name of the lion
	 */
	public Lion(String name ) {
		
			super(name, defaultpoint); 
			this.setWeight(408.2);
			scarCount = 0;
			
			MessageUtility.logConstractor(this.getClasssName(), this.getName());
		}
	
	@Override
	 /**
     * the method receives an animal and food and it checks if the animal can eat the food.
     *  
     *  @param animal 
     *  	   The desired animal for feeding
     *  
     *  @param food
     *         The desired food for feeding
     *  
     *  @return The increase in lion weight after eating
     */
	public double eat(Animal animal,IEdible food) {
		
		if(food.getFoodtype()== EFoodType.MEAT) {
			
			animal.makeSound();
			this.setWeight(animal.getWeight()*1.1);
			
			Random rnd = new Random();
			scarCount += rnd.nextInt(0,2);
			return this.getWeight()*0.1;
		}
		
		return 0;
	}
	
	
	
}
