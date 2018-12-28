package cn.edu.hust.service;

import cn.edu.hust.interfaces.Component;

public class Decorator implements Component{
    private Component decorated;

    public Decorator(Component decorated) {
        this.decorated = decorated;
    }

    //没有装饰的方法
    public void methodA() {
        this.decorated.methodA();
    }

    public void methodB() {
        System.out.println("装饰方法开始执行。。。。");
        this.decorated.methodB();
    }
}
