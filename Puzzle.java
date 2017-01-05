import javax.swing.*;     
import java.awt.*;
import java.awt.Dimension;


public class Puzzle extends JFrame {

    private static Color OthelloBoard;	

     public void Color(int r, int g, int b) {

       Color OthelloBoard = new Color(0, 102, 0);

    }	

    private static JButton[] arrayBtn;  

    public Puzzle(){

        // sets size of frame

        this.setSize(1200,1200);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
        this.setTitle("The Othello Game");
        // forces frame to remain in the center of the screen

        this.setLocationRelativeTo(null);

         

        // create a new panel - panel1

        JPanel panel1 = new JPanel();  

        JPanel panel2 = new JPanel();

	JButton but2  = new JButton("SOUTH");
	
	JButton but3  = new JButton("EAST");

	JButton but4  = new JButton("WEST");

	
        this.add(panel1,BorderLayout.CENTER);
	this.add(panel2, BorderLayout.NORTH);
	this.add(but2, BorderLayout.SOUTH);
	this.add(but3, BorderLayout.EAST);
	this.add(but4, BorderLayout.WEST);

        // set layout of panel1

        panel1.setLayout(new GridLayout(8, 8, 0, 0));
	      
		
	// add buttons to the frame
		
		
	arrayBtn = new JButton[64];
		
	// add JButtons dynamically
		
	for(int i=0; i < arrayBtn.length; i++) {
		    
	    arrayBtn[i] = new JButton(Integer.toString(i));
	    arrayBtn[i].setBackground(Color.GREEN);
	    arrayBtn[i].setOpaque(true);
	    panel1.add(arrayBtn[i]);
	    
	}


	panel2.setLayout(new FlowLayout());
	panel2.setPreferredSize(new Dimension(1080, 1080));

	JButton button1 = new JButton("White Goes First");
	JButton button2 = new JButton("Random");
	JButton button3 = new JButton("Black Goes First");
	button1.setPreferredSize(new Dimension(100,100));
	button2.setPreferredSize(new Dimension(100,100));
	button3.setPreferredSize(new Dimension(100,100));
	panel2.add(button1, FlowLayout.LEADING);
	panel2.add(button2, FlowLayout.CENTER);
	panel2.add(button3, FlowLayout.TRAILING);
	panel2.add(button1, FlowLayout.LEADING);
	panel2.add(button1, FlowLayout.LEADING);
	
    }
    public static void main(String[] args) {
	Puzzle p = new Puzzle();
	p.setVisible(true);
    }

}

//button.setBackground(Color.RED);
//button.setOpaque(true);


/*
 public void Color(int r, int g, int b) {

       OthelloBoard = new Color(0, 102, 0);

    }	

*/
