package lk.sliit.customerservice.repository;

import lk.sliit.customerservice.model.Model;
import lk.sliit.customerservice.util.DatabaseHandler;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Repository<M, I> {
    public static final String SELECT_FROM = "SELECT * FROM ";
    protected Model<I> model;
    protected String tableName;
    protected DatabaseHandler databaseHandler = DatabaseHandler.getInstance();
    protected PreparedStatement preparedStatement;


    public void save(Model<I> model) throws SQLException, ClassNotFoundException {
        model.saveModel(databaseHandler.open()).execute();
        databaseHandler.close();
    }

    public void update(Model<I> model) throws SQLException, ClassNotFoundException {
        model.updateModel(databaseHandler.open()).execute();
        databaseHandler.close();
    }

    public void delete(I id) throws SQLException, ClassNotFoundException {
        preparedStatement = databaseHandler.open().prepareStatement(String.join(" ", "DELETE FROM", tableName, "WHERE id = ?"));
        preparedStatement.setObject(1, id);
        preparedStatement.executeUpdate();
        databaseHandler.close();
    }


    public List<M> findALl() throws SQLException, ClassNotFoundException {
        List<M> models = new ArrayList<>();

        ResultSet resultSet = databaseHandler.open().createStatement().executeQuery(SELECT_FROM + tableName);
        while (resultSet.next()) {
            models.add((M) model.mapToObject(resultSet));
        }
        databaseHandler.close();
        return models;
    }

    public M findById(I id) throws SQLException, ClassNotFoundException {
        M object = null;
        preparedStatement = databaseHandler.open().prepareStatement(String.join(" ", SELECT_FROM, tableName, "WHERE id = ? "));
        preparedStatement.setObject(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            object = (M) model.mapToObject(resultSet);
        }
        databaseHandler.close();
        return object;
    }

    public M lastRecode() throws SQLException, ClassNotFoundException {
        M object = null;
        preparedStatement = databaseHandler.open().prepareStatement(String.join(" ", SELECT_FROM, tableName, "ORDER BY ID DESC LIMIT 1"));
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            object = (M) model.mapToObject(resultSet);
        }
        databaseHandler.close();
        return object;
    }


}
