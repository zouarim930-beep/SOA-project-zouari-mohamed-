package webservices;

import metiers.UniteEnseignementBusiness;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Path;
@Path("/ue")
public class uniteEnsRestAPI {
    //helper: instance that will help this
    // to manipulate data : crud

    UniteEnseignementBusiness helper =
            new UniteEnseignementBusiness();

    //get list ue's
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getlistUEs(){

        return Response
                .status(200)
                .entity(helper.getListeUE())
                .build();
    }
}
