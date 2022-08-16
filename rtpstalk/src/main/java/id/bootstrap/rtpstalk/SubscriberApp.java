package id.bootstrap.rtpstalk;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import pinorobotics.rtpstalk.RtpsTalkClient;
import pinorobotics.rtpstalk.messages.RtpsTalkDataMessage;

public class SubscriberApp {

    public static void main(String[] args) throws Exception {
        try (var client = new RtpsTalkClient()) {
            var topicName = "HelloWorldTopic";
            var topicType = "HelloWorld";
            var future = new CompletableFuture<Void>();
            // register a new subscriber
            client.subscribe(topicName, topicType, new Subscriber<RtpsTalkDataMessage>() {
                private Subscription subscription;
                private int counter;
    
                @Override
                public void onSubscribe(Subscription subscription) {
                    this.subscription = subscription;
                    // once we subscribed we request for messages
                    subscription.request(1);
                }
    
                @Override
                public void onNext(RtpsTalkDataMessage message) {
                    message.data().ifPresent(
                            data -> System.out.println("Received " + HelloWorld.read(data)));
                    if (++counter < 10)
                        subscription.request(1);
                    else {
                        subscription.cancel();
                        future.complete(null);
                        System.out.println("Closing...");
                    }
                }
    
                @Override
                public void onError(Throwable throwable) {
                    throwable.printStackTrace();
                }
    
                @Override
                public void onComplete() {
    
                }
            });
            future.get();
        }
    }
}