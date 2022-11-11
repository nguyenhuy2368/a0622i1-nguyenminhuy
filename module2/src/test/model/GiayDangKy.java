package test.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GiayDangKy {
    private String soDK;
    private String tenChuXe;
    private Date ngayDK;
    private String maPT;
    public SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public GiayDangKy() {
    }
    public GiayDangKy(String str) throws ParseException {
        String[] strings=str.split(",");
        setSoDK(strings[0]);
        setTenChuXe(strings[1]);
        Date date = null;
        try {
            date = simpleDateFormat.parse(strings[2]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        setNgayDK(date);
        setMaPT(strings[3]);
    }
    public GiayDangKy(String soDK, String tenChuXe, Date ngayDK, String maPT) {
        this.soDK = soDK;
        this.tenChuXe = tenChuXe;
        this.ngayDK = ngayDK;
        this.maPT = maPT;
    }

    public String getSoDK() {
        return soDK;
    }

    public void setSoDK(String soDK) {
        this.soDK = soDK;
    }

    public String getTenChuXe() {
        return tenChuXe;
    }

    public void setTenChuXe(String tenChuXe) {
        this.tenChuXe = tenChuXe;
    }

    public Date getNgayDK() {
        return ngayDK;
    }

    public void setNgayDK(Date ngayDK) {
        this.ngayDK = ngayDK;
    }

    public String getMaPT() {
        return maPT;
    }

    public void setMaPT(String maPT) {
        this.maPT = maPT;
    }
    public String getInFo(){
        Date date =null;
        String ngayDK = simpleDateFormat.format(this.ngayDK);
        return this.soDK +"," +this.tenChuXe +"," + ngayDK + "," +this.maPT;
    }
    @Override
    public String toString() {
        String ngayDK = simpleDateFormat.format(this.ngayDK);
        return "GiayDangKy{" +
                "soDK='" + soDK + '\'' +
                ", tenChuXe='" + tenChuXe + '\'' +
                ", ngayDK=" + ngayDK + " "
                ;
    }
}
