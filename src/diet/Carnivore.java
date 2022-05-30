package diet;

import animals.Animal;
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;

/**
 * This class defines the characteristics and behavior of the Carnivore.
 * 
 * @author 
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 */
public class Carnivore extends Animal {

	public Carnivore(String name, Point point , double weight , IDiet diet , 
			int size , int horSpeed , int verSpeed , String color, ZooPanel pan) {
		
		super( name,  point ,  weight ,  diet ,  size ,  horSpeed ,  verSpeed ,  color,  pan);
	}
	
	
	/**
	 *  The constructor initializes the fields of the carnivore according to the parameters entered.
	 *  
	 * @param name
	 * 	      The name of the carnivore
	 * 
	 * @param location 
	 * 		  the location of the carnivore
	 */
	public Carnivore(String name, Point location) {
		super(name,location);
	}
	
	/**
	 * The method print the sound that the carnivore made
	 */
	public void roar() {
		
		MessageUtility.logSound(this.getName(),"Roars, then stretches and shakes its mane");
	}
	
	/**
	 * The method print the sound that the carnivore made
	 */
	public void makeSound() {
		this.roar();
	}


	


	





	

}
