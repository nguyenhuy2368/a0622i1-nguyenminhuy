package repository.customer;

import model.customer.CustomerType;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository implements ICustomerTypeRepository {
    private final String  SELECT_CUSTOMER_TYPE = "SELECT * FROM customer_type";
    @Override
    public List<CustomerType> selectAllCustomerType() {
        List<CustomerType> list =new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_CUSTOMER_TYPE);
            ResultSet resultSet = statement.executeQuery();
            CustomerType customerType = null;
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                customerType = new CustomerType(id,name);
                list.add(customerType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public CustomerType findCustomerTypeById(int id) {
        return selectAllCustomerType().get(id);
    }
}
