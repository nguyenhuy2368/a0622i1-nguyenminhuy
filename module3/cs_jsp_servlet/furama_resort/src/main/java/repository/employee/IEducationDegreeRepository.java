package repository.employee;

import model.employee.EducationDegree;

import java.util.List;

public interface IEducationDegreeRepository {
    List<EducationDegree> selectAllEducationDegree();
    EducationDegree getEducationDegreeById(int id);
}
