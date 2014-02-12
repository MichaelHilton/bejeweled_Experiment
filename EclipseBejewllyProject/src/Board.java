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
    }

    // /////////////////////////
    // Participant-defined functions

    public void swapAnyTwoPieces(int[] piece_a, int[] piece_b) {
        Piece temp_a = this.boardGrid[piece_a[0]][piece_a[1]];
        this.boardGrid[piece_a[0]][piece_a[1]] = this.boardGrid[piece_b[0]][piece_b[1]];
        this.boardGrid[piece_b[0]][piece_b[1]] = temp_a;
    }

    public Boolean wasChainCreated() {
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
        if (!wasChainCreated()) {
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
    
    // This is a static board used for testing so we know the expected locations of gems
    protected void loadStaticBoard() {
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

    // //////////////////
    // Utility functions
    private String getCharForNumber(int i) {
        return i > 0 && i < 27 ? String.valueOf((char) (i + 64)) : null;
    }

    private int getNumberForCharacter(char value) {
        return (int) value - 64;
    }
}
