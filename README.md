# APCS1-Final-Project
This is our first semester final project Othello is a board game that has been around for over a century. The object of the game is to have the majority of the pieces on the board when the last playable square has been filled.

How To Compile and Run Code:
First, compile Othello.java (javac Othello.java).
 First, compile Puzzle.java (javac Puzzle.java).

Then, run Puzzle.java (java Puzzle).

How to Use the Program: Players take turns placing disks on the board with their assigned color facing up. During a play, any disks of the opponent's color that are in a straight line and bounded by the disk just placed and another disk of the current player's color are turned over to the current player's color. At the beginning of your turn, there are highlighted spots, in yellow, of where you are allowed to play, making sure that you don't make invalid moves. The game ends when neither player can play a valid move, or there are no more spots left. The winner is the player with the most pieces on the board. There is a tie if both players have 32 pieces on the board.

Working Features:

We have two restart buttons that allow you to choose which color should go first.(Black goes first if no button is pressed) A turn is skipped if there is no possible move for a player. The game will end if a player captures all of his opponent's pieces. The game will also end when there is no more possible moves. We have a board that is comprised of buttons. Terminal will print out who wins when the game is over. We have a highlight feature that tells you which moves are available for you to choose from. Pressing on a nonhighlighted square should not do anything to the board. Pieces count and turn countis shown on the side. Unresolved Bugs/ not working features: When you resize your GUI, the GUI does not refresh itself. 
