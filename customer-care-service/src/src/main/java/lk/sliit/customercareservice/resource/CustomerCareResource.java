package lk.sliit.customercareservice.resource;

import lk.sliit.customercareservice.model.CustomerCareModel;
import lk.sliit.customercareservice.service.CustomerCareService;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/customer/care")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerCareResource {

    private CustomerCareService service = new CustomerCareService();

    @POST
    public String insert(CustomerCareModel model) {
        return service.insert(model);
    }

    @PUT
    public String update(CustomerCareModel model) {
        return service.update(model);
    }

    @DELETE
    @Path("/{id}")
    public String delete(@PathParam("id") Long id) {
        return service.delete(id);
    }

    @GET
    public List<CustomerCareModel> list() {
        return service.list();
    }


}