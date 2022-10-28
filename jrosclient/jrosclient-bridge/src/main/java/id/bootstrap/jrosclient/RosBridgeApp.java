package id.bootstrap.jrosclient;

import id.jros1client.JRos1ClientFactory;
import id.jros2client.JRos2ClientFactory;
import id.jrosclient.TopicSubscriber;
import id.jrosclient.TopicSubmissionPublisher;
import id.jrosmessages.std_msgs.StringMessage;

/**
 * ROS Bridge example between ROS1 and ROS2
 */
public class RosBridgeApp {

    public static void main(String[] args) throws Exception {
        var client2 = new JRos2ClientFactory().createClient();
        String topicName = "/helloRos";
        var publisher = new TopicSubmissionPublisher<>(StringMessage.class, topicName);
        // register a new publisher for a new topic with ROS2
        client2.publish(publisher);

        // specify URL of the master node
        var client1 = new JRos1ClientFactory().createClient("http://localhost:11311/");
        // register a new subscriber
        client1.subscribe(new TopicSubscriber<>(StringMessage.class, topicName) {
            @Override
            public void onNext(StringMessage item) {
                System.out.println(item);
                publisher.submit(item);
                System.out.println("Published");
                getSubscription().get().request(1);
            }
        });

        // usually we need to close client once we are done
        // but here we keep it open so that subscriber will keep
        // printing messages indefinitely
    }
}

