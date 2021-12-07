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

    public static class SellOneItemController {
        private Catalog catalog;
        private Display display;

        public SellOneItemController(Catalog catalog, Display display) {
            this.catalog = catalog;
            this.display = display;
        }

        public void onBarcode(String barcode) {
            display.displayPrice(catalog.findPrice(barcode));
        }
    }
    public interface Catalog {
        Price findPrice(String barcode);
    }
    public interface Display {
        void displayPrice(Price price);
    }

    public record Price(int valueInCents) {
        public static Price cents(int valueInCents) { return new Price(valueInCents); }
    }
}
