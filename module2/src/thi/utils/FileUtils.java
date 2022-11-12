package thi.utils;

import thi.models.BrandMobile;
import thi.models.SecondMobile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static void writeBrandMobile(BrandMobile brandMobile) {
        File file = new File("D:\\A0622I1\\module2\\src\\thi\\datas\\brandmobiles.csv");
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(brandMobile.getId() + "," + brandMobile.getName() + "," + brandMobile.getPrice() + "," + brandMobile.getQuantity() + "," + brandMobile.getBrand() + "," + brandMobile.getTimeGuarantee() + "," + brandMobile.getRangeGuarante() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeSecondMobile(SecondMobile secondMobile) {
        File file = new File("D:\\A0622I1\\module2\\src\\thi\\datas\\secondmobiles.csv");
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(secondMobile.getId() + "," + secondMobile.getName() + "," + secondMobile.getPrice() + "," + secondMobile.getQuantity() + "," + secondMobile.getBrand() + "," + secondMobile.getFromNation() + "," + secondMobile.getStatus() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<BrandMobile> getListBrandMobile() {
        List<BrandMobile> brandMobileList = new ArrayList<>();
        File file = new File("D:\\A0622I1\\module2\\src\\thi\\datas\\brandmobiles.csv");
        BufferedReader bufferedReader = null;
        String line;
        BrandMobile brandMobile;
        String[] temp;
        try {
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                brandMobile = new BrandMobile(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), temp[4], Integer.parseInt(temp[5]), temp[6]);
                brandMobileList.add(brandMobile);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return brandMobileList;
    }

    public static void readBrandMobile() {
        List<BrandMobile> brandMobileList;
        brandMobileList = getListBrandMobile();
        for (BrandMobile element : brandMobileList) {
            element.showInfor();
        }
    }

    public static int getIdLastBrandMobile() {
        List<BrandMobile> brandMobileList;
        brandMobileList = getListBrandMobile();
        int lastIndex = brandMobileList.size() - 1;
        if (brandMobileList.size() == 0) {
            return 0;
        } else {
            return brandMobileList.get(lastIndex).getId();
        }
    }

    public static void searchNameBrandMobile(String myString) {
        List<BrandMobile> brandMobileList;
        List<BrandMobile> foundList = new ArrayList<>();
        brandMobileList = getListBrandMobile();
        for (int i = 0; i < brandMobileList.size(); i++) {
            if (brandMobileList.get(i).getName().contains(myString)) {
                foundList.add(brandMobileList.get(i));
            }
        }
        if (foundList.size() == 0) {
            System.out.println("Khong tim thay");
        } else {
            for (BrandMobile element : foundList) {
                element.showInfor();
            }
        }

    }

    public static List<SecondMobile> getListSecondMobile() {
        List<SecondMobile> secondMobileList = new ArrayList<>();
        File file = new File("D:\\A0622I1\\module2\\src\\thi\\datas\\secondmobiles.csv");
        BufferedReader bufferedReader = null;
        String line;
        SecondMobile secondMobile;
        String[] temp;
        try {
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                secondMobile = new SecondMobile(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), temp[4], temp[5], temp[6]);
                secondMobileList.add(secondMobile);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return secondMobileList;
    }


    public static void readSecondMobile() {
        List<SecondMobile> secondMobileList;
        secondMobileList = getListSecondMobile();
        for (SecondMobile element : secondMobileList) {
            element.showInfor();
        }
    }

    public static int getIdLastSecondMobile() {
        List<SecondMobile> secondMobileList;
        secondMobileList = getListSecondMobile();
        int lastIndex = secondMobileList.size() - 1;
        if (secondMobileList.size() == 0) {
            return 0;
        } else {
            return secondMobileList.get(lastIndex).getId();
        }
    }

    public static void searchNameSecondMobile(String myString) {
        List<SecondMobile> secondMobileList;
        List<SecondMobile> foundSecondMobileList = new ArrayList<>();
        secondMobileList = getListSecondMobile();
        for (int i = 0; i < secondMobileList.size(); i++) {
            if (secondMobileList.get(i).getName().contains(myString)) {
                foundSecondMobileList.add(secondMobileList.get(i));
            }
        }
        if (foundSecondMobileList.size() == 0) {
            System.out.println("Khong tim thay");
        } else {
            for (SecondMobile element : foundSecondMobileList) {
                element.showInfor();
            }
        }
    }

    public static void deleteBrandMobile(int id) {
        List<BrandMobile> brandMobileList;
        brandMobileList = getListBrandMobile();

        for (int i = 0; i < brandMobileList.size(); i++) {
            if (id == brandMobileList.get(i).getId()) {
                brandMobileList.remove(i);
            }
        }
        File file = new File("D:\\A0622I1\\module2\\src\\thi\\datas\\brandmobiles.csv");
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < brandMobileList.size(); i++) {
                bufferedWriter.write(brandMobileList.get(i).getId() + "," + brandMobileList.get(i).getName() + "," + brandMobileList.get(i).getPrice() + "," + brandMobileList.get(i).getQuantity() + "," + brandMobileList.get(i).getBrand() + "," + brandMobileList.get(i).getTimeGuarantee() + "," + brandMobileList.get(i).getRangeGuarante() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteSecondMobile(int id) {

        List<SecondMobile> secondMobileList;
        secondMobileList = getListSecondMobile();

        for (int i = 0; i < secondMobileList.size(); i++) {
            if (id == secondMobileList.get(i).getId()) {
                secondMobileList.remove(i);
            }
        }
        File file = new File("D:\\A0622I1\\module2\\src\\thi\\datas\\secondmobiles.csv");
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < secondMobileList.size(); i++) {
                bufferedWriter.write(secondMobileList.get(i).getId() + "," + secondMobileList.get(i).getName() + "," + secondMobileList.get(i).getPrice() + "," + secondMobileList.get(i).getQuantity() + "," + secondMobileList.get(i).getBrand() + "," + secondMobileList.get(i).getFromNation() + "," + secondMobileList.get(i).getStatus() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
