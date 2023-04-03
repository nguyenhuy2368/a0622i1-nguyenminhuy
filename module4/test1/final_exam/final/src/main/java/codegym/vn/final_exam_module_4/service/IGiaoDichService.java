package codegym.vn.final_exam_module_4.service;

import codegym.vn.final_exam_module_4.model.GiaoDich;

import java.util.List;

public interface IGiaoDichService {
    void create(GiaoDich giaoDich);
    void delete(String id);
    List<GiaoDich> findAll();
    GiaoDich finById(String id);
}
