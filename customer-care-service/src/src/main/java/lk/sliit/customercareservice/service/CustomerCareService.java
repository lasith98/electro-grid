package lk.sliit.customercareservice.service;

import lk.sliit.customercareservice.model.CustomerCareModel;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerCareService {
    public String insert(CustomerCareModel model) {

        String output;
        try {
            Connection con = connect();

            // create a prepared statement
            String query = "INSERT INTO customer_care (customerId,bilAccount,complainType) VALUE (?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            // binding values
            preparedStmt.setLong(1, model.getCustomerId());
            preparedStmt.setLong(2, model.getBilAccount());
            preparedStmt.setString(3, model.getComplainType());
            // execute the statement
            preparedStmt.execute();
            con.close();
            output = "Inserted successfully";
        } catch (Exception e) {
            output = "Error while inserting the item.";
            System.err.println(e.getMessage());
        }
        return output;


    }

    public String update(CustomerCareModel model) {
        String output;
        try {
            Connection con = connect();
            if (con == null) {
                return "Error while connecting to the database for inserting.";
            }
            // create a prepared statement
            String query = "UPDATE customer_care SET customerId=?,bilAccount=?,complainType=? WHERE id=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            // binding values
            preparedStmt.setLong(1, model.getCustomerId());
            preparedStmt.setLong(2, model.getBilAccount());
            preparedStmt.setString(3, model.getComplainType());
            preparedStmt.setLong(4, model.getId());
            // execute the statement
            preparedStmt.execute();
            con.close();
            output = "Update successfully";
        } catch (Exception e) {
            output = "Error while Update  the item.";
            System.err.println(e.getMessage());
        }
        return output;
    }

    public String delete(Long id) {

        String output = "";
        try {
            Connection con = connect();
            if (con == null) {
                return "Error while connecting to the database for deleting.";
            }
            // create a prepared statement
            String query = "delete from customer_care where id=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            // binding values
            preparedStmt.setLong(1, id);
            // execute the statement
            preparedStmt.execute();
            con.close();
            output = "Deleted successfully";
        } catch (Exception e) {
            output = "Error while deleting the item.";
            System.err.println(e.getMessage());
        }
        return output;

    }

    public List<CustomerCareModel> list() {

        List<CustomerCareModel> list = new ArrayList<>();

        try {
            Connection con = connect();


            String query = "select * from customer_care";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            // iterate through the rows in the result set
            while (rs.next()) {
                CustomerCareModel model = new CustomerCareModel();
                model.setId(rs.getLong("id"));
                model.setCustomerId(rs.getLong("customerId"));
                model.setBilAccount(rs.getLong("bilAccount"));
                model.setComplainType(rs.getString("complainType"));
                list.add(model);
            }
            con.close();
            // Complete the html table

        } catch (Exception e) {

            System.err.println(e.getMessage());
        }
        return list;


    }


    private Connection connect() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            //Provide the correct details: DBServer/DBName, username, password
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/customer_care", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
