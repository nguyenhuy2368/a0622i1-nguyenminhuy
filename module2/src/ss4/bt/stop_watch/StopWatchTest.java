package ss4.stop_watch;

import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        LocalTime start = LocalTime.now();
        int [] arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100000);
        }
        Arrays.sort(arr);
        LocalTime end = LocalTime.now();
        StopWatch dh = new StopWatch(start, end);
        System.out.println("mili s :" + dh.getElapsedTime());
    }
}
