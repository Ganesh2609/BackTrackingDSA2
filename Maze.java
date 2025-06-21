import java.util.*;

public class Maze extends Thread{

        static int count=0;

        static void calculate(int a,int b,boolean[][] array,String output,int x,int y,int[][] path,int step){

            int c=x,d=y;
            boolean[][] temp = array;

            if(c==(a-1) && d==(b-1)){
                System.out.println("Path "+(count+1)+" :");
                for(int[] arr : path  ){
                    System.out.println(Arrays.toString(arr));
                }
                System.out.println("Path : "+output+"\n");
                count++;
                return;
            }

            if(c<a-1){
                c++;
                if(array[c][d] != false){
                    array[c][d] = false;
                    path[c][d] = step;
                    calculate(a,b,array,output+"D",c,d,path,step+1);
                    path[c][d] = 0;
                    array[c][d] = true;
                }
            }

            c=x;
            d=y;

            if(d<b-1){
                d++;
                if(array[c][d] != false){
                    array[c][d] = false;
                    path[c][d] = step;
                    calculate(a,b,array,output+"R",c,d,path,step+1);
                    path[c][d] = 0;
                    array[c][d] = true;
                }
            }

            c=x;
            d=y;

            if(d>0){
                d--;
                if(array[c][d] == true){
                    array[c][d] = false;
                    path[c][d] = step;
                    calculate(a,b,array,output+"L",c,d,path,step+1);
                    path[c][d] = 0;
                    array[c][d] = true;
                }
            }

            c=x;
            d=y;

            if(c>0){
                c--;
                if(array[c][d] == true){
                    array[c][d] = false;
                    path[c][d] = step;
                    calculate(a,b,array,output+"U",c,d,path,step+1);
                    path[c][d] = 0;
                    array[c][d] = true;
                } 
            }

        }
        public static void main(String args[]){
    
            Scanner sc = new Scanner(System.in);
    
            System.out.print("Enter the size (example : '<x><space><y>' where x and y are the row size and column size respectively): ");
            int a,b;
    
            a=sc.nextInt();
            b=sc.nextInt();

            if(a<=0 || b<=0){
                System.out.println("Please enter the correct size. Values lesser than 0 are undefined for this purpose.");
                System.exit(1);
            }
    
            boolean[][] array = new boolean[a][b];

            for(int i=0;i<a;i++){
                for(int j=0;j<b;j++){
                    array[i][j] = true;
                }
            }

            array[0][0] = false;
            int[][] path= new int[a][b];
            path[0][0] = 1;

            System.out.println("\nThe paths are : \n");
            calculate(a,b,array,"",0,0,path,2);
    
            System.out.println("\nThe total number of ways are : "+count);
            System.out.print("Program will exit in a moment...");
            try{        
                Thread.sleep(50000);
            }
            catch(Exception e){}
        }
}
