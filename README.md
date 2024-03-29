Minesweeper

The objective of the game is to clear a minefield without detonating a land mine. The player is initially presented with a n*n grid of squares. Some randomly-selected squares, unknown to the player, are designated to contain mines.

On each turn, the player has to select a square (x,y)to indicate if it contains a mine (flag a mine) or if it is safe and does not have a mine (open a cell).
If the square containing a mine is opened, the player loses the game.
If it does not contain a mine, the square displays '0'.

The player uses this information to deduce the contents of other squares, and may either safely reveal each square or flag the square as containing a mine. The game is won when all mine-free squares are revealed, because all mines have been located.

Sample Input:

Enter the minefield layout : xxm,xmx,xxx

(This represents a 3*3 mine field with mines located in 0,2 and 1,1 locations. The program should then display the grid as shown below with all squares concealed.)

xxx
xxx
xxx

Enter option : o(0,0)

(this options specifies to open location 0,0. The program should then display the grid as shown below.)

0xx
xxx
xxx

Enter option : o(0,1)

(this options specifies to open location 0,1. The program should then display the grid as shown below. 0 is displayed in 0,1 since there are some mines adjacent to it in 0,2 and 1,1.)

00x
xxx
xxx

Enter option : f(0,2)

(this options specifies to flag location 0,2. The program should then display the grid as shown below.)
00f
xxx
xxx

Enter option : o(1,1)

(this options specifies to open location 1,1. Since there is a mine, the player loses. The output will be as shown below.)

00f
xmx
xxx

Oops, you stepped on a mine ! Game over !

If the player opens all the locations that do not have mines, the player wins the game. In such a case, the output will be as shown below.

00f
0f0
000

Wow, you cleared the minefield ! Game over !

Note that the player has to open all locations that do not contain a mine. If some squares are flagged but do not contain a mine, he still has to continue and open the squares that don't have mines. If he requires, he can open a location that has already been flagged.
