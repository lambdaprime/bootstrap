package id.bootstrap.jrosclient;

import id.jrosclient.JRosClient;
import id.jrosclient.TopicSubscriber;
import id.jrosmessages.std_msgs.StringMessage;

public class SubscriberApp {

    public static void main(String[] args) throws Exception {
        // specify URL of the master node
        var client = new JRosClient("http://localhost:11311/");
        String topicName = "/helloRos";
        // register a new subscriber
        client.subscribe(new TopicSubscriber<>(StringMessage.class, topicName) {
            @Override
            public void onNext(StringMessage item) {
                System.out.println(item);
                // request next message
                getSubscription().request(1);
            }
        });
    }
}