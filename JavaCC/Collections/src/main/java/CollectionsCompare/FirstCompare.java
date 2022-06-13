package CollectionsCompare;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedList;

public class FirstCompare {

    public static void main(String[] args) {

        ArrayList<String> arrList = new ArrayList();
        LinkedList<String> linkedList = new LinkedList<>();
        ArrayList<String> arrList1 = new ArrayList();
        LinkedList<String> linkedList1 = new LinkedList<>();
        ArrayList<String> arrList2 = new ArrayList();
        LinkedList<String> linkedList2 = new LinkedList<>();
        ArrayList<String> arrList3 = new ArrayList();
        LinkedList<String> linkedList3 = new LinkedList<>();

        for (int i = 0; i < 10000; i++) {
            arrList.add(" a - " + i);
            linkedList.add(" l - " + i);
            arrList1.add(" a1 - " + i);
            linkedList1.add(" l1 - " + i);
            arrList2.add(" a2 - " + i);
            linkedList2.add(" l2 - " + i);
            arrList3.add(" a3 - " + i);
            linkedList3.add(" l3 - " + i);
        }

        timeBetweenDifferentOperations("Arr last add ", () -> {
            arrList.add(10000, "444");
        });

        timeBetweenDifferentOperations("Linked last add", () -> {
            linkedList.add(10000, "444");

        });

        timeBetweenDifferentOperations("Arr beginning add ", () -> {
            arrList1.add(0, "444");
        });

        timeBetweenDifferentOperations("Linked beginning add", () -> {
            linkedList1.add(0, "444");

        });

        timeBetweenDifferentOperations("Arr remove", () -> {
            arrList2.remove(5000);
        });

        timeBetweenDifferentOperations("Linked remove", () -> {
            linkedList2.remove(5000);

        });

        timeBetweenDifferentOperations("Arr iterate", () -> {
            for (int i = 0; i < arrList3.size(); i++) {
                arrList3.get(i);
            }
        });

        timeBetweenDifferentOperations("Linked iterate", () -> {
            for (int i = 0; i < linkedList3.size(); i++) {
                linkedList3.get(i);
            }

        });

    }

    static void timeBetweenDifferentOperations(String operationName, Runnable r) {
        new Thread(() -> {
            LocalDateTime start = LocalDateTime.now();
            // execute operations
            r.run();

            LocalDateTime end = LocalDateTime.now();
            long difference = ChronoUnit.MILLIS.between(start, end);
            System.out.println(operationName + " : " + "Difference = " + difference + " ms ");
        }).start();
    }

}
