package com.island.monster.Demos.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ServiceProxyFactory implements InvocationHandler {

    private ServiceImpl serviceImpl;

    public void setServiceImpl(ServiceImpl serviceImpl) {
        this.serviceImpl = serviceImpl;
    }

    public ServiceImpl getServiceImpl() {
        return serviceImpl;
    }

    public ServiceProxyFactory(){
        super();
    }

    public ServiceProxyFactory(ServiceImpl serviceImpl) {
        this.serviceImpl = serviceImpl;
    }

    public Service getInstance() {
        return (Service) Proxy.newProxyInstance(ServiceProxyFactory.class.getClassLoader(),
                ServiceImpl.class.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(" begin >>>>>"+method.getName());
        Object result = method.invoke(serviceImpl,args);
        System.out.println("end........");
        return result;
    }
}
