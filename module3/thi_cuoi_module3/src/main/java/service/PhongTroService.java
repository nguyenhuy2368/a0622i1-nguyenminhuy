package service;

import model.PhongTro;
import repository.IPhongTroRepository;
import repository.PhongTroRepository;

import java.util.List;

public class PhongTroService implements IPhongTroService {
    IPhongTroRepository repository = new PhongTroRepository();

    @Override
    public List<PhongTro> findAll() {
        return repository.findAll();
    }

    @Override
    public void addPhong(PhongTro phongTro) {
        repository.addPhong(phongTro);
    }

    @Override
    public void removeById(int id) {
        repository.removeById(id);
    }

    @Override
    public PhongTro findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<PhongTro> findByName(String phongName) {
        return repository.findByName(phongName);
    }
}
