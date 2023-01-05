package service.employee;

import model.employee.Divition;
import repository.employee.DivitionRepository;
import repository.employee.IDivitionRepository;

import java.util.List;

public class DivitionService implements IDivitionService {
    IDivitionRepository repository = new DivitionRepository();
    @Override
    public List<Divition> selectAllDivition() {
        return repository.selectAllDivition();
    }

    @Override
    public Divition getDivitionById(int id) {
        for (int i = 0; i < repository.selectAllDivition().size() ; i++) {
            if (repository.selectAllDivition().get(i).getId()==id){
                return repository.selectAllDivition().get(i);
            }
        }
        return null;
    }
}
