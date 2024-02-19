import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testZavd1() {
        String[] expected = {"0ax", "0ay", "0az", "0bx", "0by", "0bz", "0cx", "0cy", "0cz", "1ax", "1ay", "1az", "1bx", "1by", "1bz", "1cx", "1cy", "1cz"};
        Assert.assertArrayEquals(expected, zavd1());
    }

    public static String[] zavd1() {
        char[] A = {'a', 'b', 'c'};
        char[] B = {'x', 'y', 'z'};
        char[] C = {'0', '1'};
        String[] D = new String[18];
        int j = 0;

        for (int ic = 0; ic < C.length; ic++) {
            for (int ia = 0; ia < A.length; ia++) {
                for (int ib = 0; ib < B.length; ib++) {
                    D[j] = "" + C[ic] + A[ia] + B[ib];
                    j++;
                }
            }
        }

        return D;
    }

    @Test
    public void testZavd2() {

        int[][] results = Main.zavd2();

        // Перевіряємо очікувані результати
        int[] expectedAbit = {1, 1, 0, 0, 0};
        int[] expectedBbit = {0, 1, 1, 1, 0};
        int[] expectedNotA = {0, 0, 1, 1, 1};
        int[] expectedAandB = {0, 1, 0, 0, 0};
        int[] expectedAorB = {1, 1, 1, 1, 0};
        int[] expectedAdiffB = {1, 0, 0, 0, 0};
        int[] expectedAxorB = {1, 0, 1, 1, 0};

        assertArrayEquals(expectedAbit, results[0]);
        assertArrayEquals(expectedBbit, results[1]);
        assertArrayEquals(expectedNotA, results[2]);
        assertArrayEquals(expectedAandB, results[3]);
        assertArrayEquals(expectedAorB, results[4]);
        assertArrayEquals(expectedAdiffB, results[5]);
        assertArrayEquals(expectedAxorB, results[6]);
    }
}