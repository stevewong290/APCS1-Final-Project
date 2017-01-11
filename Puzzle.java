import javax.swing.*;     
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.*;


public class Puzzle extends JFrame implements ActionListener{
    /* private static Color OthelloBoard;   
       public void Color(int r, int g, int b) {
       Color OthelloBoard = new Color(0, 102, 0);
       }
    */

    private static JButton[] arrayBtn;
    Othello a = new Othello();
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
    
        //  but2.addActionLister(this);
        //  but2.setActionCommand("yellow");
        JPanel panel3  = new JPanel();
    
    

    
        this.add(panel1, BorderLayout.CENTER);
        this.add(panel2, BorderLayout.NORTH);
        this.add(panel3, BorderLayout.EAST);

        // set layout of panel1

        panel1.setLayout(new GridLayout(8, 8, 0, 0));
          
        
	// add buttons to the frame
        
        
	arrayBtn = new JButton[64];
        
	for(int i=0; i < arrayBtn.length; i++) {
	    int x = i / 8;
	    int y = i % 8;
	    arrayBtn[i] = new JButton();    
	    //  ImageIcon whitecircles = new ImageIcon("./whitecircle.jpg");
	    //  whitecircles.setPreferredSize(50,50);
	    // arrayBtn[i].setIcon(whitecircles);
	    if(a.board[x][y] == 1){
			ImageIcon whitecircles = new ImageIcon("./whitecircle.jpg");
			arrayBtn[i].setIcon(whitecircles);
	    }
	    else if(a.board[x][y] == -1){
			ImageIcon blackcircles = new ImageIcon("./blackcircle.png");
		arrayBtn[i].setIcon(blackcircles);
	    }
	    else if(a.highlighter[x][y] == true){
		//	arrayBtn[i].setBackground(Color.YELLOW);
		//  capture(x,y);
		arrayBtn[i].addActionListener(this);
		arrayBtn[i].setActionCommand("capturing" + x + y);
	    }
	    else{
		arrayBtn[i].setBackground(Color.GREEN);
	    }
	    arrayBtn[i].setOpaque(true);
	    panel1.add(arrayBtn[i]);
        
	}


	panel2.setLayout(new FlowLayout());
	panel2.setPreferredSize(new Dimension(500, 30));

	JButton button1 = new JButton("White Goes First");
	button1.addActionListener(this);
	button1.setActionCommand("restartboard");
	JButton button2 = new JButton("Random");
	button2.addActionListener(this);
	button2.setActionCommand("restartboard1");
	JButton button3 = new JButton("Black Goes First");
	button3.addActionListener(this);
	button3.setActionCommand("restartboard2");

    
	button1.setPreferredSize(new Dimension(300,20));
	button2.setPreferredSize(new Dimension(300,20));
	button3.setPreferredSize(new Dimension(300,20));
	panel2.add(button1);
	panel2.add(button2);
	panel2.add(button3);
    

	panel3.setLayout(new BorderLayout());
	JLabel textarea1 = new JLabel("Black Pieces: " +  a.black);
 
	JLabel textarea2 = new JLabel("White Pieces: " + a.white);
  
	JLabel textarea3 = new JLabel("Turns: " + a.turn);

   
	panel3.add(textarea1, BorderLayout.NORTH);
	panel3.add(textarea2, BorderLayout.CENTER);
	panel3.add(textarea3, BorderLayout.SOUTH);

    
    }

    public void paint(Graphics g){
    }

    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	/*  if(event.equals("Yellow")){
	    arrayBtn[i].setBackground(Color.YELLOW);
	    }
	    if(event.equals("Green")){
	    arrayBtn[i].setBackground(Color.GREEN);
	    } */
        if(event.equals("restartboard")){
	    a.restartBoard("whites");
	    for(int x = 0; x < arrayBtn.length;x++){
		arrayBtn[x].repaint();
	    }
	}
	if(event.equals("restartboard2")){
	    a.restartBoard("black");
	}
	if(event.equals("donothing")){
	}
	if(event.substring(0,9).equals("capturing")){
	    //print x and y
	    a.capture(Character.getNumericValue(event.charAt(9)), Character.getNumericValue(event.charAt(10)));
	    //should we refresh hear? Do we just recall the constructor or whjbo at???fafdsafdsa
	    //   Puzzle p = new Puzzle();
	    for(int x = 0; x < arrayBtn.length;x++){
		int b = x / 8;
		int c = x % 8;
		arrayBtn[x].addActionListener(this);
		arrayBtn[x].setActionCommand("donothing");
		arrayBtn[x].setBackground(Color.GREEN);
		if(a.board[b][c] == 1){
		    ImageIcon whitecircles = new ImageIcon("./whitecircle.jpg");
		    arrayBtn[x].setIcon(whitecircles);
		}
		else if(a.board[b][c] == -1){
		    ImageIcon blackcircles = new ImageIcon("./blackcircle.png");
		    arrayBtn[x].setIcon(blackcircles);
		}
		else if(a.highlighter[b][c] == true){
		    arrayBtn[x].setBackground(Color.YELLOW);
		    arrayBtn[x].addActionListener(this);
		    arrayBtn[x].setActionCommand("capturing" + b + c);
		}
	    }
	    repaint();
	    System.out.println(a);
	}
    }
    public static void main(String[] args) {
	Puzzle p = new Puzzle();
	p.setVisible(true);
    }

}

//button.setBackground(Color.RED);
//button.setOpaque(true);
