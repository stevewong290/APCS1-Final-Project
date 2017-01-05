javac public class Othello{
    private int[][] board = new int[8][8];
    private int[][] highlighter = new int[8][8];
    private int turns, whites, blacks, counter, empty;
    //private String first;
    public Othello(){
	restartBoard();
    }
    /* private void turn(){
       if (first == black){
       }
       else{
       }
       }*/
    private void highlight(){
	if(first =="black"){
	    if(turn % 2 == 1){
		for(int x = 0; x < 8; x++){
		    for(int y = 0: y < 8; y++){
			if (board[x][y] == -1){
			    check(x,y);
			}
		    }
		}
	    }
	    else{
		for(int x = 0; x < 8; x++){
		    for(int y = 0: y < 8; y++){
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
		    for(int y = 0: y < 8; y++){
			if (board[x][y] == -1){
			    check(x,y);
			}
		    }
		}
	    }
	    else{
		for(int x = 0; x < 8; x++){
		    for(int y = 0: y < 8; y++){
			if (board[x][y] == -1){
			    check(x,y);
			}
		    }
		}
	    }
	}
    }
    private check(int x, int y){
	
    }
    private void restartBoard(){
	turns = 1;
	whites = 2;
	blacks = 2;
	counter = 0;
	for(int x = 0; x <board.length;x++){
	    for(int y = 0; y < board[x].length;y++){
		board[x][y] = 0;
	    }
	}
	board[3][3] = -1;
	board[3][4] = 1;
	board[4][3] = 1;
	board[4][4] = -1;
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
	    }
	}
    }
    public String toString(){
	String s = "";
	for(int x = 0;x < board.length; x ++){
	    for (int y = 0; y < board[x].length; y ++){
		s += board[x][y];
		s +=" ";
	    }
	    s += "\n";
	}
	return s;
    }
    public static void main(String[] args){
	Othello a = new Othello();
	a.whiteMoves(4,5);
	a.blackMoves(5,5);
	System.out.println(a);
    }
}public class Othello{
    private int[][] board = new int[8][8];
    private int turns, whites, blacks, counter;
    //private String first;
    public Othello(){
	restartBoard();
    }
    /* private void turn(){
       if (first == black){
       }
       else{
       }
       }*/
    private void endGame(){
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
    private void restartBoard(){
	turns = 1;
	whites = 2;
	blacks = 2;
	empty = 60;
	counter = 0;
	for(int x = 0; x <board.length;x++){
	    for(int y = 0; y < board[x].length;y++){
		board[x][y] = 0;
	    }
	}
	board[3][3] = -1;
	board[3][4] = 1;
	board[4][3] = 1;
	board[4][4] = -1;
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
    }
    public void captureDown(int x, int y){
	int val = board[x][y];
	int a;
	empty--;
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
	    <<<<<<< HEAD
		for(int i = a + 1; i < y && board[x][i] == val * -1; i++){
		    =======
		    for(int i = a + 1; i < x && board[x][i] == val * -1; i++){
			>>>>>>> d9dc592bcab941393d3cc0bbaa1d743912c75947
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
	public String toString(){
	    String s = "";
	    for(int x = 0;x < board.length; x ++){
		for (int y = 0; y < board[x].length; y ++){
		    s += board[x][y];
		    s +=" ";
		}
		s += "\n";
	    }
	    return s;
	}
	public static void main(String[] args){
	    Othello a = new Othello();
	    a.whiteMoves(4,5);
	    a.blackMoves(5,5);
	    System.out.println(a);
	}
    }
    
