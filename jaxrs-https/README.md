Bootstrap project for Java REST web service with JAX-RS support.
It has embedded HTTP server (Jetty) and builded as a single standalone Java application.

It is using HTTPS only and prohibits any HTTP connections.

Packaged with default keystore (see resources folder)

To generate your own use following command:

``` bash
keytool -keystore keystore -alias jetty -genkey -keyalg RSA -sigalg SHA256withRSA
```

And update password in LauncherApp.java

To test:

``` bash
java -jar webservice.jar
curl -vvv --insecure -XGET https://localhost:8086/webservice/greet
```

# Contributors

lambdaprime <intid@protonmail.com>
