package testabc.models;

public abstract class PhuongTien {
    private String maPhuongTien;
    private String tenPhuongTien;
    private String hangSanXuat;
    private int namSanXuat;
    private String congSuat;
    private String dungTich;
    private int loaiPhuongTien;

    public PhuongTien() {
    }

    public PhuongTien(String maPhuongTien, String tenPhuongTien, String hangSanXuat, int namSanXuat, String congSuat, String dungTich, int loaiPhuongTien) {
        this.maPhuongTien = maPhuongTien;
        this.tenPhuongTien = tenPhuongTien;
        this.hangSanXuat = hangSanXuat;
        this.namSanXuat = namSanXuat;
        this.congSuat = congSuat;
        this.dungTich = dungTich;
        this.loaiPhuongTien = loaiPhuongTien;
    }

    public String getMaPhuongTien() {
        return maPhuongTien;
    }

    public void setMaPhuongTien(String maPhuongTien) {
        this.maPhuongTien = maPhuongTien;
    }

    public String getTenPhuongTien() {
        return tenPhuongTien;
    }

    public void setTenPhuongTien(String tenPhuongTien) {
        this.tenPhuongTien = tenPhuongTien;
    }

    public String getHangSanXuat() {
        return hangSanXuat;
    }

    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(String congSuat) {
        this.congSuat = congSuat;
    }

    public String getDungTich() {
        return dungTich;
    }

    public void setDungTich(String dungTich) {
        this.dungTich = dungTich;
    }

    public int getLoaiPhuongTien() {
        return loaiPhuongTien;
    }

    public void setLoaiPhuongTien(int loaiPhuongTien) {
        this.loaiPhuongTien = loaiPhuongTien;
    }

    @Override
    public String toString() {
        return "PhuongTien{" +
                "maPhuongTien='" + maPhuongTien + '\'' +
                ", tenPhuongTien='" + tenPhuongTien + '\'' +
                ", hangSanXuat='" + hangSanXuat + '\'' +
                ", namSanXuat=" + namSanXuat +
                ", congSuat=" + congSuat +
                ", dungTich=" + dungTich +
                '}';
    }

    public abstract void showInfor();
}
