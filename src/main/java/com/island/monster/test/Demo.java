package com.island.monster.test;


import com.island.monster.bean.IslandTopicInfo;
import com.island.monster.mapper.IslandTopicInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class Demo {

    class Cat{
        private String name;
        private Integer age;

        public Cat(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    @Autowired
    private IslandTopicInfoMapper islandTopicInfoMapper;

    @Test
    public void test() {
//        System.out.println(islandTopicInfoMapper.getByTopicId("1"));
        List<Cat> list = new ArrayList<>();
        list.add(new Cat("tom4",1));
        list.add(new Cat("tom2",3));
        list.add(new Cat("tom1",4));
        list.add(new Cat("tom3",2));

        System.out.println(list);
        list.sort((o1, o2) -> o2.getAge()-o1.getAge());
        System.out.println(list);
    }
}
