package service.employee;

import model.employee.EducationDegree;
import repository.employee.EducationDegreeRepository;
import repository.employee.IEducationDegreeRepository;
import repository.employee.IEmployeeRepository;

import java.util.List;

public class EducationDegreeService implements IEducationDegreeService {
    IEducationDegreeRepository repository =new EducationDegreeRepository();
    @Override
    public List<EducationDegree> selectAllEducationDegree() {
        return repository.selectAllEducationDegree();
    }

    @Override
    public EducationDegree getEducationDegreeById(int id) {
        for (int i = 0; i < repository.selectAllEducationDegree().size(); i++) {
            if (repository.selectAllEducationDegree().get(i).getId()==id){
                return repository.selectAllEducationDegree().get(i);
            }
        }
        return null;
    }
}
