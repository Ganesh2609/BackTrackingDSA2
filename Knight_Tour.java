import java.util.*;

public class Knight_Tour extends Thread{
    public static int count=0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the board : ");
        int n = sc.nextInt();

        if(n<=0){
            System.out.println("ERROR : Invalid board size");
            System.exit(1);
        }

        int[][] board = new int[n][n];
        
        solve(board,0,0,1);

        System.out.println("The total number of knight tours are : "+count);
        System.out.print("Program will exit in a moment...");
        try{        
            Thread.sleep(50000);
        }
        catch(Exception e){}
        
    }

    public static void solve(int[][] board, int a, int b,int step) {

        int n=board.length;
        int[][] values = {{2,2,1,1,-2,-2,-1,-1},{1,-1,2,-2,1,-1,2,-2}};
 
        board[a][b] = step;

        if(step>=n*n){
            board[a][b] = step;
            System.out.println("The way "+(count+1)+" is : ");
            display(board);
            System.out.println();
            count++;
        }

        for(int i=0;i<8;i++){
            int a1 = a+values[0][i];
            int b1 = b+values[1][i];

            if(a1<board.length && a1>=0 && b1<board.length && b1>=0 && board[a1][b1] == 0){
                solve(board,a1,b1,step+1);
            }
        }

        board[a][b] = 0;

    }

    public static void display(int[][] board){

        for(int[] row : board){
            System.out.println(Arrays.toString(row));
        }
    }


}
