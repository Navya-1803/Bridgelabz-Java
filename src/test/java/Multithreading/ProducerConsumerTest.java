package Multithreading;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ProducerConsumerTest {

    @Test
    void shouldProduceAndConsumeAllTasks() {

        ProducerConsumer.Result result =
                ProducerConsumer.execute(10, 3);

        assertEquals(10, result.getProducedTasks().size());
        assertEquals(10, result.getConsumedTasks().size());
    }

    @Test
    void shouldProduceTasksInCorrectOrder() {

        ProducerConsumer.Result result =
                ProducerConsumer.execute(5, 2);

        assertEquals(
                List.of(1, 2, 3, 4, 5),
                result.getProducedTasks()
        );
    }

    @Test
    void shouldConsumeAllProducedTasks() {

        ProducerConsumer.Result result =
                ProducerConsumer.execute(5, 2);

        assertEquals(
                result.getProducedTasks(),
                result.getConsumedTasks()
        );
    }

    @Test
    void shouldHandleZeroTasks() {

        ProducerConsumer.Result result =
                ProducerConsumer.execute(0, 2);

        assertTrue(result.getProducedTasks().isEmpty());
        assertTrue(result.getConsumedTasks().isEmpty());
    }

    @Test
    void shouldHandleSingleTask() {

        ProducerConsumer.Result result =
                ProducerConsumer.execute(1, 1);

        assertEquals(List.of(1), result.getProducedTasks());
        assertEquals(List.of(1), result.getConsumedTasks());
    }

    @Test
    void shouldRejectNegativeTaskCount() {

        assertThrows(
                IllegalArgumentException.class,
                () -> ProducerConsumer.execute(-5, 2)
        );
    }

    @Test
    void shouldRejectInvalidQueueCapacity() {

        assertThrows(
                IllegalArgumentException.class,
                () -> ProducerConsumer.execute(5, 0)
        );
    }
}
