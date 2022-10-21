package ss16_io.th.tim_max_ghi_file;

import java.util.List;

public class FindMaxValue {

    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("D:\\A0622I1\\module2\\src\\ss16_io\\th\\tim_max_ghi_file\\numbers.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("D:\\A0622I1\\module2\\src\\ss16_io\\th\\tim_max_ghi_file\\result.txt", maxValue);
    }
}
