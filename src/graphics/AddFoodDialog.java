package graphics;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.invoke.StringConcatFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import plants.Cabbage;
import plants.Lettuce;
import plants.Meat;
import plants.Plant;
/*
 * This class defines the behavior of the button:"food".
 * @author Administrator
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 *
 */
public class AddFoodDialog   {

	private JDialog dialog;
	private JButton lettuce=new JButton("Lettuce");
	private JButton cabbage=new JButton("Cabbage");
	private JButton meat=new JButton("Meat");
	private JPanel displayButtons=new JPanel();
	private JPanel displayLabel =new JPanel();
	private JLabel title=new JLabel("Please Select Food Type:");
	private ZooPanel zooPanel;
	private ZooFrame zooFrame;
	private BufferedImage img;
	private String getType=this.getClass().getSimpleName();


	private static CopyOnWriteArrayList<Plant> food=new CopyOnWriteArrayList();

	/**
	 * The constructor of the food button.
	 * @param zf
	 *          zooframe
	 * @param zp
	 *           zoopanel
	 */        
	public AddFoodDialog(ZooFrame zf , ZooPanel zp) {
		dialog=new JDialog();
		zooFrame=zf;
		zooPanel=zp;
		displayLabel.add(title);
		displayButtons.add(cabbage);
		displayButtons.add(lettuce);
		displayButtons.add(meat);

		cabbage.addActionListener(new ActionListener() {

		@Override
			public void actionPerformed(ActionEvent e) {
				food.add(new Cabbage(zooPanel, zooFrame));
				disableButtons();
				dialog.dispose();
				//zooPanel.repaint();
				

			}
		});
		
		lettuce.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				food.add(new Lettuce(zooPanel ,zooFrame));
				disableButtons();
				dialog.dispose();
				//zooPanel.repaint();

			}
		});
		
		meat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				food.add(new Meat(zooPanel, zooFrame));
				disableButtons();
				dialog.dispose();
				//zooPanel.repaint();
				
			}
		});
		

		dialog.pack();
		dialog.add(displayLabel,BorderLayout.NORTH);
		dialog.add(displayButtons,BorderLayout.SOUTH);
		dialog.setBounds(200, 200, 500, 300);
		dialog.setDefaultCloseOperation(dialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		
	}

	/**
	 * The method closes the option to press the button
	 */
	private void disableButtons()
	{
		meat.setEnabled(false);
		lettuce.setEnabled(false);
		cabbage.setEnabled(false);
		//zooFrame.resize(new Dimension(800,601));
		//zooPanel.repaint();

	}
	/**
	 * The method returns the list of plants
	 * @return the list of plants
	 */
	public static CopyOnWriteArrayList<Plant> getFood()
	{
		return food;
	}
	/**
	 * The nethod returns the type of plants
	 * @return  the type of plants
	 */
	public String getFoodName()
	{
		return this.getType;
	}


}