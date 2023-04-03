package codegym.vn.final_exam_module_4.service;

import codegym.vn.final_exam_module_4.model.GiaoDich;
import codegym.vn.final_exam_module_4.repository.GiaoDichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiaoDichService implements IGiaoDichService{
    @Autowired
    GiaoDichRepository giaoDichRepository;
    @Override
    public void create(GiaoDich giaoDich) {
        giaoDichRepository.save(giaoDich);
    }

    @Override
    public void delete(String id) {
        giaoDichRepository.deleteAllByIdHouse(id);
    }

    @Override
    public List<GiaoDich> findAll() {
        return giaoDichRepository.findAll();
    }

    @Override
    public GiaoDich finById(String id) {
        return giaoDichRepository.findById(id).orElse(null);
    }
}
