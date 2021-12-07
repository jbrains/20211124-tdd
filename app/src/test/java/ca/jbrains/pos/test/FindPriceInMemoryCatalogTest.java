package ca.jbrains.pos.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class FindPriceInMemoryCatalogTest {
    @Test
    void productFound() {
        InMemoryCatalog catalog = new InMemoryCatalog(Map.of("23456", SellOneItemControllerTest.Price.cents(1250)));
        Assertions.assertEquals(SellOneItemControllerTest.Price.cents(1250), catalog.findPrice("23456"));
    }

    public static class InMemoryCatalog {
        public <String, Price> InMemoryCatalog(Map<String, Price> pricesByBarcode) {
        }

        public SellOneItemControllerTest.Price findPrice(String barcode) {
            return SellOneItemControllerTest.Price.cents(1250);
        }
    }
}
