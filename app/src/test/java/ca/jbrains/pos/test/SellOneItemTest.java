package ca.jbrains.pos.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SellOneItemTest {
    @Test
    void productFound() {
        Display display = new Display();
        Sale sale = new Sale(display, new HashMap<>() {{
            put("12345", "EUR 7.95");
            put("23456", "EUR 12.50");
        }});

        sale.onBarcode("12345");

        Assertions.assertEquals("EUR 7.95", display.getText());
    }

    @Test
    void anotherProductFound() {
        Display display = new Display();
        Sale sale = new Sale(display, new HashMap<>() {{
            put("12345", "EUR 7.95");
            put("23456", "EUR 12.50");
        }});

        sale.onBarcode("23456");

        Assertions.assertEquals("EUR 12.50", display.getText());
    }

    @Test
    void productNotFound() {
        Display display = new Display();
        Sale sale = new Sale(display, Collections.emptyMap());

        sale.onBarcode("99999");

        Assertions.assertEquals("Product not found: 99999", display.getText());
    }

    @Test
    void emptyBarcode() {
        Display display = new Display();
        Sale sale = new Sale(display, null);

        sale.onBarcode("");

        Assertions.assertEquals("Scanning error: empty barcode", display.getText());
    }

    private static class Sale {
        private final Map<String, String> pricesByBarcode;
        private Display display;

        private Sale(Display display, Map<String, String> pricesByBarcode) {
            this.display = display;
            this.pricesByBarcode = pricesByBarcode;
        }

        public void onBarcode(String barcode) {
            if ("".equals(barcode))
                // SMELL This path ignores the pricesByBarcode, so why is it here?!
                display.setText("Scanning error: empty barcode");
            else if (pricesByBarcode.containsKey(barcode))
                display.setText(pricesByBarcode.get(barcode));
            else
                display.setText(String.format("Product not found: %s", barcode));
        }
    }

    private static class Display {
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
