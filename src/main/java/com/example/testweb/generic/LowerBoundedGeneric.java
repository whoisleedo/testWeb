package com.example.testweb.generic;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundedGeneric {
    public static void main(String[] args) {
        List<Number> numList = new ArrayList<>();
        addNumbers(numList);
        System.out.println(numList);

        List<Object> objList = new ArrayList<>();
        addNumbers(objList);
        System.out.println(objList);
    }
    //下界通配符使用<? super Type>語法，表示參數化類型可能是指定的類型，或者是這個類型的父類型。
    //這個範例中的addNumbers方法可以接受Integer或其任何父類型（如Number或Object）的列表。方法添加數字到列表中。
    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
    }


}
