package thi.models;

public class SecondMobile extends Moblie {
    private String fromNation;
    private String status;

    public SecondMobile() {
    }

    public SecondMobile(int id, String name, int price, int quantity, String brand, String fromNation, String status) {
        super(id, name, price, quantity, brand);
        this.fromNation = fromNation;
        this.status = status;
    }

    public String getFromNation() {
        return fromNation;
    }

    public void setFromNation(String fromNation) {
        this.fromNation = fromNation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "SecondMobile{" +
                super.toString() +
                "fromNation='" + fromNation + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
