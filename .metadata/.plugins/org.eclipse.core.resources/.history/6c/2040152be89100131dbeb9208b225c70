import java.util.Arrays;

class BejewellyUtils {

  public static int[] concatAll(int[] first, int[]... rest) {
    int totalLength = first.length;
    for (int[] array : rest) {
      totalLength += array.length;
    }
    int[] result = Arrays.copyOf(first, totalLength);
    int offset = first.length;
    for (int[] array : rest) {
      System.arraycopy(array, 0, result, offset, array.length);
      offset += array.length;
    }
    return result;
  }

  public static int[][] concatAll(int[][] first, int[][]... rest) {
    int totalLength = first.length;
    for (int[][] array : rest) {
      totalLength += array.length;
    }
    int[][] result = Arrays.copyOf(first, totalLength);
    int offset = first.length;
    for (int[][] array : rest) {
      System.arraycopy(array, 0, result, offset, array.length);
      offset += array.length;
    }
    return result;
  }

  public static <T> T[] concatAll(T[] first, T[]... rest) {
    int totalLength = first.length;
    for (T[] array : rest) {
      totalLength += array.length;
    }
    T[] result = Arrays.copyOf(first, totalLength);
    int offset = first.length;
    for (T[] array : rest) {
      System.arraycopy(array, 0, result, offset, array.length);
      offset += array.length;
    }
    return result;
  }

  public static int[] joinArrays(int[] x, int[] y) {
    int[] arr = new int[x.length + y.length];
    System.arraycopy(x, 0, arr, 0, x.length);
    System.arraycopy(y, 0, arr, x.length, y.length);
    return arr;
  }

  public static int[] addPostions(int[] x, int[] y){  
    int[] sequence = new int[x.length];
    for(int i = x.length-1; i >= 0; i--){ 
       int addResult = y[i] + x[i];  
       sequence[i] = addResult;
    }
    return sequence;
  }  
}