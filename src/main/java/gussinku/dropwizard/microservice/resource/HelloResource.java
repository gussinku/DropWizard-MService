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

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;


    public HelloResource(String template, String defaultName) {
        this.defaultName = defaultName;
        this.template = template;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    @Path("/test")
    public Saying sayHello(@QueryParam("name") Optional<String> name, @QueryParam("name23") Optional<String> maka) {
        final String value = String.format("Welcome %s,its time to learn %s", name.orElse(defaultName), maka.orElse("swim"));
        return new Saying(counter.incrementAndGet(), value);
    }


    @GET
    @Timed
    @Path("/test2")
    public Saying sayHello2(@QueryParam("name") Optional<String> name, @QueryParam("name23") Optional<String> maka) {
        final String value = String.format("lungu %s, bupe %s", name.orElse(defaultName), maka.orElse("eat"));
        return new Saying(counter.incrementAndGet(), value);
    }


}
