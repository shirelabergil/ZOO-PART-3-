package mobility;

/**
 * A descriptive interface that can return what its current location is,
 * and update its current location
 * 
 * @author 
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 */
public interface Ilocatable {

	/**
	 * A method that checks what the current location is
	 * 
	 * @return the current position of the animal
	 */
	public Point getLocation();
	
	/**
	 * A method that updates the current position of the animal
	 * 
	 * @return True or false - whether the location has been updated or not
	 */
	public boolean setLocation(Point p);
}
