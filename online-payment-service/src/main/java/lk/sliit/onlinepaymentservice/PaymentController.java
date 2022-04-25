package lk.sliit.onlinepaymentservice;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("Payment")
public class PaymentController 
{
		
	PaymentRepo repo = new PaymentRepo();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Payment> getPayment()
	{
		
		System.out.println("Calling function");
		return repo.getPayment(); 
		
	}
	
	
	@GET
	@Path("Payment/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Payment getPay(@PathParam("id")  int id)
	{
		
		return repo.getPayment(id);
		
	}
	
	
	@POST
	@Path("Payment")
	public Payment CreatPayment(Payment p1)
	{
		repo.create(p1);	
		return p1;
	}
	
	
	@PUT
	@Path("Payment")
	public Payment updatePayment(Payment p1)
	{
		if(repo.getPayment(p1.getId()).getId()==0)
		{
			repo.create(p1);
		}
		else {
			repo.update(p1);
		}
		
		repo.update(p1);	
		return p1;
	}
	
	
	@DELETE
	@Path("Payment/{id}")
	public Payment delPay(@PathParam("id")int id)
	{	
		Payment p =repo.getPayment(id);
		
		if(p.getId() != 0)
		{
			repo.delete(id);
		}
		
		return p;
		
	}

	

}
