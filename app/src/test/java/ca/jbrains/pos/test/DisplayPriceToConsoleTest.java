package ca.jbrains.pos.test;

import ca.jbrains.pos.ConsoleDisplay;
import ca.jbrains.pos.Price;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.StringWriter;

public class DisplayPriceToConsoleTest {
    @Test
    void happyPath() {
        StringWriter canvas = new StringWriter();
        new ConsoleDisplay(canvas).displayPrice(Price.cents(795));
        Assertions.assertEquals("EUR 7.95\n", canvas.toString());
    }

    @Test
    void wholeNumberOfEuro() {
        StringWriter canvas = new StringWriter();
        new ConsoleDisplay(canvas).displayPrice(Price.cents(1200));
        Assertions.assertEquals("EUR 12.00\n", canvas.toString());
    }

    @Test
    void onlyOneTrailingZero() {
        StringWriter canvas = new StringWriter();
        new ConsoleDisplay(canvas).displayPrice(Price.cents(1870));
        Assertions.assertEquals("EUR 18.70\n", canvas.toString());
    }

    @Test
    void leadingZeroWhenThePriceIsLessThanOneEuro() {
        StringWriter canvas = new StringWriter();
        new ConsoleDisplay(canvas).displayPrice(Price.cents(59));
        Assertions.assertEquals("EUR 0.59\n", canvas.toString());
    }

    @Test
    void zeroEuro() {
        StringWriter canvas = new StringWriter();
        new ConsoleDisplay(canvas).displayPrice(Price.cents(0));
        Assertions.assertEquals("EUR 0.00\n", canvas.toString());
    }
}
