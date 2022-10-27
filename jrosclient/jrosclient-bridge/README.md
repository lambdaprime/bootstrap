Bootstrap project for ROS Bridge between ROS1 and ROS2 using [jrosclient](https://github.com/lambdaprime/jrosclient)

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

In ROS1 run topic publisher:

``` bash
rostopic pub -r 10 helloRos std_msgs/String "hello there"
```

In ROS2 run topic subscriber:

``` bash
ros2 topic echo helloRos std_msgs/String
```

Run application Maven build:

``` bash
java -cp target/ros-bridge-1.0-SNAPSHOT.jar id.bootstrap.jrosclient.RosBridgeApp
```

Run application Gradle build:

``` bash
java -cp build/libs/ros-bridge.jar id.bootstrap.jrosclient.RosBridgeApp
```

# Contributors

lambdaprime <intid@protonmail.com>
