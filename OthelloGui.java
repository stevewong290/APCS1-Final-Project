/*package layout;
 

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
 
public class OthelloGui {
    public static boolean RIGHT_TO_LEFT = false;
     
    public static void addComponentsToPane(Container pane) {
         
	if (!(pane.getLayout() instanceof BorderLayout)) {
	    pane.add(new JLabel("Container doesn't use BorderLayout!"));
	    return;
	}
         
	if (RIGHT_TO_LEFT) {
	    pane.setComponentOrientation(
					 java.awt.ComponentOrientation.RIGHT_TO_LEFT);
	}
         
	JButton button = new JButton("Button 1 (PAGE_START)");
	pane.add(button, BorderLayout.PAGE_START);
         
	//Make the center component big, since that's the
	//typical usage of BorderLayout.
	button = new JButton("Button 2 (CENTER)");
	button.setPreferredSize(new Dimension(200, 100));
	pane.add(button, BorderLayout.CENTER);
         
	button = new JButton("Button 3 (LINE_START)");
	pane.add(button, BorderLayout.LINE_START);
         
	button = new JButton("Long-Named Button 4 (PAGE_END)");
	pane.add(button, BorderLayout.PAGE_END);
         
	button = new JButton("5 (LINE_END)");
	pane.add(button, BorderLayout.LINE_END);
    }
     
   
    private static void createAndShowGUI() {
         
	//Create and set up the window.
	JFrame frame = new JFrame("BorderLayoutDemo");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//Set up the content pane.
	addComponentsToPane(frame.getContentPane());
	//Use the content pane's default BorderLayout. No need for
	//setLayout(new BorderLayout());
	//Display the window.
	frame.pack();
	frame.setVisible(true);
    }
     
    public static void main(String[] args) {
	 Use an appropriate Look and Feel 
	try {
	    //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
	} catch (UnsupportedLookAndFeelException ex) {
	    ex.printStackTrace();
	} catch (IllegalAccessException ex) {
	    ex.printStackTrace();
	} catch (InstantiationException ex) {
	    ex.printStackTrace();
	} catch (ClassNotFoundException ex) {
	    ex.printStackTrace();
	}
	Turn off metal's use bold fonts 
	UIManager.put("swing.boldMetal", Boolean.FALSE);
         
	//Schedule a job for the event dispatch thread:
	//creating and showing this application's GUI.
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
		public void run() {
		    createAndShowGUI();
		}
	    });
    }
}

*/

import javax.swing.*;
import java.awt.*;
public class OthelloGui extends JFrame {
    private Container pane;

    private JButton b;
    private JButton l;
    private JButton t;
    private JButton c;
 
    //CONSTRUCTOR SETS EVERYTHING UP
    public OthelloGui() {
	this.setTitle("The Othello Game");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
	pane = this.getContentPane();
	pane.setLayout(new BorderLayout());  //NOTE!! THIS CAN BE CHANGED (see below)
    
	JButton button = new JButton("Button 1 (PAGE_START)");
	pane.add(button, BorderLayout.PAGE_START);
         
	//Make the center component big, since that's the
	//typical usage of BorderLayout.
	button = new JButton("Button 2 (CENTER)");
	button.setPreferredSize(new Dimension(200, 100));
	pane.add(button, BorderLayout.CENTER);
         
	button = new JButton("Button 3 (LINE_START)");
	pane.add(button, BorderLayout.LINE_START);
         
	button = new JButton("Long-Named Button 4 (PAGE_END)");
	pane.add(button, BorderLayout.PAGE_END);
         
	button = new JButton("5 (LINE_END)");
        pane.add(button, BorderLayout.LINE_END);
    }

    //MAIN JUST INSTANTIATES + MAKE VISIBLE
    public static void main(String[] args) {
	OthelloGui g = new OthelloGui();
	g.setVisible(true);
    }
}
