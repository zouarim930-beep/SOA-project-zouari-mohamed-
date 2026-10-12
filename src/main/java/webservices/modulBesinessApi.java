package webservices;

import entities.Module;
import metiers.ModuleBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/module")
public class modulBesinessApi {

    ModuleBusiness helper = new ModuleBusiness();


    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllModules() {
        return Response.status(200).entity(helper.getAllModules()).build();
    }


    @Path("/new")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createModule(Module module) {
        if (helper.addModule(module)) {
            return Response.status(201).entity("ok").build();
        } else {
            return Response.status(400).entity("Erreur").build();
        }
    }

    @Path("/{matricule}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getModuleByMatricule(@PathParam("matricule") String matricule) {
        Module m = helper.getModuleByMatricule(matricule);
        if (m != null) {
            return Response.ok(m).build();
        } else {
            return Response.status(404).entity("Module introuvable").build();
        }
    }

    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getModulesByType(@QueryParam("type") Module.TypeModule type) {
        return Response.ok(helper.getModulesByType(type)).build();
    }

    
    @Path("/{matricule}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateModule(@PathParam("matricule") String matricule, Module updatedModule) {
        if (helper.updateModule(matricule, updatedModule)) {
            return Response.status(200).entity("ok").build();
        } else {
            return Response.status(400).entity("Erreur").build();
        }
    }


    @Path("/{matricule}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteModule(@PathParam("matricule") String matricule) {
        if (helper.deleteModule(matricule)) {
            return Response.status(200).entity("ok").build();
        } else {
            return Response.status(400).entity("Erreur").build();
        }
    }
}

