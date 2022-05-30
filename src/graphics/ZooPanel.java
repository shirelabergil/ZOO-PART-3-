package graphics;
/***
 * This class defines the behavior of the panel:"ZooPanel"
 * @author Administrator
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 *
 */
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import graphics.AddAnimalDialog;
import mobility.Point;
import plants.Cabbage;
import plants.Lettuce;
import plants.Meat;
import plants.Plant;
import animals.Animal;

public class ZooPanel extends JPanel implements ActionListener , Runnable {
 /**
  * the thread of this panel
  */
	private Thread controller;
	/**
	 * the pannel button 
	 */
	private JPanel btMenu = new JPanel();
	/**
	 * an addanimal panel 
	 */
	private AddAnimalDialog addanimal;
	
	/**
	 * the arr who save the animals 
	 */
	protected static CopyOnWriteArrayList<Animal> animalarr;
	/**
	 * the image of the panel 
	 */
	private BufferedImage img = null;
	
	
	/**
	 * the buttons of this panel 
	 */
	private JButton addAnimal = new JButton("Add Animal");
	private JButton sleep = new JButton("Sleep");
	private JButton wakeup = new JButton("Wake Up");
	private JButton clear = new JButton("Clear All");
	private JButton food = new JButton("Food");
	private JButton info = new JButton("Info");
	private JButton exit = new JButton("Exit");
	
	/**
	 * the zooframe panel 
	 */
	private ZooFrame zooframe;
	/**
	 * the plant panel 
	 */
	private Plant plant;
	
	JPanel Food = new JPanel();
	private JButton jb1 = new JButton(" lettuce ");
	private JButton jb2 = new JButton(" cabbage ");
	private JButton jb3 = new JButton(" meat ");
	


	/**
	 * the constructor of this panel 
	 * @param z - reference of the frame 
	 */
	public ZooPanel(ZooFrame z) {
		
		this.zooframe = z;
		
		controller = new Thread(this);
		controller.start();
		
		animalarr = new CopyOnWriteArrayList();

		
		this.setLayout(new BorderLayout());
		
		this.setPreferredSize(new Dimension(600, 800));
		
		
		btMenu.setLayout(new BoxLayout(btMenu, BoxLayout.LINE_AXIS));
		
		btMenu.add(addAnimal);
		btMenu.add(sleep);
		btMenu.add(wakeup);
		btMenu.add(clear);
		btMenu.add(food);
		btMenu.add(info);
		btMenu.add(exit);

		
		
		addAnimal.addActionListener(this);
		sleep.addActionListener(this);
		wakeup.addActionListener(this);
		clear.addActionListener(this);
		food.addActionListener(this);
		info.addActionListener(this);
		exit.addActionListener(this);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		//this.setBackground(Color.black);
		//add(background);
		add(btMenu , BorderLayout.SOUTH);	
		this.setOpaque(true);
		this.setVisible(true);
		
		
	}
	/**
	 * 
	 * @return the zooframe 
	 */
	public ZooFrame getZooFrame() {return this.zooframe; }
	/**
	 * 
	 * @return the background of the panel
	 */
	public BufferedImage getImg() { return this.img ; };
	/**
	 * setting the background 
	 * @param img : the requested background 
	 */
	public void setImg(BufferedImage img) { this.img = img ;}
	/**
	 * 
	 * @return the animal arr 
	 */
	public static CopyOnWriteArrayList<Animal> getAnimalList() { return animalarr ;}
	/**
	 * adding an animal to the animal arr
	 * @param animal : the requested animal to add
	 */
	public void setAnimalList( Animal animal) {animalarr.add(animal);}
	
	
	/**
	 * an overriding , doing the repaint .
	 */
	@Override
	public void paintComponent(Graphics g) {
		 super.paintComponent(g) ;
	
		 Graphics2D gr = ( Graphics2D ) g;
		 gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		
		 try
		 {	
			 if( img!=null ) {gr.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),this);}
			 
			 for( int i =0 ; i< addanimal.getAnimalArr().size() ; i++ ) {
				
				 if(addanimal.getAnimalArr().get(i) != null/* && animalarr.get(i).getTerm()==true*/) { 
				
					 addanimal.getAnimalArr().get(i).loadImages(addanimal.getAnimalArr().get(i).getColor());
					 addanimal.getAnimalArr().get(i).drawObject(gr);
					
					 
				 }
			 }
			 
			
			
				 for (int i=0;i<AddFoodDialog.getFood().size();++i)
				 {
					 if(AddFoodDialog.getFood().get(i) != null) {
					 AddFoodDialog.getFood().get(i).loadImages(AddFoodDialog.getFood().get(i).getClass().getSimpleName());
					 AddFoodDialog.getFood().get(i).drawObject(gr);
					
					 }
				 }
			
		 }
		 
		catch (Exception e) {System.out.println("cannot load image");
			return ;}
		 
		 }
	
	/**
	 * choose what method to start by the source
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if( e.getSource() == addAnimal) {  addanimal = new AddAnimalDialog( getAnimalList() , this, zooframe); }
		
		if( e.getSource() == clear) { clearAll();}
		
		if( e.getSource() == food) {
		
				 new AddFoodDialog(zooframe , this);
				food.setEnabled(false);
		}
		
		if( e.getSource() == info) {new Info(zooframe ,  getAnimalList());}
		
		if( e.getSource() == exit) {System.exit(0);}
		
		if( e.getSource() == sleep) {
			
			for( int i =0 ; i< addanimal.getAnimalArr().size() ; i++ )
			{	
				 addanimal.getAnimalArr().get(i).setThreadSuspended(true);
			}
			
		}
		
		if( e.getSource() == wakeup) { 
			
			//controller.start();
			
			for (int i = 0 ; i<addanimal.getAnimalArr().size() ; i++ )
			{
				this.setResumed();		
			}
		}
	}
	/**
	 * wakeups the animals
	 */
	public void setResumed() {
		
		for (int i = 0 ; i<addanimal.getAnimalArr().size() ; i++ )
		{
			synchronized( addanimal.getAnimalArr().get(i).getThread()) {
				addanimal.getAnimalArr().get(i).getThread().notify();
				addanimal.getAnimalArr().get(i).setThreadSuspended(false);
			}
		}
	}
	/**
	 * checking if the animals doing any change
	 * @return
	 */
	public boolean isChange() {
	
		 for(int i =0 ; i< animalarr.size() ; i++ ) {
			 
			 if(animalarr.get(i).getChanges() == true ) { return true;}
		 }
		 
		return false;
	}
/**
 * manage the repainting by the relevant functions
 */
	public void manageZoo() {
		
		   if(isChange()) { repaint();};
		   if(tryEatAnotherAnimal()) {repaint();} 
		   eatPlants(); 
		   
		   repaint(); 
		
		   
		

	}
	/**
	 * delete all the elements on panel and stop the threads
	 */
	private  void clearAll()
	{
		
		for(int i=0;i<getAnimalList().size();++i)
		{
			getAnimalList().get(i).setisAlive(false);
			getAnimalList().removeAll(getAnimalList());
		}
		
		for(int i=0;i<AddFoodDialog.getFood().size();++i) {
			
			AddFoodDialog.getFood().removeAll(AddFoodDialog.getFood());
		}
		
		this.food.setEnabled(true);
		repaint();
		
	}
	/**
	 * every animal tey to eat other animal
	 * @return if some animal success to eat enother animal
	 */
	private  synchronized boolean tryEatAnotherAnimal()
	{
		
		Animal predator,prey;
		for(int i=0;i< getAnimalList().size();++i)
		{
			for(int j=0; j< getAnimalList().size();++j)
			{
				predator= getAnimalList().get(i);
				prey= getAnimalList().get(j);
				 
					 if(predator.getdiet().canEat(prey)&&predator.getWeight()>=2*prey.getWeight() &&
						predator.calcDistance(prey.getLocation()) < prey.getSize() ) 
					 {
						 predator.eat(predator, prey);
						 getAnimalList().remove(j);
						 predator.eatInc();
						 JOptionPane.showMessageDialog(this, predator.getAnimalName()+" Ate :"+prey.getAnimalName());
						 prey.setisAlive(false);
						 return true;
					 }
			}
				
		}
		return false;
	}
	
	/**
	 * checks eating conditions and returns true if they returns true.
	 * @return Boolean-true if condition is valid.
	 */
		public synchronized void eatPlants() 
		{
		
		for(int i=0;i<AddFoodDialog.getFood().size();++i) {
  	  	  
  	  	  for (Animal animal : addanimal.getAnimalArr()) { // going through the entire array
  	  		  
  	  		  plant = AddFoodDialog.getFood().get(i);
    	  
  	  		  
  	  		  if (plant!=null && animal.getdiet().canEat(plant))
  	  		  {
  	  			  if(animal.getLocation().getx()>plant.getLocation().getx())
  	  				  animal.setXdir(-1);
  	  			  else
  	  				  animal.setXdir(1);

  	  			  if(animal.getLocation().gety()>plant.getLocation().gety())
  	  				  animal.setYdir(-1);
  	  			  else
  	  				  animal.setYdir(1);
             
  	  			  if(Math.abs(animal.getLocation().getx()-plant.getLocation().getx())<=animal.getHorSpeed() && plant != null/*&& animal.getHorSpeed()!=0*/)
  	  			  {
  	  				  animal.setLocation(new Point(plant.getLocation().getx(),animal.getLocation().gety()));
 	  				  //animal.setHorSpeed(0);
  	  				  
  	  			  }
             
  	  			  if(Math.abs(animal.getLocation().gety()-plant.getLocation().gety())<=animal.getVerSpeed() && plant != null /*&&animal.getVerSpeed()!=0*/)
  	  			  {
  	  				  animal.setLocation(new Point(animal.getLocation().getx(),plant.getLocation().gety()));
  	  				  //animal.setVerSpeed(0);
  	  				 
  	  			  }

  	  			  if (animal.getLocation().getx() == plant.getLocation().getx() && animal.getLocation().gety() == plant.getLocation().gety()) 
  	  			  {
  	  				  animal.eat(plant);
  	  				  JOptionPane.showMessageDialog(this, animal.getAnimalName()+" Ate :"+ plant);
  	  				  animal.eatInc();
  	  				  AddFoodDialog.getFood().remove(i);
  	  				  food.setEnabled(true);
  	  				  
  	  			  }
          
  	  		  }
  	  			
  	  		  
  	  		  
  	  	  	}
		}
	}
	/**
	 * all of what the zooPanel thread to 
	 */
	@Override
	public void run() {
		
		   manageZoo();
	}

	

	
	
	
	
	
}