public class Validation {

    public boolean checkTask1(Board gameBoard) {

        int[] testLoc1 = { 2, 3 };
        int[] testLoc2 = { 2, 4 };

        if (gameBoard.gemAtLocation(testLoc1).ordinal() == 7) {
            if (gameBoard.gemAtLocation(testLoc2).ordinal() == 2) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTask2(Board gameBoard) {
        return gameBoard.wasChainCreated();
    }

    public boolean checkTask3(Board gameBoard) {
        return false;
    }

    public boolean checkTask3Valid(Board gameBoard) {
        int[] testLoc1 = { 2, 3 };
        int[] testLoc2 = { 0, 4 };

        if (gameBoard.gemAtLocation(testLoc1).ordinal() == 7) {
            if (gameBoard.gemAtLocation(testLoc2).ordinal() == 4) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTask3Invalid(Board gameBoard) {
        int[] testLoc1 = { 2, 3 };
        int[] testLoc2 = { 2, 2 };

        if (gameBoard.gemAtLocation(testLoc1).ordinal() == 2) {
            if (gameBoard.gemAtLocation(testLoc2).ordinal() == 6) {
                return true;
            }
        }
        return false;
    }
    
    ////////////////////////////
    // TASK 1
    ////////////////////////////
    
    // Adjacent (horizontal?) pieces should swap with the task 1 function
    public boolean task1AnySwap1() {
        Board gameBoard = new Board();
        gameBoard.loadStaticBoard();
        int[] testLoc1 = {0,0};
        int[] testLoc2 = {0,1};
        int piece1 = gameBoard.gemAtLocation(testLoc1).ordinal();
        int piece2 = gameBoard.gemAtLocation(testLoc2).ordinal();
        gameBoard.swapAnyTwoPieces(testLoc1, testLoc2);
        if (gameBoard.gemAtLocation(testLoc1).ordinal() == piece2){
            if (gameBoard.gemAtLocation(testLoc2).ordinal() == piece1){
                return true;
            }
        }
        return false;
    }
    // Adjacent (vertical?) pieces should swap with the task 1 function
    public boolean task1AnySwap2() {
        Board gameBoard = new Board();
        gameBoard.loadStaticBoard();
        int[] testLoc1 = {5,5};
        int[] testLoc2 = {6,5};
        int piece1 = gameBoard.gemAtLocation(testLoc1).ordinal();
        int piece2 = gameBoard.gemAtLocation(testLoc2).ordinal();
        gameBoard.swapAnyTwoPieces(testLoc1, testLoc2);
        if (gameBoard.gemAtLocation(testLoc1).ordinal() == piece2){
            if (gameBoard.gemAtLocation(testLoc2).ordinal() == piece1){
                return true;
            }
        }
        return false;
    }
    // Non-adjacent pieces should swap with the task 1 function
    public boolean task1AnySwap3() {
        Board gameBoard = new Board();
        gameBoard.loadStaticBoard();
        int[] testLoc1 = {2,2};
        int[] testLoc2 = {6,6};
        int piece1 = gameBoard.gemAtLocation(testLoc1).ordinal();
        int piece2 = gameBoard.gemAtLocation(testLoc2).ordinal();
        gameBoard.swapAnyTwoPieces(testLoc1, testLoc2);
        if (gameBoard.gemAtLocation(testLoc1).ordinal() == piece2){
            if (gameBoard.gemAtLocation(testLoc2).ordinal() == piece1){
                return true;
            }
        }
        return false;
    }
    // Requests for pieces off the board should return no swap
    public boolean task1AnySwap4() {
        Board gameBoard = new Board();
        gameBoard.loadStaticBoard();
        int[] testLoc1 = {2,3};
        int[] testLoc2 = {6,-1};
        int piece1 = gameBoard.gemAtLocation(testLoc1).ordinal();
        gameBoard.swapAnyTwoPieces(testLoc1, testLoc2);
        try {
            if (gameBoard.gemAtLocation(testLoc1).ordinal() == piece1){
                return true;
            }
        }
        catch (Exception e){
            return false;
        }
        return false;
    }
    // Requests for pieces off the board should return no swap
    public boolean task1AnySwap5() {
        Board gameBoard = new Board();
        gameBoard.loadStaticBoard();
        int[] testLoc1 = {7,7};
        int[] testLoc2 = {7,8};
        int piece1 = gameBoard.gemAtLocation(testLoc1).ordinal();
        gameBoard.swapAnyTwoPieces(testLoc2, testLoc1);
        try {
            if (gameBoard.gemAtLocation(testLoc1).ordinal() == piece1){
                return true;
            }
        }
        catch (Exception e){
            return false;
        }
        return false;
    }
    
    ////////////////////////////
    // TASK 2
    ////////////////////////////
    
    // 
    public boolean task2AnySwap1() {
        Board gameBoard = new Board();
        gameBoard.loadStaticBoard();
        int[] testLoc1 = {0,0};
        int[] testLoc2 = {0,1};
        int piece1 = gameBoard.gemAtLocation(testLoc1).ordinal();
        int piece2 = gameBoard.gemAtLocation(testLoc2).ordinal();
        gameBoard.swapAnyTwoPieces(testLoc1, testLoc2);
        if (gameBoard.gemAtLocation(testLoc1).ordinal() == piece2){
            if (gameBoard.gemAtLocation(testLoc2).ordinal() == piece1){
                return true;
            }
        }
        return false;
    }
}
