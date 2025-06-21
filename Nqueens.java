import java.util.*;
import java.lang.Math;

public class Nqueens extends Thread{

    static int count = 0;
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the board : ");
        int n = sc.nextInt();

        if(n<=0){
            System.out.println("ERROR : Invalid board size");
            System.exit(1);
        }

        boolean[][] board = new boolean[n][n];
        get(board,0);

        System.out.println("The total number of ways is : "+count);
        System.out.print("Program will exit in a moment...");
        try{        
            Thread.sleep(50000);
        }
        catch(Exception e){}

    }

    public static void get(boolean[][] board,int row){

        if(row == board.length){
            display(board);
            System.out.println();
            count++;
            return;
        }

        for(int i=0;i<board.length;i++){
            if(check(board,row,i)){
                board[row][i] = true;
                get(board,row+1);
                board[row][i] = false;
            }
        }
    
    }

    private static boolean check(boolean[][] board, int row, int col) {

        for(int i=0;i<board.length;i++){
            if(board[i][col] == true){
                return false;
            }
        }

        int lmin = Math.min(row,col),rmin = Math.min(row,board.length-col-1);

        int r = row,c = col;

        for(int j=0;j<lmin;j++){
            row--;
            col--;
            if(board[row][col]){
                return false;
            }
        }

        for(int j=0;j<rmin;j++){
            r--;
            c++;
            if(board[r][c]){
                return false;
            }
        }

        return true;
    }

    public static void display(boolean[][] board) {
            for(boolean[] tem : board){
                for(boolean temp : tem){
                    if(temp == true){
                        System.out.print("Q ");
                    }
                    else{
                        System.out.print("X ");
                    }
                }
                System.out.println();
            }
    }

}
