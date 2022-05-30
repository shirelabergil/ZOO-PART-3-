package plants;

import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import food.EFoodType;
import food.IEdible;
import graphics.IDrawable;
import graphics.ZooFrame;
import graphics.ZooPanel;
import mobility.Ilocatable;
import mobility.Point;
import utilities.MessageUtility;


public abstract class Plant implements IEdible, Ilocatable , IDrawable {
	
	private BufferedImage cab , let , meat ;
	private ZooPanel pan ;
	private ZooFrame frame ;
	private boolean drawTerm;
	
	
	/**
	 * 
	 */
	private double height;
	/**
	 * 
	 */
	private Point location;
	/**
	 * 
	 */
	private double weight;

	/**
	 * 
	 */
	public Plant( ZooPanel p , ZooFrame z) {
		
		this.pan = p;
		this.frame = z;
		
		Random rand = new Random();
		int x = rand.nextInt(30);
		int y = rand.nextInt(12);
		this.location = new Point(x, y);
		this.height = rand.nextInt(30);
		this.weight = rand.nextInt(12);
		MessageUtility.logConstractor("Plant", "Plant");
		this.drawTerm = true;
	}
	
	public BufferedImage getCab() { return this.cab ;}
	public BufferedImage getLet() { return this.let ;}
	public BufferedImage getMeat() { return this.meat ;}
	public ZooPanel getpan() { return this.pan ;}
	public boolean getTerm() {return this.drawTerm ;}
	public void setTerm(boolean t) {this.drawTerm = t;}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see food.IFood#getFoodtype()
	 */
	@Override
	public EFoodType getFoodtype() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.VEGETABLE);
		if (this.getClass().getSimpleName().equals("Meat"))
			return EFoodType.MEAT;
		return EFoodType.VEGETABLE;
	}

	/**
	 * @return
	 */
	public double getHeight() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getHeight", this.height);
		return this.height;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mobility.ILocatable#getLocation()
	 */
	@Override
	public Point getLocation() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getLocation", this.location);
		return this.location;
	}

	/**
	 * @return
	 */
	public double getWeight() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getWeight", this.weight);
		return weight;
	}

	/**
	 * @param height
	 * @return
	 */
	public boolean setHeight(double height) {

		boolean isSuccess = (height >= 0);
		if (isSuccess) {
			this.height = height;
		} else {
			this.height = 0;
		}
		MessageUtility.logSetter(this.getClass().getSimpleName(), "setHeight", height, isSuccess);
		return isSuccess;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mobility.ILocatable#setLocation(mobility.Point)
	 */
	@Override
	public boolean setLocation(Point newLocation) {
		boolean isSuccess = Point.checkBoundaries(newLocation);
		if (isSuccess) {
			this.location = newLocation;
		}
		MessageUtility.logSetter(this.getClass().getSimpleName(), "setLocation", newLocation, isSuccess);
		return isSuccess;
	}

	/**
	 * @param weight
	 * @return
	 */
	public boolean setWeight(double weight) {
		boolean isSuccess = (weight >= 0);
		if (isSuccess) {
			this.weight = weight;
		} else {
			this.weight = 0;
		}
		MessageUtility.logSetter(this.getClass().getSimpleName(), "setWeight", weight, isSuccess);

		return isSuccess;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[" + this.getClass().getSimpleName() + "] ";
	}
	
	@Override
	public void loadImages(String strfood) {
		
		System.out.println("loading img ");
		System.out.println(strfood);
		
		final String [] names = { "cabbage.png" , "lettuce.png" , "meat.gif"};
		final String [] className = { "Cabbage" , "Lettuce" , "Meat" };
		
		if (strfood.equals(className[0])) {
			
			
			try {  this.cab = ImageIO.read(new File(PICTURE_PATH +names[0])); }
			
			catch (IOException e) { System.out.println("Cannot load image"); } 
		}
		
		if (strfood.equals(className[1])) {
			
			try {  this.let = ImageIO.read(new File(PICTURE_PATH +names[1])); }
			
			catch (IOException e) { System.out.println("Cannot load image 1"); } 
		}
		
		if (strfood.equals(className[2])) {
			
			try {  this.meat = ImageIO.read(new File(PICTURE_PATH +names[2])); }
			
			catch (IOException e) { System.out.println("Cannot load image"); } 
		}
		
	}

	@Override
	public void drawObject(Graphics g) {
		
		
		if( this.getClass().getSimpleName().equals("Lettuce")) {
			
			g.drawImage(this.getLet(), (frame.getContentPane().getWidth()-80)/2, (frame.getContentPane().getHeight()-80)/2, 80, 80, this.getpan());
			this.setLocation(new Point((int)(frame.getContentPane().getWidth()-80)/2, (int)(frame.getContentPane().getHeight()-80)/2));
		
		}
		
		if( this.getClass().getSimpleName().equals("Cabbage")) { 
			
			g.drawImage(this.getCab(),(frame.getContentPane().getWidth()-80)/2, (frame.getContentPane().getHeight()-80)/2, 80, 80, this.getpan());
			this.setLocation(new Point((int)(frame.getContentPane().getWidth()-80)/2, (int)(frame.getContentPane().getHeight()-80)/2));
		}
		
		if( this.getClass().getSimpleName().equals("Meat")) {
			
			g.drawImage(this.getMeat(),(frame.getContentPane().getWidth()-80)/2, (frame.getContentPane().getHeight()-80)/2, 80, 80, this.getpan());
			this.setLocation(new Point((int)(frame.getContentPane().getWidth()-80)/2, (int)(frame.getContentPane().getHeight()-80)/2));
		}
	}
	
	// 	 g.drawImage(this.img1, this.getLocation().getx()-this.size/2, this.getLocation().gety()-this.size/3, this.size, this.size/(3/2), this.pan);

	@Override
	public String getColor() {
		return null;
	}

}
