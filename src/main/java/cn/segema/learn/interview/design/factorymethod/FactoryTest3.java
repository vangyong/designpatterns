package cn.segema.learn.interview.design.factorymethod;

public class FactoryTest3 {

	public static void main(String[] args) {	
		Sender sender = SendFactory3.produceMail();
		sender.Send();
	}
}