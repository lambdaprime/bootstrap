Bootstrap project for [jros2client](https://github.com/lambdaprime/jros2client)

# Build

Using Gradle:

``` bash
gradle clean build
```

# Usage

Run topic publisher:

``` bash
ros2 topic pub -r 10 helloRos std_msgs/String 'data: "hello there"'
```

Run application Gradle build:

``` bash
java -cp build/libs/jros2client.jar id.bootstrap.jrosclient.SubscriberApp
```

# Contacts

lambdaprime <intid@protonmail.com>
