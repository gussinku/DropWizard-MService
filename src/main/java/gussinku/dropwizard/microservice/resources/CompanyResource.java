package gussinku.dropwizard.microservice.resources;


import gussinku.dropwizard.microservice.api.CompanyForm;
import gussinku.dropwizard.microservice.db.CompanyDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class CompanyResource {

    private final CompanyDAO dao;

    public CompanyResource(CompanyDAO dao) {
        this.dao = dao;

    }

    @POST
    @Path("/company")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CompanyForm save(CompanyForm form) {
        dao.insert(form.getId(), form.getName(), form.getPersonalsDescription(), form.getEmail());//save
        return dao.findById(form.getId());
        //update need as new contract
    }

    @GET
    @Path("/companyList")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CompanyForm> companyList() {
        return dao.listOfCompany();
    }

    @GET
    @Path("/company/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CompanyForm getCompany(@PathParam("id") int id) {
        return dao.findById(id);

    }
    /**delete method*/


}
