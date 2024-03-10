Bootstrap project for [jros2client](https://github.com/lambdaprime/jros2client)

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
ros2 topic pub -r 10 helloRos std_msgs/String 'data: "hello there"'
```

Run application Maven build:

``` bash
java -cp target/jros2client-1.0-SNAPSHOT.jar id.bootstrap.jrosclient.SubscriberApp
```

Run application Gradle build:

``` bash
java -cp build/libs/jros2client.jar id.bootstrap.jrosclient.SubscriberApp
```

# Contacts

lambdaprime <intid@protonmail.com>
