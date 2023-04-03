package codegym.vn.final_exam_module_4.service;

import codegym.vn.final_exam_module_4.model.GiaoDich;
import codegym.vn.final_exam_module_4.model.KhachHang;

import java.util.List;

public interface IKhachHangService {
    KhachHang findByName(String name);
    List<KhachHang> findAll();
}
