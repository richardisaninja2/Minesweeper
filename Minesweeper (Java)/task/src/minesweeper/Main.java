package minesweeper;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // write your code here
        minefield();
    }

    public static void minefield(){
        Random rand = new Random();



        int rows = 9;
        int columns = 9;
        String[][] array = new String[rows+1][columns+1];
        String field = ".";
        for(int i = 0; i<rows; i++){
            int randomNumber = rand.nextInt(9);

            for(int j = 0; j<columns; j++){
                array[i][j] = field;
                array[i][randomNumber] = "x";
            }
        }

        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                System.out.print(array[i][j] + "");
            }
            System.out.println();
        }
    }


}
