package ThiThu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountRenter extends Account {
    private float minDienTich;
    private float maxDienTich;
    private int minGiaTien;
    private int maxGiaTien;
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public AccountRenter() {
    }

    public AccountRenter(String cccd, String hoTen, Date ngaySinh, int gioiTinh, boolean trangThai, float minDienTich, float maxDienTich, int minGiaTien, int maxGiaTien) {
        super(cccd, hoTen, ngaySinh, gioiTinh, trangThai);
        this.minDienTich = minDienTich;
        this.maxDienTich = maxDienTich;
        this.minGiaTien = minGiaTien;
        this.maxGiaTien = maxGiaTien;
    }

    public AccountRenter(String str) throws ParseException {
        String[] strings = str.split(",");
        setCccd(strings[0]);
        setHoTen(strings[1]);
        Date date = dateFormat.parse(strings[2]);
        setNgaySinh(date);
        setGioiTinh(Integer.parseInt(strings[3]));
        if(strings[4]=="false"){
            setTrangThai(false);
        }else {
            setTrangThai(true);
        }
        this.maxDienTich = Float.parseFloat(strings[5]);
        this.minDienTich = Float.parseFloat(strings[6]);
        this.maxGiaTien = Integer.parseInt(strings[7]);
        this.minGiaTien = Integer.parseInt(strings[8]);

    }
    public float getMinDienTich() {
        return minDienTich;
    }

    public void setMinDienTich(float minDienTich) {
        this.minDienTich = minDienTich;
    }

    public float getMaxDienTich() {
        return maxDienTich;
    }

    public void setMaxDienTich(float maxDienTich) {
        this.maxDienTich = maxDienTich;
    }

    public int getMinGiaTien() {
        return minGiaTien;
    }

    public void setMinGiaTien(int minGiaTien) {
        this.minGiaTien = minGiaTien;
    }

    public int getMaxGiaTien() {
        return maxGiaTien;
    }

    public void setMaxGiaTien(int maxGiaTien) {
        this.maxGiaTien = maxGiaTien;
    }

    @Override
    public String getInfor() {
        return super.getData()+","+this.minDienTich+","+this.maxDienTich+","+this.minGiaTien+","+this.maxGiaTien;
    }

    @Override
    public String toString() {
        return "AccountRenter{" +
                "minDienTich=" + minDienTich +
                ", maxDienTich=" + maxDienTich +
                ", minGiaTien=" + minGiaTien +
                ", maxGiaTien=" + maxGiaTien +
                '}';
    }
}
