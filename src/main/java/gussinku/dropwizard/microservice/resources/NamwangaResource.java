package gussinku.dropwizard.microservice.resources;

import com.codahale.metrics.annotation.Timed;
import gussinku.dropwizard.microservice.api.CompanyForm;

import javax.ws.rs.*;
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


    @POST
    @Path("/update-name")
    @Consumes(MediaType.APPLICATION_JSON)
    public String addMessage() {

        return "This works";
    }

    @POST
    @Path("/message")
    @Consumes(MediaType.APPLICATION_JSON)
    public ArrayList<String> updateMessage(ArrayList<String> listOfNames) {
        return listOfNames;
    }

    @POST
    @Path("/receive")
    @Consumes(MediaType.APPLICATION_JSON)
    public CompanyForm receiveForm(CompanyForm receive) {
        return receive;
    }

}
