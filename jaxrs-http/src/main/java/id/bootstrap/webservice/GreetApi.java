package id.bootstrap.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/greet")
public class GreetApi {

    @GET
    public String greet() {
        return "Hello";
    }

}
