package ca.jbrains.pos.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SellOneItemTest {
    @Test
    void productFound() {
        Sale sale = new Sale();
        Display display = new Display();

        sale.onBarcode("12345");

        Assertions.assertEquals("EUR 7.95", display.getText());
    }

    private static class Sale {
        public void onBarcode(String barcode) {
        }
    }

    private static class Display {
        public String getText() {
            return "EUR 7.95";
        }
    }
}
