package com.will.cloud.config.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring自定义 事件/监听器
 */
public class MySpringEventListener  {

    public static void main(String[] args) {
        //Annotation 驱动的 spring 上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册监听器
        context.addApplicationListener(new ApplicationListener<MyApplicationEvent>() {
            @Override
            public void onApplicationEvent(MyApplicationEvent event) {
                System.out.println("recieve event: " + event.getSource() + ",@" + event.getApplicationContext());
            }
        });
        //监听器得到事件
        context.refresh();
        //发布事件
        context.publishEvent(new MyApplicationEvent(context, "Hello,World!"));
        context.publishEvent(new MyApplicationEvent(context, 1));
        context.publishEvent(new MyApplicationEvent(context, new Integer(100)));
    }

    private static class MyApplicationEvent extends ApplicationEvent {

        private final ApplicationContext applicationContext;

        public MyApplicationEvent(ApplicationContext applicationContext, Object source) {
            super(source);
            this.applicationContext = applicationContext;
        }

        public ApplicationContext getApplicationContext() {
            return applicationContext;
        }
    }

}
