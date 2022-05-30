package graphics;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import graphics.ZooPanel;

/*
 * This class defines the behavior of the frame:"Zooframe"
 * @author Administrator
 * Shirel ghanah:206645103 
 * Noa Asulin:213250749
 * Ashdod Campus
 *
 */
public class ZooFrame extends JFrame implements ActionListener {

	private JMenuBar menupanel;
	private ZooPanel zooPanel = new ZooPanel(this);

	
    private JMenu file = new JMenu("File");
    private JMenu backGround = new JMenu("Background");
    private JMenu help = new JMenu("Help");
    private JMenuItem helpitem = new JMenuItem("Help");
    private JMenuItem imageItem = new JMenuItem("Image");
    private JMenuItem exitItem = new JMenuItem("Exit");
    private JMenuItem greenItem = new JMenuItem("Green");
    private JMenuItem noneItem = new JMenuItem("None");
    private BufferedImage tmpimg ;
    
    
    ImageIcon savanna = new ImageIcon(getClass().getResource("savanna.png"));
	/**
	 * The constructor of the department that initializes its fields
	 */
	public ZooFrame() {
		
		super("Zoo");
		
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		
		menupanel = new JMenuBar();
		
	    file.add(exitItem);
	    
	    backGround.add(imageItem);
	    backGround.add(greenItem);
	    backGround.add(noneItem);
	    
	    help.add(helpitem);
	    
	    menupanel.add(file);
	    menupanel.add(backGround);
	    menupanel.add(help);
	    
		add(menupanel);
		add(zooPanel);
		this.setSize(800, 600);
		
		exitItem.addActionListener(this);
		imageItem.addActionListener(this);
		greenItem.addActionListener(this);
		noneItem.addActionListener(this);
		helpitem.addActionListener(this);
		
		
		this.setVisible(true);
		
	}
	/**
	 * The method returns the zooframe
	 * @return the zooframe
	 */
	public ZooFrame getZooFrame() { return this ;} 
	/**
	 * The method Responds to the buttons of the zooframe
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == exitItem) { System.exit(0);}
			
		if (e.getSource() == imageItem) {  try { tmpimg = ImageIO.read(new File( "C:\\Users\\Administrator\\Desktop\\studys\\JAVA\\thezoo\\photoszoo\\savanna.png"));
		zooPanel.setImg(tmpimg);
		zooPanel.repaint();
		}
		 catch (IOException ev) { System.out.println("Cannot load image"); }}
			
		if (e.getSource() == greenItem) {zooPanel.setImg(null); zooPanel.setBackground(Color.GREEN);}
				
		if (e.getSource() == noneItem) {zooPanel.setImg(null); zooPanel.setBackground(Color.WHITE);}	
			
		if (e.getSource() == helpitem) {JOptionPane.showMessageDialog(null, String.format("Home work 2\n GUI"));}
			  
	  }	
		
	/**
	 * the main function
	 * @param args
	 */
	public static void main(String args[]) {
		
		ZooFrame zooFrame = new ZooFrame();
		zooFrame.setPreferredSize(new Dimension(2200,830));
	//	zooFrame.zooPanel.manageZoo();

		
		
	}
		
}