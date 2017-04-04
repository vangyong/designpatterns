package com.segema.jdk7.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Described：堆溢出测试
 * @VM args:-verbose:gc -Xms20M -Xmx20M -XX:+PrintGCDetails
 * @author YHJ create at 2011-11-12 下午07:52:22
 * @FileNmae com.yhj.jvm.memory.heap.HeapOutOfMemory.java
 */

public class HeapOutOfMemory {

    /**
     * @param args
     * @Author YHJ create at 2011-11-12 下午07:52:18
     */

    public static void main(String[] args) {
       List<TestCase> cases = new ArrayList<TestCase>();
       while(true){
           cases.add(new TestCase());
       }
    }
}
