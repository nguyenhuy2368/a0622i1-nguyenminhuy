package service;

import model.ThanhVien;
import repository.IThanhVienRepository;
import repository.ThanhVienRepository;

import java.util.List;

public class ThanhVienService implements IThanhVienService{
    private IThanhVienRepository thanhVienRepository = new ThanhVienRepository();
    @Override
    public List<ThanhVien> selectAllThanhVien() {
        return thanhVienRepository.selectAllThanhVien();
    }
}
