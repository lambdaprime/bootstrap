package id.bootstrap.jrosclient;

import id.jros1client.JRos1ClientFactory;
import id.jrosclient.TopicSubscriber;
import id.jrosmessages.std_msgs.StringMessage;

public class SubscriberApp {

    public static void main(String[] args) throws Exception {
        // specify URL of the master node
        var client = new JRos1ClientFactory().createClient("http://localhost:11311/");
        String topicName = "/helloRos";
        // register a new subscriber
        client.subscribe(new TopicSubscriber<>(StringMessage.class, topicName) {
            @Override
            public void onNext(StringMessage item) {
                System.out.println(item);
                // request next message
                getSubscription().get().request(1);
            }
        });
    }
}