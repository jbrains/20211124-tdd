package ca.jbrains.math.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddFractionsTest {
    @Test
    void zeroPlusZero() {
        Assertions.assertEquals(new Fraction(0), new Fraction(0).plus(new Fraction(0)));
    }

    @Test
    void notZeroPlusZero() {
        Assertions.assertEquals(new Fraction(7), new Fraction(7).plus(new Fraction(0)));
    }

    @Test
    void zeroPlusNotZero() {
        Assertions.assertEquals(new Fraction(12), new Fraction(0).plus(new Fraction(12)));
    }

    @Test
    void notZeroPlusNotZero() {
        Assertions.assertEquals(new Fraction(9), new Fraction(3).plus(new Fraction(6)));
    }

    @Test
    void sameDenominator() {
        Assertions.assertEquals(
                new Fraction(3, 5),
                new Fraction(1, 5).plus(new Fraction(2, 5)));
    }

    @Test
    void oneDenominatorIsAMultipleOfTheOther() {
        Assertions.assertEquals(
                new Fraction(3, 8),
                new Fraction(1, 4).plus(new Fraction(1, 8)));
    }

    @Test
    void denominatorsHaveAComonFactor() {
        Assertions.assertEquals(
                new Fraction(31, 36),
                new Fraction(7, 12).plus(new Fraction(5, 18)));
    }

    @Test
    void denominatorsAreRelativelyPrime() {
        Assertions.assertEquals(
                new Fraction(31, 40),
                new Fraction(2, 5).plus(new Fraction(3, 8)));
    }

    private static class Fraction {
        private int numerator;
        private int denominator;

        public Fraction(int integerValue) {
            this(integerValue, 1);
        }

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public Fraction plus(Fraction that) {
            if (this.denominator == that.denominator)
                return new Fraction(this.numerator + that.numerator, this.denominator);
            else
                return new Fraction(
                        this.numerator * that.denominator + that.numerator * this.denominator,
                        this.denominator * that.denominator);
        }

        @Override
        public boolean equals(Object other) {
            if (other instanceof Fraction) {
                Fraction that = (Fraction) other;
                return this.numerator * that.denominator == this.denominator * that.numerator;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return 0;
        }

        @Override
        public String toString() {
            return String.format("%d/%d", numerator, denominator);
        }
    }
}
