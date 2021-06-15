package sample.repository;

import sample.models.Item;

import java.util.ArrayList;
import java.util.List;

public class FilterByPrice implements FilterStrategy{
    @Override
    public List<Item> doFiltering(List<Item> items) {
        return new ArrayList<>();
    }
}
