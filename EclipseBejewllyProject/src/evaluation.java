
public class evaluation {
    public evaluation() {}
    
    ////////////////////////////
    // TASK 1
    ////////////////////////////
    
    // Adjacent (horizontal?) pieces should swap with the task 1 function
    private boolean task1Test1() {
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
    private boolean task1Test2() {
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
    private boolean task1Test3() {
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
    private boolean task1Test4() {
        Board gameBoard = new Board();
        gameBoard.loadStaticBoard();
        int[] testLoc1 = {2,3};
        int[] testLoc2 = {6,-1};
        int piece1 = gameBoard.gemAtLocation(testLoc1).ordinal();
        try {
            gameBoard.swapAnyTwoPieces(testLoc1, testLoc2);
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
    private boolean task1Test5() {
        Board gameBoard = new Board();
        gameBoard.loadStaticBoard();
        int[] testLoc1 = {7,7};
        int[] testLoc2 = {7,8};
        int piece1 = gameBoard.gemAtLocation(testLoc1).ordinal();
        try {
            gameBoard.swapAnyTwoPieces(testLoc2, testLoc1);
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
    
    // A chain should be created when swapping B0 and B1 (horizontal)
    private boolean task2Test1() {
        Board gameBoard = new Board();
        gameBoard.loadStaticBoard();
        Piece temp_a = gameBoard.boardGrid[1][0];
        gameBoard.boardGrid[1][0] = gameBoard.boardGrid[1][1];
        gameBoard.boardGrid[1][1] = temp_a;
        if (gameBoard.wasChainCreated()) { return true; }
        else { return false; }
    }
    
    // A chain should be created when swapping G5 and H5 (vertical)
    private boolean task2Test2() {
        Board gameBoard = new Board();
        gameBoard.loadStaticBoard();
        Piece temp_a = gameBoard.boardGrid[6][5];
        gameBoard.boardGrid[6][5] = gameBoard.boardGrid[7][5];
        gameBoard.boardGrid[7][5] = temp_a;
        if (gameBoard.wasChainCreated()) { return true; }
        else { return false; }
    }
    
    // They should return false with the default board
    private boolean task2Test3() {
        Board gameBoard = new Board();
        gameBoard.loadStaticBoard();
        if (gameBoard.wasChainCreated()) { return false; }
        else { return true; }
    }
    
    ////////////////////////////
    // TASK 3
    ////////////////////////////
    
 // Adjacent (horizontal) pieces that create a chain should swap with the task 3 function
    private boolean task3Test1() {
        Board gameBoard = new Board();
        gameBoard.loadStaticBoard();
        int[] testLoc1 = {1,0};
        int[] testLoc2 = {1,1};
        int piece1 = gameBoard.gemAtLocation(testLoc1).ordinal();
        int piece2 = gameBoard.gemAtLocation(testLoc2).ordinal();
        gameBoard.swapPiecesWhenAcceptable(testLoc1, testLoc2);
        if (gameBoard.gemAtLocation(testLoc1).ordinal() == piece2){
            if (gameBoard.gemAtLocation(testLoc2).ordinal() == piece1){
                return true;
            }
        }
        return false;
    }
    // Adjacent (vertical) pieces that create a chain should swap with the task 3 function
    private boolean task3Test2() {
        Board gameBoard = new Board();
        gameBoard.loadStaticBoard();
        int[] testLoc1 = {6,5};
        int[] testLoc2 = {7,5};
        int piece1 = gameBoard.gemAtLocation(testLoc1).ordinal();
        int piece2 = gameBoard.gemAtLocation(testLoc2).ordinal();
        gameBoard.swapPiecesWhenAcceptable(testLoc1, testLoc2);
        if (gameBoard.gemAtLocation(testLoc1).ordinal() == piece2){
            if (gameBoard.gemAtLocation(testLoc2).ordinal() == piece1){
                return true;
            }
        }
        return false;
    }
    // Non-adjacent pieces should not swap with the task 3 function
    private boolean task3Test3() {
        Board gameBoard = new Board();
        gameBoard.loadStaticBoard();
        int[] testLoc1 = {2,2};
        int[] testLoc2 = {6,6};
        int piece1 = gameBoard.gemAtLocation(testLoc1).ordinal();
        int piece2 = gameBoard.gemAtLocation(testLoc2).ordinal();
        gameBoard.swapPiecesWhenAcceptable(testLoc1, testLoc2);
        if (gameBoard.gemAtLocation(testLoc1).ordinal() == piece1){
            if (gameBoard.gemAtLocation(testLoc2).ordinal() == piece2){
                return true;
            }
        }
        return false;
    }
    // Requests for pieces off the board should return no swap
    private boolean task3Test4() {
        Board gameBoard = new Board();
        gameBoard.loadStaticBoard();
        int[] testLoc1 = {2,3};
        int[] testLoc2 = {6,-1};
        int piece1 = gameBoard.gemAtLocation(testLoc1).ordinal();
        try {
            gameBoard.swapPiecesWhenAcceptable(testLoc1, testLoc2);
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
    private boolean task3Test5() {
        Board gameBoard = new Board();
        gameBoard.loadStaticBoard();
        int[] testLoc1 = {7,7};
        int[] testLoc2 = {7,8};
        int piece1 = gameBoard.gemAtLocation(testLoc1).ordinal();
        try {
            gameBoard.swapPiecesWhenAcceptable(testLoc2, testLoc1);
            if (gameBoard.gemAtLocation(testLoc1).ordinal() == piece1){
                return true;
            }
        }
        catch (Exception e){
            return false;
        }
        return false;
    }

    // Adjacent (horizontal?) swaps that don't make a chain should not swap with the task 3 function
    private boolean task3Test6() {
        Board gameBoard = new Board();
        gameBoard.loadStaticBoard();
        int[] testLoc1 = {0,0};
        int[] testLoc2 = {0,1};
        int piece1 = gameBoard.gemAtLocation(testLoc1).ordinal();
        int piece2 = gameBoard.gemAtLocation(testLoc2).ordinal();
        gameBoard.swapPiecesWhenAcceptable(testLoc1, testLoc2);
        if (gameBoard.gemAtLocation(testLoc1).ordinal() == piece1){
            if (gameBoard.gemAtLocation(testLoc2).ordinal() == piece2){
                return true;
            }
        }
        return false;
    }

 // Adjacent (vertical?) swaps that don't make a chain should not swap with the task 3 function
    private boolean task3Test7() {
        Board gameBoard = new Board();
        gameBoard.loadStaticBoard();
        int[] testLoc1 = {5,4};
        int[] testLoc2 = {6,4};
        int piece1 = gameBoard.gemAtLocation(testLoc1).ordinal();
        int piece2 = gameBoard.gemAtLocation(testLoc2).ordinal();
        gameBoard.swapPiecesWhenAcceptable(testLoc1, testLoc2);
        if (gameBoard.gemAtLocation(testLoc1).ordinal() == piece1){
            if (gameBoard.gemAtLocation(testLoc2).ordinal() == piece2){
                return true;
            }
        }
        return false;
    }

    protected void runEvaluations() {
        System.out.println("task1Test1 pass?: " + task1Test1());
        System.out.println("task1Test2 pass?: " + task1Test2());
        System.out.println("task1Test3 pass?: " + task1Test3());
        System.out.println("task1Test4 pass?: " + task1Test4());
        System.out.println("task1Test5 pass?: " + task1Test5());
        System.out.println("task2Test1 pass?: " + task2Test1());
        System.out.println("task2Test2 pass?: " + task2Test2());
        System.out.println("task2Test3 pass?: " + task2Test3());
        System.out.println("task3Test1 pass?: " + task3Test1());
        System.out.println("task3Test2 pass?: " + task3Test2());
        System.out.println("task3Test3 pass?: " + task3Test3());
        System.out.println("task3Test4 pass?: " + task3Test4());
        System.out.println("task3Test5 pass?: " + task3Test5());
        System.out.println("task3Test6 pass?: " + task3Test6());
        System.out.println("task3Test7 pass?: " + task3Test7());
    }
}
