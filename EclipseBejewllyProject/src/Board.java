import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class Board {
    public Piece[][] boardGrid;
    private int BOARD_SIZE = 8;
    private int[][] walkRow = { { 1, 0 }, { -1, 0 } };
    private int[][] walkColumn = { { 0, 1 }, { 0, -1 } };

    public Board() {
        this.boardGrid = new Piece[BOARD_SIZE][BOARD_SIZE];
        loadNewBoard();
    }

    // /////////////////////////
    // Participant-defined functions

    public void swapAnyTwoPieces(int[] piece_a, int[] piece_b) {
        Piece temp_a = this.boardGrid[piece_a[0]][piece_a[1]];
        this.boardGrid[piece_a[0]][piece_a[1]] = this.boardGrid[piece_b[0]][piece_b[1]];
        this.boardGrid[piece_b[0]][piece_b[1]] = temp_a;
    }

    public Boolean wasSequenceCreated() {
        // Left
        for (int i = 2; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.boardGrid[i][j] == this.boardGrid[i - 1][j]) {
                    if (this.boardGrid[i][j] == this.boardGrid[i - 2][j]) {
                        return true;
                    }
                }
            }
        }
        // System.out.println("Left completed");
        // Right
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.boardGrid[i][j] == this.boardGrid[i + 1][j]) {
                    if (this.boardGrid[i][j] == this.boardGrid[i + 2][j]) {
                        return true;
                    }
                }
            }
        }
        // System.out.println("Right completed");
        // Up
        for (int i = 0; i < 8; i++) {
            for (int j = 2; j < 8; j++) {
                if (this.boardGrid[i][j] == this.boardGrid[i][j - 1]) {
                    if (this.boardGrid[i][j] == this.boardGrid[i][j - 2]) {
                        return true;
                    }
                }
            }
        }
        // System.out.println("Up completed");
        // Down
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                if (this.boardGrid[i][j] == this.boardGrid[i][j + 1]) {
                    if (this.boardGrid[i][j] == this.boardGrid[i][j + 2]) {
                        return true;
                    }
                }
            }
        }
        // System.out.println("Down completed");
        return false;
    }

    public void swapPiecesWhenAcceptable(int[] piece_a, int[] piece_b) {
        swapAnyTwoPieces(piece_a, piece_b);
        if (!wasSequenceCreated()) {
            swapAnyTwoPieces(piece_a, piece_b);
        } else {

        }
    }

    public Piece gemAtLocation(int[] piece) {
        int y = piece[0];
        int x = piece[1];
        // System.out.println("Piece at x: " + x + " y: " + y);
        // System.out.println("Gem is: " + this.boardGrid[y][x]);
        return this.boardGrid[y][x];
    }

    // //////////////////////////
    // Console/Display functions
    public void displayBoard() {
        // System.out.println("      You're playing Bejwelly...");
        System.out.println("--+---+---+---+---+---+---+---+---+");
        // System.out.println("      Current Score: " +
        // this.scoreBoard.getScore());
        StringBuilder topRow = new StringBuilder();
        topRow.append("  ");
        for (int i = 0; i < BOARD_SIZE; i++) {
            // topRow.append("| " + (i + 1) + " ");
            topRow.append("| " + (i) + " ");
        }
        topRow.append("|");
        System.out.println(topRow.toString());
        for (int i = 0; i < BOARD_SIZE; i++) {
            StringBuilder sb = new StringBuilder();
            // sb.append(getCharForNumber(i + 1) + " |");
            // sb.append(i + " |");
            sb.append(getCharForNumber(i + 1) + " |");
            for (int j = 0; j < BOARD_SIZE; j++) {
                // String[] boadGrid = this.boardGrid.get(i).toArray(new
                // String[this.boardGrid.get(i).size()]);
                // System.out.println(Arrays.toString(boadGrid));
                sb.append(" " + this.boardGrid[i][j].value + " ");
                sb.append("|");
            }
            System.out.println(sb.toString());
        }
    }
    ////////////////////////////

    private void loadNewBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                addRandomPieceAtLocation(i, j);
            }
        }
    }

    protected void loadBoardTask1() {
        // for (int i = 0; i < BOARD_SIZE; i++) {
        // for (int j = 0; j < BOARD_SIZE; j++) {
        // addPieceToBoardTheSameWay(i,j);
        // }
        // }
        Piece[] array1 = { Piece.values()[4], Piece.values()[3],
                Piece.values()[2], Piece.values()[7], Piece.values()[4],
                Piece.values()[1], Piece.values()[7], Piece.values()[2] };
        this.boardGrid[0] = array1;

        Piece[] array2 = { Piece.values()[6], Piece.values()[4],
                Piece.values()[7], Piece.values()[7], Piece.values()[1],
                Piece.values()[5], Piece.values()[6], Piece.values()[2] };
        this.boardGrid[1] = array2;

        Piece[] array3 = { Piece.values()[4], Piece.values()[1],
                Piece.values()[6], Piece.values()[2], Piece.values()[7],
                Piece.values()[3], Piece.values()[3], Piece.values()[7] };
        this.boardGrid[2] = array3;

        Piece[] array4 = { Piece.values()[3], Piece.values()[1],
                Piece.values()[2], Piece.values()[5], Piece.values()[4],
                Piece.values()[3], Piece.values()[4], Piece.values()[7] };
        this.boardGrid[3] = array4;

        Piece[] array5 = { Piece.values()[7], Piece.values()[5],
                Piece.values()[3], Piece.values()[1], Piece.values()[2],
                Piece.values()[6], Piece.values()[2], Piece.values()[4] };
        this.boardGrid[4] = array5;

        Piece[] array6 = { Piece.values()[4], Piece.values()[1],
                Piece.values()[6], Piece.values()[1], Piece.values()[1],
                Piece.values()[4], Piece.values()[3], Piece.values()[1] };
        this.boardGrid[5] = array6;

        Piece[] array7 = { Piece.values()[6], Piece.values()[5],
                Piece.values()[4], Piece.values()[6], Piece.values()[4],
                Piece.values()[3], Piece.values()[4], Piece.values()[6] };
        this.boardGrid[6] = array7;

        Piece[] array8 = { Piece.values()[3], Piece.values()[6],
                Piece.values()[6], Piece.values()[4], Piece.values()[2],
                Piece.values()[2], Piece.values()[3], Piece.values()[3] };
        this.boardGrid[7] = array8;
    }

    private void addRandomPieceAtLocation(int i, int j) {
        Random randomPiece = new Random();
        int gemInt = randomPiece.nextInt(BOARD_SIZE - 1) + 1;
        this.boardGrid[i][j] = Piece.values()[gemInt];
        int[] newPieceArray = { i, j };
        if (hasSequence(newPieceArray)) {
            addRandomPieceAtLocation(i, j);
        } else {
            return;
        }
    }

    private Boolean hasSequence(int[] currentLocation) {
        HashMap<String, int[][]> resultHash = getSequences(currentLocation);
        if (resultHash.get("row").length > 2
                || resultHash.get("col").length > 2) {
            return true;
        } else {
            return false;
        }
    }
    
    private HashMap<String, int[][]> getSequences(int[] currentLocation) {
        int[][] currentSequence = { currentLocation };
        HashMap<String, int[][]> directionalSequences = new HashMap<String, int[][]>();
        // Check horizontal
        int[][] backwardRowDirection = walkChain(currentLocation, walkRow[0]);
        int[][] forwardRowDirection = walkChain(currentLocation, walkRow[1]);
        int[][] currentRowSequence = BejewellyUtils.concatAll(
                backwardRowDirection, currentSequence, forwardRowDirection);

        directionalSequences.put("row", currentRowSequence);
        // Check vertical
        int[][] backwardColDirection = walkChain(currentLocation, walkColumn[0]);
        int[][] forwardColDirection = walkChain(currentLocation, walkColumn[1]);
        int[][] currentColSequence = BejewellyUtils.concatAll(
                backwardColDirection, currentSequence, forwardColDirection);

        directionalSequences.put("col", currentColSequence);

        return directionalSequences;
    }

    private int[][] walkChain(int[] currentLocation, int[] vector) {
        ArrayList<int[]> completedSequence = new ArrayList<int[]>();
        return walkChain(currentLocation, vector, completedSequence);
    }

    private int[][] walkChain(int[] currentLocation, int[] vector,
            ArrayList<int[]> completedSequence) {
        Piece firstPiece = this.boardGrid[currentLocation[0]][currentLocation[1]];
        int[] nextLocation = BejewellyUtils
                .addPostions(currentLocation, vector);
        if (isWithinBounds(nextLocation)) {
            Piece nextPiece = this.boardGrid[nextLocation[0]][nextLocation[1]];
            if (firstPiece == nextPiece) {
                completedSequence.add(nextLocation);
                return walkChain(nextLocation, vector, completedSequence);
            }
        }
        int[][] sequence = new int[completedSequence.size()][];
        sequence = completedSequence.toArray(sequence);
        return sequence;
    }
    private Boolean isWithinBounds(int[] piece_array) {
        int y = piece_array[0];
        int x = piece_array[1];
        if (y >= 0 && y <= BOARD_SIZE - 1 && x >= 0 && x <= BOARD_SIZE - 1) {
            return true;
        } else {
            return false;
        }
    }
    // //////////////////
    // Utility functions
    private String getCharForNumber(int i) {
        return i > 0 && i < 27 ? String.valueOf((char) (i + 64)) : null;
    }

    private int getNumberForCharacter(char value) {
        return (int) value - 64;
    }

    // //////////////////
}
