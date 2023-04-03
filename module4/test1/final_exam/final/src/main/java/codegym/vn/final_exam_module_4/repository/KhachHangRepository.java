package codegym.vn.final_exam_module_4.repository;

import codegym.vn.final_exam_module_4.model.GiaoDich;
import codegym.vn.final_exam_module_4.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang,String> {
    List<GiaoDich> findByNameContaining(String name);
}
