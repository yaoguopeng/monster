package com.island.monster.test;


import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.island.monster.highConcurrency.IslandSpringExtensionProvider;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AkkaTest {

    @Autowired
    private ActorSystem actorSystem;

    @Test
    public void contextLoads() {
        ActorRef ref = actorSystem.actorOf(IslandSpringExtensionProvider.getInstance().get(actorSystem).create("testActor"), "testActor");
        ref.tell("hello", ActorRef.noSender());
    }
}