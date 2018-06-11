package gussinku.dropwizard.microservice.resource;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;

@Path("")
@Produces(MediaType.APPLICATION_JSON)
public class NamwangaResource {
    private ArrayList<String> mwakata =
            new ArrayList<>(Arrays.asList("Kundananji, Izukanji,Tamikanji,Mukundwe"));


    @GET
    @Timed
    @Path("/namwanga-name")
    public ArrayList<String> getNawangaName() {
        return this.mwakata;
    }

}
