package gussinku.dropwizard.microservice.resources;


import gussinku.dropwizard.microservice.db.UserDAO;

public class UserResource {


    private final UserDAO dao;

    public UserResource(UserDAO dao) {
        this.dao = dao;

    }
}
