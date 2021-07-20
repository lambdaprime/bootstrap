package id.bootstrap.webservice;

import org.glassfish.jersey.server.ResourceConfig;

public class WebServiceApp extends ResourceConfig {

    public WebServiceApp() {
        System.out.println("Application class resolved");
        packages("id.bootstrap.webservice");
    }
}
