package ss10_dsa_stack_queue.bt.dem_so_lan_xh_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapSapXep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập chuỗi:");
        String string = scanner.nextLine();
        String[] arr = string.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String element : arr) {
            int count = 1;
            System.out.println(element);
            boolean isHas = map.containsKey(element);
            if (isHas) {
                count = map.get(element) + 1;
                System.out.println(count);
            }
            map.put(element, count);
        }
        System.out.println(map);
    }
}

