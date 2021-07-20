package id.bootstrap.webservice;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.SecureRequestCustomizer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.SslConnectionFactory;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.webapp.WebAppContext;

public class LauncherApp {

    public static void main(String[] args) throws Exception {
        System.out.println("Starting JAX-RS Web Service");
        String rootPath = LauncherApp.class.getResource("/WEB-INF/web.xml").toString();
        System.out.println("Root path: " + rootPath);

        Server server = new Server(8080);
        HttpConfiguration config = new HttpConfiguration();
        config.setSecureScheme("https");
        config.setSecurePort(8086);
        config.addCustomizer(new SecureRequestCustomizer());

        SslContextFactory sslContextFactory = new SslContextFactory.Server();
        
        sslContextFactory.setKeyStorePath(LauncherApp.class.getResource("/keystore").toString());
        sslContextFactory.setKeyStorePassword("qwerty");
        final ServerConnector https = new ServerConnector(server,
                new SslConnectionFactory(sslContextFactory , "http/1.1"),
                new HttpConnectionFactory(config));
        https.setPort(8086);
        server.setConnectors(new Connector[]{https});
        
        WebAppContext webapp = new WebAppContext(rootPath, "");
        server.setHandler(webapp);

        server.start();
        server.join();
    }
}
