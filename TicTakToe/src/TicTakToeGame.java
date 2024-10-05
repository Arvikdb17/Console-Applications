import java.util.Arrays;
import java.util.Scanner;

public class TicTakToeGame {
     static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		startGame();
	}

	private static void startGame() {
		char[][] board=new char[3][3];
		for(char[] c:board) {
			Arrays.fill(c, '.');
		}
		boolean player1=true;
		
		runGame(board,player1);
		
	}

	private static void runGame(char[][] board, boolean player1) {
		displayBoard(board);
		
		int row=-1;
		int col=-1;
		
		   while(true) {
			   String player=player1==true ? "Player1 (X)" :"Player2 (O)";
			     System.out.println(player+", enter your move (row  column): ");
				 row=sc.nextInt();
			     col=sc.nextInt();
			     if(validRowCol(board,row,col)) {
			    	 if(board[row][col]=='.') {
				    	 fillBoard(row,col,board,player1);
				    	 checkWinner(board,player1,row,col);
				    	 checkDraw(board);
				    	 player1=player1==true?false:true;
				    	 displayBoard(board);
				     }
			     }
			     else {
			    	 System.err.println("Invalid move please try again..");
			     }
			     
		   }
		
	}

	

	private static boolean validRowCol(char[][] board, int row, int col) {
		
		if(row > 2 || row < 0 || col<0 || col>2 || board[row][col] !='.') return false;
		
		return true;
	}

	private static void checkDraw(char[][] board) {
		char d='D';
		for(char[] c:board ) {
			for(char ch : c) {
				if(ch=='.') {
					d=ch;
				}
			}		
		}
		
		if(d=='D') {
			displayBoard(board);
			System.out.println("Game draw...");
			System.exit(0);
		}
	}

	private static void checkWinner(char[][] board, boolean player1,int row,int col) {
		char c=player1==true ? 'X' : 'O';
		
		 if(checkForRows(board, row, c)) {
			 displayBoard(board);
			 String player=player1==true? "Player1" :"Player2";
			 System.out.println(player + " wins");
			 System.exit(0);
		 }
		
		 if(checkForCols(board,col,c)) {
			 displayBoard(board);
			 String player=player1==true? "Player1" :"Player2";
			 System.out.println(player + " wins");
			 System.exit(0);
		 }
		
		 if(row==col || (row==0 && col==2) || (row==2 && col==0)) {
			 if(checkForDiagonals(board,row,col,c)) {
				 displayBoard(board);
				 String player=player1==true? "Player1" :"Player2";
				 System.out.println(player + " wins");
				 System.exit(0);
			 }
		 }
		    
		 
	}

	private static boolean checkForDiagonals(char[][] board, int row, int col, char c) {
		//check for diagonals:
		
		if(board[0][0]==c && board[1][1]==c && board[2][2]==c) return true;
		if(board[0][2]==c && board[1][1]== c && board[2][0]==c) return true;
		
		return false;
		
	}

	private static boolean checkForRows(char[][] board, int row, char c) {
		//for rows:
		for(int i=0;i<board[0].length;i++) {
			if(board[row][i] !=c)
				return false;
		}
		return true;
	}
	private static boolean checkForCols(char[][] board, int col, char c) {
		//for cols:
		for(int i=0;i<board[0].length;i++) {
			if(board[i][col] !=c)
				return false;
		}
		return true;
	}
	
	
	

	private static void fillBoard(int row, int col, char[][] board, boolean player1) {
		board[row][col]=player1==true? 'X' : 'O';
		
	}

	private static void displayBoard(char[][] board) {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
