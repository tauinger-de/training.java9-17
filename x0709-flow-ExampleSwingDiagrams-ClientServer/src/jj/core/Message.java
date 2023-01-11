package jj.core;

import java.io.Serializable;

public class Message implements Serializable {
	
	public final int index;
	public final long sequenceNumber;
	public final double value;
	public final int[] data = new int[512];  // tricky... to enforce transmission...

	public Message(int index, long sequenceNumber, double value) {
		this.index = index;
		this.sequenceNumber = sequenceNumber;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[" + this.index + ", " + this.sequenceNumber + ", " + this.value + "]";
	}
}
