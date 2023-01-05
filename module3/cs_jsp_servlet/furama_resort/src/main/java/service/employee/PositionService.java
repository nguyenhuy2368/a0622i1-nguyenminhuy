package service.employee;

import model.employee.Position;
import repository.employee.IPositionRepository;
import repository.employee.PositionRepository;

import java.util.List;

public class PositionService implements IPositionService{
    IPositionRepository repository = new PositionRepository();
    @Override
    public List<Position> selectAllPosition() {
        return repository.selectAllPosition();
    }

    @Override
    public Position getPositionById(int id) {
        for (int i = 0; i < repository.selectAllPosition().size(); i++) {
            if (repository.selectAllPosition().get(i).getId()==id){
                return repository.selectAllPosition().get(i);
            }
        }
        return null;
    }
}
