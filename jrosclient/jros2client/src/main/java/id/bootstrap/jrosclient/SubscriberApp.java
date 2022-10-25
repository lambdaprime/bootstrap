package id.bootstrap.jrosclient;

import id.jros2client.JRos2ClientFactory;
import id.jrosclient.TopicSubscriber;
import id.jrosmessages.std_msgs.StringMessage;

/**
 * Subscribes to ROS topic
 */
public class SubscriberApp {

    public static void main(String[] args) throws Exception {
        // specify URL of the master node
        var client = new JRos2ClientFactory().createClient();
        var topicName = "/helloRos";
        // register a new subscriber
        client.subscribe(new TopicSubscriber<>(StringMessage.class, topicName) {
            @Override
            public void onNext(StringMessage item) {
                System.out.println(item);
                // request next message
                getSubscription().get().request(1);
            }
        });

        // usually we need to close client once we are done
        // but here we keep it open so that subscriber will keep
        // printing messages indefinitely
    }
}