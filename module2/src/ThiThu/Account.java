package ThiThu;

import java.util.Date;

public class Account {
    private String cccd;
    private String hoTen;
    private Date ngaySinh;
    private int gioiTinh;
    private boolean trangThai = false;

    public Account() {
    }

    public Account(String cccd, String hoTen, Date ngáyinh, int gioiTinh, boolean trangThai) {
        this.cccd = cccd;
        this.hoTen = hoTen;
        this.ngaySinh = ngáyinh;
        this.gioiTinh = gioiTinh;
        this.trangThai = trangThai;
    }

    public Account(String line) {
    }

//    public Account(String str) {
//        String[] data = str.split(",");
//        this.
//    }


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
    public String getInfor (){
        return this.cccd+","+this.hoTen+","+this.ngaySinh+","+this.gioiTinh+","+this.trangThai;
    }
}
