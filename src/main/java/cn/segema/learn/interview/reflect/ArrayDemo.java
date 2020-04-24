 package cn.segema.learn.interview.reflect;

import java.lang.reflect.Array;

public class ArrayDemo {
     public static void main(String[] args) {
         Object matrix = Array.newInstance(int.class, 2);
         Object row0 = Array.newInstance(int.class, 2);
         Object row1 = Array.newInstance(int.class, 2);

         Array.setInt(row0, 0, 1);
         Array.setInt(row0, 1, 2);
         Array.setInt(row1, 0, 3);
         Array.setInt(row1, 1, 4);

         Array.set(matrix, 0, row0);
         Array.set(matrix, 1, row1);
    }

}
