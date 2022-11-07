package codegym.vn.binaryfile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DemoFileBinary {
    public static void main(String[] args) {
        try (FileOutputStream stream = new FileOutputStream("tu.mp4")){
            String str = "Hom nay, Tu di hoc";
            int a = 97;
            stream.write(str.getBytes());
            stream.write(a);
            stream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
