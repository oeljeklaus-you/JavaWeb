package cn.edu.hust;

import cn.edu.hust.interfaces.Component;
import cn.edu.hust.service.Decorated;
import cn.edu.hust.service.Decorator;
import org.junit.Before;
import org.junit.Test;

public class DecoratorTest {
    private Component component;
    @Before
    public void init()
    {
        Decorated decorated=new Decorated();
        component=new Decorator(decorated);
    }
    @Test
    public void test()
    {
        component.methodA();
        component.methodB();
    }

}
