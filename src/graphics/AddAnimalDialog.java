 package graphics;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

import animals.*;
/***
 * This class defines the behavior of the button:"Add Animal"
 * @author Administrator
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 *
 */
public class AddAnimalDialog extends JDialog implements ActionListener {

	private TabbedPane mainTB ;
	private int horizonForConstructor;
	private int vertForConstructor;
	private String colorForConstructor ;
	private int sizeForConstructor ;
	private String typeForConstructor;
	private int animalsCounter ;
	private ZooPanel pan;
	private ZooFrame frame;
	private  CopyOnWriteArrayList<Animal> animalArr ;
	
	
	public CopyOnWriteArrayList<Animal> getAnimalArr(){ return this.animalArr ;}
	
	/**
	 * This function checks what is the number of the animal
	 * 
	 * @return the number of animals
	 */
	public int getAnimalCounter() { return this.animalsCounter; }
	/**
	 * The function changes the number of animals
	 * @param newNum The new number of animals
	 */
	public void setAnimalCounter(int newNum) { this.animalsCounter = newNum ;}
	
	/**
	 * The constructor of the button: "Add an animal", and it initializes the fields of the object
	 * @param arr the array of the animal
	 * @param zp the zoo panel
	 */
	public AddAnimalDialog( CopyOnWriteArrayList<Animal> arr , ZooPanel zp , ZooFrame zf) {
		
		animalArr = arr;
		pan = zp;
		frame = zf;
		
		
		mainTB = new TabbedPane();
		
	}
	
	public class TabbedPane implements ActionListener {  
		
		JFrame f;  
		//Animals types button :
		
		JRadioButton l=new JRadioButton("Lion", true);    
		JRadioButton e=new JRadioButton("Elephant", false);    
		JRadioButton g=new JRadioButton("Giraffe", false); 
		JRadioButton t=new JRadioButton("Turtle", false); 
		JRadioButton b=new JRadioButton("Bear", false); 
		JButton AddAnimal = new JButton("Add Animal") ;
		
		// Animals colors button :
		
		JRadioButton red=new JRadioButton("Red", false); 
		JRadioButton blue=new JRadioButton("Blue", false); 
		JRadioButton netural=new JRadioButton("Netural", true); 
		
		//Animals size :
		
		JSpinner animalSize ;
		
		//Animal Speed :
		
		JSlider horizon;
		JSlider vert;
		
		/**
		 * an inner panel in addAnimalDialog panel 
		 */
		public TabbedPane() {  
		    f=new JFrame("Add Animal");  
		    
		    JPanel animalType=new JPanel();  
		    animalType.setLayout(new BoxLayout(animalType, BoxLayout.PAGE_AXIS));
		    
		    JPanel size=new JPanel();  
		    
		    JPanel Hspeed=new JPanel();  
		    
		    JPanel Vspeed=new JPanel();  
		    
		    JPanel color=new JPanel();  
		    
		    
		    JTabbedPane tp=new JTabbedPane();  
		    tp.setBounds(50,50,200,200);  
		    tp.add("Animal Type",animalType);  
		    tp.add("Animal Size",size);  
		    tp.add("Horizontal Speed",Hspeed);  
		    tp.add("Vertical Speed",Vspeed);    
		    tp.add("Animal Color",color);   
		    
		    ButtonGroup typebg=new ButtonGroup(); 
		    ButtonGroup colorbg=new ButtonGroup(); 
		    
		    
		    typebg.add(l); typebg.add(e); typebg.add(g); typebg.add(t); typebg.add(b); 
			animalType.add(l); animalType.add(e); animalType.add(g); animalType.add(t) ;animalType.add(b);
			
			colorbg.add(red); colorbg.add(blue); colorbg.add(netural);
			color.add(red); color.add(blue); color.add(netural);
			
			
			 SpinnerModel value = new SpinnerNumberModel(150, 50, 300, 1);   
			 animalSize = new JSpinner(value);  
			 
			 size.add(animalSize);
			 
			 horizon = new JSlider(JSlider.HORIZONTAL, 1, 10, 5);  
			 horizon.setMinorTickSpacing(1);  
			 horizon.setMajorTickSpacing(1);  
			 horizon.setPaintTicks(true);  
			 horizon.setPaintLabels(true); 
			 
			 Hspeed.add(horizon);
			 
			 vert = new JSlider(JSlider.HORIZONTAL, 1, 10, 5);  
			 vert.setMinorTickSpacing(1);  
			 vert.setMajorTickSpacing(1);  
			 vert.setPaintTicks(true);  
			 vert.setPaintLabels(true); 
			
			 Vspeed.add(vert);
		              
		    f.add(tp);  
		    f.add(AddAnimal);
		    f.setSize(400,400);  
		    f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.PAGE_AXIS)); 
		    f.setVisible(true);  
		    
		    
		    //ActionLiateners :
		    
			red.addActionListener(this);
			blue.addActionListener(this);
			netural.addActionListener(this);
			
			l.addActionListener(this);
			b.addActionListener(this);
			e.addActionListener(this);
			t.addActionListener(this);
			g.addActionListener(this);
			
			horizon.addChangeListener(new SliderListener());
			vert.addChangeListener(new SliderListener());
			animalSize.addChangeListener(new SpinnerListener());
			
			
			AddAnimal.addActionListener(this);
			
			
		}
		/**
		 * a slider listener who listen to the slider action 
		 */
		private class SliderListener implements  ChangeListener {
			
			@Override
			public void stateChanged(ChangeEvent e) {
			
				horizonForConstructor = (int) horizon.getValue();
				vertForConstructor =  (int) vert.getValue();	
				
			}	
		}
		/**
		 * a spinner listener who listen to the spinner action 
		 */
		private class SpinnerListener implements  ChangeListener {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				sizeForConstructor = (int) animalSize.getValue();
				
			}	
		}
		/**
		 * the action listener who listen to the panel actions
		 */
		@Override
		public void actionPerformed(ActionEvent ev) {
			
			if ( red.isSelected()) { colorForConstructor = "Red" ;}
			if ( blue.isSelected()) { colorForConstructor = "Blue" ;}
			if (netural.isSelected()) { colorForConstructor = "Netural" ;}
			
			if ( l.isSelected()) { ; typeForConstructor = "Lion" ;}
			if ( b.isSelected()) { typeForConstructor = "Bear" ;}
			if ( e.isSelected()) { typeForConstructor = "Elephant" ;}
			if ( t.isSelected()) { typeForConstructor = "Turtle" ;}
			if ( g.isSelected()) { typeForConstructor = "Giraffe" ;}
			
			
			if ( ev.getSource() == AddAnimal ) {
				f.dispose();
				if( animalArr.size() >= 10 ) { JOptionPane.showMessageDialog(null, String.format("You can't add more than 10 animals"));}
				
				else {
					
					sizeForConstructor = (int) animalSize.getValue();
					horizonForConstructor = (int) horizon.getValue();
					vertForConstructor =  (int) vert.getValue();	
					
							if (typeForConstructor == "Lion") {
								animalArr.add(new Lion(sizeForConstructor, horizonForConstructor, vertForConstructor,
										colorForConstructor, pan)); 
								animalArr.get(animalArr.size()-1).setChanges(true);
									
						
							}
							
							if (typeForConstructor == "Bear") {
								
								animalArr.add(new Bear(sizeForConstructor, horizonForConstructor, vertForConstructor,
										colorForConstructor, pan)); 
								animalArr.get(animalArr.size()-1).setChanges(true);
								
							
							}
							
							if (typeForConstructor == "Elephant") {
								
								animalArr.add(new Elephant(sizeForConstructor, horizonForConstructor, vertForConstructor,
										colorForConstructor, pan)); 
								animalArr.get(animalArr.size()-1).setChanges(true);
								
							
							}
							
							if (typeForConstructor == "Turtle") {
								
								animalArr.add(new Turtle(sizeForConstructor, horizonForConstructor, vertForConstructor,
										colorForConstructor, pan));
								animalArr.get(animalArr.size()-1).setChanges(true);
								
							
							}
							
							if (typeForConstructor == "Giraffe") {
								
								animalArr.add(new Giraffe(sizeForConstructor, horizonForConstructor, vertForConstructor,
										colorForConstructor, pan)); 
								animalArr.get(animalArr.size()-1).setChanges(true);
								
								
							}
						
						}
				
					}	
						
				}
					
					
}
	
	@Override
	public void actionPerformed(ActionEvent e) {}
	
}
