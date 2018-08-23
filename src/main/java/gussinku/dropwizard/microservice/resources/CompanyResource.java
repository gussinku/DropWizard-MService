package gussinku.dropwizard.microservice.resources;


import gussinku.dropwizard.microservice.api.CompanyForm;
import gussinku.dropwizard.microservice.db.CompanyDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

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
        final Optional<CompanyForm> company = Optional.ofNullable(dao.findById(id));
        if (!company.isPresent()) {
            throw new NotFoundException("OOps Kumboy !!No such user");
        }
        return company.get();
    }

    /**
     * just to demonstration how class mappers with
     * sql works with missing entities
     */
    @GET
    @Path("/companyName/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CompanyForm getCompanyName(@PathParam("id") int id) {
        return dao.findNameById(id);

    }

    /**
     * just to demonstration how class mappers
     * with sql works with missing entities
     */
    @GET
    @Path("/companyEmail/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CompanyForm getCompanyNameEmail(@PathParam("id") int id) {
        return dao.findNameEmailById(id);

    }

    /**
     * delete method
     */
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteMe(@PathParam("id") int id) {
        dao.delete(id);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CompanyForm updateComapany(@PathParam("id") int id, CompanyForm alter) {
        if (id == alter.getId())
            dao.update(alter);
        return alter;
    }



}
