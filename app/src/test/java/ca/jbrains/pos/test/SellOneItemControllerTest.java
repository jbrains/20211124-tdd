package ca.jbrains.pos.test;

import ca.jbrains.pos.Catalog;
import ca.jbrains.pos.Display;
import ca.jbrains.pos.Price;
import ca.jbrains.pos.SellOneItemController;
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

}
