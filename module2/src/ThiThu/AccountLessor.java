package ThiThu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountLessor extends Account {
    private float dienTich;
    private String diaChi;
    private int soNguoi;
    private int giaTien;
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public AccountLessor() {
    }


    public AccountLessor(String cccd, String hoTen, Date ngaySinh, int gioiTinh, boolean trangThai, float dienTich, String diaChi, int soNguoi, int giaTien) {
        super(cccd, hoTen, ngaySinh, gioiTinh, trangThai);
        this.dienTich = dienTich;
        this.diaChi = diaChi;
        this.soNguoi = soNguoi;
        this.giaTien = giaTien;
    }

    public AccountLessor(String str) throws ParseException {
        String[] strings = str.split(",");
        setCccd(strings[0]);
        setHoTen(strings[1]);
        Date date = dateFormat.parse(strings[2]);
        setNgaySinh(date);
        setGioiTinh(Integer.parseInt(strings[3]));
        if (strings[4] == "false") {
            setTrangThai(false);
        } else {
            setTrangThai(true);
        }
        this.dienTich = Float.parseFloat(strings[5]);
        this.diaChi = strings[6];
        this.soNguoi = Integer.parseInt(strings[7]);
        this.giaTien = Integer.parseInt(strings[8]);
    }

    public float getDienTich() {
        return dienTich;
    }

    public void setDienTich(float dienTich) {
        this.dienTich = dienTich;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getSoNguoi() {
        return soNguoi;
    }

    public void setSoNguoi(int soNguoi) {
        this.soNguoi = soNguoi;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    @Override
    public String getInfor() {
        return super.getData() + "," + this.diaChi + "," + this.dienTich + "," + this.giaTien + "," + this.soNguoi;
    }


    @Override
    public String toString() {
        return "AccountLessor{" +
                "dienTich=" + dienTich +
                ", diaChi='" + diaChi + '\'' +
                ", soNguoi=" + soNguoi +
                ", giaTien=" + giaTien +
                '}';
    }


}
