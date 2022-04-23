package lk.sliit.customerservice.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * author: Lasith Hansana
 * date: 9/21/2020
 * time: 3:12 PM
 */
public abstract class Model<I> {
    protected I id;
    protected PreparedStatement preparedStatement;

    public I getId() {
        return id;
    }

    public void setId(I id) {
        this.id = id;
    }

    public abstract PreparedStatement updateModel(Connection connection) throws SQLException;

    public abstract PreparedStatement saveModel(Connection connection) throws SQLException;

    public abstract Object mapToObject(ResultSet resultSet) throws SQLException;

}
