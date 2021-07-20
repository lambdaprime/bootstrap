package id.bootstrap.webservice;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class LauncherApp {

    public static void main(String[] args) throws Exception {
        System.out.println("Starting JAX-RS Web Service");
        String rootPath = LauncherApp.class.getResource("/WEB-INF/web.xml").toString();
        System.out.println("Root path: " + rootPath);

        Server server = new Server(8080);
        WebAppContext webapp = new WebAppContext(rootPath, "");
        server.setHandler(webapp);

        server.start();
        server.join();
    }
}
