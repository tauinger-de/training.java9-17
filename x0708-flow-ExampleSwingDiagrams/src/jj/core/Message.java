package jj.core;

public class Message {

    public final long sequenceNumber;
    public final double value;

    public Message(long sequenceNumber, double value) {
        this.sequenceNumber = sequenceNumber;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + this.sequenceNumber + ", " + this.value + "]";
    }
}
