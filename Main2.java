import java.util.Scanner; 

public class Main2 {
  static int shipsLeft = 5;
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    regBattleship b1 = new regBattleship(10,10);
    System.out.print("For player one: you are given five boats of lengths 1-5. \n"); //all directions
    System.out.print("This is your ships board.\n\n");
    b1.printShips();
    System.out.print("Please choose the coordinates for the starting point of each ship and whether they will be horizontal or vertical.\n\n");  
    b1.placeShips();

    System.out.print("For player two: there are five boats of lengths 1-5. Player one has chosen their locations. It is your job to guess where they placed each boat. You will be given a guessing board that record your hits and misses. \n");
    System.out.print("\n" + "1 = a hit" + "\n");
    System.out.print("2 = a miss" + "\n");
    System.out.print("\n" + "Guess where I hid my boats" + "\n"); //dialog for the game
    b1.printGuess(); 
    System.out.print("\n\n");
    b1.printShips();
    
    while (shipsLeft > 0) { //while the user hasn't found all the ships yet run
      System.out.print("\n" + "Enter the row you think the ship is in: " + "\n");
      int rowG = scan.nextInt(); //gets persons row guess
      System.out.print("\n" + "Enter the column you think the ship is in: " + "\n");
      int columnG = scan.nextInt(); //guess persons column guess
      
      shipsLeft = b1.hitShips(rowG, columnG); // uses hitShips function
      System.out.print("there are " + shipsLeft + " ships left" + "\n");
      
      try {
        Thread.sleep(5000); //creates 5 second pause
      } catch (InterruptedException ie) {
        Thread.currentThread().interrupt();
        }
      System.out.print("\033[H\033[2J"); //clears screen
      System.out.flush();
      b1.printGuess();
    }
    System.out.print("\n" + "you hit all my ships! Game is over");
  }
}