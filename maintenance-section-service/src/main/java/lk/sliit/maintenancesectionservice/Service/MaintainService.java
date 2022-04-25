package lk.sliit.maintenancesectionservice.Service;
import lk.sliit.maintenancesectionservice.Model.MainteinenceModel;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class MaintainService {

    Connection con= null;

    public MaintainService() {
            String url = "jdbc:mysql://localhost:3306/maintaindb";
            String username="root";
            String password="root";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(url, username, password);
            }
            catch(Exception e){
                System.out.println(e);
            }
    }

    public String  getMaintain() {
        String output = "";
        List<MainteinenceModel> maintains = new ArrayList<>();
        String sql = "select * from maintain";
        try {
            output = "<table border='1'><tr><th>Maintain ID</th><th>Description</th><th>Affected Area</th><th>Affected Time</th><th>Predicted Time Range</th>" +
                    "<th>Update</th><th>Remove</th></tr>";
            Statement st = con.createStatement();
            ResultSet rs =st.executeQuery(sql);
            while(rs.next()){
                MainteinenceModel m= new MainteinenceModel();
                String ID= Integer.toString(rs.getInt("ID"));
                String description= rs.getString("description");
                String affected_Area= rs.getString("affected_Area");
                String affected_time= rs.getString("affected_time");
                String predicted_time= rs.getString("predicted_time");
                // adding to table
                output += "<tr><td>" + ID + "</td>";
                output += "<td>" + description + "</td>";
                output += "<td>" + affected_Area + "</td>";
                output += "<td>" + affected_time + "</td>";
                output += "<td>" + predicted_time + "</td>";
                //buttons
                output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
                        + "<td><form method='post' action='maintain.jsp'>"
                        + "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
                        + "<input name='itemID' type='hidden' value='" + ID + "'>" + "</form></td></tr>";
            }
            output += "</table>";
        }
        catch(Exception e){
            System.out.println(e);
        }
        return output;
    }

    public MainteinenceModel getMaintain(int ID) {

        String sql = "select * from maintain where ID="+ID;
        MainteinenceModel m= new MainteinenceModel();
        try {
            Statement st = con.createStatement();
            ResultSet rs =st.executeQuery(sql);
            if(rs.next()){

                m.setID(rs.getInt(1));
                m.setDescription(rs.getString(2));
                m.setAffected_Area((rs.getString(3)));
                m.setAffected_time(rs.getString(4));
                m.setPredicted_time(rs.getString(5));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return m;
    }

    public void createMaintainReco(MainteinenceModel m1)
    {
        String sql = "insert into maintain values(?,?,?,?,?)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,m1.getID());
            st.setString(2,m1.getDescription());
            st.setString(3,m1.getAffected_Area());
            st.setString(4, m1.getAffected_time());
            st.setString(5,m1.getPredicted_time());
            st.executeUpdate();

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public String updateMaintainReco(MainteinenceModel m1)
    {
        String feedback = "";
        String sql = "update maintain set description=?, affected_Area=?,affected_time=?,predicted_time=? where ID=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(5,m1.getID());
            st.setString(1,m1.getDescription());
            st.setString(2,m1.getAffected_Area());
            st.setString(3, m1.getAffected_time());
            st.setString(4,m1.getPredicted_time());
            st.executeUpdate();
            feedback= "Record has been updated successfully!";

        }
        catch(Exception e){
            System.out.println(e);
        }
        return feedback;
    }

    public String  deleteMaintainReco(int ID) {
        String feedback = "";
        String sql = "delete from maintain where ID=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
           st.setInt(1,ID);
           st.executeUpdate();
            feedback = "Record has been deleted successfully!";

        }
        catch(Exception e){
            System.out.println(e);
        }
        return feedback;
    }

    public List<MainteinenceModel> getMaintainInJson() {
        List<MainteinenceModel> maintains = new ArrayList<>();
        String sql = "select * from maintain";
        try {
            Statement st = con.createStatement();
            ResultSet rs =st.executeQuery(sql);
            while(rs.next()){
                MainteinenceModel m= new MainteinenceModel();
                m.setID(rs.getInt(1));
                m.setDescription(rs.getString(2));
                m.setAffected_Area((rs.getString(3)));
                m.setAffected_time(rs.getString(4));
                m.setPredicted_time(rs.getString(5));
                maintains.add(m);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return maintains;
    }
}



