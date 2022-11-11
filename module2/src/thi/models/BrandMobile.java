package thi.models;

public class BrandMobile extends Moblie {
    private int timeGuarantee;
    private String rangeGuarante;

    public BrandMobile() {
    }

    public BrandMobile(int id, String name, int price, int quantity, String brand, int timeGuarantee, String rangeGuarante) {
        super(id, name, price, quantity, brand);
        this.timeGuarantee = timeGuarantee;
        this.rangeGuarante = rangeGuarante;
    }

    public int getTimeGuarantee() {
        return timeGuarantee;
    }

    public void setTimeGuarantee(int timeGuarantee) {
        this.timeGuarantee = timeGuarantee;
    }

    public String getRangeGuarante() {
        return rangeGuarante;
    }

    public void setRangeGuarante(String rangeGuarante) {
        this.rangeGuarante = rangeGuarante;
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "BrandMobile{" +
                "id=" + super.getId() + '\'' +
                ", name='" +super.getName() + '\'' +
                ", price=" + super.getPrice() + '\'' +
                ", quantity=" + super.getQuantity() +'\'' +
                ", brand='" + super.getBrand() + '\'' +
                ", timeGuarantee=" + timeGuarantee +'\'' +
                ", rangeGuarante='" + rangeGuarante + '\'' +
                '}';
    }
}
