package com.island.monster.highConcurrency;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.island.monster.bean.IslandPost;
import com.island.monster.bean.IslandTopic;
import com.island.monster.common.IslandUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IslandActorService {

    @Autowired
    private ActorSystem actorSystem;

    public void topicVisited(IslandTopic topic) {
        ActorRef ref = actorSystem.actorOf(IslandSpringExtensionProvider.getInstance().
                get(actorSystem).create("islandTopicInfoActor"), "islandTopicInfoActor" + IslandUtil.uuid());
        ref.tell(topic, ActorRef.noSender());
    }

    public void postVisited(IslandPost post) {
        ActorRef ref = actorSystem.actorOf(IslandSpringExtensionProvider.getInstance().
                get(actorSystem).create("islandPostInfoActor"), "islandPostInfoActor" + IslandUtil.uuid());
        ref.tell(post, ActorRef.noSender());
    }
}
