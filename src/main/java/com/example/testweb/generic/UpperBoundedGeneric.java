package com.example.testweb.generic;

import java.util.Arrays;
import java.util.List;

public class UpperBoundedGeneric {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3);
        System.out.println("Integer List Sum = " + sumOfList(intList));

        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);
        System.out.println("Double List Sum = " + sumOfList(doubleList));
    }
    //上界通配符使用<? extends Type>語法，表示參數化類型可能是指定的類型，或者是這個類型的子類型。
    //在這個例子中，sumOfList方法可以接受任何Number的子類型的列表，如Integer、Double等。

    public static double sumOfList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }


}
