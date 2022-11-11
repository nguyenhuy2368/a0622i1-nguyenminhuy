package ThiThu;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Account {
    private String cccd;
    private String hoTen;
    private Date ngaySinh;
    private int gioiTinh;
    private boolean trangThai = false;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Account() {
    }

    public Account(String cccd, String hoTen, Date ngaySinh, int gioiTinh, boolean trangThai) {
        this.cccd = cccd;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.trangThai = trangThai;
    }


    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getData() {
        String date = dateFormat.format(this.ngaySinh);
        return this.cccd + "," + this.hoTen + "," + this.ngaySinh + "," + this.gioiTinh + "," + this.trangThai;
    }

    public abstract String getInfor();

    @Override
    public String toString() {
        return "Account{" +
                "cccd='" + cccd + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", gioiTinh=" + gioiTinh +
                ", trangThai=" + trangThai +
                '}';
    }
}
