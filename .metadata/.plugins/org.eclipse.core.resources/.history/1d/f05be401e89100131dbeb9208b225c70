enum Piece
{
  BLANK(" "), STAR("*"), UMBRELLA("^"), SUN("O"), DIAMOND("&"), HEART("@"), SPADE("$"), CLUB("}");
  public String value;
  private Piece(String value){
    this.value = value;
  }
}




public class Bejewelly {
  public static void main(String[] args) {
    Board gameBoard = new Board();
    //gameBoard.clearScreen();
    //gameBoard.promptUser();
    //gameBoard.printInstructions();
      
    gameBoard.loadBoardTask1();
    gameBoard.displayBoard();
    int[] p1 = new int[2];
    int[] p2 = new int[2];
    p1[0] = 1;
    p1[1] = 0;
    p2[0] = 1;
    p2[1] = 1;
    System.out.println("Swapping [" + p1[0] + "," + p1[1] + "] and ["+ p2[0] + "," + p2[1] + "]");
    gameBoard.swapAnyTwoPieces(p1, p2);
    gameBoard.displayBoard();
    System.out.println("A sequence should have been created.");
    System.out.println("T or F: A sequence was created: " + gameBoard.wasSequenceCreated());
    gameBoard.swapAnyTwoPieces(p1, p2); 
    gameBoard.displayBoard();
    System.out.println("When returned to an original state, there should be no sequence.");
    System.out.println("T or F: A sequence was created: " + gameBoard.wasSequenceCreated());
   
    
    System.out.println("Can you avoid swapping when a sequence is not created?");
    p2[0] = 0;
    p2[1] = 0;
    gameBoard.swapPiecesWhenAcceptable(p1, p2);
    gameBoard.displayBoard();
    System.out.println("Does that same function swap when it is acceptable?");
    p2[0] = 1;
    p2[1] = 1;
    gameBoard.swapPiecesWhenAcceptable(p1, p2);
    gameBoard.displayBoard();
    
    //ability to swap two elements (one game move)
    //upon swapping, check for matches
    //if a match occurs, delete the elements that match, add new pieces to the board
    //implement a scoring algorithm
    
    // swap any two elements
    
    // check if a sequence is created
    // swap back if no sequence is created

  }
}