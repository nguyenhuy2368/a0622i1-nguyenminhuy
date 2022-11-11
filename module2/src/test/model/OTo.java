package test.model;

public class OTo extends PhuongTien{
    private int soChoNgoi;
    private String loaiDongCo;

    public OTo() {
    }

    public OTo(String maPT, String tenPT, String tenHang, int namSX, int congSuat, int dungTich, int loaiPT, int soChoNgoi, String loaiDongCo) {
        super(maPT, tenPT, tenHang, namSX, congSuat, dungTich, loaiPT);
        this.soChoNgoi = soChoNgoi;
        this.loaiDongCo = loaiDongCo;
    }
    public OTo(String str){
        String [] strings = str.split(",");
        setMaPT(strings[0]);
        setTenPT(strings[1]);
        setTenHang(strings[2]);
        setNamSX(Integer.parseInt(strings[3]));
        setCongSuat(Integer.parseInt(strings[4]));
        setDungTich(Integer.parseInt(strings[5]));
        setLoaiPT(Integer.parseInt(strings[6]));
        setSoChoNgoi(Integer.parseInt(strings[7]));
        setLoaiDongCo(strings[8]);
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
    public String getInFo(){
        return super.getInFo() + "," + this.getSoChoNgoi() + "," +this.getLoaiDongCo();
    }
    @Override
    public String toString() {
        return super.toString()+
                "soChoNgoi=" + soChoNgoi +
                ", loaiDongCo='" + loaiDongCo + '\'' +
                '}';
    }
}
