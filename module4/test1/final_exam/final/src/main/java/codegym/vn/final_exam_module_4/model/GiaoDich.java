package codegym.vn.final_exam_module_4.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "giao_dich")
public class GiaoDich {
    @Id
    private String idHouse;
    @ManyToOne()
    @JoinColumn(name = "idCustomer", referencedColumnName = "id")
    private KhachHang khachHang;
    private Date ngayGiaoDich;
    private boolean loaiDichVu;
    private Double donGia;
    private Double dienTich;

    public GiaoDich() {
    }

    public GiaoDich(String idHouse, KhachHang khachHang, Date ngayGiaoDich, boolean loaiDichVu, Double donGia, Double dienTich) {
        this.idHouse = idHouse;
        this.khachHang = khachHang;
        this.ngayGiaoDich = ngayGiaoDich;
        this.loaiDichVu = loaiDichVu;
        this.donGia = donGia;
        this.dienTich = dienTich;
    }

    public String getIdHouse() {
        return idHouse;
    }

    public void setIdHouse(String idHouse) {
        this.idHouse = idHouse;
    }

    public KhachHang getCustomer() {
        return khachHang;
    }

    public void setCustomer(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public Date getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public void setNgayGiaoDich(Date ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }


    public boolean isLoaiDichVu() {
        return loaiDichVu;
    }

    public void setLoaiDichVu(boolean loaiDichVu) {
        this.loaiDichVu = loaiDichVu;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public Double getDienTich() {
        return dienTich;
    }

    public void setDienTich(Double dienTich) {
        this.dienTich = dienTich;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }
}
