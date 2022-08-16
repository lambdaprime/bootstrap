package id.bootstrap.rtpstalk;

import java.util.concurrent.SubmissionPublisher;
import pinorobotics.rtpstalk.RtpsTalkClient;
import pinorobotics.rtpstalk.messages.RtpsTalkDataMessage;

public class PublisherApp {

    public static void main(String[] args) throws Exception {
        try (var client = new RtpsTalkClient()) {
            var topicName = "HelloWorldTopic";
            var topicType = "HelloWorld";
            var publisher = new SubmissionPublisher<RtpsTalkDataMessage>();
            client.publish(topicName, topicType, publisher);
            int c = 1;
            // keep publishing messages every 100ms
            while (true) {
                var m = new RtpsTalkDataMessage(new HelloWorld(c++, "Hello from Java").toByteArray());
                publisher.submit(m);
                Thread.sleep(100);
            }
        }
    }
}