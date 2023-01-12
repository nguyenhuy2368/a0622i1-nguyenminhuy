package service;

import model.HocSinh;
import repositpry.HocSinhReponsitory;
import repositpry.IHocSinhReponsitory;

import java.util.List;

public class HocSinhService implements IHocSinhService {
    IHocSinhReponsitory hocSinhReponsitory = new HocSinhReponsitory();
    @Override
    public List<HocSinh> findAll() {
        return hocSinhReponsitory.findAll();
    }
}
