package lk.sliit.customerservice.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
public class CustomerModel extends Model<Long> {
    private String firstName;
    private String lastName;
    private String nic;
    private String mobileNo;
    private String email;
    private String address;

    @Override
    public PreparedStatement updateModel(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE customer_information SET first_name=?, last_name=?, nic=?, mobile_no=?, email=?, address=? WHERE id=?");

        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        preparedStatement.setString(3, nic);
        preparedStatement.setString(4, mobileNo);
        preparedStatement.setString(5, email);
        preparedStatement.setString(6, address);
        preparedStatement.setLong(7, id);
        return preparedStatement;
    }

    @Override
    public PreparedStatement saveModel(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customer_information (first_name, last_name, nic, mobile_no, email, address) VALUES (?,?,?,?,?,?) ");

        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        preparedStatement.setString(3, nic);
        preparedStatement.setString(4, mobileNo);
        preparedStatement.setString(5, email);
        preparedStatement.setString(6, address);
        return preparedStatement;
    }

    @Override
    public Object mapToObject(ResultSet resultSet) throws SQLException {
        CustomerModel model = new CustomerModel();
        model.setId(resultSet.getLong("id"));
        model.setFirstName(resultSet.getString("first_name"));
        model.setLastName(resultSet.getString("last_name"));
        model.setNic(resultSet.getString("nic"));
        model.setMobileNo(resultSet.getString("mobile_no"));
        model.setEmail(resultSet.getString("email"));
        model.setAddress(resultSet.getString("address"));
        return model;
    }
}
