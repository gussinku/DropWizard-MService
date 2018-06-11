package gussinku.dropwizard.microservice.resource;

import com.codahale.metrics.annotation.Timed;
import gussinku.dropwizard.microservice.api.Saying;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;


@Path("/companyProfile")
@Produces(MediaType.APPLICATION_JSON)
public class CompanyProfileResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;


    public CompanyProfileResource(String template, String defaultName) {
        this.counter = new AtomicLong();
        this.template = template;
        this.defaultName = defaultName;


    }

    @GET
    @Timed
    public Saying companyProfile(@QueryParam("CompanyName") Optional<String> comp, @QueryParam("CompId") Optional<String> id,
                                 @QueryParam("NumberOfEmployees") Optional<String> employee, @QueryParam("netWorth") Optional<String> worth) {
        final String profile = String.format(template, comp.orElse("Me"), id.orElse("0"), employee.orElse("0")
                , worth.orElse("0"));

        return new Saying(counter.incrementAndGet(), profile);

    }
}
