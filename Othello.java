public class Othello{
    private int[][] board = new int[8][8];
    private int turns, whites, blacks, counter;
    public Othello{
	restartBoard();
    }
    private restartBoard(){
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
    private whiteMoves(int x,y){
	board[x][y] = 1;
	int a = x;
	int b = y;
	if(x > 1 && data[x - 1][y] == -1){
	    captureUp();
	}
	if(x < 6 && data[x + 1][y] == -1){
	    captureDown();
	}
	if(y > 1 && data[x][y - 1] == -1){
	    captureRight();
	}
	if(y < 6 && data[x][y + 1] == -1){
	    captureleft();
	}
	// diagonals
	if(x > 1 && y > 1 && data[x - 1][y - 1] == -1){
	    captureUpAndLeft();
	}
	if(x < 6 && y > 1 && data[x + 1][y - 1] == -1){
	    captureDownAndLeft();
	}
	if(x > 1 && y < 7 && data[x - 1][y + 1] == -1){
	    captureUpAndRight();
	}
	if(x < 6 && y < 7 && data[x + 1][y + 1] == -1){
	    captureDownAndRight();
	}

    }
}
