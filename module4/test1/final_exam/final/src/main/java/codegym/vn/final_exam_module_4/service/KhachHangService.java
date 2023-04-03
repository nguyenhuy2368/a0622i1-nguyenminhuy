package codegym.vn.final_exam_module_4.service;

import codegym.vn.final_exam_module_4.model.KhachHang;
import codegym.vn.final_exam_module_4.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangService implements IKhachHangService {
    @Autowired
    KhachHangRepository khachHangRepository;
    @Override
    public KhachHang findByName(String name) {
        return null;
    }

    @Override
    public List<KhachHang> findAll() {
        return khachHangRepository.findAll();
    }
}
