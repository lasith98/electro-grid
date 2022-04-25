package lk.sliit.billcreationservice.resource;




import lk.sliit.billcreationservice.model.BillingModel;
import lk.sliit.billcreationservice.service.BillingService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/billing")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BillingResource {

    private BillingService service = new BillingService();

    @POST
    public String insert(BillingModel model) {
        return service.insert(model);
    }

    @PUT
    public String update(BillingModel model) {
        return service.update(model);
    }

    @DELETE
    @Path("/{id}")
    public String delete(@PathParam("id") Long id) {
        return service.delete(id);
    }

    @GET
    public List<BillingModel> list() {
        return service.list();
    }


}