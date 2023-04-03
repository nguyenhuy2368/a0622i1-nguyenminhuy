package codegym.vn.final_exam_module_4.repository;

import codegym.vn.final_exam_module_4.model.GiaoDich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiaoDichRepository extends JpaRepository<GiaoDich,String> {
    public void deleteAllByIdHouse(String id);
}
