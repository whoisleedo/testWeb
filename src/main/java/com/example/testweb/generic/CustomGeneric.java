package com.example.testweb.generic;

import java.util.Arrays;
import java.util.List;

public class CustomGeneric {
    public static void main(String[] args) {
        testBoxGeneric();
        System.out.println("=========");
        testStringBox();
    }

    public static void testBoxGeneric(){
        Box b1 = new Box();
        b1.setT("這是字串");
        Box b2 = new Box();
        b2.setT(123);
        List<Box> boxes = Arrays.asList(b1, b2);
        boxes.forEach(box -> System.out.println(box));
    }

    public static void  testStringBox(){
        Box<String> b1 = new Box();
        b1.setT("這是字串,透過<String>來限定箱子裡只能放字串");
        Box<String> b2 = new Box();
        b2.setT("如果放其他不是字串的類型，編譯器會討厭你，不信你打開下面的註解");

        //Box<String> b3 = new Box();
        //b3.setT(1970010100000);
        List<Box<String>> boxes = Arrays.asList(b1, b2);
        boxes.forEach(box -> System.out.println(box));

    }
}
