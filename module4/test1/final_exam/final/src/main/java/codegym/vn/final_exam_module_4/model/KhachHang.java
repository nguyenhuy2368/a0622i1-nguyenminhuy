package codegym.vn.final_exam_module_4.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "khach_hang")
public class KhachHang {
    @Id
    private String id;
    private String name;
    private String phone;
    private String email;
     @OneToMany(mappedBy = "khachHang")
     private List<GiaoDich> giaoDichs;

    public KhachHang() {
    }

    public KhachHang(String id, String name, String phone, String email, List<GiaoDich> giaoDichs) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.giaoDichs = giaoDichs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<GiaoDich> getGiaoDichs() {
        return giaoDichs;
    }

    public void setGiaoDichs(List<GiaoDich> houses) {
        this.giaoDichs = houses;
    }
}
