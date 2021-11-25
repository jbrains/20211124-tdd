package ca.jbrains.math.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddFractionsTest {
    @Test
    void zeroPlusZero() {
        Fraction sum = new Fraction(0).plus(new Fraction(0));
        Assertions.assertEquals(0, sum.intValue());
    }

    @Test
    void notZeroPlusZero() {
        Fraction sum = new Fraction(7).plus(new Fraction(0));
        Assertions.assertEquals(7, sum.intValue());
    }

    private static class Fraction {
        private int integerValue;

        public Fraction(int integerValue) {
            this.integerValue = integerValue;
        }

        public Fraction plus(Fraction fraction) {
            return this;
        }

        public int intValue() {
            return integerValue;
        }
    }
}
