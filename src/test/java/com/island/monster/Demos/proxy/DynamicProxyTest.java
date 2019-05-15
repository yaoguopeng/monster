package com.island.monster.Demos.proxy;

public class DynamicProxyTest {

    public static void main(String[] args) {

        ServiceImpl serviceImpl = new ServiceImpl();
        ServiceProxyFactory factory = new ServiceProxyFactory(serviceImpl);
        Service service = factory.getInstance();
        service.test();

    }
}
