package com.example.testweb.generic;

import java.util.Arrays;
import java.util.List;

public class MethodGeneric {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("3", "2", "1");
        printList(stringList);
        System.out.println("============");
        List<Integer> integers = Arrays.asList(1, 2, 3);
        printList(integers);
        System.out.println("============");
        System.out.println(add(1,99));
        System.out.println("============");
        System.out.println(add(11.0,22.0));

    }



    public static <T> void printList(List<T> genericList){
        System.out.println("泛型也能當作方法參數來宣告");
        System.out.println("左邊的<T>，告訴編譯器，這個方法裡面使用了一個自訂的泛型");
        System.out.println("T的型別會在呼叫這個方法時決定");

        for(T t : genericList){
            System.out.println(t);
        }

        System.out.println("這樣的泛型使用，可以保證方法的彈性");
        System.out.println("方法可被複用，不用重複造輪子");
    }
    //可以善用繼承的關係來宣告泛型，這樣就可以讓所有的數字型別的相加
    public static <T extends Number, U extends Number> double add(T num1, U num2) {
        return num1.doubleValue() + num2.doubleValue();
    }


}
