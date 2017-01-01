public class Othello{
    private int[][] board = new int[8][8];
    private int turns, whites, blacks, counter;
    public Othello(){
	restartBoard();
    }
    private void restartBoard(){
	turns = 1;
	whites = 2;
	blacks = 2;
	counter = 0;
	for(int x = 0; x <board.length;x++){
	    for(int y = 0; x < board[x].length;y++){
		board[x][y] = 0;
	    }
	}
	board[3][3] = -1;
	board[3][4] = 1;
	board[4][3] = 1;
	board[4][4] = -1;
    }
    private void whiteMoves(int x,int y){
	board[x][y] = 1;
	if(x > 1 && board[x - 1][y] == -1){
	    captureUp(x,y);
	}
	if(x < 6 && board[x + 1][y] == -1){
	    captureDown(x,y);
	}
	if(y > 1 && board[x][y - 1] == -1){
	    captureRight(x,y);
	}
	if(y < 6 && board[x][y + 1] == -1){
	    captureLeft(x,y);
	}
	// diagonals
	if(x > 1 && y > 1 && board[x - 1][y - 1] == -1){
	    captureUpAndLeft(x,y);
	}
	if(x < 6 && y > 1 && board[x + 1][y - 1] == -1){
	    captureDownAndLeft(x,y);
	}
	if(x > 1 && y < 7 && board[x - 1][y + 1] == -1){
	    captureUpAndRight(x,y);
	}
	if(x < 6 && y < 7 && board[x + 1][y + 1] == -1){
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
	    for(int i = a; i > x && board[i][y] == val * -1; i--){
		board[i][y] = val* -1;
	    }
	}
    }
    public void captureUp(int x, int y){
	int val = board[x][y];
	int a;
        for(a = x + 1; a >= 0 && board[a][y] == val * -1; a--){
	    if(board[a][y] == 0){
		break;
	    }
	    
	}
	if(board[a][y] == val){
	    for(int i = a; i < x && board[i][y] == val * -1; i++){
		board[i][y] = val* -1;
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
	    for(int i = a; i > x && board[x][i] == val * -1; i--){
		board[x][i] = val* -1;
	    }
	}
    }
    public void captureLeft(int x, int y){
	int val = board[x][y];
	int a;
        for(a = y + 1; a >= 0 && board[x][a] == val * -1; a--){
	    if(board[x][a] == 0){
		break;
	    }
	    
	}
	if(board[x][a] == val){
	    for(int i = a; i < x && board[x][i] == val * -1; i++){
		board[x][i] = val* -1;
	    }
	}
    }
}
    
