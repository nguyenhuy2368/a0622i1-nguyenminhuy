package repository.employee;

import model.employee.Position;
import org.omg.PortableServer.POA;

import java.util.List;

public interface IPositionRepository {
    List<Position> selectAllPosition();
    Position getPositionById(int id);
}
