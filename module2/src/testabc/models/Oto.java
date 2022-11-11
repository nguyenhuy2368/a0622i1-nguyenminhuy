package testabc.models;

public class Oto extends PhuongTien {
    private int soChoNgoi;
    private String loaiDongCo;

    public Oto() {
    }

    public Oto(String maPhuongTien, String tenPhuongTien, String hangSanXuat, int namSanXuat, String congSuat, String dungTich, int loaiPhuongTien, int soChoNgoi, String loaiDongCo) {
        super(maPhuongTien, tenPhuongTien, hangSanXuat, namSanXuat, congSuat, dungTich, loaiPhuongTien);
        this.soChoNgoi = soChoNgoi;
        this.loaiDongCo = loaiDongCo;
    }
    public Oto(String line) {
        String[] data = line.split(",");
        this.setMaPhuongTien(data[0]);
        this.setTenPhuongTien(data[1]);
        this.setHangSanXuat(data[2]);
        this.setNamSanXuat(Integer.parseInt(data[3]));
        this.setCongSuat(data[4]);
        this.setDungTich(data[5]);
        this.setLoaiPhuongTien(Integer.parseInt(data[6]));
        this.setSoChoNgoi(Integer.parseInt(data[7]));
        this.setLoaiDongCo(data[8]);
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public String getLoaiDongCo() {
        return loaiDongCo;
    }

    public void setLoaiDongCo(String loaiDongCo) {
        this.loaiDongCo = loaiDongCo;
    }

    @Override
    public String toString() {
        return "Oto{" +
                "maPhuongTien='" + super.getMaPhuongTien() + '\'' +
                ", tenPhuongTien='" +  super.getTenPhuongTien() + '\'' +
                ", hangSanXuat='" + super.getHangSanXuat() + '\'' +
                ", namSanXuat=" + super.getNamSanXuat() +
                ", congSuat=" + super.getCongSuat() +
                ", dungTich=" + super.getDungTich() +
                "soChoNgoi=" + soChoNgoi +
                ", loaiDongCo='" + loaiDongCo + '\'' +
                '}';
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());
    }
}
