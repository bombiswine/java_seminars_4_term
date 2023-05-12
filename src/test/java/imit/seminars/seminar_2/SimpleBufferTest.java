package imit.seminars.seminar_2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SimpleBufferTest {
    @Test
    public static void simpleBufferIsEmpty_ReturnsTrue_thenCorrect_test() {
        final SimpleBuffer<Integer> intBuff = new SimpleBuffer<>();
        assertTrue(intBuff.isEmpty());

        intBuff.add(5);
        intBuff.add(5);
        intBuff.add(5);
        intBuff.add(5);
        intBuff.clear();
        assertTrue(intBuff.isEmpty());
    }

    @Test
    public static void simpleBufferGetElement_returnsValue_thenCorrect_test() {
        final SimpleBuffer<Integer> intBuff = new SimpleBuffer<>();
        final int BUFF_SIZE = 10;
        for (int i = 0; i < BUFF_SIZE; i++) {
            intBuff.add(i);
        }
        for (int i = 0; i < BUFF_SIZE; i++) {
            assertEquals(intBuff.get(), i);
        }
    }

    @Test(dataProvider = "simpleBufferGetSize_returnsProperSize_thenCorrect_data")
    public static void simpleBufferGetSize_returnsProperSize_thenCorrect_test(
        final SimpleBuffer<Integer> intBuff,
        final int expectedSize
    ) {
        assertEquals(intBuff.getSize(), expectedSize);
    }

    @DataProvider
    public static Object[][] simpleBufferGetSize_returnsProperSize_thenCorrect_data() {
        final SimpleBuffer<Integer> buff1 = new SimpleBuffer<>();
        final int BUFF_1_SIZE = 10;
        for (int i = 0; i < BUFF_1_SIZE; i++) {
            buff1.add(i);
        }

        return new Object[][] {
            { buff1, BUFF_1_SIZE },
            { new SimpleBuffer<>(), 0 },
        };
    }
}
