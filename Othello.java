public class Othello{
    public int[][] board = new int[8][8];
    public boolean[][] highlighter = new boolean[8][8];
    public int turn, white, black, counter, empty;
    public String first;
    public void endgame(){
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
    public Othello(){
	restartBoard("blacks");
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
    public void highlight(){
      	for(int a = 0; a <board.length;a++){
	    for(int b = 0; b < board[a].length;b++){
		highlighter[a][b] = false;
	    }
        }
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
			if (board[x][y] == 1){
			    check(x,y);
			}
		    }
		}
	    }
	}
	else{
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
			if (board[x][y] == 1){
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
    public boolean count(){
	for(int x = 0; x < 8;x++){
	    for(int y = 0; y < 8;y++){
		if(highlighter[x][y] == true){
		    return true;
		}
	    }
	}
	return false;
    }
    public void check(int x, int y){
	int val = board[x][y];
	if(x > 1 && board[x - 1][y] == val * -1){
	    checkUp(x,y);
	}
	if(x < 6 && board[x + 1][y] == val * -1){
	    checkDown(x,y);
	}
	if(y < 6 && board[x][y - 1] == val * -1){
	    checkLeft(x,y);
	}
	if(y > 1 && board[x][y + 1] == val * -1){
	    checkRight(x,y);
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
	if(board[a][y] == 0){
	    highlighter[a][y] = true;
      System.out.println('1');
	}
    }
    public void checkUp(int x, int y){
	int val = board[x][y];
	int a;
	for(a = x - 1; a >= 0 && board[a][y] == val * -1; a--){
	    if(board[a][y] == 0){
		break;
	    }
        
	}
	if(board[a][y] == 0){
	    highlighter[a][y] = true;
	}
    }
    public void checkRight(int x, int y){
	int val = board[x][y];
	int a;
	for(a = y + 1; a <= 7 && board[x][a] == val * -1; a++){
	    if(board[x][a] == 0){
		break;
	    }
	}
	if(board[x][a] == 0){
	    highlighter[x][a] = true;
	}
    }
    public void checkLeft(int x, int y){
	int val = board[x][y];
	int a;
	for(a = y - 1; a >= 0 && board[x][a] == val * -1; a--){
	    if(board[x][a] == 0){
		break;
	    }
	}
	if(board[x][a] == 0){
	    highlighter[x][a] = true;
	}
    }
    public void checkDownAndRight(int x, int y){
	int val = board[x][y];
	int a;
	for(a = 1;a + y <= 7 && a + x <= 7 && board[x + a][y + a] == val * -1; a++){
	    if(board[x + a][y + a] == 0){
		break;
	    } 
	}
	if(board[x + a][y +a] == 0){
	    highlighter[x + a][y + a] = true;
	}
    }
    public void checkDownAndLeft(int x, int y){
	int val = board[x][y];
	int a;
	for(a = 1;y - a >= 0 && a + x <= 7 && board[x + a][y - a] == val * -1; a++){
	    if(board[x + a][y - a] == 0){
		break;
	    } 
	}
	if(board[x + a][y +a] == 0){
	    highlighter[x + a][y - a] = true;
	}
    }
    public void checkUpAndLeft(int x, int y){
	int val = board[x][y];
	int a;
	for(a = 1;y - a >= 0 && x - a >= 0 && board[x - a][y - a] == val * -1; a++){
	    if(board[x - a][y - a] == 0){
		break;
	    } 
	}
	if(board[x + a][y + a] == 0){
	    highlighter[x - a][y - a] = true;
	}
    }
    public void checkUpAndRight(int x, int y){
	int val = board[x][y];
	int a;
	for(a = 1;y + a <= 7 && x - a >= 0 && board[x - a][y + a] == val * -1; a++){
	    if(board[x - a][y + a] == 0){
		break;
	    } 
	}
	if(board[x + a][y +a] == 0){
	    highlighter[x - a][y + a] = true;
	}
    }
    public void restartBoard(String a){
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
    
    public void blackMoves(int x,int y){
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
    public void whiteMoves(int x,int y){
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
    
    public void capture(int x, int y){
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
    public String toString(){
	String s = "";
	for(int x = 0;x < board.length; x ++){
	    for (int y = 0; y < board[x].length; y ++){
		s += highlighter[x][y];
		s +=" ";
	    }
	    s += "\n";
	}
	return s;
    }
    public static void main(String[] args) {
      Othello a = new Othello();
      System.out.println(a);
    }
}



