package repository.employee;

import model.employee.Divition;

import java.util.List;

public interface IDivitionRepository {
    List<Divition> selectAllDivition();

    Divition getDivitionById(int id);
}
