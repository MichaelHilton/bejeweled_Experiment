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
        return gameBoard.wasSequenceCreated();
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

}
