package com.patterns.designpatterns;

class Person {

    private static Person person;

    private Person() {

    }

    // double checked singleton
    public static Person getInstance() {
        if (person == null) {
            synchronized (Person.class) {
                if (person == null) {
                    person = new Person();
                }
            }
        }
        return person;
    }
}

public class SingletonDesignPattern {

    public static void main(String[] args) {
        System.out.println(Person.getInstance());
        System.out.println(Person.getInstance());
    }
}
