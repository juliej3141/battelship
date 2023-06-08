import java.util.Scanner; 

public class Main {
  static int shipsLeft = 3;


  
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Battleship b1 = new Battleship(8,8);
    b1.autoPlace();
    
    System.out.print("\033[H\033[2J"); //clears screen
    System.out.flush();
    System.out.print("For player two: there are three boats of lengths 1-3. Their locations were randomly chosen. It is your job to guess where they placed each boat. You will be given a guessing board that record your hits and misses.\n"); //directions to play
    System.out.print("\n" + "1 = a hit" + "\n");
    System.out.print("2 = a miss" + "\n");
    System.out.print("\n" + "Guess where I hid my boats" + "\n"); //dialog for the game
    b1.printGuess(); 
    System.out.print("\n\n");
    //b1.printShips();
    
    while (shipsLeft > 0) { //while the user hasn't found all the ships yet run
      System.out.print("\n" + "Enter the row you think a ship is in: " + "\n");
      int rowG = scan.nextInt(); //gets persons row guess
      System.out.print("\n" + "Enter the column you think a ship is in: " + "\n");
      int columnG = scan.nextInt(); //guess persons column guess
      
      shipsLeft = b1.hitShips(rowG, columnG); // uses hitShips function
      System.out.print("\n" + "there are " + shipsLeft + " ships left" + "\n");
      try {
        Thread.sleep(5000); //pauses code for 5 seconda
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