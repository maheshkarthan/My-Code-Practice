package com.patterns.designpatterns;

interface Prototype {
    public Prototype getClonedObject();

    public int add();
}

public class PrototypeDesignPattern implements Prototype {

    private int a;
    private int b;

    public PrototypeDesignPattern() {
        System.out.println("Constructor Called Everytime a New Object is Created without params");
    }

    public PrototypeDesignPattern(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Prototype getClonedObject() {
        return new PrototypeDesignPattern(a, b);
    }

    @Override
    public int add() {
        return a + b;
    }

    public static void main(String[] args) {
        Prototype prototype = new PrototypeDesignPattern(25, 25);
        System.out.println(prototype.add());
        
        Prototype prototype1 = new PrototypeDesignPattern(); //default constructor is called here.

        Prototype prototype2 = prototype.getClonedObject();
        System.out.println(prototype2.add());
        System.out.println("1st Object:: "+prototype);
        System.out.println("2nd Object:: "+prototype1);
        System.out.println("3rd Object:: "+prototype2);
    }

}
