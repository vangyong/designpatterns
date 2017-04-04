package com.segema.threadlocal.test;

import java.util.Random;

public class TestThreadLocal implements Runnable {

	ThreadLocal studentLocal = new ThreadLocal();

	public static void main(String[] args) {
		TestThreadLocal t = new TestThreadLocal();
		new Thread(t, "t1").start();
		new Thread(t, "t2").start();
	}

	@Override
	public void run() {
		accessStudent();
	}

	private void accessStudent() {
		Student s = this.getStudent();
		Random random = new Random();
		int age = random.nextInt(100);
		System.out.println("current thread set age " + Thread.currentThread()
				+ ":" + age);
		s.setAge(age);
		System.out.println("current thread first get age "
				+ Thread.currentThread() + ":" + s.getAge());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("current thread second get age "
				+ Thread.currentThread() + ":" + s.getAge());
	}

	public Student getStudent() {
		Student s = (Student) studentLocal.get();
		if (s == null) {
			s = new Student();
			studentLocal.set(s);
		}
		return s;
	}
}
