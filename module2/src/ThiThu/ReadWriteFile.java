package ThiThu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {
    public static void writeFile(List<AccountLessor> accounts, String filename) {
        try (BufferedWriter buffered = new BufferedWriter(new FileWriter(filename, false))) {
            for (AccountLessor account : accounts) {
                buffered.write(account.getInfor());
                buffered.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}