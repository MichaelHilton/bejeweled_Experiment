
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
    Validation val = new Validation();
    System.out.println("************** TASK1 **************");
    System.out.println("********* Swap C3 with C4 *********");
    System.out.println("***********************************");  
    Board gameBoard = new Board();
    gameBoard.loadBoardTask1();
    System.out.println("");
    System.out.println("********** Before Swap ************");
    gameBoard.displayBoard();
    int[] piece_a = {2,3};
    int[] piece_b = {2,4};
   

    //FUNCTION TO SWAP ANY TWO PICES.  THIS MUST BE IMPLEMENTED IN BOARD.JAVA
    gameBoard.swapAnyTwoPieces(piece_a,piece_b);
    //TODO REMOVE THIS FUNCTION ALSO
    //gameBoard.locationSwap(piece_a,piece_b);
    
    System.out.println("");
    System.out.println("*********** After Swap ************");
    gameBoard.displayBoard();
    
    System.out.println("");
    
    System.out.println("******* Was Swap Performed? *******");
    System.out.println("SEQUENCE CREATED: " + val.checkTask1(gameBoard));
    System.out.println("");
    boolean task1done = val.checkTask1(gameBoard);
    if(task1done){
    	System.out.println("TASK 1: [DONE]");
    }else{
    	System.out.println("TASK 1: [INCOMPLETE]");
    }
    // String Task1_Result = checkTask1;
    //System.out.println("TASK 1: [INCOMPLETE]");
    System.out.println("");
    
    System.out.println("************** TASK2 **************");
    System.out.println("****** Swap Created Sequence ******");
    System.out.println("***********************************");  
    Board gameBoard2 = new Board();
    gameBoard2.loadBoardTask1();
    gameBoard.displayBoard();
    System.out.println("");
    System.out.println("****** Was Sequence Created? ******");
    System.out.println("SEQUENCE CREATED: " + gameBoard.wasSequenceCreated());
    boolean task2done = val.checkTask2(gameBoard);
    System.out.println("");
    if(task2done){
    	System.out.println("TASK 2: [DONE]");
    }else{
    	System.out.println("TASK 2: [INCOMPLETE]");
    }
    System.out.println("");

    System.out.println("************** TASK3 **************");
    System.out.println("** Swap Only if Sequence Created **");
    System.out.println("***********************************"); 
    
    System.out.println("******* Before Valid Swap *********");
    gameBoard.loadBoardTask1();
    gameBoard.displayBoard();
    System.out.println();
    System.out.println("** Perform Valid Swap [C3 to C4] **");
    System.out.println();
    
    int[] piece_valid_a = {2,3};
    int[] piece_valid_b = {2,4};
    gameBoard.swapPiecesWhenAcceptable(piece_valid_a,piece_valid_b);
    gameBoard.displayBoard();
    System.out.println();
    System.out.println("********* Did Swap Occur? *********");
    boolean checkTask3Valid = val.checkTask3Valid(gameBoard);
    System.out.println("Swap Occured: " + checkTask3Valid);
    
    System.out.println();
    System.out.println("****** Before Invalid Swap ********");
    gameBoard.loadBoardTask1();
    gameBoard.displayBoard();
    System.out.println();
    System.out.println("* Attempt Invalid Swap [C2 to C3] *");
    System.out.println();
    
    int[] piece_invalid_a = {2,2};
    int[] piece_invalid_b = {2,3};
    gameBoard.swapPiecesWhenAcceptable(piece_invalid_a,piece_invalid_b);
    gameBoard.displayBoard();
    System.out.println();
    System.out.println("********* Did Swap Occur? *********");
    boolean checkTask3Invalid = val.checkTask3Invalid(gameBoard);
	System.out.println("Swap was NOT performed: " + checkTask3Invalid);
    System.out.println("");
    if(checkTask3Valid && checkTask3Invalid){
    	System.out.println("TASK 3: [DONE]");
    }else{
    	System.out.println("TASK 3: [INCOMPLETE]");
    }
    System.out.println("");
    
    /*
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
*/
  }
}