package com.patterns.designpatterns;

//change in Context behaviour based on strategy object it deploys or uses
interface Strategy {
    public int doOperation(int a, int b);
}

class AddingStrategy implements Strategy {

    @Override
    public int doOperation(int a, int b) {
        return a + b;
    }
}

class SubstractingStrategy implements Strategy {

    @Override
    public int doOperation(int a, int b) {
        return a - b;
    }
}

class MultiplyingStrategy implements Strategy {

    @Override
    public int doOperation(int a, int b) {
        return a * b;
    }
}

class StrategyContext {
    Strategy strategy;

    public StrategyContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int a, int b) {
        return strategy.doOperation(a, b);
    }
}

public class StrategyDesignPattern {

    public static void main(String[] args) {
        StrategyContext context;

        context = new StrategyContext(new AddingStrategy());
        System.out.println("Addition:: " + context.executeStrategy(10, 20));

        context = new StrategyContext(new SubstractingStrategy());
        System.out.println("Substraction:: " + context.executeStrategy(10, 20));

        context = new StrategyContext(new MultiplyingStrategy());
        System.out.println("Multiplication:: " + context.executeStrategy(10, 20));
    }
}
