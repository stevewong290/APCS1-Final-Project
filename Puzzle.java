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
    private static JButton[] arrayBtn2;
    private static JLabel textarea1, textarea2, textarea3;
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
    
        //but2.addActionLister(this);
        //  but2.setActionCommand("yellow");
        JPanel panel3  = new JPanel();
    
    

    
        this.add(panel1, BorderLayout.CENTER);
        this.add(panel2, BorderLayout.NORTH);
        this.add(panel3, BorderLayout.EAST);

        // set layout of panel1

        panel1.setLayout(new GridLayout(8, 8, 0, 0));
	panel1.setSize(1200, 1170);
        
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
		Image image = whitecircles.getImage();
		Image newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		whitecircles = new ImageIcon(newimg);
		//	whitecircles.setPreferredSize(50, 50);
		arrayBtn[i].setIcon(whitecircles);
	    }
	    else if(a.board[x][y] == -1){
		ImageIcon blackcircles = new ImageIcon("./blackcircle.png");
		Image image = blackcircles.getImage();
		Image newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		blackcircles = new ImageIcon(newimg);
		arrayBtn[i].setIcon(blackcircles);
	    }
	    else if(a.highlighter[x][y] == true){
		arrayBtn[i].setBackground(Color.YELLOW);
		//  capture(x,y);
		arrayBtn[i].addActionListener(this);
		arrayBtn[i].setActionCommand("capturing" + x + y);
	    }
	    else{
		arrayBtn[i].setBackground(Color.GREEN);
		arrayBtn[i].addActionListener(this);
		arrayBtn[i].setActionCommand("donothing");
	    }
	    arrayBtn[i].setOpaque(true);
	    panel1.add(arrayBtn[i]);
        
	}


	panel2.setLayout(new FlowLayout());
	panel2.setPreferredSize(new Dimension(500, 30));

	arrayBtn2 = new JButton[2];
	
	arrayBtn2[0]  = new JButton("White Goes First");
	arrayBtn2[0].addActionListener(this);
	/*	button1.setActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
		a.restartBoard("white");
		for(int x = 0; x < arrayBtn.length;x++){
		arrayBtn[x].repaint();
		}
		System.out.println(a);
		}
		});*/
	arrayBtn2[0].setActionCommand("restartboard");
	//	JButton button2 = new JButton("Random");
	//	button2.addActionListener(this);
	//	button2.setActionCommand("restartboard1");
	arrayBtn2[1] = new JButton("Black Goes First");
	arrayBtn2[1].addActionListener(this);
	arrayBtn2[1].setActionCommand("restartboard2");

    
	arrayBtn2[0].setPreferredSize(new Dimension(300,20));
	arrayBtn2[1].setPreferredSize(new Dimension(300,20));
	panel2.add(arrayBtn2[0]);
	panel2.add(arrayBtn2[1]);
    

	panel3.setLayout(new BorderLayout());
	textarea1 = new JLabel("Black Pieces: " +  a.getBlack());
	//	textarea1.addActionCommand("add");
	textarea2 = new JLabel("White Pieces: " + a.getWhite());
  
	textarea3 = new JLabel("Turn: " + a.getTurn());

   
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
		int b = x / 8;
		int c = x % 8;
		arrayBtn[x].setActionCommand("donothing");
		arrayBtn[x].setIcon(null);
		arrayBtn[x].setBackground(Color.GREEN);
		if(a.board[b][c] == 1){
		    ImageIcon whitecircles = new ImageIcon("./whitecircle.jpg");
		    Image image = whitecircles.getImage();
		    Image newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		    whitecircles = new ImageIcon(newimg);
		    arrayBtn[x].setIcon(whitecircles);
		}
		else if(a.board[b][c] == -1){
		    ImageIcon blackcircles = new ImageIcon("./blackcircle.png");
		    Image image = blackcircles.getImage();
		    Image newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		    blackcircles = new ImageIcon(newimg);
		    arrayBtn[x].setIcon(blackcircles);
		    // arrayBtn[x].repaint();
		}
		else if(a.highlighter[b][c] == true){
		    arrayBtn[x].setBackground(Color.YELLOW);
		    // arrayBtn[x].addActionListener(this);
		    arrayBtn[x].setActionCommand("capturing" + b + c);
		}
		arrayBtn[x].repaint();
		arrayBtn2[0].repaint();
		arrayBtn[1].repaint();
	    }
	     textarea1.setText("Black Pieces: " +  a.getBlack());
	    
	    textarea2.setText("White Pieces: " + a.getWhite());
  
	    textarea3.setText("Turn: " + a.getTurn());
	    textarea1.repaint();
	    textarea2.repaint();
	    textarea3.repaint();
	    System.out.println(a);
	    /*   for(int x = 0; x < arrayBtn.length;x++){
		 arrayBtn[x].repaint();
		 }
		 System.out.println(a);
		 }*/
	}
	if(event.equals("restartboard2")){
	    a.restartBoard("blacks");
	    for(int x = 0; x < arrayBtn.length;x++){
		int b = x / 8;
		int c = x % 8;
		arrayBtn[x].setActionCommand("donothing");
		arrayBtn[x].setBackground(Color.GREEN);
		arrayBtn[x].setIcon(null);
		if(a.board[b][c] == 1){
		    ImageIcon whitecircles = new ImageIcon("./whitecircle.jpg");
		    Image image = whitecircles.getImage();
		    Image newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		    whitecircles = new ImageIcon(newimg);
		    arrayBtn[x].setIcon(whitecircles);
		}
		else if(a.board[b][c] == -1){
		    ImageIcon blackcircles = new ImageIcon("./blackcircle.png");
		    Image image = blackcircles.getImage();
		    Image newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		    blackcircles = new ImageIcon(newimg);
		    arrayBtn[x].setIcon(blackcircles);
		    // arrayBtn[x].repaint();
		}
		else if(a.highlighter[b][c] == true){
		    arrayBtn[x].setBackground(Color.YELLOW);
		    // arrayBtn[x].addActionListener(this);
		    arrayBtn[x].setActionCommand("capturing" + b + c);
		}
		arrayBtn[x].repaint();
		arrayBtn2[1].repaint();
		arrayBtn2[0].repaint();
	    }
	    textarea1.setText("Black Pieces: " +  a.getBlack());
	    
	    textarea2.setText("White Pieces: " + a.getWhite());
  
	    textarea3.setText("Turn: " + a.getTurn());
	    
	    textarea1.repaint();
	    textarea2.repaint();
	    textarea3.repaint();
	    System.out.println(a);
	}
	if(event.equals("donothing")){
	}
	if(event.substring(0,9).equals("capturing")){
	    //print x and y
	    a.capture(Character.getNumericValue(event.charAt(9)), Character.getNumericValue(event.charAt(10)));
	    //   Puzzle p = new Puzzle();
	    for(int x = 0; x < arrayBtn.length;x++){
		int b = x / 8;
		int c = x % 8;
		arrayBtn[x].setActionCommand("donothing");
		arrayBtn[x].setBackground(Color.GREEN);
		if(a.board[b][c] == 1){
		    ImageIcon whitecircles = new ImageIcon("./whitecircle.jpg");
		    Image image = whitecircles.getImage();
		    Image newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		    whitecircles = new ImageIcon(newimg);
		    arrayBtn[x].setIcon(whitecircles);
		}
		else if(a.board[b][c] == -1){
		    ImageIcon blackcircles = new ImageIcon("./blackcircle.png");
		    Image image = blackcircles.getImage();
		    Image newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		    blackcircles = new ImageIcon(newimg);
		    arrayBtn[x].setIcon(blackcircles);
		    // arrayBtn[x].repaint();
		}
		else if(a.highlighter[b][c] == true){
		    arrayBtn[x].setBackground(Color.YELLOW);
		    // arrayBtn[x].addActionListener(this);
		    arrayBtn[x].setActionCommand("capturing" + b + c);
		}
		arrayBtn[x].repaint();
		arrayBtn2[0].repaint();
		arrayBtn2[1].repaint();
	    }
	    textarea1.setText("Black Pieces: " +  a.getBlack());

	    textarea2.setText("White Pieces: " + a.getWhite());
  
	    textarea3.setText("Turn: " + a.getTurn());
	    textarea1.repaint();
	    textarea2.repaint();
	    textarea3.repaint();
	    if (a.endgame() == true) {
		if (a.getWhite() > a.getBlack()) {
		    Puzzle.infoBox("White Wins!");
		}
		else if (a.getBlack() > a.getWhite()) {
		    Puzzle.infoBox("Black Wins!");
		}
		else {
		    Puzzle.infoBox("Tie Game");
		}
	    }
	    //  repaint();
	    System.out.println(a);
	}
	//	if(event.equals("add")){
	//  black++;
	//  textarea1.repaint();
	//	}
    }
    public static void infoBox(String infoMessage) {
        JOptionPane.showMessageDialog(null, infoMessage, "Winner!", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void main(String[] args) {
	Puzzle p = new Puzzle();
	p.setVisible(true);
    }

}

//button.setBackground(Color.RED);
//button.setOpaque(true);
/*
Image img = icon.getImage() ;  
Image newimg = img.getScaledInstance( NEW_WIDTH, NEW_HEIGHT,  java.awt.Image.SCALE_SMOOTH ) ;  
icon = new ImageIcon( newimg );*/
