package com.segema.algorithm;

public class lianxi01 {
public static void main(String[] args) {
	System.out.println(" the first month: 1");
	System.out.println(" the second month: 1");
	int f1 = 1,f2 = 1,f,M = 24;
	for (int i=3;i<M;i++){
		f= f2;
		f2 = f1+f2;
		f1 = f;
		System.out.println("the "+i+"month has rabbit:"+f2);
	}
}

}
