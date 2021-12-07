package ca.jbrains.pos.test;

import ca.jbrains.pos.InMemoryCatalog;
import ca.jbrains.pos.Price;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;

public class FindPriceInMemoryCatalogTest {
    @Test
    void productFound() {
        InMemoryCatalog catalog = new InMemoryCatalog(Map.of("23456", Price.cents(1250)));
        Assertions.assertEquals(Price.cents(1250), catalog.findPrice("23456"));
    }

    @Test
    void productNotFound() {
        InMemoryCatalog catalog = new InMemoryCatalog(Collections.emptyMap());
        Assertions.assertEquals(null, catalog.findPrice("23456"));
    }

}
