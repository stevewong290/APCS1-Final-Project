import javax.swing.*;     
import java.awt.BorderLayout;
import java.awt.GridLayout;

 

public class Puzzle extends JFrame {

    private static JButton[] arrayBtn;  

    public Puzzle(){

        // sets size of frame

        this.setSize(1300,650);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
        this.setTitle("Merger");
        // forces frame to remain in the center of the screen

        this.setLocationRelativeTo(null);

         

        // create a new panel - panel1

        JPanel panel1 = new JPanel();  

	JButton but1  = new JButton("NORTH");

	JButton but2  = new JButton("SOUTH");
	
	JButton but3  = new JButton("EAST");

	JButton but4  = new JButton("WEST");

	
        this.add(panel1,BorderLayout.CENTER);
	this.add(but1, BorderLayout.NORTH);
	this.add(but2, BorderLayout.SOUTH);
	this.add(but3, BorderLayout.EAST);
	this.add(but4, BorderLayout.WEST);

        // set layout of panel1

        panel1.setLayout(new GridLayout(8, 8, 0, 0));

	    
         
		
	// add a text field with a specified text to the frame
	       
	    
         
		
	// add buttons to the frame
		
		
	arrayBtn = new JButton[64];
	    
	// add JButtons dynamically
		
	for(int i=0; i < arrayBtn.length; i++) {
		    
	    arrayBtn[i] = new JButton(Integer.toString(i));
		    
	    panel1.add(arrayBtn[i]);

	}
    }
    public static void main(String[] args) {
	Puzzle p = new Puzzle();
	p.setVisible(true);
    }

}
