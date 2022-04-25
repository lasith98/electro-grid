package lk.sliit.maintenancesectionservice.Resource;
import lk.sliit.maintenancesectionservice.Service.MaintainService;
import lk.sliit.maintenancesectionservice.Model.MainteinenceModel;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("maintain")

public class MaintainResource {
    MaintainService repo= new MaintainService();
    @GET
    @Produces(MediaType.TEXT_PLAIN)

    public String  getMaintain(){

        return repo.getMaintain();

    }
    @POST
    @Path("addRecord")
    @Produces(MediaType.APPLICATION_JSON)
    public MainteinenceModel createMaintain(MainteinenceModel m1)
    {
        repo.createMaintainReco(m1);
        return  m1;
    }

    @GET
    @Path("maintains/{ID}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
        public MainteinenceModel getMaintainById(@PathParam("ID") int ID)
    {
        return repo.getMaintain(ID);
    }


    @PUT
    @Path("updateRecord")
    @Produces(MediaType.APPLICATION_JSON)
    public String updateMaintain(MainteinenceModel m1)
    {
        return repo.updateMaintainReco(m1);
    }
    @DELETE
    @Path("deleteRecord/{ID}")
    @Produces(MediaType.APPLICATION_JSON)

    public String deleteMaintain(@PathParam("ID") int ID){
           return repo.deleteMaintainReco(ID);
    }
    @Path("maintainjson")
    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public List <MainteinenceModel>  getMaintainInJson(){
        return repo.getMaintainInJson();

    }
}
