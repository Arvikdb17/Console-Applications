package practice.dungeongame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question3 {

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
		
		List<List<String>> res=new ArrayList<>();
		
		int hunterSteps= rec(hRow,hCol,gRow,gCol,board,0,new ArrayList<>(),res);
      
		System.out.println(hunterSteps);
		
		System.out.println(res.get(0).toString());
		
		
		

	}
	private static int rec(int hRow, int hCol, int gRow, int gCol,int[][] board, int steps,List<String> temp,List<List<String>> path) {

       if(hRow<0 || hCol<0 || hRow >=board.length || hCol>=board[0].length || board[hRow][hCol]==1) {
    	   return Integer.MAX_VALUE;
       }
       
       if(hRow==gRow && hCol==gCol) {
    	  if(path.size()==0 || path.get(0).size() >temp.size()) {
    		  path.clear();
    		  path.add(temp);
    	  }
    	  return steps;
       }
       
       board[hRow][hCol]=1;
       temp.add((hRow+1)+" "+(gCol+1));
       int left= rec(hRow,hCol-1,gRow,gCol,board,steps+1,temp,path);
       int right=rec(hRow,hCol+1,gRow,gCol,board,steps+1,temp,path);
       int up=rec(hRow-1,hCol,gRow,gCol,board,steps+1,temp,path);
       int down=rec(hRow+1,hCol,gRow,gCol,board,steps+1,temp,path);
       temp.remove(temp.size()-1);
       board[hRow][hCol]=0;
		
		return Math.min(Math.min(up, down),Math.min(left, right));
	}	

}
