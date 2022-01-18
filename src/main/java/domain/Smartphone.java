package domain;

import java.util.Objects;

public class Smartphone extends Product{
    private String generator;

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public Smartphone () {
        super();
    }

    public Smartphone(int id, String name, int price, String generator) {
        super(id, name, price);
        this.generator = generator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return Objects.equals(generator, that.generator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), generator);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "generator='" + generator + '\'' +
                '}';
    }
}
