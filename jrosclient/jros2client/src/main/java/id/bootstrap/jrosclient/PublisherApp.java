package id.bootstrap.jrosclient;

import id.jros2client.JRos2ClientFactory;
import id.jrosclient.TopicSubmissionPublisher;
import id.jrosmessages.std_msgs.StringMessage;

/**
 * Creates a new topic and publishes messages to it.
 */
public class PublisherApp {

    public static void main(String[] args) throws Exception {
        // specify URL of the master node
        var client = new JRos2ClientFactory().createClient();
        String topicName = "/helloRos";
        var publisher = new TopicSubmissionPublisher<>(StringMessage.class, topicName);
        // register a new publisher for a new topic with ROS
        client.publish(publisher);
        while (true) {
            publisher.submit(new StringMessage().withData("Hello ROS"));
            System.out.println("Published");
            Thread.sleep(1000);
        }

        // usually we need to close client once we are done
        // but here we keep it open so that subscriber will keep
        // printing messages indefinitely
    }
}

