package mobility;

import utilities.MessageUtility;

/**
 * A class describing the movement of an animal
 * 
 * @author
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 *
 */
public class Mobile implements Ilocatable {
	
	/**
	 * the current location
	 */
	private Point location;
	
	/**
	 * the total distance the animal has made
	 */
	private double totalDistance;
	
	/**
	 * The constructor who updates the animal
	 *  fields according to the entered parameters
	 * 
	 * @param location
	 *        The location of the animal
	 */
	public Mobile(Point location) {
		
		this.location = location;
	
		this.totalDistance = 0;
	    
	}
	
	/**
	 * A method that increases the total distance the animal has made
	 * 
	 * @param dis
	 *        The desired distance to add 
	 */
	public void addTotalDistance(double dis) {
		
		this.totalDistance+=dis;
	}
	
	/**
	 * A method that receives a point and calculates the distance
	 *  between the current position of the animal and that point
	 * 
	 * @param p
	 * 		  The point between it and 
	 *        the current location has to calculate the distance
	 *        
	 * @return the distance
	 *  between the current position of the animal and the point
	 */
	public double calcDistance(Point p) {
		
		double dis = Math.sqrt(Math.pow(p.getx() - this.location.getx(),2)+Math.pow(p.gety()-this.location.gety(),2));
		this.addTotalDistance(dis);
		return dis;
	}
	
	/**
	 * A method that checks what the current location is
	 * 
	 * @return the current position of the animal
	 */
	public synchronized Point getLocation() {
	
		return this.location;
	}
	
	/**
	 * A method that checks what is the current total distance 
	 * that the animal was made is
	 * 
	 * @return the current total distance of the animal
	 */
	public double getTotalDistance() {
		
		return this.totalDistance;
	}
	
	/**
	 * A method that updates the current position of the animal
	 * 
	 * @return True or false - whether the location has been updated or not
	 */
	public synchronized boolean setLocation(Point p) {
		
		if( Point.checkBoundaries(p)) {
			
			this.location.setx(p.getx());
			this.location.sety(p.gety());
			return true;
		}
		
		MessageUtility.logSetter(this.getClass().getSimpleName(), "setLocation", p, Point.checkBoundaries(p));
		return false;
	}
	
	
	
	

}
