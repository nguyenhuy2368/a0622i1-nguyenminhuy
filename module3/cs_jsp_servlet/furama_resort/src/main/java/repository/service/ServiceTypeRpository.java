package repository.service;

import model.service.ServiceType;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRpository implements ISerivceTypeRepository {
    private final String SELECT_ALL_SERVICE_TYPE = "SELECT * FROM furamar_jsp_servlet.service_type;";
    private final String SELECT_SERVICE_TYPE_BY_ID = "SELECT * FROM furamar_jsp_servlet.service_type where service_type_id = ?;";
    @Override
    public List<ServiceType> selectAllServiceType() {
        List<ServiceType> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SERVICE_TYPE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                list.add(new ServiceType(id,name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public ServiceType getServiceTypeById(int id) {
        ServiceType serviceType = new ServiceType();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_SERVICE_TYPE_BY_ID);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString(2);
                serviceType = new ServiceType(id,name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serviceType;
    }
}
