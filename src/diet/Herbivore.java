package diet;

import animals.Animal;
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;

/**
 * This class defines the characteristics and behavior of the Herbivore.
 * 
 * @author 
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 */
public class Herbivore extends Animal {

	public Herbivore(String name, Point point , double weight , IDiet diet , 
			int size , int horSpeed , int verSpeed , String color, ZooPanel pan) {
		
		super( name,  point ,  weight ,  diet ,  size ,  horSpeed ,  verSpeed ,  color,  pan);
	}
	
	
	/**
	 *  The constructor initializes the fields of the Herbivore according to the parameters entered.
	 *  
	 * @param name
	 * 	      The name of the Herbivore
	 * 
	 * @param location 
	 * 		  the location of the Herbivore
	 */
	public Herbivore(String name, Point location) {
		super(name,location);
	}

	/**
	 * The method print the sound that the herbivore made
	 */
	public void chew() {
		
		 if (this.getClasssName() == "Turtle") {
			 
			 MessageUtility.logSound(this.getName(),"Retracts its head in then eats quietly");
		 }
		 
		 if (this.getClasssName() == "Giraffe") {
			 
			 MessageUtility.logSound(this.getName(),"Bleats and Stomps its legs, then chews");
		 }
		 
		 if (this.getClasssName() == "Elephant") {
			 
			 MessageUtility.logSound(this.getName(),"Trumpets with joy while flapping its ears, then chews");
		 }
		
	}
	
	/**
	 * The method print the sound that the herbivore made
	 */
	public void makeSound() {
		this.chew();
	}


	
}
