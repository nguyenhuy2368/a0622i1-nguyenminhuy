package codegym.vn.maptree;

import java.util.*;

public class DemoMap {
    public static void main(String[] args) {
//        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "Hà Nội");
        map.put(10, "Đà Nẵng");
        map.put(5, "Hồ Chí Minh");
        map.put(2, "Hải Phòng");

        // Duyệt map bằng entry
//        Set<Map.Entry<Integer, String>> citiesList = map.entrySet();
//        for(Map.Entry<Integer, String> entry: citiesList) {
//            System.out.println("Key: " + entry.getKey() + " | Value: "+ entry.getValue());
//        }

        // Duyệt map bằng list key
//        Set<Integer> keys = map.keySet();
//        for(Integer key: keys) {
//            System.out.println("Key: " + key + " | Value: "+ map.get(key));
//        }

        // Duyệt theo list value
        Collection<String> values = map.values();
        for (String value: values) {
            System.out.println(value);
        }
    }
}
