package gussinku.dropwizard.microservice;


import gussinku.dropwizard.microservice.db.CompanyDAO;
import gussinku.dropwizard.microservice.health.TemplateHealthCheck;
import gussinku.dropwizard.microservice.resources.CompanyProfileResource;
import gussinku.dropwizard.microservice.resources.CompanyResource;
import gussinku.dropwizard.microservice.resources.HelloResource;
import gussinku.dropwizard.microservice.resources.NamwangaResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

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

        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, config.getDataSourceFactory(), "h2");

        final CompanyDAO companyDAO = jdbi.onDemand(CompanyDAO.class);

        companyDAO.createTable();//creating table from this point

        final CompanyResource companyResource = new CompanyResource(companyDAO);


        final HelloResource helloResource = new HelloResource(
                config.getTemplate(),
                config.getDefaultName());

        final CompanyProfileResource comResource = new CompanyProfileResource(
                config.getTemplate(),
                config.getDefaultName());
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(config.getTemplate());

        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(helloResource);
        environment.jersey().register(new NamwangaResource());
        environment.jersey().register(comResource);
        environment.jersey().register(companyResource);
    }

}
