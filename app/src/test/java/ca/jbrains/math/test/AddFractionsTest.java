package ca.jbrains.math.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddFractionsTest {
    @Test
    void zeroPlusZero() {
        Fraction sum = new Fraction(0).plus(new Fraction(0));
        Assertions.assertEquals(0, sum.intValue());
    }

    private static class Fraction {
        public Fraction(int integerValue) {
        }

        public Fraction plus(Fraction fraction) {
            return new Fraction(-2837);
        }

        public int intValue() {
            return 0;
        }
    }
}
