package com.pi;

public class Car {
    private final int yearOfProduction;
    private final int EngineCapacity;

    public Car(int yearOfProduction, int engineCapacity) {
        this.yearOfProduction = yearOfProduction;
        EngineCapacity = engineCapacity;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public int getEngineCapacity() {
        return EngineCapacity;
    }

    @Override
    public String toString() {
        return "Car{" +
                "yearOfProduction=" + yearOfProduction +
                ", EngineCapacity=" + EngineCapacity +
                '}';
    }
}
