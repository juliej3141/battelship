import java.util.Random;
import java.util.Scanner; 

public class Battleship {
  Scanner scan = new Scanner(System.in);
  int[][] shipsB;
  int[][] guessB;
  int shipsLeft = 0;
  boolean tf;
  boolean tf2;
  boolean tf3;
  int lTwo = 0;
  int lThree = 0;
  Random random = new Random(); //random generator
  public Battleship(int rows, int cols) {
    shipsB = new int[rows][cols]; //shipsB is the board with my shipson them
    guessB = new int[rows][cols];  
     //creates a new board for guessing
    
  }

  public void printGuess() { //board for the user to guess where i hid my ship
    System.out.print("   " + 1 + "  " + 2 + "  " + 3 + "  " + 4 + "  " + 5 + "  " + 6 + "  " + 7 + "  " + 8 + "\n");
    for (int r = 0; r < guessB.length; r++) { //print row
      System.out.print(r + 1);
      for (int c = 0; c < guessB[r].length; c++) { //print columns
        System.out.print("  " + guessB[r][c]);
      } //closes columns
      System.out.print("\n");
    } //closes rows
  }

  public void printShips() { //board for my ships, shows where my ships are
    for (int r = 0; r < shipsB.length; r++) { //print row
      System.out.print(r + 1);
      for (int c = 0; c < shipsB[r].length; c++) { //print columns
        System.out.print("  " + shipsB[r][c]);
      } //closes columns
      System.out.print("\n");
    } //closes rows
  }

  public void autoPlace() { //random places my ships
    tf = random.nextBoolean(); //decide if boat goes horizontal or vertical
    //do big for loop
    //do while loop inside for loop
    int shipr1 = (int)(Math.random()* 7 + 0); //7 bc board of 8x8 + don't want ships to go off the board
    double temp = Math.random() * 1000; 
    int shipc1 = (int)(Math.random()* 7 + 0);
    if (tf == true) { //if new random boolean is true then go vertical, if false go horizontal
      for (int i = 0; i < 1; i++) {
        shipsB[shipr1][shipc1 + i] = 4;
      } 
    }
    else {
      for (int i = 0; i < 1; i++) {
        shipsB[shipr1 + i][shipc1] = 4;
      } 
    }

    tf2 = random.nextBoolean();
    temp = Math.random() * 1000; //decide if boat goes horizontal or vertical
    int shipr2 = (int)(Math.random()*6 + 0); //6 bc board of 8x8 + don't want ships to go off the board, length 2
    int shipc2 = (int)(Math.random()*6 + 0);
    while (shipsB[shipr2][shipc2] != 0) {
      shipr2 = (int)(Math.random()*6 + 0); //6 bc board of 8x8 + don't want ships to go off the board, length 2
      shipc2 = (int)(Math.random()*6 + 0);
    }
    if (tf2 == true) { //if new random boolean is true then go vertical, if false go horizontal
      for (int i = 0; i < 2; i++) {
        shipsB[shipr2][shipc2 + i] = 5;
      } 
    }
    else {
      for (int i = 0; i < 2; i++) {
        shipsB[shipr2 + i][shipc2] = 5;
      } 
    }

    tf3 = random.nextBoolean(); 
    temp = Math.random() * 1000; //decide if boat goes horizontal or vertical
    int shipr3 = (int)(Math.random()*5 + 0); //5 bc board of 8x8 + don't want ships to go off the board, length 3
    int shipc3 = (int)(Math.random()*5 + 0);
    while (shipsB[shipr3][shipc3] != 0) {
      shipr3 = (int)(Math.random()*5 + 0); //6 bc board of 8x8 + don't want ships to go off the board, length 2
      shipc3 = (int)(Math.random()*5 + 0);
    }
    if (tf3 == true) { //if new random boolean is true then go vertical, if false go horizontal
      for (int i = 0; i < 3; i++) {
        shipsB[shipr3][shipc3 + i] = 6;
      } 
    }
    else {
      for (int i = 0; i < 3; i++) {
        shipsB[shipr3 + i][shipc3] = 6;
      } 
    }
    shipsLeft = 3;
  }

  public int hitShips(int rowG, int columnG) { //sees if they hit my ship
    if (shipsB[rowG - 1][columnG - 1] == 4) { //if they hit a ship w/ val 4 then i know it only has length 1 so they have sunk a ship
      guessB[rowG - 1][columnG - 1] = 1; 
      shipsLeft -= 1;
      System.out.print("\n\n" + "you sunk a ship!" + "\n");
    }
    else if (shipsB[rowG - 1][columnG - 1] == 5) {  
      guessB[rowG - 1][columnG - 1] = 1;
      System.out.print("\n\n" + "you hit a ship!" + "\n");
      lTwo++;
      if (lTwo == 2) {
        shipsLeft -= 1; //if both parts of ship is hit sunk, counter will = 2
        System.out.print("\n\n" + "you sunk a ship!" + "\n");
      }
    }
    else if (shipsB[rowG - 1][columnG - 1] == 6) {
      guessB[rowG - 1][columnG - 1] = 1;
      lThree++;
      System.out.print("\n\n" + "you hit a ship!" + "\n");
      if (lThree == 3) {
        shipsLeft -= 1; //if three counter is 3 they hit all parts of ship and it is sunk
        System.out.print("\n\n" + "you sunk a ship!" + "\n");
      }
    }
    else {
      guessB[rowG - 1][columnG - 1] = 2; //put 2 where player guessed if they miss
      System.out.print("\n\n" + "you missed" + "\n");
    }
    printGuess();
    return shipsLeft;
  }
}