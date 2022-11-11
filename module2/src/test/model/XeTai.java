package test.model;

public class XeTai extends PhuongTien{
    private int trongTai;

    public XeTai() {
    }

    public XeTai(String maPT, String tenPT, String tenHang, int namSX, int congSuat, int dungTich, int loaiPT, int trongTai) {
        super(maPT, tenPT, tenHang, namSX, congSuat, dungTich, loaiPT);
        this.trongTai = trongTai;
    }

    public XeTai(String str){
        String [] strings = str.split(",");
        setMaPT(strings[0]);
        setTenPT(strings[1]);
        setTenHang(strings[2]);
        setNamSX(Integer.parseInt(strings[3]));
        setCongSuat(Integer.parseInt(strings[4]));
        setDungTich(Integer.parseInt(strings[5]));
        setLoaiPT(Integer.parseInt(strings[6]));
        setTrongTai(Integer.parseInt(strings[7]));
    }
    public int getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(int trongTai) {
        this.trongTai = trongTai;
    }
    public String getInFo(){
        return super.getInFo() +"," +this.getTrongTai();
    }
    @Override
    public String toString() {
        return super.toString()+
                "trongTai=" + trongTai +
                '}';
    }
}
