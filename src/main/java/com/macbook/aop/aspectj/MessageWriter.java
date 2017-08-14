package com.macbook.aop.aspectj;

public class MessageWriter {
    public void writeMessage() {
        System.out.println("foobar!");
    }

    public void foo() {
        System.out.println("foo");
    }
}
