package ca.jbrains.pos.test;

public class Display {
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
