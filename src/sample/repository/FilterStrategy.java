package sample.repository;

import sample.models.Item;

import java.util.List;

public interface FilterStrategy {
    public List<Item> doFiltering(List<Item> items);
}

