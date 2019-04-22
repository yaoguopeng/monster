package com.island.monster.highConcurrency;

import akka.actor.AbstractActor;
import com.island.monster.bean.IslandTopicInfo;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class IslandTopicInfoActor extends AbstractActor {

    @Override
    public Receive createReceive() {
        return receiveBuilder().matchAny(topicInfo -> {
            System.out.println("接受到消息：" + topicInfo);
        }).build();
    }
}
