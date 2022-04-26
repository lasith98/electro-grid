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

    private static final String POWER_USAGE_MONITORING_SERVICE_URL = "http://localhost:8080/power_usage_monitoring_service_war/api/usage/monitoring";

    @GET
    @Path("monthly/usage/{customerId}/{month}/{year}")
    public ResponseWrapper<List<MonthlyUsageReportDTO>> monthlyUsage(@PathParam("customerId") Long customerId, @PathParam("month") String month,@PathParam("year") String year) {
        Client client = ClientBuilder.newClient();

        List<MonthlyUsageReportDTO> report = client.target(POWER_USAGE_MONITORING_SERVICE_URL)
                .path(String.valueOf(customerId))
                .path(month)
                .path(year)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<MonthlyUsageReportDTO>>() {
                });


        return new ResponseWrapper<>("", report, true);


    }
}