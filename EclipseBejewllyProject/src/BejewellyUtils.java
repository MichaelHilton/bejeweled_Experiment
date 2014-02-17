import java.util.Arrays;

class BejewellyUtils {

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

    public static int[] addPostions(int[] x, int[] y) {
        int[] sequence = new int[x.length];
        for (int i = x.length - 1; i >= 0; i--) {
            int addResult = y[i] + x[i];
            sequence[i] = addResult;
        }
        return sequence;
    }
}