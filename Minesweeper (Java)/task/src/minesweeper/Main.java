package minesweeper;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        numberOfMinesQuestion();
    }

    public static void numberOfMinesQuestion(){
        System.out.println("How many mines do you want on the field?");
        Scanner scanner = new Scanner(System.in);
        minefield(scanner.nextInt());
    }

    public static void minefield(int count){
        Random rand = new Random();

        int rows = 9;
        int columns = 9;
        String[][] array = new String[rows+1][columns+1];
        int numberOfMines = 0;
        String field = ".";
        for(int i = 0; i<rows; i++){
            int randomNumber = rand.nextInt(9);
            for(int j = 0; j<columns; j++){
                //populate the board with field characters "."
                array[i][j] = field;
            }
        }


        while(numberOfMines < count){
            //while numberOfMines is less than count keep calling the addAnX method
            numberOfMines = addAnX(array, rows, columns, count, numberOfMines);
        }

        //calls method to display the board
        displayBoards(rows, columns, array);

    }

    public static void displayBoards(int rows, int columns, String[][] array){
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                System.out.print(array[i][j] + "");
            }
            System.out.println();
        }
    }

    public static int addAnX(String[][] array, int rows, int columns, int count, int numberOfMines){
        //random number boaunded by 9
        Random rand = new Random();

        for(int i = 0; i<rows; i++){
            int randomNumber = rand.nextInt(9);
            for(int j  = 0; j<columns; j++){
                if(numberOfMines < count){
                    //while number oif mines is less than count
                    if(array[i][randomNumber].equals(".")){
                        //if position on board equals .
                        //place an X for mine
                        array[i][randomNumber] = "X";
                        //add 1 to the number of mines
                        numberOfMines += 1;

                    }


                }
            }
        }
        return numberOfMines;
    }


}
