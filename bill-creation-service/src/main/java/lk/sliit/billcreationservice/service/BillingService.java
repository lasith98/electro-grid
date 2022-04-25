package lk.sliit.billcreationservice.service;

import lk.sliit.billcreationservice.model.BillingModel;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillingService {
    public String insert(BillingModel model) {

        String output;
        try {
            Connection con = connect();

            // create a prepared statement
            String query = "INSERT INTO  billing (customer_id,date,unit,price) VALUE (?,?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            // binding values
            preparedStmt.setLong(1, model.getCustomerId());
            preparedStmt.setDate(2, Date.valueOf(model.getDate()));
            preparedStmt.setFloat(3, model.getUnit());
            preparedStmt.setFloat(4, model.getPrice());
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

    public String update(BillingModel model) {
        String output;
        try {
            Connection con = connect();
            if (con == null) {
                return "Error while connecting to the database for inserting.";
            }
            // create a prepared statement
            String query = "UPDATE  billing SET customer_id=?,date=?,unit=?,price=? WHERE id=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            // binding values
            preparedStmt.setLong(1, model.getCustomerId());
            preparedStmt.setDate(2, Date.valueOf(model.getDate()));
            preparedStmt.setFloat(3, model.getUnit());
            preparedStmt.setFloat(4, model.getPrice());
            preparedStmt.setLong(5, model.getId());
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
            String query = "delete from  billing where id=?";
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

    public List<BillingModel> list() {

        List<BillingModel> list = new ArrayList<>();

        try {
            Connection con = connect();


            String query = "select * from  billing";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            // iterate through the rows in the result set
            while (rs.next()) {
                BillingModel model = new BillingModel();
                model.setId(rs.getLong("id"));
                model.setDate(rs.getString("date"));
                model.setUnit(rs.getLong("unit"));
                model.setCustomerId(rs.getLong("customer_id"));
                model.setPrice(rs.getFloat("price"));
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
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bill_service", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
