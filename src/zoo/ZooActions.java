package zoo;

import food.IEdible;
import animals.Animal;
import diet.Carnivore;
import diet.Herbivore;
import diet.Omnivore;
import mobility.Point;
import utilities.MessageUtility;

import java.util.Scanner;
import animals.Bear;
import animals.Elephant;
import animals.Giraffe;
import animals.Lion;
import animals.Turtle;
import java.util.Random;


/**
 * A class that describes the actions that a zoo animal can do
 * 
 * @author 
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 */
public class ZooActions {

	 private static Scanner sc;

	/**
	    * the method receives an animal and food and it checks if the animal can eat the food.
	    * 
	      @param animal 
	      		  The animal that eats
	      		  
	      @param food 
	      		  The desired food for feeding
	      		  
	      @return The weight gained by the animal after feeding
	    */
	public static boolean eat(Object animal, IEdible food) {
		
		if (animal instanceof Carnivore) {
         
          		if(((Carnivore)animal).canEat(food)){
          			
          			((Carnivore) animal).makeSound();
          			 MessageUtility.logBooleanFunction(((Carnivore)animal).getName(), "eat", food,((Carnivore)animal).canEat(food));
          			 return true;
          		}      
		}
		
		if (animal instanceof Herbivore) {
			
				if(((Herbivore)animal).canEat(food)) {
				
					((Herbivore)animal).makeSound();
					MessageUtility.logBooleanFunction(((Herbivore)animal).getName(), "eat", food,((Herbivore)animal).canEat(food));
					return true;
				}
		}
		
		if (animal instanceof Omnivore) {
			
				if(((Omnivore)animal).canEat(food)) {
				
					((Omnivore)animal).makeSound();
					MessageUtility.logBooleanFunction(((Omnivore)animal).getName(), "eat", food,((Omnivore)animal).canEat(food));
					return true;
				}
		}
		MessageUtility.logBooleanFunction(((Animal)animal).getName() , "eat", food , false);
		return false; 
	}
	
	/**
	 * The method receives a location and moves the animal to the location it received
	 * @param p
	 * 		  the new location of the animal
	 * 
	 * @return the distance the animal made from where it was to the new location.
	 */
	public static boolean move(Object animal, Point point) {
		
		if ( animal instanceof Animal) {
			
		    ((Animal)animal).calcDistance(point);
			((Animal) animal).setLocation(point);
			MessageUtility.logBooleanFunction(((Animal)animal).getName(),"move", point,true );
			return true;
		}
		MessageUtility.logBooleanFunction(((Animal)animal).getName(),"move", point, false );
		return false;
	}
	
	/**
	 * The main method of the program
	 * 
	 * @param args
	 */
/*	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		System.out.println(" pls enter size of arr");
		int size = sc.nextInt();
		while(size < 3) {
			
			System.out.println(" pls enter size bigger then 3");
			size = sc.nextInt();
		}
		
		Animal[] zoo = new Animal[size];
		
		for (int i=0; i < zoo.length; i+=1) {
			
			System.out.println("what animal do you want ?\n  \n 1- Bear\n 2- Elephant\n 3- Giraffe\n 4- Lion\n 5- Turtle\n ");
			int type = sc.nextInt();
			while( type < 1 || type > 5 ) {
				
				System.out.println(" pls enter again number between 1-5");
				type = sc.nextInt();
			}
			
			System.out.println("what name do you want ?\n");
			String name =sc.next();
			
			System.out.println("what weigth do you want ?\n");
			double weigth =sc.nextDouble();
			
			
			if(type == 1) {
	
				System.out.println("what fur's color do you want ?\n");
				String furcolor =sc.next();
				
				System.out.println("what location do you want ?\n X component ?\n");
				int x = sc.nextInt();
				System.out.println("Y component ?\n");
				int y = sc.nextInt();
				
				Point point = new Point(x,y);
				
				zoo[i] = new Bear(name , furcolor, point);
				zoo[i].setWeight(weigth);
			
			}
			
			if(type == 2) {

				System.out.println("what length of trunk do you want ?\n");
				double trunklength =sc.nextDouble();
				
				System.out.println("what location do you want ?\n X component ?\n");
				int x = sc.nextInt();
				System.out.println("Y component ?\n");
				int y = sc.nextInt();
				
				Point point = new Point(x,y);
				
				zoo[i] = new Elephant(name , trunklength, point);
				zoo[i].setWeight(weigth);
			}
			
			if(type == 3) {
				
				System.out.println("what length of neck do you want ?\n");
				double necklength =sc.nextDouble();
				
				System.out.println("what location do you want ?\n X component ?\n");
				int x = sc.nextInt();
				System.out.println("Y component ?\n");
				int y = sc.nextInt();
				
				Point point = new Point(x,y);
				
				zoo[i] = new Giraffe(name , necklength, point);
				zoo[i].setWeight(weigth);
			}
			
			if(type == 4) {
				
				System.out.println("what location do you want ?\n X component ?\n");
				int x = sc.nextInt();
				System.out.println("Y component ?\n");
				int y = sc.nextInt();
				
				Point point = new Point(x,y);
				
				zoo[i] = new Lion(name , point);
				zoo[i].setWeight(weigth);
	
			}
			
			if(type == 5) {
				
				System.out.println("what age do you want ?\n");
				int age =sc.nextInt();
				
				System.out.println("what location do you want ?\n X component ?\n");
				int x = sc.nextInt();
				System.out.println("Y component ?\n");
				int y = sc.nextInt();
				
				Point point = new Point(x,y);
				
				zoo[i] = new Turtle(name , age, point);
				zoo[i].setWeight(weigth);
			}
			
			System.out.println("______________________________________________________\n");
		}
		
		System.out.println("what location do you want ?\n X component ?\n");
		int x = sc.nextInt();
		System.out.println("Y component ?\n");
		int y = sc.nextInt();
		
		Point p = new Point(x,y);
		
		while(!Point.checkBoundaries(p)) {
			
			System.out.println("what location do you want ?\n X component ?\n");
			 x = sc.nextInt();
			System.out.println("Y component ?\n");
			 y = sc.nextInt();
			
			 p.setx(x);
			 p.sety(y);
		}
		
		for (int i=0; i < zoo.length; i+=1) {
			
		move(zoo[i], p);	
			
		}
		
		for (int i=0; i<= size/2 ; i+=1) {
			
			Random rnd = new Random();
			
			Object animal1 = zoo[rnd.nextInt(0, size)];
			Animal animal2 = zoo[rnd.nextInt(0,size)];
			
			if( animal1 != null && animal2 !=null){
				
				if (eat(animal1,animal2)==true) {
					
					animal2 = null;
				}
				System.out.println("null can't be eaten and can't eat\n");
			}	
		}	
	}	*/
}

