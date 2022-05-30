package mobility;

import utilities.MessageUtility;

/**
 * A class that describes a position by a point
 * 
 * @author
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 */
public class Point {
	
	/**
	 * The minimum value that the X component can have
	 */
	private final static int minx = 0;
	
	/**
	 * The minimum value that the Y component can have
	 */
	private final static int miny = 0;
	
	/**
	 * The maximum value that the X component can have
	 */
	private final static int maxx = 800;
	
	/**
	 * The maximum value that the Y component can have
	 */
	private final static int maxy = 600;
	
	/**
	 * The value of the X component
	 */
	private int x;
	
	/**
	 * The value of the Y component
	 */
	private int y;
	
	/**
	 * The constructor that updates the X and Y 
	 * components according to the parameters obtained
	 * 
	 * @param x
	 *        The X component     
	 *          
	 * @param y
	 *        The X component
	 */
	public Point(int x, int y) {
		
			this.x=x;
			this.y=y;
		}	

	/**
	 * A method that updates the value of the X component
	 * 
	 * @param x 
	 *        The desired X value for the update
	 */
	public void setx(int x)	{
		
		if(x >= minx && x<=maxx) {
			
			this.x=x;
		}
	}
	
	/**
	 * A method that updates the value of the Y component
	 * 
	 * @param x 
	 *        The desired Y value for the update
	 */
	public void sety(int y)	{
		
			if(y >= miny && y<=maxy) {
			
				this.y=y;
		}
	}
	
	/**
	 * A method that checks the value of the X component
	 * 
	 * @return The value of the X component
	 */
	public int getx() {
		return this.x;
	}
	
	/**
	 * A method that checks the value of the Y component
	 * 
	 * @return The value of the Y component
	 */
	public int gety() {
		return this.y;
	}
	
	/**
	 * A method that checks whether the values 
	 * of the X and Y components are correct
	 * 
	 * @param pointToCheck
	 *        The desired point for checking 
	 *        
	 * @return True or false - whether the point components are correct or not
	 */
	public static boolean checkBoundaries(Point pointToCheck){
		
		if((pointToCheck.getx() >= minx && pointToCheck.getx() <= maxx) && (pointToCheck.gety() >= miny && pointToCheck.gety() <= maxy)) {
			return true;
		}
		return false;
	}
	
	/**
	 * A method that describes the point and its components
	 */
	public String toString() {
		
		return "(" + this.x + "," + this.y +")" ;
	}
		
	
}


