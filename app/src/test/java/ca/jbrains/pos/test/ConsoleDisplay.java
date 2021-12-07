package ca.jbrains.pos.test;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ConsoleDisplay implements Display {
    private StringWriter canvas;

    public ConsoleDisplay(StringWriter canvas) {
        this.canvas = canvas;
    }

    @Override
    public void displayPrice(Price price) {
        new PrintWriter(canvas).println(String.format("EUR %.2f", price.valueInCents() / 100.0d));
    }

    @Override
    public void displayProductNotFoundMessage(String barcodeNotFound) {
        System.out.println(String.format("Product not found: %s", barcodeNotFound));
    }

    @Override
    public void displayEmptyBarcodeMessage() {
        System.out.println("Scanning error: empty barcode");
    }
}
