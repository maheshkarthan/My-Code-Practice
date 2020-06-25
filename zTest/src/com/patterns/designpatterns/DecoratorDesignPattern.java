package com.patterns.designpatterns;

interface Food {
    public String prepareFood();

    public String getPreparedFood();
}

class VegFood implements Food {

    @Override
    public String prepareFood() {
        return ("Preparing a Veg Food Item");
    }

    @Override
    public String getPreparedFood() {
        return ("Getting Prepared Veg Food Item");
    }
}

class NonVegFood implements Food {

    @Override
    public String prepareFood() {
        return ("Preparing a Non-Veg Food Item");
    }

    @Override
    public String getPreparedFood() {
        return ("Getting Prepared Non-Veg Food Item");
    }
}

// i want to extend Non-veg to Chicken Biryani so using Decorator pattern
abstract class FoodDecorator implements Food {

    Food food;

    public FoodDecorator(Food food) {
        this.food = food;
    }

    @Override
    public String prepareFood() {
        return food.prepareFood();
    }

    @Override
    public String getPreparedFood() {
        return food.getPreparedFood();
    }
}

// Extending for more features in Food
class Biryani extends FoodDecorator {

    public Biryani(Food food) {
        super(food);
    }

    @Override
    public String prepareFood() {
        return super.prepareFood() + " Biryani";
    }

    @Override
    public String getPreparedFood() {
        return super.getPreparedFood() + " Biryani";
    }
}

public class DecoratorDesignPattern {

    public static void main(String[] args) {

        Food vegfood = new VegFood();
        System.out.println(vegfood.prepareFood());
        System.out.println(vegfood.getPreparedFood());

        Food nonVegfood = new NonVegFood();
        System.out.println(nonVegfood.prepareFood());
        System.out.println(nonVegfood.getPreparedFood());

        Food biryani = new Biryani(new NonVegFood());
        System.out.println(biryani.prepareFood());
        System.out.println(biryani.getPreparedFood());

        Food biryaniFood = new Biryani(new VegFood());
        System.out.println(biryaniFood.prepareFood());
        System.out.println(biryaniFood.getPreparedFood());
    }
}
