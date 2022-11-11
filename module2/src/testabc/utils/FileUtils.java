package testabc.utils;

import testabc.models.GiayDangKy;
import testabc.models.Oto;
import testabc.models.PhuongTien;
import testabc.models.XeTai;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileUtils {
    public static void writeFileAccount(List<GiayDangKy> giayDangKyList, String filename) {
        try (BufferedWriter buffered = new BufferedWriter(new FileWriter(filename, false))) {
            for (GiayDangKy giayDangKy : giayDangKyList) {
                buffered.write(giayDangKy.getInfor());
                buffered.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<GiayDangKy> readFile(String filename) {
        List<GiayDangKy> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("")) {
                    continue;
                }
                list.add(new GiayDangKy(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static List<PhuongTien> readFilePhuongTien(String filename) {
        List<PhuongTien> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("")) {
                    continue;
                }
                String[] data = line.split(",");
                int loaiPhuongTien = Integer.parseInt(data[6]);
                if (loaiPhuongTien==0) {
                    list.add(new Oto(line));
                } else {
                    list.add(new XeTai(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static List<XeTai> readFileXeTai(String filename) {
        List<XeTai> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
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
    public static List<Oto> readFileOTo(String filename) {
        List<Oto> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("")) {
                    continue;
                }
                String[] data = line.split(",");
                int loaiPhuongTien = Integer.parseInt(data[6]);
                if (loaiPhuongTien==0) {
                    list.add(new Oto(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
