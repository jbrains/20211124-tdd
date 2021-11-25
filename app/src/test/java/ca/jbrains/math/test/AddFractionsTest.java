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

    @Test
    void zeroPlusNotZero() {
        Fraction sum = new Fraction(0).plus(new Fraction(12));
        Assertions.assertEquals(12, sum.intValue());
    }

    @Test
    void notZeroPlusNotZero() {
        Fraction sum = new Fraction(3).plus(new Fraction(6));
        Assertions.assertEquals(9, sum.intValue());
    }

    @Test
    void sameDenominator() {
        Fraction sum = new Fraction(1, 5).plus(new Fraction(2, 5));
        Assertions.assertEquals(3, sum.getNumerator());
        Assertions.assertEquals(5, sum.getDenominator());
    }

    private static class Fraction {
        private int integerValue;
        private int numerator;
        private int denominator;

        public Fraction(int integerValue) {
            this.integerValue = integerValue;
        }

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public Fraction plus(Fraction that) {
            if (this.denominator == 0)
                return new Fraction(this.integerValue + that.integerValue);
            else
                return new Fraction(this.numerator + that.numerator, this.denominator);
        }

        public int intValue() {
            return integerValue;
        }

        public int getNumerator() {
            return numerator;
        }

        public int getDenominator() {
            return denominator;
        }
    }
}
