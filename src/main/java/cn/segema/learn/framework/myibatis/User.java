package cn.segema.learn.framework.myibatis;

public class User {

	public User(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
	private int age;
	
	private String name;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
