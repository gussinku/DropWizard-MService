package gussinku.dropwizard.microservice.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Form {
    @JsonProperty
    private String name;
    @JsonProperty
    private int age;
    @JsonProperty
    private String email;
    @JsonProperty
    private String personalsDescription;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
