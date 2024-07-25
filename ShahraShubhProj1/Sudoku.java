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

 */

import java.util.Scanner;
public class Sudoku 
{
	static int [][] grid = new int[9][9];
	static int numOfzero=0;
	static Scanner input = new Scanner(System.in);	
	public static void main(String[] args) 
	{

		do 
		{
			readArray();				//calls read array to take the input of sudoku

			if(numOfzero<=3) 
			{
				solve();				//calls the solve method where the solution takes place	
			}

		}

		while(numOfzero<81); 			//if number of zeros are 81 than print "END"
		{
			System.out.println("END");
		}
	}


	static void readArray() 			//reads the array
	{
		numOfzero = 0;	
		for (int i = 0; i < 9; i++)   //loop for row
		{
			for (int j = 0; j < 9; j++) //loop for column
			{
				grid[i][j] = input.nextInt();				//array input

				if(grid[i][j]==0) 
				{
					numOfzero++;  //adds one to the number of zero is the input is zero
				}
			}
		}
	}




	static void solve()  //the method that contains the solution
	{
		while(numOfzero>0)
		{
			if(numOfzero==1) //type 1 problem where there is only one zero
			{
				int[] zero1 = type1ZeroPos(grid); // store the position of zero in zero1[]
				System.out.println("("+zero1[0]+","+zero1[1]+","+checkColumn(grid,zero1[1])+")");
				//print the output for type one here check column return the number than zero should replace in the sudoku 
				
			}
			if(numOfzero==2) //type 2 problem where there are two zeros
			{

				System.out.println(type2Output(grid));
			}


			if(numOfzero==3) //type 3 problem where there are three zeros
			{
				//outputStr to store the final output
				String outputStr = "";
				
				//store the location of all the three zeros in zeroLoc[]
				int[] zeroLoc = type3ZeroPos(grid); 
				
				//store a sudoku into newGrid[][] whose one of the number is replaced 
				//with the correct number making the sudoku type two problem stored in newGrid[][]
				int[][] newGrid =  theMissingNumberType3(grid); 
				
				/*
				 * In the for loop bellow the if statement checks weather the
				 * number at all the three location is not equal to zero in the neGrid which has a replaced number 
				 * and thus storing the output in the outputStr for the number which is already 
				 * solved by the method theMissingNumber()
				 */
				for(int i=0 ; i<6 ; i=i+2) 
				{
					if(newGrid[zeroLoc[i]][zeroLoc[i+1]] != 0) 
					{
						outputStr = ("("+zeroLoc[i]+","+zeroLoc[i+1]+","+newGrid[zeroLoc[i]][zeroLoc[i+1]]+") ");
					}
				}
				
				/*
				 * Adding outputStr with the String returned by the type2Output when the 
				 * newGrid is sent to it.
				 */
				outputStr += type2Output(newGrid);
				
				//prints outputStr that store the type three output
				System.out.println(outputStr);
				break;			
			}
			else
			{
				break;
			}
		}
	}
	
	/*
	 * to return a string value containing type two solution
	 */
	public static String type2Output(int[][] grid) {
		//store the location of all the two zeros in zero2[]
		int[] zero2 = type2ZeroPos(grid); 

		/*
		 * the if statement checks if the zeros are in same column
		 * or are in the same row and does the calculation accordingly
		 */
		if(zero2[0]==zero2[2] ) //if the zeros are in same row
		{
			int[] replacedValue = {checkColumn(grid,zero2[1]),checkColumn(grid,zero2[3])}; 	 
			return ("("+zero2[0]+","+zero2[1]+","+ replacedValue[0]+ ")"+
					" "+"("+zero2[2]+","+zero2[3]+","+ replacedValue[1]+ ")");
		}

		else //else the zeros are in same column
		{
			int[] replacedValue = {checkRow(grid,zero2[0]),checkRow(grid,zero2[2])}; 
			return ("("+zero2[0]+","+zero2[1]+","+ replacedValue[0]+ ")"+
					" "+"("+zero2[2]+","+zero2[3]+","+ replacedValue[1]+ ")");
		}

	}

	/*
	 * method used to return a 1-d Array containing the position of type one zero
	 */
	public static int[] type1ZeroPos(int[][] grid) {
		int[] pos=new int[2];	
		for (int i = 0; i < 9; i++) 
		{//start of i loop
			for (int j = 0; j < 9; j++) 
			{//start of j loop
				if(grid[i][j]==0) 
				{
					pos[0]=i;
					pos[1]=j;
				}//end of if
			}//end of j loop
		}//end of i loop
		return pos;
	}//end of type1

	/*
	 * method used to return a 1-d Array containing the position of type three zero
	 */
	public static int[] type3ZeroPos(int[][] grid) {
		int[] pos=new int[6];
		int k=0;
		while(k<6) 
		{
			for (int i = 0; i < 9; i++) 
			{//start of i loop
				for (int j = 0; j < 9; j++) 
				{//start of j loop	
					if(grid[i][j]==0) 
					{
						pos[k]=i;
						pos[k+1]=j;
						k+=2;
					}//end of if
				}//end of k loop
			}//end of j loop
		}//end of i loop
		return pos;
	}//end of type1

	/*
	 * method used to return a 1-d Array containing the position of type two zero
	 */
	public static int[] type2ZeroPos(int[][] grid) {
		int[] pos=new int[4];
		int k=0;
		while(k<3) 
		{
			for (int i = 0; i < 9; i++) 
			{//start of i loop
				for (int j = 0; j < 9; j++) 
				{//start of j loop	
					if(grid[i][j]==0) 
					{
						pos[k]=i;
						pos[k+1]=j;
						k+=2;
					}//end of if
				}//end of j loop
			}//end of i loop
		}//end of while loop
		return pos;
	}//end of type1

	//checked by column to find the replacement of zero
	public static int checkColumn(int[][] grid,int column) {
		int sum=0;  
		for (int i = 0; i < 9; i++) 
		{//start of i loop
			for (int j = 0; j < 9; j++) 
			{//start of j loop
				if(grid[i][column]==j+1) 
				{
					sum+=j+1;
					break;
				}//end of if 
			}//end of j loop
		}//end of i loop
		return 45-sum;
	}

	//checked by row to find the replacement of zero  
	public static int checkRow(int[][] grid,int row) {
		int sum=0;  
		for (int i = 0; i < 9; i++) 
		{//start of i loop
			for (int j = 0; j < 9; j++) 
			{//start of j loop
				if(grid[row][i]==j+1) 
				{
					sum+=j+1;
					break;
				}//end of if 
			}//end of j loop
		}//end of i loop
		return 45-sum;
	}

	/*
	 * this method convert a type 3 problem sudoku into a type 2 problem
	 * and returns a new 9x9 sudoku  
	 */
	public static int[][] theMissingNumberType3(int[][] grid) {
		int[] zeroLoc = type3ZeroPos(grid);
		int[][] newGrid = grid;
		for(int i=0 ; i<6 ; i=i+2) 
		{
			newGrid[zeroLoc[i]][zeroLoc[i+1]] =  countZeroInPerticularBox(grid,zeroLoc[i],zeroLoc[i+1]);
		}
		return newGrid;
	}
	/*
	 * this method takes a sudoku and the location of the zero (row and column) and 
	 * find that in which box the zero lies and then count the total number of zero
	 * present in than box 
	 * 
	 * if the box only has one zero than it adds up all the component of that box and 
	 * returns the number which replaces the zero
	 * 
	 * else if there are more than one zero in that box the method returns zero.
	 */
	public static int countZeroInPerticularBox(int[][] grid, int row, int column) {
		int RowBoxNumber = (row/3)*3; 			//store the row from where the box starts 
		int ColumnBoxNumber = (column/3)*3;  	//store the row from where the box starts
		int count = 0;							//count the number of zero in the particular box
		int sum=0;						//to store the sum of the box and subtract it from 45 to find the missing number

		for (int i = RowBoxNumber; i < RowBoxNumber + 3; i++) 
		{
			for (int j = ColumnBoxNumber; j < ColumnBoxNumber + 3; j++) 
			{
				if (grid[i][j] == 0) 
				{
					count++;
				}
			}
		}
		if(count == 1) {
			for (int i = RowBoxNumber; i < RowBoxNumber + 3; i++) 
			{
				for (int j = ColumnBoxNumber; j < ColumnBoxNumber + 3; j++) 
				{
					sum += grid[i][j] ;
				}
			}
			return 45-sum;
		}
		else 
		{
			return 0;
		}
	}

}//end of program