package com.island.monster.test;


import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.island.monster.highConcurrency.IslandSpringExtensionProvider;
import com.island.monster.mapper.IslandTopicInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;

@RunWith(SpringRunner.class)
@SpringBootTest
//@Service
public class AkkaTest {

    @Autowired
    private ActorSystem actorSystem;

    @Autowired
    private   IslandTopicInfoMapper islandTopicInfoMapper;

    @Test
//    @PostConstruct
    public void contextLoads() {
        ActorRef ref = actorSystem.actorOf(IslandSpringExtensionProvider.getInstance().
                get(actorSystem).create("islandTopicInfoActor"), "islandTopicInfoActor");
        ref.tell("1", ActorRef.noSender());
    }
}