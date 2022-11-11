package test.model;

public abstract class PhuongTien {
    private String maPT;
    private String tenPT;
    private String tenHang;
    private int namSX;
    private int congSuat;
    private int dungTich;
    private int loaiPT;

    public PhuongTien() {
    }

    public PhuongTien(String maPT, String tenPT, String tenHang, int namSX, int congSuat, int dungTich, int loaiPT) {
        this.maPT = maPT;
        this.tenPT = tenPT;
        this.tenHang = tenHang;
        this.namSX = namSX;
        this.congSuat = congSuat;
        this.dungTich = dungTich;
        this.loaiPT = loaiPT;
    }

    public String getMaPT() {
        return maPT;
    }

    public void setMaPT(String maPT) {
        this.maPT = maPT;
    }

    public String getTenPT() {
        return tenPT;
    }

    public void setTenPT(String tenPT) {
        this.tenPT = tenPT;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }

    public int getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(int congSuat) {
        this.congSuat = congSuat;
    }

    public int getDungTich() {
        return dungTich;
    }

    public void setDungTich(int dungTich) {
        this.dungTich = dungTich;
    }

    public int getLoaiPT() {
        return loaiPT;
    }

    public void setLoaiPT(int loaiPT) {
        this.loaiPT = loaiPT;
    }
    public String getInFo(){
        return this.maPT + "," + this.tenPT +"," +this.tenHang + "," +this.namSX + "," +this.congSuat +"," +this.dungTich +"," +this.loaiPT;
    }
    @Override
    public String toString() {
        return "maPT='" + maPT + '\'' +
                ", tenPT='" + tenPT + '\'' +
                ", tenHang='" + tenHang + '\'' +
                ", namSX=" + namSX +
                ", congSuat=" + congSuat +
                ", dungTich=" + dungTich +
                ", loaiPT=" + loaiPT +
                ' ';
    }
}
