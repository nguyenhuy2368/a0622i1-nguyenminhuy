package testabc.models;

public class XeTai extends PhuongTien {
    private int TrongTai;

    public XeTai() {
    }

    public XeTai(String maPhuongTien, String tenPhuongTien, String hangSanXuat, int namSanXuat, String congSuat, String dungTich, int loaiPhuongTien, int trongTai) {
        super(maPhuongTien, tenPhuongTien, hangSanXuat, namSanXuat, congSuat, dungTich, loaiPhuongTien);
        TrongTai = trongTai;
    }

    public XeTai(String line) {
        String[] data = line.split(",");
        this.setMaPhuongTien(data[0]);
        this.setTenPhuongTien(data[1]);
        this.setHangSanXuat(data[2]);
        this.setNamSanXuat(Integer.parseInt(data[3]));
        this.setCongSuat(data[4]);
        this.setDungTich(data[5]);
        this.setLoaiPhuongTien(Integer.parseInt(data[6]));
        this.setTrongTai(Integer.parseInt(data[7]));
    }

    public int getTrongTai() {
        return TrongTai;
    }

    public void setTrongTai(int trongTai) {
        TrongTai = trongTai;
    }

    public String getInfor() {
        return this.getMaPhuongTien() + "," + this.getTenPhuongTien() + "," + this.getHangSanXuat() + "," + this.getNamSanXuat() + "," + this.getCongSuat() + "," + this.getDungTich() + "," + this.getTrongTai();
    }

    @Override
    public String toString() {
        return "XeTai{" +
                "maPhuongTien='" + super.getMaPhuongTien() + '\'' +
                ", tenPhuongTien='" + super.getTenPhuongTien() + '\'' +
                ", hangSanXuat='" + super.getHangSanXuat() + '\'' +
                ", namSanXuat=" + super.getNamSanXuat() +
                ", congSuat=" + super.getCongSuat() +
                ", dungTich=" + super.getDungTich() +
                "TrongTai=" + TrongTai +
                '}';
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());
    }
}
