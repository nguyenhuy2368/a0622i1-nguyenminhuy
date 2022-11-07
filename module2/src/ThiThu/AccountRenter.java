package ThiThu;

import java.util.Date;

public class AccountRenter extends Account {
    private float minDienTich;
    private float maxDienTich;
    private int minGiaTien;
    private int maxGiaTien;

    public AccountRenter() {
    }

    public AccountRenter(String cccd, String hoTen, Date ngaySinh, int gioiTinh, boolean trangThai, float minDienTich, float maxDienTich, int minGiaTien, int maxGiaTien) {
        super(cccd, hoTen, ngaySinh, gioiTinh, trangThai);
        this.minDienTich = minDienTich;
        this.maxDienTich = maxDienTich;
        this.minGiaTien = minGiaTien;
        this.maxGiaTien = maxGiaTien;
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
    public String getInfor(){return this.maxDienTich+","+this.minDienTich+","+this.maxGiaTien+","+this.minGiaTien;}
}
