package diet;

import animals.Animal;
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;

/**
 * This class defines the characteristics and behavior of the Omnivore.
 * 
 * @author 
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 */
public class Omnivore extends Animal {

	public Omnivore(String name, Point point , double weight , IDiet diet ,
			int size , int horSpeed , int verSpeed , String color, ZooPanel pan) {
		
		super( name,  point ,  weight ,  diet ,  size ,  horSpeed ,  verSpeed ,  color,  pan);
	}
	
	
	/**
	 *  The constructor initializes the fields of the Omnivore according to the parameters entered.
	 *  
	 * @param name
	 * 	      The name of the Omnivore
	 * 
	 * @param location 
	 * 		  the location of the Omnivore
	 */
	public Omnivore(String name, Point location) {
		super(name,location);
	}
	
	/**
	 * The method print the sound that the omnivore made
	 */
	public void roar() {
		
		MessageUtility.logSound(this.getName(),"Stands on its hind legs, roars and scratches its belly");
	}
	
	/**
	 * The method print the sound that the omnivore made
	 */
	public void makeSound() {
		this.roar();
	}


}


