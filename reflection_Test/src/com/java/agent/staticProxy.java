package com.java.agent;


interface  ClothFactory{
    void produceCloth();
}

//代理类
class PersonTest implements  ClothFactory{
    private ClothFactory factory;

    public PersonTest(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("制衣厂开始做一些工作");

        factory.produceCloth();

        System.out.println("制衣厂做一些收尾工作");
    }
    //用被代理对象进行实例化
}

//被代理类
class NeckTest implements  ClothFactory{


    @Override
    public void produceCloth() {
        System.out.println("制衣厂计划生产一批衣服");
    }
}

public class staticProxy {
    /**
     * 静态代理举例
     *
     * 特点：代理类和被代理类在编译期间，就确定下来了。
     */
    public static void main(String[] args) {
        ClothFactory cloth = new NeckTest();

        ClothFactory proxyCloth = new PersonTest(cloth);
        proxyCloth.produceCloth();
    }

}

