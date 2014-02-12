public class Bejewelly {
    public static void main(String[] args) {
        Validation val = new Validation();
        // TASK 1 - SWAP ANY TWO PIECES
        System.out.println("************** TASK1 **************");
        System.out.println("********* Swap C3 with C4 *********");
        System.out.println("***********************************");
        Board gameBoard = new Board();
        gameBoard.loadStaticBoard();
        System.out.println("");
        System.out.println("********** Before Swap ************");
        gameBoard.displayBoard();
        int[] piece_a = { 2, 3 };
        int[] piece_b = { 2, 4 };

        val.checkTask1(gameBoard);
        // FUNCTION TO SWAP ANY TWO PICES. THIS MUST BE IMPLEMENTED IN
        // BOARD.JAVA
        gameBoard.swapAnyTwoPieces(piece_a, piece_b);

        System.out.println("");
        System.out.println("*********** After Swap ************");
        gameBoard.displayBoard();
        System.out.println("");
        System.out.println("******* Was Swap Performed? *******");
        System.out.println("SEQUENCE CREATED: " + val.checkTask1(gameBoard));
        System.out.println("");
        boolean task1done = val.checkTask1(gameBoard);
        if (task1done) {
            System.out.println("TASK 1: [DONE]");
        } else {
            System.out.println("TASK 1: [INCOMPLETE]");
        }
        System.out.println("");

        // TASK 2 - DETECT IF SWAP CREATED A VALID SEQUENCE
        System.out.println("************** TASK2 **************");
        System.out.println("****** Swap Created Sequence ******");
        System.out.println("***********************************");
        Board gameBoard2 = new Board();
        gameBoard2.loadStaticBoard();
        gameBoard.displayBoard();
        System.out.println("");
        System.out.println("****** Was Sequence Created? ******");

        // TODO: IMPLEMENT THIS FUNCTION IN BOARD.JAVA
        System.out.println("SEQUENCE CREATED: "
                + gameBoard.wasChainCreated());
        boolean task2done = val.checkTask2(gameBoard);
        System.out.println("");
        if (task2done) {
            System.out.println("TASK 2: [DONE]");
        } else {
            System.out.println("TASK 2: [INCOMPLETE]");
        }
        System.out.println("");

        // TASK 3 - ONLY PERFORM SWAP IF IT CREATES A VALID SEQUENCE
        System.out.println("************** TASK3 **************");
        System.out.println("** Swap Only if Sequence Created **");
        System.out.println("***********************************");

        System.out.println("******* Before Valid Swap *********");
        gameBoard.loadStaticBoard();
        gameBoard.displayBoard();
        System.out.println();
        System.out.println("** Perform Valid Swap [C3 to C4] **");
        System.out.println();

        int[] piece_valid_a = { 2, 3 };
        int[] piece_valid_b = { 2, 4 };

        // TODO: IMPLEMENT THIS FUNCTION
        gameBoard.swapPiecesWhenAcceptable(piece_valid_a, piece_valid_b);

        gameBoard.displayBoard();
        System.out.println();
        System.out.println("********* Did Swap Occur? *********");
        boolean checkTask3Valid = val.checkTask3Valid(gameBoard);
        System.out.println("Swap Occured: " + checkTask3Valid);
        System.out.println();
        System.out.println("****** Before Invalid Swap ********");
        gameBoard.loadStaticBoard();
        gameBoard.displayBoard();
        System.out.println();
        System.out.println("* Attempt Invalid Swap [C2 to C3] *");
        System.out.println();

        int[] piece_invalid_a = { 2, 2 };
        int[] piece_invalid_b = { 2, 3 };

        // TODO: IMPLEMENT THIS FUNCTION
        gameBoard.swapPiecesWhenAcceptable(piece_invalid_a, piece_invalid_b);

        gameBoard.displayBoard();
        System.out.println();
        System.out.println("********* Did Swap Occur? *********");
        boolean checkTask3Invalid = val.checkTask3Invalid(gameBoard);
        System.out.println("Swap was NOT performed: " + checkTask3Invalid);
        System.out.println("");
        if (checkTask3Valid && checkTask3Invalid) {
            System.out.println("TASK 3: [DONE]");
        } else {
            System.out.println("TASK 3: [INCOMPLETE]");
        }
        System.out.println("");
    }
}

enum Piece {
    BLANK(" "), STAR("*"), UMBRELLA("^"), SUN("O"), DIAMOND("&"), HEART("@"), SPADE(
            "$"), CLUB("}");
    public String value;

    private Piece(String value) {
        this.value = value;
    }
}
