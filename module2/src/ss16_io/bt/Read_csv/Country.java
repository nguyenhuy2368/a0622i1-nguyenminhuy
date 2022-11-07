package ss16_io.bt.Read_csv;

public class Country {
    private String id;
    private String code;
    private String name;

    public Country() {
    }

    public Country(String id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public Country(String str) {
        String[]data = str.split(",");
        this.id= data[0];
        this.code= data[1];
        this.name= data[2];

    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
    public String getInfo() {
        return this.id + "," + this.name + "," + this.code;
    }
}
