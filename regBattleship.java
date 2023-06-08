import java.util.Random;
import java.util.Scanner; 

public class regBattleship {
  Scanner scan = new Scanner(System.in);
  int[][] shipsB;
  int[][] guessB;
  int lTwo = 0; //counter for how many spots of the boat have been hit, same for other ones too
  int lThree = 0;
  int lFour = 0;
  int lFive = 0;
  int shipsLeft = 0;
  public regBattleship(int rows, int cols) {
    shipsB = new int[rows][cols]; //shipsB is the board with my shipson them
    guessB = new int[rows][cols];  
     //creates a new board for guessing
  }

  public void printGuess() { //board for the user to guess where i hit my ship
    System.out.print("   " + 1 + "  " + 2 + "  " + 3 + "  " + 4 + "  " + 5 + "  " + 6 + "  " + 7 + "  " + 8 + "  " + 9 + "  " + 10 + "\n");
    for (int r = 0; r < guessB.length; r++) { //print row
      System.out.print(r + 1);
      for (int c = 0; c < guessB[r].length; c++) { //print columns
        System.out.print("  " + guessB[r][c]);
      } //closes columns
      System.out.print("\n");
    } //closes rows
  }

  public void printShips() {
    System.out.print("   " + 1 + "  " + 2 + "  " + 3 + "  " + 4 + "  " + 5 + "  " + 6 + "  " + 7 + "  " + 8 + "  " + 9 + "  " + 10 + "\n");
    for (int r = 0; r < shipsB.length; r++) { //print row
      System.out.print(r + 1);
      for (int c = 0; c < shipsB[r].length; c++) { //print columns
        System.out.print("  " + shipsB[r][c]);
      } //closes columns
      System.out.print("\n");
    } //closes rows
  }

  public void placeShips() { //places my ships
    System.out.print("What row do you want your ship of length one to be?\n"); 
    int shipr1 = scan.nextInt(); //gets the val user inputs, same for all the other boats
    System.out.print("\nWhat column do you want your ship of length one to be?\n\n");
    int shipc1 = scan.nextInt(); //gets the val user inputs
    shipsB[shipr1][shipc1] = 3; //only length 1 so just puts 3 at spot user chose
    
    System.out.print("What row do you want your ship of length two to be?\n");
    int shipr2 = scan.nextInt();
    System.out.print("What column do you want your ship of length two to be?\n");
    int shipc2 = scan.nextInt();
    System.out.print("Type h if you want the ship to be horizontal. Type v if you want the ship to be vertical\n");
    String shiphv2 = scan.nextLine();
    //while (shiphv2.equals("h") == false || shiphv2.equals("v") == false) {
      //System.out.print("\n\nPlease enter a valid value. Type h if you want the ship to be horizontal. Type v if you want the ship to be vertical\n");
      //shiphv2 = scan.nextLine();
    //}
    if (shiphv2.equals("v") == true) { //if player chooses to go vertical
      for (int i = 0; i < 2; i++) { //print 4 two times vertically
        shipsB[shipr2][shipc2 + i] = 4;
      } 
    }
    else { //prints horizonatally
      for (int i = 0; i < 2; i++) {
        shipsB[shipr2 + i][shipc2] = 4;
      } 
    }
    
    System.out.print("\n\nWhat row do you want your ship of length three to be?");
    int shipr3 = scan.nextInt();
    System.out.print("\nWhat column do you want your ship of length three to be?");
    int shipc3 = scan.nextInt();
    System.out.print("\nType h if you want the ship to be horizontal. Type v if you want the ship to be vertical");
    String shiphv3 = scan.nextLine();
    //while (shiphv3.equals("h") == false || shiphv3.equals("v") == false) {
      //System.out.print("\n\nPlease enter a valid value. Type h if you want the ship to be horizontal. Type v if you want the ship to be vertical\n");
      //shiphv3 = scan.nextLine();
    //}
    if (shiphv3.equals("v") == true) {
      for (int i = 0; i < 3; i++) {
        shipsB[shipr3][shipc3 + i] = 5; //print 5 three times vertically
      } 
    }
    else { //horizonatal
      for (int i = 0; i < 3; i++) {
        shipsB[shipr3 + i][shipc3] = 5;
      } 
    }

    System.out.print("What row do you want your ship of length four to be?\n");
    int shipr4 = scan.nextInt();
    System.out.print("\nWhat column do you want your ship of length four to be?");
    int shipc4 = scan.nextInt();
    System.out.print("\nType h if you want the ship to be horizontal. Type v if you want the ship to be vertical");
    String shiphv4 = scan.nextLine();
    //while (shiphv4.equals("h") == false || shiphv4.equals("v") == false) {
      //System.out.print("\n\nPlease enter a valid value. Type h if you want the ship to be horizontal. Type v if you want the ship to be vertical");
      //shiphv4 = scan.nextLine();
    //}
    if (shiphv4.equals("v") == true) {
      for (int i = 0; i < 4; i++) { ////print 6 four times vertically
        shipsB[shipr4][shipc4 + i] = 6;
      } 
    }
    else { //horizontal
      for (int i = 0; i < 4; i++) {
        shipsB[shipr4 + i][shipc4] = 6;
      } 
    }
    
    System.out.print("What row do you want your ship of length five to be?");
    int shipr5 = scan.nextInt();
    System.out.print("\n\nWhat column do you want your ship of length five to be?");
    int shipc5 = scan.nextInt();
    System.out.print("\n\nType h if you want the ship to be horizontal. Type v if you want the ship to be vertical");
    String shiphv5 = scan.nextLine();
    //while (shiphv5.equals("h") == false || shiphv5.equals("v") == false) {
      //System.out.print("\n\nPlease enter a valid value. Type h if you want the ship to be horizontal. Type v if you want the ship to be vertical");
      //shiphv5 = scan.nextLine();
    //}
    if (shiphv5.equals("v") == true) {
      for (int i = 0; i < 5; i++) { ////print 7 five times vertically
        shipsB[shipr5][shipc5 + i] = 7;
      } 
    }
    else { //horizontal
      for (int i = 0; i < 5; i++) {
        shipsB[shipr5 + i][shipc5] = 7;
      } 
    }
    shipsLeft = 5;
  }
  public int hitShips(int rowG, int columnG) { //sees if they hit my ship
    if (shipsB[rowG - 1][columnG - 1] == 3) { //if they hit a ship w/ val 4 then i know it only has length 1 so they have sunk a ship
      guessB[rowG - 1][columnG - 1] = 1; 
      shipsLeft -= 1;
      System.out.print("\n\n" + "you sunk a ship!" + "\n");
    }
    else if (shipsB[rowG - 1][columnG - 1] == 4) {  
      guessB[rowG - 1][columnG - 1] = 1;
      System.out.print("\n\n" + "you hit a ship!" + "\n");
      lTwo++; //adds to two counter
      if (lTwo == 2) {
        shipsLeft -= 1; //if counter is 2 then they sunk a ship
        System.out.print("\n\n" + "you sunk a ship!" + "\n");
      }
    }
    else if (shipsB[rowG - 1][columnG - 1] == 5) {
      guessB[rowG - 1][columnG - 1] = 1;
      lThree++;
      System.out.print("\n\n" + "you hit a ship!" + "\n");
      if (lThree == 3) {
        shipsLeft -= 1; //if counter is 3 thye sunk a ship
        System.out.print("\n\n" + "you sunk a ship!" + "\n");
      }
    }
    else if (shipsB[rowG - 1][columnG - 1] == 6) {
      guessB[rowG - 1][columnG - 1] = 1;
      lFour++;
      System.out.print("\n\n" + "you hit a ship!" + "\n");
      if (lFour == 4) {
        shipsLeft -= 1; //sunk ship if counter 4
        System.out.print("\n\n" + "you sunk a ship!" + "\n");
      }
    }
    else if (shipsB[rowG - 1][columnG - 1] == 7) {
      guessB[rowG - 1][columnG - 1] = 1;
      lFive++;
      System.out.print("\n\n" + "you hit a ship!" + "\n");
      if (lFive == 5) {
        shipsLeft -= 1; //sunk ship if counter 5
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