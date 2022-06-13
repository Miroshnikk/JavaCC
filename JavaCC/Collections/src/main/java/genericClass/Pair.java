package genericClass;

import java.util.Objects;

public class Pair<String,Integer> {
    private String value;
    private Integer key;

    public Pair(String v, Integer k) {
        value = v;
        key = k;
    }

    @Override
    public java.lang.String toString() {
        return "genericClass.Pair{" +
                "value=" + value +
                ", key=" + key +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(value, pair.value) && Objects.equals(key, pair.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, key);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }
}

class Example {
    public static void main(String[] args) {
        Pair<String, Integer> firstPair = new Pair<>("Hello World", 10);
        Pair<String, Integer> secondPair = new Pair<>("Bye World", 50);

        boolean equals = firstPair.equals(secondPair);
        String format = "First pair: %s and second pair: %s are equals: %s";

        System.out.println(String.format(format, firstPair, secondPair, equals));
    }
}