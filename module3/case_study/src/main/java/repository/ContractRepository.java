package repository;

import model.Contract;
import model.Customer;
import model.Employee;
import model.Facility;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository implements ContractRepositoryInt {
    @Override
    public List<Contract> selectAllContract() {
        Connection connection = BaseRepository.getConnect();
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        List<Contract> contractList = new ArrayList<>();
        try {
            callableStatement = connection.prepareCall("call selectAllContract()");
            resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int contractId = resultSet.getInt("contractid");
                String startDate = resultSet.getString("startDate");
                String endDate = resultSet.getString("endDate");
                double deposit = resultSet.getInt("deposit");
                String customerId = resultSet.getString("customerid");
                String customerName = resultSet.getString("customername");
                Customer customer = new Customer(customerId, customerName);
                int facilityId = Integer.parseInt(resultSet.getString("facilityid"));
                String facilityName = resultSet.getString("facilityname");
                Facility facility = new Facility(facilityId, facilityName);
                int employeeId = resultSet.getInt("employeeid");
                String employeeName = resultSet.getString("name");
                Employee employee = new Employee(employeeId, employeeName);
                Contract contract = new Contract(contractId, startDate, endDate, deposit, customer, facility, employee);
                contractList.add(contract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractList;
    }

    @Override
    public void save(Contract contract) {
        Connection connection = BaseRepository.getConnect();
    }

    @Override
    public Contract findContractById(int contractId) {
        return null;
    }

    @Override
    public void update(int contractid, Contract contract) {

    }

    @Override
    public void delete(int contractId) {

    }

    @Override
    public List<Contract> findContract(String valueFind) {
        return null;
    }
}
