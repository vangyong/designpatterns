package cn.segema.learn.interview.threadlocal;

import java.lang.ref.WeakReference;

public class Entry<BigByte>  extends WeakReference<BigByte>{

	private byte[] value;
	
	public Entry(BigByte bigByte , byte[] value) {
		super(bigByte);
		this.value = value;
	} 
	
	public BigByte getKey(){
		return this.get();
	}
	

	public byte[] getValue(){
		return this.value;
	}
}
