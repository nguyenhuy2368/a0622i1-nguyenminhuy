package repository;

import model.PhongTro;

import java.util.List;

public interface IPhongTroRepository {
    public List<PhongTro> findAll();
    public void addPhong (PhongTro phongTro);
    public void removeById (int id);
    public PhongTro findById (int id);
    public List<PhongTro> findByName(String phongName);
}
