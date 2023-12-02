package com.example.testweb.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombineGeneric {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<Number> numList = new ArrayList<>();
        copyList(intList, numList);
        System.out.println(numList);
    }

    //在這個範例中，copyList方法可以從一個類型的列表複製到另一個類型的列表。
    // 源列表（src）使用上界通配符（可以是T或T的子類型），而目標列表（dest）使用下界通配符（可以是T或T的父類型）。
    public static <T> void copyList(List<? extends T> src, List<? super T> dest) {
        for (T item : src) {
            dest.add(item);
        }
    }


}
