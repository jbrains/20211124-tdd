package ca.jbrains.pos;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

public class PointOfSaleTerminal {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        SellOneItemController sellOneItemController = new SellOneItemController(
                new InMemoryCatalog(
                        Map.of("12345", Price.cents(795),
                                "23456", Price.cents(1250))
                ),
                new ConsoleDisplay(out)
        );

        sellOneItemController.onBarcode("12345");
        sellOneItemController.onBarcode("23456");
        sellOneItemController.onBarcode("99999");
        sellOneItemController.onBarcode("88888");
        sellOneItemController.onBarcode("");
        out.flush();
    }
}
