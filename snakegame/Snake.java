package practice.snakegame;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Snake {
	char[][] board;
	private Queue<Node> snake;;
	private Node food;
	
	
	Snake(int row,int col){
		board=new char[row][col];
		for(char[] c :board) {	
			Arrays.fill(c, '.');
		}
		snake=new LinkedList<>();
		snake.add(new Node(0,0));
		int foodRow=getRandomNum(row);
		int foodCol=getRandomNum(col);
		food=new Node(foodRow,foodCol);
		
		board[foodRow][foodCol]='0';
		
		
	}
	
	
	private void displayBoard() {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
					System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
	}


	public void move(int row,int col) {
		if(row<0 || row>=board.length || col<0 || col>= board[0].length || board[row][col]=='*') {
			System.out.println("Game Over !!!");
			System.exit(0);
		}
		snake.add(new Node(row,col));
		
		if(board[row][col]!='0') {
			Node node=snake.poll();
			int r = node.getRow();
            int c = node.getCol();
            board[r][c] = '.';
		}
		if(board[row][col]=='0') {
			int r=getRandomNum(board.length);
			int c=getRandomNum(board[0].length);
			board[r][c]='0';
		}
		moveAndPrint(row,col);
		if(! snake.isEmpty()) {
			 System.out.print("Enter a direction to move : ");
			 System.out.print("w --> up ");
			 System.out.print("s --> down");
			 System.out.print("d --> right");
			 System.out.print("a --> left ");
			 
             Scanner s = new Scanner(System.in);
             char direction = s.next().charAt(0);

             if (direction == 'w') {
                 move(--row, col);
             }
             if (direction == 's') {
            	 move(++row, col);
             }
             if (direction == 'd') {
            	 move(row, ++col);
             }
             if (direction == 'a') {
            	 move(row, --col);
             }
		}
	}


	private void moveAndPrint(int row,int col) {
		board[row][col]='*';
		displayBoard();
		
	}


	private int getRandomNum(int row) {
		Random r=new Random();
		return r.nextInt(row);
		
	}
 
}
