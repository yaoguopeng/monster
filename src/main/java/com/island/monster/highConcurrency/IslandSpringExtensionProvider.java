package com.island.monster.highConcurrency;

import akka.actor.AbstractExtensionId;
import akka.actor.ExtendedActorSystem;
import org.springframework.stereotype.Component;

/**
 * 第三步，创建SpringExtProvider继承AbstractExtensionId;
 * 通过继承AbstractExtensionId，可以在ActorSystem范围内创建并查找IslandSpringExtension
 */
@Component
public class IslandSpringExtensionProvider extends AbstractExtensionId<IslandSpringExtension> {

    private static IslandSpringExtensionProvider provider = new IslandSpringExtensionProvider();

    public static IslandSpringExtensionProvider getInstance() {
        return provider;
    }

    @Override
    public IslandSpringExtension createExtension(ExtendedActorSystem extendedActorSystem) {
        return new IslandSpringExtension();

    }
}
