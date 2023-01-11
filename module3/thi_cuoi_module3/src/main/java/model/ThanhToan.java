package model;

public class ThanhToan {
    private int idThanhToan;
    private String tenHinhThuc;

    public ThanhToan() {
    }

    public ThanhToan(int idThanhToan, String tenHinhThuc) {
        this.idThanhToan = idThanhToan;
        this.tenHinhThuc = tenHinhThuc;
    }

    public int getIdThanhToan() {
        return idThanhToan;
    }

    public void setIdThanhToan(int idThanhToan) {
        this.idThanhToan = idThanhToan;
    }

    public String getTenHinhThuc() {
        return tenHinhThuc;
    }

    public void setTenHinhThuc(String tenHinhThuc) {
        this.tenHinhThuc = tenHinhThuc;
    }
}
