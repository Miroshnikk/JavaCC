package CollectionsCompare;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.TreeMap;

public class ThirdCompare {
    public static void main(String[] args) {

        HashMap<Integer, String> hashMap = new HashMap<>();
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        for (int i = 0; i < 100000; i++) {
            treeMap.put(i, "" + i);
            hashMap.put(i, "" + i);
        }

        timeBetweenDifferentOperations("Tree search", () -> {
            System.out.println(treeMap.get(99999));
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
