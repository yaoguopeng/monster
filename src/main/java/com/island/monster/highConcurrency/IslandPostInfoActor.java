package com.island.monster.highConcurrency;

import akka.actor.AbstractActor;
import com.island.monster.bean.IslandPost;
import com.island.monster.service.IslandPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("islandPostInfoActor")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class IslandPostInfoActor extends AbstractActor {

    private static final Logger LOGGER = LoggerFactory.getLogger(IslandTopicInfoActor.class);

    @Autowired
    private IslandPostService islandPostService;

    @Override
    public Receive createReceive() {
        return receiveBuilder().matchAny(post -> {
            LOGGER.info("{}帖子访量+1", post);
            islandPostService.postVisitedTimesIncrease((IslandPost) post);
        }).build();
    }
}
