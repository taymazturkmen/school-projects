package ex02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


class NgramsTest {
    @Test
    @Order(1)
    void test() {

        try {
            Character[] chars = {'A', 'E', 'B', 'E', 'D'};
            Ngrams ngram = new Ngrams(chars);
            assertEquals(2, ngram.solve(3));
            assertEquals(1, ngram.solve(2));

            Character[] chars2 = {'A', 'E', 'B', 'E', 'D', 'E', 'E', 'A'};
            Ngrams ngram2 = new Ngrams(chars2);
            assertEquals(3, ngram2.solve(4));
        } catch (Exception e) {
            fail();
        }
    }
}