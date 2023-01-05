package service.employee;

import model.employee.Divition;

import java.util.List;

public interface IDivitionService {
    List<Divition> selectAllDivition();

    Divition getDivitionById(int id);
}
