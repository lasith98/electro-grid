package lk.sliit.powerusagemonitoringservice.service;

import lk.sliit.powerusagemonitoringservice.model.Usage;
import lk.sliit.powerusagemonitoringservice.model.UsageMonitoringModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsageMonitoringService {
    public String insert(UsageMonitoringModel model) {

        String output;
        try {
            Connection con = connect();

            // create a prepared statement
            String query = "INSERT INTO power_usage (customer_id,date,unit) VALUE (?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            // binding values
            preparedStmt.setLong(1, model.getCustomerId());
            preparedStmt.setDate(2, Date.valueOf(model.getDate()));
            preparedStmt.setFloat(3, model.getUnit());
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

    public String update(UsageMonitoringModel model) {
        String output;
        try {
            Connection con = connect();
            if (con == null) {
                return "Error while connecting to the database for inserting.";
            }
            // create a prepared statement
            String query = "UPDATE power_usage SET customer_id=?,date=?,unit=? WHERE id=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            // binding values
            preparedStmt.setLong(1, model.getCustomerId());
            preparedStmt.setDate(2, Date.valueOf(model.getDate()));
            preparedStmt.setFloat(3, model.getUnit());
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
            String query = "delete from power_usage where id=?";
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

    public List<UsageMonitoringModel> list() {

        List<UsageMonitoringModel> list = new ArrayList<>();

        try {
            Connection con = connect();


            String query = "select * from power_usage";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            // iterate through the rows in the result set
            while (rs.next()) {
                UsageMonitoringModel model = new UsageMonitoringModel();
                model.setId(rs.getLong("id"));
                model.setDate(rs.getString("date"));
                model.setUnit(rs.getLong("unit"));
                model.setCustomerId(rs.getLong("customer_id"));
                list.add(model);
            }
            con.close();
            // Complete the html table

        } catch (Exception e) {

            System.err.println(e.getMessage());
        }
        return list;


    }

    public List<Usage> monthlyUsage(Long customerId, String year, String month) {

        List<Usage> list = new ArrayList<>();

        try {
            Connection con = connect();


            PreparedStatement stmt = con.prepareStatement("select * from power_usage where YEAR(date) =? and MONTH(date)=? and customer_id=?");
            stmt.setString(1, year);
            stmt.setString(2, month);
            stmt.setLong(3, customerId);
            ResultSet rs = stmt.executeQuery();

            // iterate through the rows in the result set
            while (rs.next()) {
                Usage model = new Usage();
                model.setDate(rs.getString("date"));
                model.setUnit(rs.getLong("unit"));
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
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/usage_service", "root", );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
