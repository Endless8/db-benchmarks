package application.printer;

import java.util.Collections;
import java.util.List;

public class PrintResults {

    public static void printTimes(List<Long> insertionTimes, String queryType) {
        Long minInsertionTime = Collections.min(insertionTimes);
        Long maxInsertionTime = Collections.max(insertionTimes);
        Long avgInsertionTime = 0L;
        for (Long insertionTime : insertionTimes) {
            avgInsertionTime += insertionTime;
        }
        avgInsertionTime /= insertionTimes.size();
        System.out.printf(queryType + " statement time: MIN %dms - MAX %dms - AVG %dms\n", minInsertionTime, maxInsertionTime, avgInsertionTime);
    }

}
