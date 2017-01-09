import javax.swing.*;     
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.*;


public class Puzzle extends JFrame implements ActionListener{

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
	//	but2.addActionLister(this);
	//	but2.setActionCommand("yellow");
	JPanel panel3  = new JPanel();

	JButton but4  = new JButton("WEST");

	
        this.add(panel1,BorderLayout.CENTER);
	this.add(panel2, BorderLayout.NORTH);
	this.add(but2, BorderLayout.SOUTH);
	this.add(panel3, BorderLayout.EAST);
	this.add(but4, BorderLayout.WEST);

        // set layout of panel1

        panel1.setLayout(new GridLayout(8, 8, 0, 0));
	      
		
	// add buttons to the frame
		
		
	arrayBtn = new JButton[64];
		
	for(int i=0; i < arrayBtn.length; i++) {
		    
	    arrayBtn[i] = new JButton(Integer.toString(i));
	    arrayBtn[i].setBackground(Color.GREEN);
	    arrayBtn[i].setOpaque(true);
	    arrayBtn[i].addActionListener(this);
	    arrayBtn[i].setActionCommand("yellow");
	    panel1.add(arrayBtn[i]);
	    
	}


	panel2.setLayout(new FlowLayout());
	panel2.setPreferredSize(new Dimension(500, 30));

	JButton button1 = new JButton("White Goes First");
	JButton button2 = new JButton("Random");
	JButton button3 = new JButton("Black Goes First");
	button1.setPreferredSize(new Dimension(300,20));
	button2.setPreferredSize(new Dimension(300,20));
	button3.setPreferredSize(new Dimension(300,20));
	panel2.add(button1);
	panel2.add(button2);
	panel2.add(button3);
	

	panel3.setLayout(new BorderLayout());
	JLabel textarea1 = new JLabel("Black Pieces");
	textarea1.addActionListener(this);
	textarea1.addActionCommand("changeblackcount");
	JLabel textarea2 = new JLabel("White Pieces");
	textarea2.addActionListener(this);
	textarea2.addActionCommand("changewhitecount");
	JLabel textarea3 = new JLabel("Turns");
	textarea3.addActionListener(this);
	textarea3.addActionCommand("changeturncounter");
   
	panel3.add(textarea1, BorderLayout.NORTH);
	panel3.add(textarea2, BorderLayout.CENTER);
	panel3.add(textarea3, BorderLayout.SOUTH);

	
    }

    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	if(event.equals("Yellow")){
	    arrayBtn[i].setBackground(Color.YELLOW);
	}
	if(event.equals("Green")){
	    arrayBtn[i].setBackground(Color.GREEN);
	}
	if(event.equals("changeblackcount")){
	}
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
