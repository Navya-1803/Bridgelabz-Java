package Multithreading;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class SimpleThreadedCounterTest {

    @Test
    void shouldCountFromOneToLimit() {

        List<Integer> result =
                SimpleThreadedCounter.countNumbers(10, 3);

        assertEquals(
                IntStream.rangeClosed(1, 10).boxed().toList(),
                result
        );
    }

    @Test
    void shouldCountWithOneThread() {

        List<Integer> result =
                SimpleThreadedCounter.countNumbers(5, 1);

        assertEquals(List.of(1, 2, 3, 4, 5), result);
    }

    @Test
    void shouldHandleMoreThreadsThanNumbers() {

        List<Integer> result =
                SimpleThreadedCounter.countNumbers(3, 5);

        assertEquals(List.of(1, 2, 3), result);
    }

    @Test
    void shouldRejectZeroLimit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> SimpleThreadedCounter.countNumbers(0, 3)
        );
    }

    @Test
    void shouldRejectNegativeLimit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> SimpleThreadedCounter.countNumbers(-5, 2)
        );
    }

    @Test
    void shouldRejectZeroThreads() {

        assertThrows(
                IllegalArgumentException.class,
                () -> SimpleThreadedCounter.countNumbers(10, 0)
        );
    }
}
