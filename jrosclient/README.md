Bootstrap project for [jrosclient](https://github.com/lambdaprime/jrosclient)

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
java -jar target/bootstrap-1.0-SNAPSHOT.jar 
```

Run application Gradle build:

``` bash
java -jar build/libs/jrosclient.jar
```

# Contributors

lambdaprime <intid@protonmail.com>
