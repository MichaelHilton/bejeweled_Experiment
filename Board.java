import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


class Board {
  public Piece[][] boardGrid;
  public BejeweledScore scoreBoard;
  private int BOARD_SIZE = 8;
  private int[][] walkRow = {{1,0},{-1,0}};
  private int[][] walkColumn = {{0,1},{0,-1}};
  public Board(){
    this.boardGrid = new Piece[BOARD_SIZE][BOARD_SIZE];
    this.scoreBoard = new BejeweledScore();
    loadNewBoard();
  }

  ///////////////////////////
  // Participant-defined functions
  
  public void swapAnyTwoPieces(int[] piece_a, int[] piece_b){
      Piece temp_a = this.boardGrid[piece_a[0]][piece_a[1]];
      this.boardGrid[piece_a[0]][piece_a[1]] = this.boardGrid[piece_b[0]][piece_b[1]];
      this.boardGrid[piece_b[0]][piece_b[1]] = temp_a;
  }

  public Boolean wasSequenceCreated(){
      // Left
      for (int i = 2; i < 8; i++){
          for (int j = 0; j < 8; j++){
              if (this.boardGrid[i][j] == this.boardGrid[i-1][j]){
                  if (this.boardGrid[i][j] == this.boardGrid[i-2][j]){
                      return true;
                  }
              }
          }
      }
      //System.out.println("Left completed");
      // Right
      for (int i = 0; i < 6; i++){
          for (int j = 0; j < 8; j++){
              if (this.boardGrid[i][j] == this.boardGrid[i+1][j]){
                  if (this.boardGrid[i][j] == this.boardGrid[i+2][j]){
                      return true;
                  }
              }
          }
      }
      //System.out.println("Right completed");
      // Up
      for (int i = 0; i < 8; i++){
          for (int j = 2; j < 8; j++){
              if (this.boardGrid[i][j] == this.boardGrid[i][j-1]){
                  if (this.boardGrid[i][j] == this.boardGrid[i][j-2]){
                      return true;
                  }
              }
          }
      }
      //System.out.println("Up completed");
      // Down
      for (int i = 0; i < 8; i++){
          for (int j = 0; j < 6; j++){
              if (this.boardGrid[i][j] == this.boardGrid[i][j+1]){
                  if (this.boardGrid[i][j] == this.boardGrid[i][j+2]){
                      return true;
                  }
              }
          }
      }
      //System.out.println("Down completed");
      return false;
  }
  
  public void swapPiecesWhenAcceptable(int[] piece_a, int[] piece_b){
      swapAnyTwoPieces(piece_a, piece_b);
      if (!wasSequenceCreated()){
          swapAnyTwoPieces(piece_a,piece_b);
      } else {
          
      }
  }
  
  
  
  
  
  
  
  public Piece gemAtLocation(String piece){
    int[] array_coords = getCoordinates(piece);
    int y = array_coords[0];
    int x = array_coords[1];
    System.out.println("Piece at x: " + x + " y: " + y);
    System.out.println("Gem is: " + this.boardGrid[y][x]);
    return this.boardGrid[y][x];
  }  

  public Piece gemAtLocation(int[] piece){
    int y = piece[0];
    int x = piece[1];
    System.out.println("Piece at x: " + x + " y: " + y);
    System.out.println("Gem is: " + this.boardGrid[y][x]);
    return this.boardGrid[y][x];
  }

  ///////////////////////
  // Swap piece functions
  public Boolean swapPieces(int[] piece_a, int[] piece_b){
    if (piece_a == piece_b) {
      return false;
    }
    locationSwap(piece_a, piece_b);
    if (clearSequences(piece_b, piece_a)){
      return true;
    }
    locationSwap(piece_b, piece_a);
    return false;
  }
  public int[] temporarilySwapAndCheckPieces(int[] piece_a, int[] piece_b){
    if (piece_a == piece_b) {
      return null;
    }
    locationSwap(piece_a, piece_b);
    if (hasSequence(piece_b)){
      locationSwap(piece_b, piece_a);
      return piece_b;
    }
    if (hasSequence(piece_a)){
      locationSwap(piece_b, piece_a);
      return piece_a;
    }
    locationSwap(piece_b, piece_a);
    return null;
  }  
  public void locationSwap(int[] piece_a, int[] piece_b){
    Piece temp_a = this.boardGrid[piece_a[0]][piece_a[1]];
    this.boardGrid[piece_a[0]][piece_a[1]] = this.boardGrid[piece_b[0]][piece_b[1]];
    this.boardGrid[piece_b[0]][piece_b[1]] = temp_a;
  }
  ///////////////////////
  
  ////////////////////////////
  // Console/Display functions
  public void clearScreen(){
    System.out.println("\033[H\033[2J"); // Clears terminal
  }
  public void displayBoard(){
    //System.out.println("      You're playing Bejwelly...");
      System.out.println("--+---+---+---+---+---+---+---+---+");
    //System.out.println("      Current Score: " + this.scoreBoard.getScore());
    StringBuilder topRow = new StringBuilder();
    topRow.append("  ");
    for (int i = 0; i < BOARD_SIZE; i++) {
      //topRow.append("| " + (i + 1) + " ");
        topRow.append("| " + (i) + " ");
    }
    topRow.append("|");
    System.out.println(topRow.toString());
    for (int i = 0; i < BOARD_SIZE; i++) {
      StringBuilder sb = new StringBuilder();
      //sb.append(getCharForNumber(i + 1) + " |");
      sb.append(i + " |");
      for (int j = 0; j < BOARD_SIZE; j++) {
        // String[] boadGrid = this.boardGrid.get(i).toArray(new String[this.boardGrid.get(i).size()]);
        // System.out.println(Arrays.toString(boadGrid));
        sb.append(" " + this.boardGrid[i][j].value + " ");
        sb.append("|");
      }
      System.out.println(sb.toString());
    }
  }
  public void printInstructions(){
    System.out.println("- Instructions:");
    System.out.println("- For each gem greater than 3 in a chain it becomes");
    System.out.println("- a multiplier. e.g. a 4 gem chain means the score is multiplied");
    System.out.println("- by 2, 5 gem chain means score is multiplied by 3 and so on...");
    System.out.println("- Type HELP at any point to see this again.");
    System.out.println("- Type RELOAD at any point to start over.");
    System.out.println("- Type CHECK to see if there are still available moves.");
    System.out.println("- Type HINT to see an available move");
    System.out.println("- Type QUIT to exit.");
  }
  public void promptUser(){
    Console console = System.console();
    String selected_piece = console.readLine("Which piece would you like to move? (e.g 1A) ");
    if (selected_piece.contains("*")){
      selected_piece = selected_piece.replace("*", "");
      int[] piece_array = getCoordinates(selected_piece);
      System.out.println("Piece at " + selected_piece + " is " + this.boardGrid[piece_array[0]][piece_array[1]]);
      promptUser();
    }
    Boolean hadKeywords = checkForKeyWords(selected_piece);
    char[] input_array = selected_piece.toCharArray();
    if (!isValidEntry(input_array) && !hadKeywords){
      System.out.println("Is not a valid entry");
      promptUser();
    }
    String direction_input = console.readLine("In which direction to swap? (U,D,L,R) ");
    Boolean hadDirectionKeywords = checkForKeyWords(direction_input);
    if (hadDirectionKeywords){
      promptUser();
    }
    char[] direction_input_array = direction_input.toCharArray();
    int[] piece_array = getCoordinates(selected_piece);
    int[] swapping_piece = getSwappingPiece(direction_input, piece_array);
    if (swapping_piece != null){
      int previousScore = this.scoreBoard.getScore();
      Boolean did_swap = swapPieces(piece_array, swapping_piece);
      if (did_swap){
        clearScreen();
        displayBoard();
        int newScore = this.scoreBoard.getScore();
        int turnScore = newScore - previousScore;
        System.out.println("YAY! You've made a chain. " + turnScore + " points.");
      } else {
        System.out.println("No chain to be had. Swapping back.");
      }
      promptUser();
    } else {
      System.out.println("Is not a valid move");
      promptUser();
    }
  }
  private Boolean checkForKeyWords(String input){
      if (input.contains("HELP") || input.contains("help")){
        clearScreen();
        displayBoard();
        printInstructions();
        promptUser();
        return true;
      }
      if (input.contains("RELOAD") || input.contains("reload")){
        this.scoreBoard.resetScore();
        loadNewBoard();
        clearScreen();
        displayBoard();
        promptUser();
        return true;
      }
      if (input.contains("CHECK") || input.contains("check")){
        int[] checkArray = areMovesStillAvailable();
        if (checkArray != null && checkArray.length > 0){
          System.out.println("There are indeed still moves available.");
        } else {
          System.out.println("There are no more moves available. Feel free to RELOAD.");
        }
        return true;
      }
      if (input.contains("HINT") || input.contains("hint")){
        int[] checkArray = areMovesStillAvailable();
        if (checkArray != null && checkArray.length > 0){
          System.out.println("A sequence can be made if " + (checkArray[1]+1) + getCharForNumber(checkArray[0]+1) + " is swapped");
        } else {
          System.out.println("There are no more moves available. Feel free to RELOAD.");
        }
        return true;
      }
      if (input.contains("QUIT") || input.contains("quit")){
        System.exit(0);
        return true;
      }
      return false;
    }
  ////////////////////////////
  
  private void loadNewBoard(){
    for (int i = 0; i < BOARD_SIZE; i++) {
      for (int j = 0; j < BOARD_SIZE; j++) {
        addRandomPieceAtLocation(i,j);
      }
    }
  }
  protected void loadBoardTask1(){
//      for (int i = 0; i < BOARD_SIZE; i++) {
//        for (int j = 0; j < BOARD_SIZE; j++) {
//            addPieceToBoardTheSameWay(i,j);
//        }
//      }
      Piece[] array1 = {
              Piece.values()[4],
              Piece.values()[3],
              Piece.values()[2],
              Piece.values()[7],
              Piece.values()[4],
              Piece.values()[1],
              Piece.values()[7],
              Piece.values()[2]};
      this.boardGrid[0] = array1;
      
      Piece[] array2 = {
              Piece.values()[6],
              Piece.values()[4],
              Piece.values()[7],
              Piece.values()[7],
              Piece.values()[1],
              Piece.values()[5],
              Piece.values()[6],
              Piece.values()[2]};
      this.boardGrid[1] = array2;
      
      Piece[] array3 = {
              Piece.values()[4],
              Piece.values()[1],
              Piece.values()[6],
              Piece.values()[2],
              Piece.values()[7],
              Piece.values()[3],
              Piece.values()[3],
              Piece.values()[7]};
      this.boardGrid[2] = array3;
      
      Piece[] array4 = {
              Piece.values()[3],
              Piece.values()[1],
              Piece.values()[2],
              Piece.values()[5],
              Piece.values()[4],
              Piece.values()[3],
              Piece.values()[4],
              Piece.values()[7]};
      this.boardGrid[3] = array4;
      
      Piece[] array5 = {
              Piece.values()[7],
              Piece.values()[5],
              Piece.values()[3],
              Piece.values()[1],
              Piece.values()[2],
              Piece.values()[6],
              Piece.values()[2],
              Piece.values()[4]};
      this.boardGrid[4] = array5;
      
      Piece[] array6 = {                  
              Piece.values()[4],
              Piece.values()[1],
              Piece.values()[6],
              Piece.values()[1],
              Piece.values()[1],
              Piece.values()[4],
              Piece.values()[3],
              Piece.values()[1]
      };
      this.boardGrid[5] = array6;
      
      Piece[] array7 = {
              Piece.values()[6],
              Piece.values()[5],
              Piece.values()[4],
              Piece.values()[6],
              Piece.values()[4],
              Piece.values()[3],
              Piece.values()[4],
              Piece.values()[6]};
      this.boardGrid[6] = array7;
      
      Piece[] array8 = {
              Piece.values()[3],
              Piece.values()[6],
              Piece.values()[6],
              Piece.values()[4],
              Piece.values()[2],
              Piece.values()[2],
              Piece.values()[3],
              Piece.values()[3]};
      this.boardGrid[7] = array8;
    }
  private void addPieceToBoardTheSameWay(int i, int j){
      Random randomPiece = new Random();
      int gemInt = randomPiece.nextInt(BOARD_SIZE-1) + 1;
      this.boardGrid[i][j] = Piece.values()[2];
      int[] newPieceArray = {i,j};
      if (hasSequence(newPieceArray)){
          //addPieceToBoardTheSameWay(i,j);
      } else {
        return;
      }
    }
  private void addRandomPieceAtLocation(int i, int j){
    Random randomPiece = new Random();
    int gemInt = randomPiece.nextInt(BOARD_SIZE-1) + 1;
    this.boardGrid[i][j] = Piece.values()[gemInt];
    int[] newPieceArray = {i,j};
    if (hasSequence(newPieceArray)){
      addRandomPieceAtLocation(i,j);
    } else {
      return;
    }
  }

  private Boolean hasSequence(int[] currentLocation){
    HashMap<String, int[][]> resultHash = getSequences(currentLocation);
    if (resultHash.get("row").length > 2 || resultHash.get("col").length > 2){
      return true;
    } else {
      return false;
    }
  }

  private Boolean checkAndClear(HashMap<String, int[][]> sequence){
    String[] keys = {"row","col"};
    Boolean hasSufficientLength = false;
    for (String key : keys){
      if (sequence.get(key).length > 2 ){
        for(int[] pieceAt : sequence.get(key)){
          removePiece(pieceAt);
        }
        this.scoreBoard.addToScore(sequence.get(key).length);
        if (!hasSufficientLength){
          hasSufficientLength = true;
        }
        checkSequenceAfterRemoval(sequence.get(key));
      }
    }
    if (hasSufficientLength){
      return true;
    } else {
      return false;
    }
  }

  private void checkSequenceAfterRemoval(int[][] sequence){
    for (int[] location : sequence){
      HashMap<String, int[][]> current_sequence = getSequences(location);
      Boolean requiredClearing = checkAndClear(current_sequence);
    }
  }

  private Boolean clearSequences(int[] piece_a, int[] piece_b){
    HashMap<String, int[][]> pc_a_sqs = getSequences(piece_a);
    HashMap<String, int[][]> pc_b_sqs = getSequences(piece_b);
    Boolean a_sequences = checkAndClear(pc_a_sqs);
    Boolean b_sequences = checkAndClear(pc_b_sqs);
    if (a_sequences || b_sequences){
      return true;
    } else {
      return false;
    }
  }

  ////////////////////////
  // Remove/Replace pieces
  private void removePiece(int[] pieceAt)
  {
    this.boardGrid[pieceAt[0]][pieceAt[1]] = Piece.BLANK;
    fillInGap(pieceAt);
  }
  private void fillInGap(int[] pieceAt)
  {
    if(pieceAt[0] == 0)
    {
      addRandomPieceAtLocation(pieceAt[0],pieceAt[1]);
    }
    else
    {
      int[] coordinatesAbove = {pieceAt[0]-1, pieceAt[1]};
      Piece pieceAbove = this.boardGrid[coordinatesAbove[0]][coordinatesAbove[1]];
      this.boardGrid[coordinatesAbove[0]][coordinatesAbove[1]] = Piece.BLANK;
      this.boardGrid[pieceAt[0]][pieceAt[1]] = pieceAbove;
      removePiece(coordinatesAbove);
    }
  }
  ////////////////////////
  
  

  private int[] areMovesStillAvailable(){
    String[] directions = {"U","D","L","R"};
    for (int i = 0; i < BOARD_SIZE; i++) {
      for (int j = 0; j < BOARD_SIZE; j++) {
        int[] currentLocation = {i,j};
        for (String direction : directions){
          int[] neighborPiece = getSwappingPiece(direction, currentLocation);
          if (neighborPiece != null){
            int[] pieceCanSequence = temporarilySwapAndCheckPieces(neighborPiece, currentLocation);
            if (pieceCanSequence != null && pieceCanSequence.length > 0){
              return currentLocation;
            }
          }
        }
      }
    }
    return null;
  }

  private int[] getSwappingPiece(String direction_input, int[] piece_array){
    if (direction_input.matches("[a-zA-Z]")){
      char direction = Character.toUpperCase(direction_input.charAt(0));
      int y = piece_array[0];
      int x = piece_array[1];
      // System.out.println("x is: " + x + " y: " + y);
      if (direction == 'U' && y > 0){
        int[] swapping_piece = {y-1, x};
        return swapping_piece;
      } else if (direction == 'D' && y < BOARD_SIZE-1) {
        int[] swapping_piece = {y+1, x};
        return swapping_piece;
      } else if (direction == 'L' && x > 0) {
        int[] swapping_piece = {y, x-1};
        return swapping_piece;
      } else if (direction == 'R' && x < BOARD_SIZE-1) {
        int[] swapping_piece = {y, x+1};
        return swapping_piece;
      }
    }
    return null;
  }
  
  
  
  private HashMap<String, int[][]> getSequences(int[] currentLocation){
    int[][] currentSequence = {currentLocation};
    HashMap<String, int[][]> directionalSequences = new HashMap<String, int[][]>();
    // Check horizontal 
    int[][] backwardRowDirection = walkChain(currentLocation, walkRow[0]);
    int[][] forwardRowDirection = walkChain(currentLocation, walkRow[1]);
    int[][] currentRowSequence = BejewellyUtils.concatAll(backwardRowDirection, currentSequence, forwardRowDirection);

    directionalSequences.put("row", currentRowSequence);
    // Check vertical
    int[][] backwardColDirection = walkChain(currentLocation, walkColumn[0]);
    int[][] forwardColDirection = walkChain(currentLocation, walkColumn[1]);
    int[][] currentColSequence = BejewellyUtils.concatAll(backwardColDirection, currentSequence, forwardColDirection);

    directionalSequences.put("col", currentColSequence);

    return directionalSequences;
  }
  
  private int[][] walkChain(int[] currentLocation, int[] vector){
    ArrayList<int[]> completedSequence = new ArrayList<int[]>();
    return walkChain(currentLocation, vector, completedSequence);
  }

  private int[][] walkChain(int[] currentLocation, int[] vector, ArrayList<int[]> completedSequence){
    Piece firstPiece = this.boardGrid[currentLocation[0]][currentLocation[1]];
    int[] nextLocation = BejewellyUtils.addPostions(currentLocation, vector);
    if (isWithinBounds(nextLocation)){
      Piece nextPiece = this.boardGrid[nextLocation[0]][nextLocation[1]];
      if (firstPiece == nextPiece){
        completedSequence.add(nextLocation);
        return walkChain(nextLocation, vector, completedSequence);
      }
    }
    int[][] sequence = new int[completedSequence.size()][];
    sequence = completedSequence.toArray(sequence);
    return sequence;
  }

  
  
  private Boolean isValidEntry(char[] input_array){
    if (input_array.length > 1){
      String firstPosition = Character.toString(input_array[0]);
      String secondPosition = Character.toString(input_array[1]);
      if (firstPosition.matches("[1-"+BOARD_SIZE+"]") && secondPosition.matches("[a-hA-H]")){
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  private int[] getCoordinates(String selected_piece){
    int x = Character.getNumericValue(selected_piece.charAt(0))-1;
    int y = getNumberForCharacter(Character.toUpperCase(selected_piece.charAt(1)))-1;
    int[] coordinate_array = {y,x};
    return coordinate_array;
  }

  private Boolean isWithinBounds(int[] piece_array){
    int y = piece_array[0];
    int x = piece_array[1];
    if (y >= 0 && y <= BOARD_SIZE-1 && x >= 0 && x <= BOARD_SIZE-1){
      return true;
    } else {
      return false;
    }
  }

  

  ////////////////////
  // Utility functions
  private String getCharForNumber(int i) {
    return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;
  }

  private int getNumberForCharacter(char value) {
    return (int)value-64;
  }

  ////////////////////
}

