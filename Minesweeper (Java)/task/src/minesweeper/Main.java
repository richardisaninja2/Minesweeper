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

        cornerCheckSurrounding(array);
        checkSide(array);
        checkMiddle(array);
        //calls method to display the board
        displayBoards(rows, columns, array);

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
    public static int checkTop(String[][] array, int i, int j){
        int numberOfBombsAround = 0;
        try {
            //top
            if (!array[i][j].equals("X") && array[i - 1][j].equals("X")) {

                numberOfBombsAround += 1;
            }
//            if(numberOfBombsAround > 0){
//                array[i][j] = String.valueOf(numberOfBombsAround);
//
//            }
        }
        catch(Exception e){
            //below
            if(!array[i][j].equals("X") && array[i+1][j].equals("X")){


            }
//            if(numberOfBombsAround > 0){
//                array[i][j] = String.valueOf(numberOfBombsAround);
//
//            }
        }
        return numberOfBombsAround;
    }
    public static int checkBottom(String[][] array, int i, int j ){
        int numberOfBombsAround = 0;
        try {
            //bottom
                if(!array[i][j].equals("X") && array[i+1][j].equals("X")){

                    numberOfBombsAround +=1;
                }
//                if(numberOfBombsAround > 0){
//                    array[i][j] = String.valueOf(numberOfBombsAround);
//
//                }
        }
        catch(Exception e){
            //below
            if(!array[i][j].equals("X") && array[i-1][j].equals("X")){


            }
//            if(numberOfBombsAround > 0){
//                array[i][j] = String.valueOf(numberOfBombsAround);
//
//            }
        }
        return numberOfBombsAround;
    }
    public static int checkLeft(String[][] array, int i, int j){
        int numberOfBombsAround = 0;
        try {
            //bottom
            if(!array[i][j].equals("X") && array[i][j-1].equals("X")){

                numberOfBombsAround +=1;
            }
//            if(numberOfBombsAround > 0){
//                array[i][j] = String.valueOf(numberOfBombsAround);
//
//            }
        }
        catch(Exception e){

            //right
            if(!array[i][j].equals("X") && array[i][j+1].equals("X")){


            }
//            if(numberOfBombsAround > 0){
//                array[i][j] = String.valueOf(numberOfBombsAround);
//
//            }
        }
        return numberOfBombsAround;
    }
    public static int checkRight(String[][] array, int i, int j){
        int numberOfBombsAround = 0;
        try {
            //bottom
            if(!array[i][j].equals("X") && array[i][j+1].equals("X")){

                numberOfBombsAround +=1;
            }
//            if(numberOfBombsAround > 0){
//                array[i][j] = String.valueOf(numberOfBombsAround);
//
//            }
        }
        catch(Exception e){

            //right
            if(!array[i][j].equals("X") && array[i][j-1].equals("X")){


            }
//            if(numberOfBombsAround > 0){
//                array[i][j] = String.valueOf(numberOfBombsAround);
//
//            }
        }
        return numberOfBombsAround;
    }
    public static int checkRightTop(String[][] array, int i, int j){
        int numberOfBombsAround = 0;
        try {
            //RightTop
            if(!array[i][j].equals("X") && array[i-1][j+1].equals("X")){

                numberOfBombsAround +=1;
            }
//            if(numberOfBombsAround > 0){
//                array[i][j] = String.valueOf(numberOfBombsAround);
//
//            }
        }
        catch(Exception e){

            //rightTop
            if(!array[i][j].equals("X") && array[i+1][j-1].equals("X")){


            }
//            if(numberOfBombsAround > 0){
//                array[i][j] = String.valueOf(numberOfBombsAround);
//
//            }
        }
        return numberOfBombsAround;
    }
    public static int checkRighBottom(String[][] array, int i, int j){
        int numberOfBombsAround = 0;
        try {
            //RightTop
            if(!array[i][j].equals("X") && array[i+1][j+1].equals("X")){

                numberOfBombsAround +=1;
            }
//            if(numberOfBombsAround > 0){
//                array[i][j] = String.valueOf(numberOfBombsAround);
//
//            }
        }
        catch(Exception e){

            //rightTop
            if(!array[i][j].equals("X") && array[i-1][j+1].equals("X")){


            }
//            if(numberOfBombsAround > 0){
//                array[i][j] = String.valueOf(numberOfBombsAround);
//
//            }
        }
        return numberOfBombsAround;
    }
    public static int checkLeftBottom(String[][] array, int i, int j){
        int numberOfBombsAround = 0;
        try {
            //RightTop
            if(!array[i][j].equals("X") && array[i+1][j-1].equals("X")){

                numberOfBombsAround +=1;
            }
//            if(numberOfBombsAround > 0){
//                array[i][j] = String.valueOf(numberOfBombsAround);
//
//            }
        }
        catch(Exception e){

            //rightTop
            if(!array[i][j].equals("X") && array[i-1][j+1].equals("X")){


            }
//            if(numberOfBombsAround > 0){
//                array[i][j] = String.valueOf(numberOfBombsAround);
//
//            }
        }
        return numberOfBombsAround;
    }
    public static int checkLefTop(String[][] array, int i, int j){
        int numberOfBombsAround = 0;
        try {
            //RightTop
            if(!array[i][j].equals("X") && array[i-1][j-1].equals("X")){

                numberOfBombsAround +=1;
            }
//            if(numberOfBombsAround > 0){
//                array[i][j] = String.valueOf(numberOfBombsAround);
//
//            }
        }
        catch(Exception e){

            //rightTop
            if(!array[i][j].equals("X") && array[i+1][j+1].equals("X")){

//                numberOfBombsAround +=1;
            }
//            if(numberOfBombsAround > 0){
//                array[i][j] = String.valueOf(numberOfBombsAround);
//
//            }
        }
        return numberOfBombsAround;
    }

    public static void checkSide(String[][] array) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int numberOfBombsAround = 0;
                if (i == 0) {
                    try {
                        numberOfBombsAround = checkBottom(array, i, j) + checkLeftBottom(array, i, j) + checkRighBottom(array, i, j) + checkLeft(array, i, j) + checkRight(array, i, j);

                        if (numberOfBombsAround > 0) {
                            array[i][j] = String.valueOf(numberOfBombsAround);
                        }
                    } catch (Exception e) {

                    }
                }
                try {
                    //left wall
                    if (j == 0) {
                        numberOfBombsAround = checkTop(array, i, j)+ checkRightTop(array, i, j)+checkRight(array, i, j)+checkRighBottom(array, i, j)+ checkBottom(array, i, j);
                    }
                    if (numberOfBombsAround > 0) {
                        array[i][j] = String.valueOf(numberOfBombsAround);
                    }
                } catch (Exception e) {

                }


                try {
                    //right wall
                    if (j == 8) {
                        numberOfBombsAround = checkTop(array, i, j)+ checkLefTop(array, i, j)+checkLeft(array, i, j)+checkLeftBottom(array, i, j)+ checkBottom(array, i, j);
                    }
                    if (numberOfBombsAround > 0) {
                        array[i][j] = String.valueOf(numberOfBombsAround);
                    }
                }catch (Exception e){


                }

                try {
                    //bottom wall
                    if (i == 8) {
                        numberOfBombsAround = checkTop(array, i, j)+ checkLeft(array, i, j)+checkLefTop(array, i, j)+checkRightTop(array, i, j)+ checkRight(array, i, j);
                    }
                    if (numberOfBombsAround > 0) {
                        array[i][j] = String.valueOf(numberOfBombsAround);
                    }
                }catch (Exception e){


                }

            }


        }
    }

    public static void checkMiddle(String[][] array){
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                int numberOfBombsAround = 0;

                try{
                    if(j != 0 && j !=8 && i!=0 && i!=8){
                        numberOfBombsAround = checkTop(array, i, j)+ checkLefTop(array, i, j)+checkRightTop(array, i, j)+checkRight(array, i, j)+checkRighBottom(array, i, j)+checkBottom(array, i, j)+checkLeftBottom(array, i, j)+checkLeft(array, i, j);
                    }
                    if (numberOfBombsAround > 0) {
                        array[i][j] = String.valueOf(numberOfBombsAround);
                    }
                }catch (Exception e){

                }

            }
        }
    }


    public static void cornerCheckSurrounding(String[][] array){
        //0,0 0,8 8,0 8,
        //get the first
        for(int i = 0; i<9; i++){
            for(int j = 0; j< 9; j++){

                if(array[0][0].equals(".")){
                    int numberOfBombsAround = 0;
                    if(array[0][1].equals("X")){
                        numberOfBombsAround +=1;
                    }
                    if(array[1][1].equals("X")){
                        numberOfBombsAround +=1;
                    }
                    if(array[1][0].equals("X")){
                        numberOfBombsAround +=1;
                    }
                    if(numberOfBombsAround > 0){
                        array[0][0] = String.valueOf(numberOfBombsAround);
                    }
                }
                //check right top corner
                if(array[0][8].equals(".")){
                    int numberOfBombsAround = 0;
                    if(array[1][8].equals("X")){
                        numberOfBombsAround +=1;
                    }
                    if(array[1][7].equals("X")){
                        numberOfBombsAround +=1;
                    }
                    if(array[0][7].equals("X")){
                        numberOfBombsAround +=1;
                    }
                    if(numberOfBombsAround > 0){
                        array[0][8] = String.valueOf(numberOfBombsAround);
                    }
                }
                //bottom left
                if(array[8][0].equals(".")){
                    int numberOfBombsAround = 0;
                    if(array[7][0].equals("X")){
                        numberOfBombsAround +=1;
                    }
                    if(array[7][1].equals("X")){
                        numberOfBombsAround +=1;
                    }
                    if(array[8][1].equals("X")){
                        numberOfBombsAround +=1;
                    }
                    if(numberOfBombsAround > 0){
                        array[8][0] = String.valueOf(numberOfBombsAround);
                    }
                }
                if(array[8][8].equals(".")){
                    int numberOfBombsAround = 0;
                    if(array[7][8].equals("X")){
                        numberOfBombsAround +=1;
                    }
                    if(array[8][7].equals("X")){
                        numberOfBombsAround +=1;
                    }
                    if(array[7][7].equals("X")){
                        numberOfBombsAround +=1;
                    }
                    if(numberOfBombsAround > 0){
                        array[8][8] = String.valueOf(numberOfBombsAround);
                    }

                }
            }
        }
    }

    public static void displayBoards(int rows, int columns, String[][] array){
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                System.out.print(array[i][j] + "");
            }
            System.out.println();
        }
    }




}
