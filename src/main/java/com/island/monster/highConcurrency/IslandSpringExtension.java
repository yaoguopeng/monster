package com.island.monster.highConcurrency;

import akka.actor.Extension;
import akka.actor.Props;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 第二步，实现了DI之后，需要构造Props对象，用来创建ActorRef;
 * 扩展组件，ApplicationContext会在SpringBoot初始化的时候加载进来
 * 构造Props,用于生产ActorRef
 */
@Component("islandSpringExtension")
public class IslandSpringExtension implements Extension {

    private ApplicationContext context;

    public void init(ApplicationContext context) {
        System.out.println("applicationContext初始化...");
        this.context = context;
    }

    /**
     * 该方法用来创建Props对象，依赖前面创建的DI组件，获取到Props对象，就可以创建Actor bean对象
     *
     * @param beanName actor bean 名称
     * @return props
     */
    public Props create(String beanName) {
        return Props.create(IslandDIProducer.class, this.context, beanName);
    }
}
