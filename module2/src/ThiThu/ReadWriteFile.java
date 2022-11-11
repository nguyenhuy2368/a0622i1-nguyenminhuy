package ThiThu;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static void writeAccLessor(List<AccountLessor> accounts, String filename) {
        try (BufferedWriter buffered = new BufferedWriter(new FileWriter(filename, false))) {
            for (AccountLessor account : accounts) {
                buffered.write(account.getInfor());
                buffered.newLine();
            }
        } catch(FileNotFoundException ex) {
            System.out.println("Khong tim thay file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<AccountLessor> readAccLessor(String filename){
        List<AccountLessor> accountLessors = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("")) {
                    continue;
                }
                accountLessors.add(new AccountLessor(line));
            }
        } catch(FileNotFoundException ex) {
            System.out.println("Khong tim thay file");
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return accountLessors;
    }
    public static void writeAccRentter(List<AccountRenter> accountRentters, String filename){
        try(BufferedWriter buffered = new BufferedWriter(new FileWriter(filename))) {
            for(AccountRenter accountRentter:accountRentters){
                buffered.write(accountRentter.getInfor());
                buffered.newLine();
            }
        } catch(FileNotFoundException ex) {
            System.out.println("Khong tim thay file");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public static List<AccountRenter> readAcctRentter(String filename){
        List<AccountRenter> accountRentters = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("")) {
                    continue;
                }
                accountRentters.add(new AccountRenter(line));
            }
        } catch(FileNotFoundException ex) {
            System.out.println("Khong tim thay file");
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return accountRentters;
    }
}