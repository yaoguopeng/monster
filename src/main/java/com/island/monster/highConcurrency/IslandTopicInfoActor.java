package com.island.monster.highConcurrency;

import akka.actor.AbstractActor;
import com.island.monster.bean.IslandTopicInfo;
import com.island.monster.service.IslandTopicInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class IslandTopicInfoActor extends AbstractActor {

    private static final Logger LOGGER = LoggerFactory.getLogger(IslandTopicInfoActor.class);

    @Autowired
    private IslandTopicInfoService islandTopicInfoService;


    @Override
    public Receive createReceive() {
        return receiveBuilder().matchAny(topicId -> {
            System.out.println(topicId+"开始");
            LOGGER.info("id为{}的主题访量+1", topicId);
            islandTopicInfoService.topicVisitTimesIncrease(topicId.toString());
            System.out.println("结束"+topicId);
        }).build();
    }
}
