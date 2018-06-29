package gussinku.dropwizard.microservice.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class CompanyForm {
    @JsonProperty
    private String name;

    @NotNull
    @JsonProperty
    private int id;

    @JsonProperty
    private String email;

    @JsonProperty
    private String personalsDescription;

    public CompanyForm() {
        //// Jackson deserialization
    }


    public CompanyForm(int id, String name, String email, String personalsDescription) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.personalsDescription = personalsDescription;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonalsDescription() {
        return personalsDescription;
    }

    public void setPersonalsDescription(String personalsDescription) {
        this.personalsDescription = personalsDescription;
    }
}
