package com.island.monster;


import akka.actor.ActorSystem;
import com.island.monster.highConcurrency.IslandSpringExtensionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 第四步，通过IslandSpringExtensionProvider我们可以获取到IslandSpringExtension，
 * 通过IslandSpringExtension使用Props创建ActorRef对象，
 * 可以通过@Configuration创建一个配置类来初始化ActorSystem，并扫描到纳入到容器的Actor
 */
@Configuration
public class IslandHighConcurrencyConf {

    private final ApplicationContext context;

    @Autowired
    public IslandHighConcurrencyConf(ApplicationContext context) {
        this.context = context;
    }

    @Bean
    public ActorSystem createSystem() {
        ActorSystem system = ActorSystem.create("system");
        IslandSpringExtensionProvider.getInstance().get(system).init(context);
        return system;
    }
}
