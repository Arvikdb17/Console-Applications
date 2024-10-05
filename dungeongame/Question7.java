package practice.dungeongame;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Question7 {

	public static void main(String[] args) {
		System.out.println("****** Welcome to Dungeon game ******");
	    Scanner sc=new Scanner(System.in);
		System.out.println("Enter total number of rows");
		int rows=sc.nextInt();
		System.out.println("Enter total number of columns");
		int cols=sc.nextInt();
		
		int[][] board=new int[rows][cols];
		
		System.out.println("Enter row of gold");
		int gRow=sc.nextInt()-1;
		System.out.println("Enter col of gold");
		int gCol=sc.nextInt()-1;
		
		System.out.println("Enter row of hunter");
		int hRow=sc.nextInt()-1;
		System.out.println("Enter col of hunter");
		int hCol=sc.nextInt()-1;
		
		System.out.println("Enter row of monster");
		int mRow=sc.nextInt()-1;
		System.out.println("Enter col of monster");
		int mCol=sc.nextInt()-1;
		
		System.out.println("Enter row of trigger");
		int tRow=sc.nextInt()-1;
		System.out.println("Enter col of trigger");
		int tCol=sc.nextInt()-1;
		
		System.out.println("Enter no. of pits");
		int noOfPits=sc.nextInt();
		Set<String> pits=new HashSet<>();
		
		while(noOfPits-->0) {
			System.out.println("Enter row of pit");
			int pRow=sc.nextInt()-1;
			System.out.println("Enter col of pit");
			int pCol=sc.nextInt()-1;
			pits.add(pRow+" "+pCol);
		}
		int hunterSteps=rec(hRow,hCol,gRow,gCol,board,0,pits);
		int monsterSteps=rec(mRow,mCol,gRow,gCol,board,0);
		
		if(hunterSteps<monsterSteps) {
			System.out.println("Hunter will reach in "+hunterSteps+" steps");
		}
		else {
			int stepsToTrigger=rec(hRow,hCol,tRow,tCol,board,0,pits);
			int stepsFromTrigger=rec(tRow,tCol,gRow,gCol,board,0,pits);
			System.out.println("Hunter will reach in "+(stepsToTrigger+stepsFromTrigger)+" steps by activating trigger");
		}

	}
	
	private static int rec(int hRow, int hCol, int gRow, int gCol,int[][] board, int steps,Set<String> pits) {

	       if(hRow<0 || hCol<0 || hRow >=board.length || hCol>=board[0].length || board[hRow][hCol]==1 || pits.contains(hRow+" "+hCol)) {
	    	   return Integer.MAX_VALUE;
	       }
	       
	       if(hRow==gRow && hCol==gCol) {
	    	   return steps;
	       }
	       
	       board[hRow][hCol]=1;
	       int left= rec(hRow,hCol-1,gRow,gCol,board,steps+1,pits);
	       int right=rec(hRow,hCol+1,gRow,gCol,board,steps+1,pits);
	       int up=rec(hRow-1,hCol,gRow,gCol,board,steps+1,pits);
	       int down=rec(hRow+1,hCol,gRow,gCol,board,steps+1,pits);
	       board[hRow][hCol]=0;
			
			return Math.min(Math.min(up, down),Math.min(left, right));
		}
	
	private static int rec(int hRow, int hCol, int gRow, int gCol,int[][] board, int steps) {

	       if(hRow<0 || hCol<0 || hRow >=board.length || hCol>=board[0].length || board[hRow][hCol]==1) {
	    	   return Integer.MAX_VALUE;
	       }
	       
	       if(hRow==gRow && hCol==gCol) {
	    	   return steps;
	       }
	       
	       board[hRow][hCol]=1;
	       int left= rec(hRow,hCol-1,gRow,gCol,board,steps+1);
	       int right=rec(hRow,hCol+1,gRow,gCol,board,steps+1);
	       int up=rec(hRow-1,hCol,gRow,gCol,board,steps+1);
	       int down=rec(hRow+1,hCol,gRow,gCol,board,steps+1);
	       board[hRow][hCol]=0;
			
			return Math.min(Math.min(up, down),Math.min(left, right));
		}	

}
