package diet;

import food.EFoodType;
import food.IEdible;
import animals.Animal;

/**
 *The interface describes the object's ability to eat food that suits it,
 * and to check what food it can eat
 * 
 * * @author 
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 */
public interface IDiet {
	
/**
 * A method that tests whether the current animal can eat the food received
 * 
 * @param food
 *        The desired food for feeding
 *        
 * @return True or false - whether the food is eaten by the animal or not
 */
	public boolean canEat(IEdible food);
	
	/**
	 *A method in which the animal eats if the type of food is suitable for it
	 *
	 * @param animal
	 *        The desired animal for feeding
	 *        
	 * @param food
	 *        The desired food for feeding
	 *        
	 * @return The weight gain of the animal after feeding
	 */
	public double eat(Animal animal, IEdible food);
}
