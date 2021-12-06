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
        Sale sale = new Sale(display, new Catalog(new HashMap<>() {{
            put("12345", "EUR 7.95");
            put("23456", "EUR 12.50");
        }}));

        sale.onBarcode("12345");

        Assertions.assertEquals("EUR 7.95", display.getText());
    }

    @Test
    void anotherProductFound() {
        Display display = new Display();
        Sale sale = new Sale(display, new Catalog(new HashMap<>() {{
            put("12345", "EUR 7.95");
            put("23456", "EUR 12.50");
        }}));

        sale.onBarcode("23456");

        Assertions.assertEquals("EUR 12.50", display.getText());
    }

    @Test
    void productNotFound() {
        Display display = new Display();
        Sale sale = new Sale(display, new Catalog(Collections.emptyMap()));

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
        private Catalog catalog;
        private Display display;

        private Sale(Display display, Catalog catalog) {
            this.display = display;
            this.catalog = catalog;
        }

        public void onBarcode(String barcode) {
            if ("".equals(barcode))
                // SMELL This path ignores the pricesByBarcode, so why is it here?!
                display.displayEmptyBarcodeMessage();
            else if (catalog.hasBarcode(barcode))
                display.displayPrice(catalog.findPrice(barcode));
            else
                display.displayProductNotFoundMessage(barcode);
        }
    }

    private static class Display {
        private String text;

        public String getText() {
            return text;
        }

        public void displayPrice(String price) {
            this.text = price;
        }

        public void displayProductNotFoundMessage(String barcode) {
            this.text = String.format("Product not found: %s", barcode);
        }

        public void displayEmptyBarcodeMessage() {
            this.text = "Scanning error: empty barcode";
        }
    }
}
