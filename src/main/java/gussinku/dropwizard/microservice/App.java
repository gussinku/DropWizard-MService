package gussinku.dropwizard.microservice;


import gussinku.dropwizard.microservice.health.TemplateHealthCheck;
import gussinku.dropwizard.microservice.resource.Resource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<Config> {
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<Config> bootstrap) {
        //nothng to do yet
    }

    @Override
    public void run(Config config, Environment environment) {
        final Resource resource = new Resource(
                config.getTemplate(),
                config.getDefaultName());
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(config.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }

}
