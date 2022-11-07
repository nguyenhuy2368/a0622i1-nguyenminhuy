package utils;

import model.Account;
import model.AccountLessor;
import model.AccountRenter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static void writeFileAccount(List<Account> accountList, String filename) {
        try (BufferedWriter buffered = new BufferedWriter(new FileWriter(filename, false))) {
            for (Account account : accountList) {
                buffered.write(account.getInfo());
                buffered.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Account> readFileAccount(String filename, Class clazz) {
        List<Account> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("")) {
                    continue;
                }
                if (clazz.getName().equals("AccountRenter")) {
                    list.add(new AccountRenter(line));
                } else {

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
