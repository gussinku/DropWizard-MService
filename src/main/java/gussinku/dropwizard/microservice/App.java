package gussinku.dropwizard.microservice;

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
        //nothing to do yet
    }

}
