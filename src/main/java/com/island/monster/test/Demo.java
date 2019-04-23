package com.island.monster.test;


import com.island.monster.bean.IslandTopicInfo;
import com.island.monster.mapper.IslandTopicInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class Demo {


    @Autowired
    private IslandTopicInfoMapper islandTopicInfoMapper;

    @Test
    public void test() {
        System.out.println(islandTopicInfoMapper.getByTopicId("1"));

    }
}
