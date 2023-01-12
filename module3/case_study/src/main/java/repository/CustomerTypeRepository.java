package repository;

import model.Customer;
import model.CustomerType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository implements CustomerTypeRepositoryInt {
    @Override
    public List<CustomerType> selectAllCustomerType() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Connection connection = BaseRepository.getConnect();
            preparedStatement = connection.prepareStatement("select * from customertype");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String customerTypeId = resultSet.getString("customertypeid");
                String customerTypeName = resultSet.getString("customertypename");
                CustomerType customerType = new CustomerType(customerTypeId, customerTypeName);
                customerTypeList.add(customerType);
            }
        } catch (SQLException e) {
            e.getMessage();
        }  finally {
            try {
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException e){
                e.getMessage();
            }
            BaseRepository.close();
        }
        return customerTypeList;
    }

    @Override
    public CustomerType findCustomerTypeById(String customerTypeId) {
        Connection connection = BaseRepository.getConnect();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        CustomerType customerType = null;
        try {
            preparedStatement = connection.prepareStatement("select * from customertype where customertypeid=?");
            preparedStatement.setString(1, customerTypeId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String customerTypeName = resultSet.getString("customertypename");
                customerType = new CustomerType(customerTypeId, customerTypeName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            BaseRepository.close();
        }
        return customerType;
    }
}
