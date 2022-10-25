Bootstrap project for [jros1client](https://github.com/lambdaprime/jros1client)

# Build

Using Maven 3.5.4+:

``` bash
mvn clean install
```

Using Gradle 7.2+:

``` bash
gradle clean build
```

# Usage

Run topic publisher:

``` bash
rostopic pub -r 10 helloRos std_msgs/String "hello there"
```

Run application Maven build:

``` bash
java -cp target/bootstrap-1.0-SNAPSHOT.jar id.bootstrap.jrosclient.SubscriberApp
```

Run application Gradle build:

``` bash
java -cp build/libs/jros1client.jar id.bootstrap.jrosclient.SubscriberApp
```

# Contributors

lambdaprime <intid@protonmail.com>
