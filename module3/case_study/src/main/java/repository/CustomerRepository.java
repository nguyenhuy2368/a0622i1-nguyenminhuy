package repository;

import model.Customer;
import model.CustomerType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements CustomerRepositoryInt {
    CustomerTypeRepositoryInt customerTypeRepositoryInt = new CustomerTypeRepository();
    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try (Connection connection = BaseRepository.getConnect()) {
            preparedStatement = connection.prepareStatement("select customers.*,customertype.CustomerTypeName from customers inner join customertype on customers.CustomerTypeId=customertype.CustomerTypeId");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String customerId = resultSet.getString("customerid");
                String customerName = resultSet.getString("customername");
                String birthday = resultSet.getString("birthday");
                String idCard = resultSet.getString("idcard");
                String phoneNumber = resultSet.getString("phonenumber");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String customerTypeId = resultSet.getString("customertypeid");
                String customerTypeName = resultSet.getString("customertypename");
                CustomerType customerType = new CustomerType(customerTypeId,customerTypeName);
                Customer customer = new Customer(customerId, customerName, birthday, idCard, phoneNumber, email, customerType, address);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.getMessage();
            }
            BaseRepository.close();
        }
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        PreparedStatement preparedStatement = null;
        try (Connection connection = BaseRepository.getConnect()) {
            preparedStatement = connection.prepareStatement("insert into customers(customerid,customername,birthday,idcard,phonenumber,email,customertypeid,address) values (?,?,?,?,?,?,?,?)");

            preparedStatement.setString(1, customer.getCustomerId());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getBirthday());
            preparedStatement.setString(4, customer.getIdCard());
            preparedStatement.setString(5, customer.getPhoneNumber());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getCustomerType().getCustomerTypeId());
            preparedStatement.setString(8, customer.getAddress());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.getMessage();
                }
                BaseRepository.close();
            }


        }
    }

    @Override
    public void remove(String customerid) {
        Connection connection = BaseRepository.getConnect();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from customers where customerid=?");
            preparedStatement.setString(1, customerid);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            BaseRepository.close();
        }
    }

    @Override
    public Customer findCustomerById(String customerId) {
        Connection connection = BaseRepository.getConnect();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Customer customer = null;

        try {
            preparedStatement = connection.prepareStatement("select * from customers where customerid=?");
            preparedStatement.setString(1, customerId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String customerName = resultSet.getString("customername");
                String birthday = resultSet.getString("birthday");
                String idCard = resultSet.getString("idcard");
                String phoneNumber = resultSet.getString("phonenumber");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String customerTypeId = resultSet.getString("customertypeid");
                CustomerType customerType = customerTypeRepositoryInt.findCustomerTypeById(customerTypeId);
                customer = new Customer(customerId, customerName, birthday, idCard, phoneNumber, email, customerType, address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }   finally {
            try {
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException e){
                e.getMessage();
            }
            BaseRepository.close();
        }
        return customer;
    }

    @Override
    public void update(String customerId, Customer customer) {
        Connection connection = BaseRepository.getConnect();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update customers set customername=?, birthday=?,idcard=?, phonenumber=?,email=?,customertypeid=?,address=? where customerid=? ");
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setString(2, customer.getBirthday());
            preparedStatement.setString(3, customer.getIdCard());
            preparedStatement.setString(4, customer.getPhoneNumber());
            preparedStatement.setString(5, customer.getEmail());
            preparedStatement.setString(6, customer.getCustomerType().getCustomerTypeId());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setString(8, customerId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                preparedStatement.close();
            } catch (SQLException e){
                e.getMessage();
            }
            BaseRepository.close();
        }
    }

    @Override
    public String findNameCustomer(String customerId) {
        Connection connection =BaseRepository.getConnect();
        CallableStatement callableStatement=null;
        ResultSet resultSet=null;
        String customerName=null;

        try {
            callableStatement=connection.prepareCall("call findNameCustomer(?,?)");
            callableStatement.setString(1,customerId);
            callableStatement.executeQuery();
            customerName=callableStatement.getString(2);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                callableStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        BaseRepository.close();
        return  customerName;
    }

//    @Override
//    public int getLastCustomerId() {
//        return 0;
    }
}
