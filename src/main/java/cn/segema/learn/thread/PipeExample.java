package cn.segema.learn.thread;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeExample {
	
	public static void main(String[] args) throws IOException {
		final PipedOutputStream output = new PipedOutputStream();
		final PipedInputStream input = new PipedInputStream(output);
		
		
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					output.write("hello world,pipe".getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					int data = input.read();
					while(data!=-1) {
						System.out.println((char)data);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		thread1.start();
		thread2.start();
		
		
		
		
		
	}

}
