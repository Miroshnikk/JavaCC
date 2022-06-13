package CollectionsCompare;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.LinkedList;

public class SecondCompare {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        HashMap<Integer, String> hashMap = new HashMap<>();

        for (int i = 0; i < 100000; i++) {
            linkedList.add("" + i);
            hashMap.put(i, "" + i);
        }

        timeBetweenDifferentOperations("Linked search", () -> {
            System.out.println(linkedList.indexOf("99999"));
        });

        timeBetweenDifferentOperations("Hash search", () -> {
            System.out.println(hashMap.get(99999));
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
