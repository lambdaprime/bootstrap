package id.bootstrap.rtpstalk;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

record HelloWorld(int index, String message) {
    /**
     * Deserialize HelloWorld object from byte[]
     * which would be received from the remote Publisher
     */
    static HelloWorld read(byte[] data) {
        var buf = ByteBuffer.wrap(data);
        // To make sure that both Publisher and Subscriber use same ordering
        // when processing the data, we set it explicitly to little-endian
        buf.order(ByteOrder.LITTLE_ENDIAN);
        var id = buf.getInt();
        // each String is prefixed with its length so we read it first
        var len = buf.getInt();
        // and now we read the String
        var message = "";
        while (len-- > 0) message += (char)buf.get();
        return new HelloWorld(id, message);
    }

    /**
     * Converts message to byte[] which can be then sent to remote RTPS Subscribers
     */
    public byte[] toByteArray() {
        var buf = ByteBuffer.allocate(Integer.BYTES * 2 + message.length() + 1);
        // To make sure that both Publisher and Subscriber use same ordering
        // when processing the data, we set it explicitly to little-endian
        buf.order(ByteOrder.LITTLE_ENDIAN);
        buf.putInt(index);
        buf.putInt(message.length() + 1);
        buf.put(message.getBytes());
        return buf.array();
    }
}