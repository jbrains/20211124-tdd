package ca.jbrains.pos.test;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ConsoleDisplay implements Display {
    private StringWriter canvas;
    private PrintWriter out;

    public ConsoleDisplay(StringWriter canvas) {
        this.canvas = canvas;
        this.out = new PrintWriter(canvas);
    }

    @Override
    public void displayPrice(Price price) {
        out.println(String.format("EUR %.2f", price.inEuro()));
    }

    @Override
    public void displayProductNotFoundMessage(String barcodeNotFound) {
        out.println(String.format("Product not found: %s", barcodeNotFound));
    }

    @Override
    public void displayEmptyBarcodeMessage() {
        out.println("Scanning error: empty barcode");
    }
}
