package sample.repository;

import sample.models.Item;

import java.util.List;

public class StrategyContext {
    private final FilterStrategy strategy;

    public StrategyContext(FilterStrategy strategy){
        this.strategy = strategy;
    }

    public List<Item> executeStrategy(List<Item> items, String option){
        return strategy.doFiltering(items, option);
    }
}
