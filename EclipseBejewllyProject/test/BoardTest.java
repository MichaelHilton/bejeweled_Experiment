import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class BoardTest {
    
    public static void main(String[] args) {
        JUnitCore junit = new JUnitCore();
        Result result = junit.run(BoardTest.class);
        System.out.println(result);
    }
    
    private Board board;
    
    @Before
    public void before() {
        board = new Board();
        board.loadStaticBoard();       
    }
    
    @Test
    public void testSwap() {
        int[] loc1 = new int[]{2,3};
        int[] loc2 = new int[]{2,4};
        Piece before1 = board.gemAtLocation(loc1);
        Piece before2 = board.gemAtLocation(loc2);
        
        board.swapAnyTwoPieces(loc1, loc2);
        
        Piece after1 = board.gemAtLocation(loc1);
        Piece after2 = board.gemAtLocation(loc2);
        
        assertEquals(before1, after2);
        assertEquals(before2, after1);
    }        
}
