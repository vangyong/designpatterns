package cn.segema.learn.interview.event;

public class MyEventDemo {
	public static void main(String[] args) {

		Source source = new Source();
		source.addStateChangeListener(new StateChangeListener());
		source.addStateChangeToOneListener(new StateChangeToOneListener());

		source.changeFlag();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		//source.changeFlag();
		//System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		//source.changeFlag();
	}

}
