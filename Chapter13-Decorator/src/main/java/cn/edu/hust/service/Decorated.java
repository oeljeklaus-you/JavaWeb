package cn.edu.hust.service;

import cn.edu.hust.interfaces.Component;

public class Decorated implements Component {
    public void methodA() {
        System.out.println("the Decorated methodA invoked");
    }

    public void methodB() {
        System.out.println("the Decorated methodB invoked");
    }
}
