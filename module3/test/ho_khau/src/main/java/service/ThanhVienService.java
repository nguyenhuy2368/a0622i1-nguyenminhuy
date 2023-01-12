package service;

import model.ThanhVien;
import repository.IThanhVienRepository;
import repository.ThanhVienRepository;

import java.util.List;

public class ThanhVienService implements IThanhVienService{
    IThanhVienRepository repository = new ThanhVienRepository();
    @Override
    public List<ThanhVien> listThanhVien() {
        return repository.listThanhVien();
    }
}
