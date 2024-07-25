/*
Sudoku Solver

This is a program in Java that reads in a Sudoku grid and attempts to solve it.
The program implements different techniques depending on the number of empty cells in the grid.

The program first reads in the input grid and counts the number of empty cells.
If the number of empty cells is less than or equal to 3, the program tries to solve the grid using a specific technique.
Otherwise, the program terminates.

Techniques Used
Type 1
This technique is used when there is only one empty cell in the grid.
The program finds the row and column of the empty cell and tries to fill it with a valid number.

Type 2
This technique is used when there are two empty cells in the grid, which are in the same row or column.
The program finds the row and column of the empty cells and tries to fill them with valid numbers.

Type 3
This technique is used when there are three empty cells in the grid.
The program finds the rows and columns of the empty cells and tries to fill them with valid numbers.
The program then generates a new grid by filling in the missing number and tries to solve the new grid using Type 2.

The program ends when the input is all zeros 

Example Run
7 2 4 8 6 5 1 3 9 
5 1 9 2 4 3 8 7 6 
3 0 6 7 9 1 5 4 2 
1 7 8 6 2 9 4 5 3 
9 4 3 1 5 8 2 6 7 
6 5 2 3 7 4 9 1 8 
2 3 1 5 8 6 7 9 4 
8 9 5 4 3 7 6 2 1 
4 6 7 9 1 2 3 8 5 
7 2 4 8 6 5 1 3 9 
5 1 9 2 4 3 8 7 6 
3 8 6 7 9 1 5 4 2 
1 7 8 6 2 9 4 0 3 
9 4 3 1 5 8 2 0 7 
6 5 2 3 7 4 9 1 8 
2 3 1 5 8 6 7 9 4 
8 9 5 4 3 7 6 2 1 
4 6 7 9 1 2 3 8 5 
7 2 4 8 6 5 1 3 9 
5 1 9 2 4 3 8 7 6 
3 8 6 7 9 1 5 4 2 
1 7 8 6 2 9 4 5 3 
9 4 3 1 5 8 2 6 7 
6 5 2 3 7 4 0 0 8 
2 3 1 5 8 6 7 0 4 
8 9 5 4 3 7 6 2 1 
4 6 7 9 1 2 3 8 5 
0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 

(2,1,8) 				//This shows that in the first board, the value 8 
 						//was missing at row 2, column 1 
(3,7,5) (4,7,6) 		//This shows that in the second board, the value 5 
 						//was missing from row 3, column 7 and the value 6 
 						//was missing from row 4, column 7 
(6,7,9) (5,6,9) (5,7,1) //This shows that in the third board, the value 9 
 						//was missing from row 6, column 7, and the value 9 
 						//was missing from row 5, column 6, and the value 1 
 						//was missing from row 5, column 7 
 END 					//This message WILL be printed when a board of all 
 						//zeros is entered. 
 
 Date : 3/11/2023
 Name : Shubh Shahra
