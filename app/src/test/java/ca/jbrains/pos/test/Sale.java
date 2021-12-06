package ca.jbrains.pos.test;

public class Sale {
    private Catalog catalog;
    private Display display;

    Sale(Display display, Catalog catalog) {
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
