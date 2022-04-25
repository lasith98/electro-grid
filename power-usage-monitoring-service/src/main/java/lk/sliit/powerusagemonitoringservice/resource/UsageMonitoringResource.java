package lk.sliit.powerusagemonitoringservice.resource;

import lk.sliit.powerusagemonitoringservice.model.Usage;
import lk.sliit.powerusagemonitoringservice.model.UsageMonitoringModel;
import lk.sliit.powerusagemonitoringservice.service.UsageMonitoringService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/usage/monitoring")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsageMonitoringResource {

    private UsageMonitoringService service = new UsageMonitoringService();

    @POST
    public String insert(UsageMonitoringModel model) {
        return service.insert(model);
    }

    @PUT
    public String update(UsageMonitoringModel model) {
        return service.update(model);
    }

    @DELETE
    @Path("/{id}")
    public String delete(@PathParam("id") Long id) {
        return service.delete(id);
    }

    @GET
    public List<UsageMonitoringModel> list() {
        return service.list();
    }

    @GET
    @Path("/{customerId}/{year}/{month}")
    public List<Usage> monthUsage(@PathParam("customerId") Long customerId, @PathParam("year")String year, @PathParam("month") String month) {
        return service.monthlyUsage(customerId,year,month);
    }
}