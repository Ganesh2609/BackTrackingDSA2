import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

import java.util.*;

public class Sudoku extends Thread{

    static int i=0,j=0;
    static int[][] array = new int[9][9];
    public static final int OPTIONS = 81;
    public List<JTextField> textfields = new ArrayList<>(OPTIONS);

    private JPanel panel;

    public static void main(String[] args) {
        createAndShowGUI();

        int k,l;
        System.out.println("Your puzzle is : ");
        for(k=0;k<9;k++){
            for(l=0;l<9;l++){
                if(array[k][l] != 0){
                System.out.print(array[k][l] + " ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.out.println(); 
        } 

        for(int i=0 ; i<9 ; i++){
            for(int j=0;j<9;j++){
                int value = array[i][j];
                array[i][j] = 0;
                if(value==0){
                    continue;
                }
                if(!(check(array,i,j,value))){
                    System.out.println("ERROR : Please re-enter the puzzle correctly");
                    try{
                    Thread.sleep(5000);
                    }
                    catch(Exception e){}
                    System.exit(1);
                }
                array[i][j] = value;
            }
        }
        
        solve(array,0,0);

        System.out.println("ERROR : Cannot solve the puzzle, please check the values given.");

    }

    public Sudoku(){
        panel = new JPanel();
        panel.setLayout(new GridLayout(9,9,-10,6));
        for(int i =0;i< OPTIONS;i++){
            JTextField textfield = new JTextField(2);
            textfields.add(textfield);
            panel.add(new JLabel());
            panel.add(textfield);
        }
    }

    public static void createAndShowGUI() {
          Sudoku example = new Sudoku();
          int result = JOptionPane.showConfirmDialog(null, example.panel, 
                   "ENTER THE SUDOKU PUZZLE", JOptionPane.OK_CANCEL_OPTION);
          if (result == JOptionPane.OK_OPTION) {
            i=0;
            j=0;
             for(JTextField textfield : example.textfields){
                
                if(textfield.getText().length() == 0){
                    array[i][j] = 0;
                }
                else{
                    int a1,a2,a3,a4,a5,a6,a7,a8,a9;
                    String temp = textfield.getText();

                    a1 = temp.compareTo("1");
                    a2 = temp.compareTo("2");
                    a3 = temp.compareTo("3");
                    a4 = temp.compareTo("4");
                    a5 = temp.compareTo("5");
                    a6 = temp.compareTo("6");
                    a7 = temp.compareTo("7");
                    a8 = temp.compareTo("8");
                    a9 = temp.compareTo("9");

                    if(a1 != 0 && a2 != 0 && a3 != 0 && a4 != 0 && a5 != 0 && a6 != 0 && a7 != 0 && a8 != 0 && a9 != 0  ){
                        System.out.println("ERROR : Enter the correct integer values between 1 and 9");
                        System.exit(0);
                    }
                    else{
                        array[i][j] = Integer.parseInt(temp);
                    } 
                }

                if(j<8){
                    j++;
                }
                else{
                    i++;
                    j=0;
                }
             }

          }
    }

    public static void solve(int[][] board, int a, int b) {
        
        int i,j,k=0;

        for(i=0;i<9;i++){
            for(j=0;j<9;j++){
                if(board[i][j] != 0){
                    k++;
                }
            }
        }

        if(k==81){
            System.out.println("\nThe solution is : ");
            for(int[] row : board){
                System.out.println(Arrays.toString(row));
            }
            System.out.println("This program will exit in a moment...");
            try{
            Thread.sleep(50000);
            }
            catch(Exception e){}
            System.exit(0);
        }

        if(board[a][b] != 0){
            if(b<8){
                solve(board,a,b+1);
                return;
            }
            else{
                solve(board,a+1,0);
                return;
            }
        }

        if(board[a][b] == 0){
            for(i=1;i<=9;i++){
                if(check(board,a,b,i)){
                    board[a][b] = i;
                    if(b<8){
                        solve(board,a,b+1);
                    }
                    else{
                        solve(board,a+1,0);
                    }
                    board[a][b] = 0;
                }
            }
        }

    }

    public static boolean check(int[][] board, int a, int b, int val) {
        
        int i,j;
        for(i=0;i<9;i++){
            if(board[a][i] == val || board[i][b] == val){
                return false;
            }
        }

        int c= (a/3) + 1;
        int d = (b/3) + 1;

        for(i=(c-1)*3 ; i< c*3 ;i++){
            for(j=(d-1)*3 ; j<d*3 ;j++){
                if(board[i][j] == val){
                    return false;
                }
            }
        }
        
        return true;
    }

}

