package com.pi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Integer> allNumbers = new ArrayList<>();
    private static List<Car> cars = new ArrayList<>();
    private static final int[] amountDaysOfEachMonth = new int[12];
    static {
        amountDaysOfEachMonth[0] = 31;
        amountDaysOfEachMonth[1] = 28;
        amountDaysOfEachMonth[2] = 31;
        amountDaysOfEachMonth[3] = 30;
        amountDaysOfEachMonth[4] = 31;
        amountDaysOfEachMonth[5] = 30;
        amountDaysOfEachMonth[6] = 31;
        amountDaysOfEachMonth[7] = 31;
        amountDaysOfEachMonth[8] = 30;
        amountDaysOfEachMonth[9] = 31;
        amountDaysOfEachMonth[10] = 30;
        amountDaysOfEachMonth[11] = 31;
    }
    public static void main(String[] args) {
        askUserMonth();
        calculateTheSum();
        checkNumbers();
        enteringNumbersUntilNegativeOne();

        long product = allNumbers.get(0);
        for (int i = 1; i < allNumbers.size(); i++) {
            product *= allNumbers.get(i);
        }
        System.out.println("Product of all numbers - " + product);

        Car car1 = new Car(2005,60);
        Car car2 = new Car(2002,50);
        Car car3 = new Car(2005,70);
        Car car4 = new Car(2009,120);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

        displayCarsByYear();
        displayCarsOrderedByYear();
    }

    public static void displayCarsByYear(){
        System.out.println("Enter year to display cars :");
        int year = scanner.nextInt();
        System.out.println("Cars by year - " + year);

        for(int i = 0; i < cars.size(); i++){
            if(cars.get(i).getYearOfProduction() == year){
                System.out.println(cars.get(i));
            }
        }
    }

    public static void displayCarsOrderedByYear(){
        System.out.println("\n Cars ordered by year: ");
        cars.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o2.getYearOfProduction() - o1.getYearOfProduction();
            }
        });

        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public static void askUserMonth(){
        System.out.println("Please, enter the number of month:");
        int month = scanner.nextInt() - 1;
        allNumbers.add(month);
        System.out.println("Amount of days in this month - " + amountDaysOfEachMonth[month]);
    }

    public static void calculateTheSum(){
        int[] numbers = new int[10];
        System.out.println("Please, write 10 numbers:");
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = scanner.nextInt();
            allNumbers.add(numbers[i]);
        }

        if (checkNumbersOnPositive(numbers)){
            int sum = 0;
            for(int i = 0; i < 5; i++){
                sum += numbers[i];
            }
            System.out.println("Sum - " + sum);
        } else{
            int product = numbers[5];
            for(int i = 6; i < numbers.length; i++){
                product *= numbers[i];
            }
            System.out.println("Product - " + product);
        }


    }

    public static void checkNumbers(){
        int[] numbers = new int[5];
        int min = Integer.MAX_VALUE;
        int positionOfMinimum = 0;
        int positionOfSecondPositive = 0;
        boolean access = false;
        boolean bol = true;
        System.out.println("Please, enter five numbers:");
        for(int i = 0; i < 5; i++){
            numbers[i] = scanner.nextInt();
            allNumbers.add(numbers[i]);
            if(numbers[i] < min){
                min = numbers[i];
                positionOfMinimum = i;
            }
            if(numbers[i] > 0 && access){
                access = false;
                bol = false;
                positionOfSecondPositive = i;
            }
            if(numbers[i] > 0 && bol){
                access = true;
            }
        }
        System.out.println("Position of second positive number: " + (positionOfSecondPositive + 1));
        System.out.println("Minimum number: " + min);
        System.out.println("Position of minimum number: " + (positionOfMinimum + 1));
    }

    public static void enteringNumbersUntilNegativeOne(){
        System.out.println("Entering number until the first negative one:");
        int number;
        while((number = scanner.nextInt()) > 0){
            allNumbers.add(number);
        }
    }

    private static boolean checkNumbersOnPositive(int[] numbers){
        boolean positive = true;
        for(int i = 0; i < 5; i++){
            if(numbers[i] <= 0){
                positive = false;
                break;
            }
        }
        return positive;
    }


}
