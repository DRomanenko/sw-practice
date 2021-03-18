package service;

public class HelloImpl implements Hello {
    @Override
    public void printHello() {
        System.out.println("Hello OSGi World!");
    }
}
