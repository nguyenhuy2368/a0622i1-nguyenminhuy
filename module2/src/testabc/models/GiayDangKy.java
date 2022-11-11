package testabc.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GiayDangKy {
    private String soDangKy;
    private String tenChuPhuongTien;
    private Date ngayDangKy;
    private String maPhuongTien;

    public GiayDangKy() {
    }

    public GiayDangKy(String soDangKy, String tenChuPhuongTien, Date ngayDangKy, String maPhuongTien) {
        this.soDangKy = soDangKy;
        this.tenChuPhuongTien = tenChuPhuongTien;
        this.ngayDangKy = ngayDangKy;
        this.maPhuongTien = maPhuongTien;
    }

    public GiayDangKy(String line) {
        String[] data = line.split(",");
        setSoDangKy(data[0]);
        setTenChuPhuongTien(data[1]);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = format.parse(data[2]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        setNgayDangKy(date);
        setMaPhuongTien(data[3]);
    }

    public String getSoDangKy() {
        return soDangKy;
    }

    public void setSoDangKy(String soDangKy) {
        this.soDangKy = soDangKy;
    }

    public String getTenChuPhuongTien() {
        return tenChuPhuongTien;
    }

    public void setTenChuPhuongTien(String tenChuPhuongTien) {
        this.tenChuPhuongTien = tenChuPhuongTien;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public String getMaPhuongTien() {
        return maPhuongTien;
    }

    public void setMaPhuongTien(String maPhuongTien) {
        this.maPhuongTien = maPhuongTien;
    }

    public String getInfor() {
        Date date = new Date();
        date = this.ngayDangKy;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(date);
        return this.soDangKy + "," + this.tenChuPhuongTien + "," + this.ngayDangKy + "," + this.maPhuongTien;
    }

    @Override
    public String toString() {
        Date date = new Date();
        date = this.ngayDangKy;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(date);
        return "GiayDangKy{" +
                "soDangKy=" + soDangKy +
                ", tenChuPhuongTien='" + tenChuPhuongTien + '\'' +
                ", ngayDangKy='" + ngayDangKy + '\'' +
                ", maPhuongTien='" + maPhuongTien + '\'' +
                '}';
    }
}
