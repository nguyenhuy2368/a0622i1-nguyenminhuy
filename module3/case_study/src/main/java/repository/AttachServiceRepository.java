package repository;

import model.AttachFacility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachServiceRepository implements AttachServiceRepositoryInt {
    @Override
    public List<AttachFacility> selectAllAttachService() {
        Connection connection = BaseRepository.getConnect();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<AttachFacility> attachServiceList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select * from attachservices");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int attachFacilityId = Integer.parseInt(resultSet.getString("AttachServiceId"));
                String attachFacilityName = resultSet.getString("AttachServiceName");
                AttachFacility attachFacility = new AttachFacility(attachFacilityId, attachFacilityName);
                attachServiceList.add(attachFacility);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attachServiceList;
    }
}
