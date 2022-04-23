package lk.sliit.customerservice.resource;

import lk.sliit.customerservice.dto.MonthlyUsageReportDTO;
import lk.sliit.customerservice.wrapper.ResponseWrapper;


import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/customer/report")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerReportResource {

    private static final String POWER_USAGE_MONITORING_SERVICE_URL = "http://localhost:8080/";

    @GET
    @Path("monthly/usage/{customerId}/{monthOfYear}")
    public ResponseWrapper<List<MonthlyUsageReportDTO>> monthlyUsage(@PathParam("customerId") Long customerId, @PathParam("monthOfYear") String monthOfYear) {
        Client client = ClientBuilder.newClient();

        List<MonthlyUsageReportDTO> report = client.target(POWER_USAGE_MONITORING_SERVICE_URL)
                .path(String.valueOf(customerId))
                .path(monthOfYear)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<MonthlyUsageReportDTO>>() {
                });


        return new ResponseWrapper<>("", report, true);


    }
}