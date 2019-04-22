package com.island.monster.highConcurrency;

import akka.actor.Actor;
import akka.actor.IndirectActorProducer;
import org.springframework.context.ApplicationContext;

/**
 * 第一步，实现IndirectActorProducer，
 * 用于生产Actor，既然是交给Spring管理，肯定少不了ApplicationContext对象和bean名称
 */
public class IslandDIProducer implements IndirectActorProducer {

    private ApplicationContext context;
    private String beanName;

    public IslandDIProducer(ApplicationContext context, String beanName) {
        this.context = context;
        this.beanName = beanName;
    }

    public IslandDIProducer() {
    }

    @Override
    public Actor produce() {
        return (Actor) context.getBean(beanName);
    }

    @Override
    public Class<? extends Actor> actorClass() {
        return (Class<? extends Actor>) context.getType(beanName);
    }
}
