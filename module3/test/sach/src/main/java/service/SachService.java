package service;

import model.Sach;
import repositpry.ISachReponsitory;
import repositpry.SachReponsitory;

import java.util.List;

public class SachService implements ISachService{
    ISachReponsitory sachReponsitory = new SachReponsitory();
    @Override
    public List<Sach> findAll() {
        return sachReponsitory.findAll();
    }
}
