package food;

/**
 * An interface that describes an object 
 * that can tell what kind of food it is
 * 
 * @author 
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 */
public interface IEdible {

	/**
	 * The method checks what kind of food the animal is
	 * 
	 * @return  The food kind (MEAT,VETABLE OR NOTFOOD) .
	 */
	public EFoodType getFoodtype();
}
