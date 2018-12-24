package cn.edu.hust.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppAttributeListener implements ServletContextAttributeListener{
    //添加属性时调用
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("属性名为:"+event.getName()+"添加了值:"+event.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("属性名为:"+event.getName()+"被移除");;
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {

        System.out.println("属性名为:"+event.getName()+"更新了值:"+event.getValue());
    }
}
