package ss16_io.bt.Copy;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
        File file1 = new File("D:\\A0622I1\\module2\\src\\ss16_io\\bt\\text1.txt");
        File file2 = new File("D:\\A0622I1\\module2\\src\\ss16_io\\bt\\text2.txt");
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            //read
            FileReader fileReader = new FileReader(file1);
            bufferedReader = new BufferedReader(fileReader);
            //write
            FileWriter fileWriter = new FileWriter(file2);
            bufferedWriter = new BufferedWriter(fileWriter);
            int i;
            while ((i = bufferedReader.read()) != -1) {
                System.out.println((char) i);
                bufferedWriter.write((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
