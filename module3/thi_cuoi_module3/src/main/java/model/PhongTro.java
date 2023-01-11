package model;

public class PhongTro {
    private int maPhongTro;
    private String tenNguoiThue;
    private String sdt;
    private String ngayBatDau;
    private int idThanhToan;
    private String ghiChu;

    public PhongTro() {
    }

    public PhongTro(int maPhongTro, String tenNguoiThue, String sdt, String ngayBatDau, int idThanhToan, String ghiChu) {
        this.maPhongTro = maPhongTro;
        this.tenNguoiThue = tenNguoiThue;
        this.sdt = sdt;
        this.ngayBatDau = ngayBatDau;
        this.idThanhToan = idThanhToan;
        this.ghiChu = ghiChu;
    }

    public PhongTro(String tenNguoiThue, String sdt, String ngayBatDau, int idThanhToan, String ghiChu) {
        this.tenNguoiThue = tenNguoiThue;
        this.sdt = sdt;
        this.ngayBatDau = ngayBatDau;
        this.idThanhToan = idThanhToan;
        this.ghiChu = ghiChu;
    }

    public int getMaPhongTro() {
        return maPhongTro;
    }

    public void setMaPhongTro(int maPhongTro) {
        this.maPhongTro = maPhongTro;
    }

    public String getTenNguoiThue() {
        return tenNguoiThue;
    }

    public void setTenNguoiThue(String tenNguoiThue) {
        this.tenNguoiThue = tenNguoiThue;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public int getIdThanhToan() {
        return idThanhToan;
    }

    public void setIdThanhToan(int idThanhToan) {
        this.idThanhToan = idThanhToan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
