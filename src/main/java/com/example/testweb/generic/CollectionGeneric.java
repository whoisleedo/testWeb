package com.example.testweb.generic;

import java.util.ArrayList;
import java.util.List;

public class CollectionGeneric {

    public static void main(String[] args) {
        objectList();
        System.out.println("==================");
        genericList();
        System.out.println("==================");

    }

    public static void objectList(){
        List objectList = new ArrayList<>();
        objectList.add("這是不用泛型，原始類型的List");
        objectList.add("所以他什麼都能裝");
        objectList.add(1);
        objectList.add(false);
        objectList.add('c');

        for(Object o : objectList){
            System.out.println(o);
        }
    }

    public static void genericList(){
        List<String> stringList = new ArrayList<>();
        stringList.add("這是使用泛型，限定這個List只能放字串");
        stringList.add("所以不能放其他類別進入這個集合中");
        stringList.add("不信你把下一行註解打開");
        //stringList.add(123);
        stringList.add("打開註解之後，編譯器會幫你檢查，是否符合宣告的泛型型別");
        stringList.add("所以泛型在類型以下類型Map,List,Set,Optional,Stream...");
        stringList.add("<>中代表的都是，裡頭能存放怎樣類型的元素，能幫助檢查避免出錯");

        for(Object o : stringList){
            System.out.println(o);
        }

    }
}
