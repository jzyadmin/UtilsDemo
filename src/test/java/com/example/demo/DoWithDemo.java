package com.example.demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * DoWithDemo
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/11 15:33
 **/
public class DoWithDemo {
    @Test
    public void demo() {
        List<String> strings = new ArrayList<>();
        strings.add("2222222");
        strings.add("2222222");
        strings.add("2222222");
        strings.add("2222222");
        do {
            for (String s : strings) {
                System.out.println(s);
            }
            strings.remove(1);
        } while (strings.isEmpty());
    }
}
