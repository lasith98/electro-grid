package lk.sliit.customerservice.resource;

import lk.sliit.customerservice.model.CustomerModel;
import lk.sliit.customerservice.service.CustomerService;
import lk.sliit.customerservice.util.Validation;
import lk.sliit.customerservice.wrapper.ResponseWrapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/customer")
public class CustomerResource implements CURDResource<CustomerModel, Long> {
    private static final String ERROR_MESSAGE = "Error : ";

    private final CustomerService customerService = new CustomerService();
    private final Validation validation = new Validation();

    @POST
    @Override
    public ResponseWrapper<CustomerModel> insert(CustomerModel model) {


        // Check the valid email
        if (!validation.validateEmailAddress(model.getEmail())) {

            return new ResponseWrapper<>("Email address invalid", null, false);
        }
        // Check the valid  mobile no
        if (!validation.validateMobileNumber(model.getMobileNo())) {
            return new ResponseWrapper<>("Mobile no invalid", null, false);
        }

        try {

            return new ResponseWrapper<>("Insert successful ", customerService.insert(model), true);
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseWrapper<>(ERROR_MESSAGE + exception.getMessage(), null, false);
        }

    }

    @PUT
    @Override
    public ResponseWrapper<CustomerModel> update(CustomerModel model) {

        // Check the valid email
        if (!validation.validateEmailAddress(model.getEmail())) {

            return new ResponseWrapper<>("Email address invalid", null, false);
        }
        // Check the valid  mobile no
        if (!validation.validateMobileNumber(model.getMobileNo())) {
            return new ResponseWrapper<>("Mobile no invalid", null, false);
        }

        try {

            CustomerModel customerModel = customerService.update(model);
            if(customerModel==null){
                return new ResponseWrapper<>("Customer Not Found", null , false);
            }else{
                return new ResponseWrapper<>("Update successful", customerModel , true);
            }
        } catch (Exception exception) {
            return new ResponseWrapper<>(ERROR_MESSAGE + exception.getMessage(), null, false);
        }


    }

    @DELETE
    @Path("/{id}")
    @Override
    public ResponseWrapper<String> delete(@PathParam("id") Long id) {
        try {

            return new ResponseWrapper<>("", customerService.delete(id), true);
        } catch (Exception exception) {
            return new ResponseWrapper<>(ERROR_MESSAGE + exception.getMessage(), null, false);
        }
    }

    @GET
    @Override
    public ResponseWrapper<List<CustomerModel>> list() {
        try {

            return new ResponseWrapper<>("", customerService.list(), true);
        } catch (Exception exception) {
            return new ResponseWrapper<>(ERROR_MESSAGE + exception.getMessage(), null, false);
        }
    }

    @GET
    @Path("/{id}")
    @Override
    public ResponseWrapper<CustomerModel> getById(@PathParam("id") Long id) {
        try {

            CustomerModel customerModel = customerService.getById(id);
            if(customerModel==null){
                return new ResponseWrapper<>("Customer Not Found", null , false);
            }else{
                return new ResponseWrapper<>("", customerModel , true);
            }

        } catch (Exception exception) {
            return new ResponseWrapper<>(ERROR_MESSAGE + exception.getMessage(), null, false);
        }
    }

}
