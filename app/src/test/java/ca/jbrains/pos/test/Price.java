package ca.jbrains.pos.test;

public record Price(int valueInCents) {
    public static Price cents(int valueInCents) {
        return new Price(valueInCents);
    }

    public double inEuro() {
        return valueInCents() / 100.0d;
    }
}
