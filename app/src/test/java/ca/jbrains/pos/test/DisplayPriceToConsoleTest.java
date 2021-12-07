package ca.jbrains.pos.test;

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
}
