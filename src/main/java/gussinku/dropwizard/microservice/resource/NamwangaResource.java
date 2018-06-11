package gussinku.dropwizard.microservice.resource;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("")
@Produces(MediaType.APPLICATION_JSON)
public class NamwangaResource {
    private String[] mwakata = {"Kundananji, Izukanji,Tamikanji,Mukundwe"};

    @GET
    @Timed
    @Path("/namwanga-name")
    public String[] displayName() {
        return this.mwakata;
    }

}
