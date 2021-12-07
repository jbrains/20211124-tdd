package ca.jbrains.pos.test;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SellOneItemControllerTest {
    @Test
    void productFound() {
        Catalog catalog = Mockito.mock(Catalog.class);
        Display display = Mockito.mock(Display.class);

        Mockito.when(catalog.findPrice("12345")).thenReturn(Price.cents(795));

        new SellOneItemController(catalog, display).onBarcode("12345");

        Mockito.verify(display).displayPrice(Price.cents(795));
    }

    @Test
    void productNotFound() {
        Catalog catalog = Mockito.mock(Catalog.class);
        Display display = Mockito.mock(Display.class);

        Mockito.when(catalog.findPrice("99999")).thenReturn(null);

        new SellOneItemController(catalog, display).onBarcode("99999");

        Mockito.verify(display).displayProductNotFoundMessage("99999");
    }

    @Test
    void emptyBarcode() {
        Display display = Mockito.mock(Display.class);

        new SellOneItemController(null, display).onBarcode("");

        Mockito.verify(display).displayEmptyBarcodeMessage();
    }

    public static class SellOneItemController {
        private Catalog catalog;
        private Display display;

        public SellOneItemController(Catalog catalog, Display display) {
            this.catalog = catalog;
            this.display = display;
        }

        public void onBarcode(String barcode) {
            if ("".equals(barcode))
                display.displayEmptyBarcodeMessage();
            else {
                Price price = catalog.findPrice(barcode);
                if (price == null)
                    display.displayProductNotFoundMessage(barcode);
                else
                    display.displayPrice(price);
            }
        }
    }

    public interface Catalog {
        Price findPrice(String barcode);
    }

    public interface Display {
        void displayPrice(Price price);

        void displayProductNotFoundMessage(String barcodeNotFound);

        void displayEmptyBarcodeMessage();
    }

}
