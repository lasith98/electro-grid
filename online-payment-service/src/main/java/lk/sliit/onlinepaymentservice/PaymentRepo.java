package lk.sliit.onlinepaymentservice;

import java.util.ArrayList;
import java.sql.*;
import java.util.List;

public class PaymentRepo
{
	Connection con = null;
	
	public PaymentRepo()
	{
		String url = "jdbc:mysql://localhost:3306/restdb";
		String username = "root";
		String password = "root";
		
		try
		{
			con = DriverManager.getConnection(url, username, password);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	
	
	
	public List<Payment> getPayment()
	{
		
		List<Payment> pay = new ArrayList<>();
		String sql = "select * from onlinepayment";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next())
			{
				Payment p = new Payment();
				
				p.setName(rs.getString(1));
				p.setId(rs.getInt(2));
				p.setAmount(rs.getInt(3));
				p.setCrdTyp(rs.getString(4));
				p.setBank(rs.getString(5));
				
				pay.add(p);
				
			}
		
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		return pay;
	}
	
	
	
	
	public Payment getPayment(int id)
	{
		String sql = "select * from onlinepayment where id="+id;
		Payment p = new Payment();
		
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
				if (rs.next())
				{
					
					p.setName(rs.getString(1));
					p.setId(rs.getInt(2));
					p.setAmount(rs.getInt(3));
					p.setCrdTyp(rs.getString(4));
					p.setBank(rs.getString(5));
				
				}
		
			}
			catch(Exception e){
				System.out.println(e);
			}
			
			return p;
		}

	
	

	public void create(Payment p1) {
		
		String sql = "insert into onlinepayment values (?,?,?,?,?)";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			
			st.setString(1,p1.getName());
			st.setInt(2, p1.getId());
			st.setInt(3, p1.getAmount());
			st.setString(4, p1.getCrdTyp());
			st.setString(5, p1.getBank());
			
			st.executeUpdate();
		
	
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	
	
	public void update(Payment p1) {
		
		String sql = "update onlinepayment set name=? , id=? , amount=? , cardtype=? , bank=?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			
			st.setString(1,p1.getName());
			st.setInt(2, p1.getId());
			st.setInt(3, p1.getAmount());
			st.setString(4, p1.getCrdTyp());
			st.setString(5, p1.getBank());
			
			st.executeUpdate();
		
	
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}




	public void delete(int id) {
		
		String sql = "delete from onlinepayment where id=?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(2, id);
			
			st.executeUpdate();
		
	
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
		
}
	
	
	
	

