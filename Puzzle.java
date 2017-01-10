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
    private int[][] board = new int[8][8];
    private boolean[][] highlighter = new boolean[8][8];
    private int turn, white, black, counter, empty;
    private String first;
    
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
    
    

    
        this.add(panel1,BorderLayout.CENTER);
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
        if(board[x][y] == 1){
        ImageIcon whitecircle = new ImageIcon("./whitecircle.jpg");
        arrayBtn[i].setIcon(whitecircle);
        }
        else if(board[x][y] == -1){
        ImageIcon blackcircle = new ImageIcon("./blackcircle.png");
        arrayBtn[i].setIcon(blackcircle);
        }
        else if(highlighter[x][y] == true){
        arrayBtn[i].setBackground(Color.YELLOW);
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
    JLabel textarea1 = new JLabel("Black Pieces: " + black);
 
    JLabel textarea2 = new JLabel("White Pieces: " + white);
  
    JLabel textarea3 = new JLabel("Turns: " + turn);

   
    panel3.add(textarea1, BorderLayout.NORTH);
    panel3.add(textarea2, BorderLayout.CENTER);
    panel3.add(textarea3, BorderLayout.SOUTH);

    
    }

    private void endgame(){
    if(white == 0 || black == 0|| counter == 2 || empty == 0){
        if (black > white){
        System.out.println("black Wins");
        }
        else if(black == white){
        System.out.println("tied");
        }
        else{
        System.out.println("white wins");
        }
    }
    }    
    /* public Othello(){
       restartBoard();
       }
    */
    /* private void turn(){
       if (first == black){
       }
       else{
       }}
       }*/
    private void highlight(){
    if(first =="blacks"){
        if(turn % 2 == 1){
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
            if (board[x][y] == -1){
                check(x,y);
            }
            }
        }
        }
        else{
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
            if (board[x][y] == -1){
                check(x,y);
            }
            }
        }
        }
    }
    else{
        if(turn % 2 == 0){
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
            if (board[x][y] == -1){
                check(x,y);
            }
            }
        }
        }
        else{
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
            if (board[x][y] == -1){
                check(x,y);
            }
            }
        }
        }
    }
    if(count() == false){
        turn ++;
        counter++;
        endgame();
        highlight();
    }
    }
    private boolean count(){
    for(int x = 0; x < 8;x++){
        for(int y = 0; y < 8;y++){
        if(highlighter[x][y] == true){
            return true;
        }
        }
    }
    return false;
    }
    private void check(int x, int y){
    for(int a = 0; a <board.length;a++){
        for(int b = 0; b < board[a].length;b++){
        highlighter[a][b] = false;
        }
    }
    int val = board[x][y];
    if(x > 1 && board[x - 1][y] == val * -1){
        checkUp(x,y);
    }
    if(x < 6 && board[x + 1][y] == val * -1){
        checkDown(x,y);
    }
    if(y < 6 && board[x][y - 1] == val * -1){
        checkRight(x,y);
    }
    if(y > 1 && board[x][y + 1] == val * -11){
        checkLeft(x,y);
    }
    // diagonals
    if(x > 1 && y > 1 && board[x - 1][y - 1] == val * -1){
        checkUpAndLeft(x,y);
    }
    if(x < 6 && y > 1 && board[x + 1][y - 1] == val * -1){
        checkDownAndLeft(x,y);
    }
    if(x > 1 && y < 6 && board[x - 1][y + 1] == val * -1){
        checkUpAndRight(x,y);
    }
    if(x < 6 && y < 6 && board[x + 1][y + 1] == val * -1){
        checkDownAndRight(x,y);
    }
    }
    
    public void checkDown(int x, int y){
    int val = board[x][y];
    int a;
    for(a = x + 1; a <= 7 && board[a][y] == val * -1; a++){
        if(board[a][y] == 0){
        break;
        } 
    }
    highlighter[a][y] = true;
    }
    public void checkUp(int x, int y){
    int val = board[x][y];
    int a;
    for(a = x - 1; a >= 0 && board[a][y] == val * -1; a--){
        if(board[a][y] == 0){
        break;
        }
        
    }
    highlighter[a][y] = true;
    }
    public void checkRight(int x, int y){
    int val = board[x][y];
    int a;
    for(a = y + 1; a <= 7 && board[x][a] == val * -1; a++){
        if(board[x][a] == 0){
        break;
        }
    }
    highlighter[x][a] = true;
    }
    public void checkLeft(int x, int y){
    int val = board[x][y];
    int a;
    for(a = y - 1; a >= 0 && board[x][a] == val * -1; a--){
        if(board[x][a] == 0){
        break;
        }
    }
    highlighter[x][a] = true;
    }
    public void checkDownAndRight(int x, int y){
    int val = board[x][y];
    int a;
    for(a = 1;a + y <= 7 && a + x <= 7 && board[x + a][y + a] == val * -1; a++){
        if(board[x + a][y + a] == 0){
        break;
        } 
    }
    highlighter[x + a][y + a] = true;
    }
    public void checkDownAndLeft(int x, int y){
    int val = board[x][y];
    int a;
    for(a = 1;y - a >= 0 && a + x <= 7 && board[x + a][y - a] == val * -1; a++){
        if(board[x + a][y - a] == 0){
        break;
        } 
    }
    highlighter[x + a][y - a] = true;
    }
    public void checkUpAndLeft(int x, int y){
    int val = board[x][y];
    int a;
    for(a = 1;y - a >= 0 && x - a >= 0 && board[x - a][y - a] == val * -1; a++){
        if(board[x - a][y - a] == 0){
        break;
        } 
    }
        highlighter[x - a][y - a] = true;
    }
    public void checkUpAndRight(int x, int y){
    int val = board[x][y];
    int a;
    for(a = 1;y + a <= 7 && x - a >= 0 && board[x - a][y + a] == val * -1; a++){
        if(board[x - a][y + a] == 0){
        break;
        } 
    }
    highlighter[x - a][y + a] = true;
    }
    private void restartBoard(String a){
    first = a;
    turn = 1;
    white = 2;
    black = 2;
    counter = 0;
    for(int x = 0; x <board.length;x++){
        for(int y = 0; y < board[x].length;y++){
        board[x][y] = 0;
        highlighter[x][y] = false;
        }
    }
    board[3][3] = -1;
    board[3][4] = 1;
    board[4][3] = 1;
    board[4][4] = -1;
    highlight();
    }
    
    private void blackMoves(int x,int y){
    board[x][y] = -1;
    if(x > 1 && board[x - 1][y] == 1){
        captureUp(x,y);
    }
    if(x < 6 && board[x + 1][y] == 1){
        captureDown(x,y);
    }
    if(y < 6 && board[x][y - 1] == 1){
        captureRight(x,y);
    }
    if(y > 1 && board[x][y + 1] == 1){
        captureLeft(x,y);
    }
    // diagonals
    if(x > 1 && y > 1 && board[x - 1][y - 1] == 1){
        captureUpAndLeft(x,y);
    }
    if(x < 6 && y > 1 && board[x + 1][y - 1] == 1){
        captureDownAndLeft(x,y);
    }
    if(x > 1 && y < 6 && board[x - 1][y + 1] == 1){
        captureUpAndRight(x,y);
    }
    if(x < 6 && y < 6 && board[x + 1][y + 1] == 1){
        captureDownAndRight(x,y);
    }
    turn ++;
    endgame();
    highlight();
    }
    private void whiteMoves(int x,int y){
    board[x][y] = 1;
    if(x > 1 && board[x - 1][y] == -1){
        captureUp(x,y);
    }
    if(x < 6 && board[x + 1][y] == -1){
        captureDown(x,y);
    }
    if(y < 6 && board[x][y + 1] == -1){
        captureRight(x,y);
    }
    if(y > 1 && board[x][y - 1] == -1){
        captureLeft(x,y);
    }
    // diagonals
    if(x > 1 && y > 1 && board[x - 1][y - 1] == -1){
        captureUpAndLeft(x,y);
    }
    if(x < 6 && y > 1 && board[x + 1][y - 1] == -1){
        captureDownAndLeft(x,y);
    }
    if(x > 1 && y < 6 && board[x - 1][y + 1] == -1){
        captureUpAndRight(x,y);
    }
    if(x < 6 && y < 6 && board[x + 1][y + 1] == -1){
        captureDownAndRight(x,y);
    }
    turn++;
    endgame();
    highlight();
    }
    
    private void capture(int x, int y){
    if(first == "blacks"){
        if (turn % 2 == 0){
        whiteMoves(x,y);
        }
        else blackMoves(x,y);
    }
    else{
        if(turn % 2 == 0){
        blackMoves(x,y);
        }
        else whiteMoves(x,y);
    }
    }
    public void captureDown(int x, int y){
    int val = board[x][y];
    int a;
    for(a = x + 1; a <= 7 && board[a][y] == val * -1; a++){
        if(board[a][y] == 0){
        break;
        }
        
    }
    if(board[a][y] == val){
        for(int i = a - 1; i > x && board[i][y] == val * -1; i--){
        board[i][y] = val;
        if(val == 1){
            white++;
            black--;
        }
        else{
            white--;
            black++;
        }
        }
    }
    }
    public void captureUp(int x, int y){
    int val = board[x][y];
    int a;
    for(a = x - 1; a >= 0 && board[a][y] == val * -1; a--){
        if(board[a][y] == 0){
        break;
        }
        
    }
    if(board[a][y] == val){
        for(int i = a + 1; i < x && board[i][y] == val * -1; i++){
        board[i][y] = val;
        if(val == 1){
            white++;
            black--;
        }
        else{
            white--;
            black++;
        }
        }
    }
    }
    public void captureRight(int x, int y){
    int val = board[x][y];
    int a;
    for(a = y + 1; a <= 7 && board[x][a] == val * -1; a++){
        if(board[x][a] == 0){
        break;
        }
    }
    if(board[x][a] == val){
        for(int i = a - 1; i > x && board[x][i] == val * -1; i--){
        board[x][i] = val;
        if(val == 1){
            white++;
            black--;
        }
        else{
            white--;
            black++;
        }
        }
    }
    }
    public void captureLeft(int x, int y){
    int val = board[x][y];
    int a;
    for(a = y - 1; a >= 0 && board[x][a] == val * -1; a--){
        if(board[x][a] == 0){
        break;
        }
    }
    if(board[x][a] == val){
        for(int i = a + 1; i < y && board[x][i] == val * -1; i++){
        board[x][i] = val;
        if(val == 1){
            white++;
            black--;
        }
        else{
            white--;
            black++;
        }
        }
    }
    }
    public void captureDownAndRight(int x, int y){
    int val = board[x][y];
    int a;
    for(a = 1;a + y <= 7 && a + x <= 7 && board[x + a][y + a] == val * -1; a++){
        if(board[x + a][y + a] == 0){
        break;
        } 
    }
    if(board[x + a][y + a] == val){
        for(int i = a - 1;board[x + i][y + i] == val * -1; i--){
        board[x + i][y + i] = val;
        if(val == 1){
            white++;
            black--;
        }
        else{
            white--;
            black++;
        }
        }
    }
    }
    public void captureDownAndLeft(int x, int y){
    int val = board[x][y];
    int a;
    for(a = 1;y - a >= 0 && a + x <= 7 && board[x + a][y - a] == val * -1; a++){
        if(board[x + a][y - a] == 0){
        break;
        } 
    }
    if(board[x + a][y - a] == val){
        for(int i = a - 1;board[x + i][y - i] == val * -1; i--){
        board[x + i][y - i] = val;
        if(val == 1){
            white++;
            black--;
        }
        else{
            white--;
            black++;
        }
        }
    }
    }
    public void captureUpAndLeft(int x, int y){
    int val = board[x][y];
    int a;
    for(a = 1;y - a >= 0 && x - a >= 0 && board[x - a][y - a] == val * -1; a++){
        if(board[x - a][y - a] == 0){
        break;
        } 
    }
    if(board[x - a][y - a] == val){
        for(int i = a - 1;board[x - i][y - i] == val * -1; i--){
        board[x - i][y - i] = val;
        if(val == 1){
            white++;
            black--;
        }
        else{
            white--;
            black++;
        }
        }
    }
    }
    public void captureUpAndRight(int x, int y){
    int val = board[x][y];
    int a;
    for(a = 1;y + a <= 7 && x - a >= 0 && board[x - a][y + a] == val * -1; a++){
        if(board[x - a][y + a] == 0){
        break;
        } 
    }
    if(board[x - a][y + a] == val){
        for(int i = a - 1;board[x - i][y - i] == val * -1; i--){
        board[x - i][y + i] = val;
        if(val == 1){
            white++;
            black--;
        }
        else{
            white--;
            black++;
        }
        }
    }
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
        restartBoard("whites");
    }
    if(event.equals("restartboard2")){
        restartBoard("blacks");
    }
    if(event.substring(0,9).equals("capturing")){
        capture(Character.getNumericValue(event.charAt(9)), Character.getNumericValue(event.charAt(10)));
        //should we refresh hear? Do we just recall the constructor or whjbo at???
        Puzzle p = new Puzzle();
    }
    }
    public static void main(String[] args) {
    Puzzle p = new Puzzle();
    p.setVisible(true);
    }

}

//button.setBackground(Color.RED);
//button.setOpaque(true);
