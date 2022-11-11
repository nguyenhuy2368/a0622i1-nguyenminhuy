package test;


import test.model.GiayDangKy;
import test.model.OTo;
import test.model.XeTai;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static List<OTo> readFileOTo(String path){
        List<OTo> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("")) {
                    continue;
                }
                String[] data = line.split(",");
                int loaiPhuongTien = Integer.parseInt(data[6]);
                if (loaiPhuongTien==0) {
                    list.add(new OTo(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static List<XeTai> readFileXeTai(String path){
        List<XeTai> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("")) {
                    continue;
                }
                String[] data = line.split(",");
                int loaiPhuongTien = Integer.parseInt(data[6]);
                if (loaiPhuongTien==1) {
                    list.add(new XeTai(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void writeFileGiayDangKy(List<GiayDangKy> giayDangKyList, String filename) {
        try (BufferedWriter buffered = new BufferedWriter(new FileWriter(filename, false))) {
            for (GiayDangKy giayDangKy : giayDangKyList) {
                buffered.write(giayDangKy.getInFo());
                buffered.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<GiayDangKy> readFileGiayDangKy(String filename) {
        List<GiayDangKy> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("")) {
                    continue;
                }
                list.add(new GiayDangKy(line));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return list;
    }
}
