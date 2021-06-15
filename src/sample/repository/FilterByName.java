package sample.repository;

import sample.models.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilterByName implements FilterStrategy {
    @Override
    public List<Item> doFiltering(List<Item> items, String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return new ArrayList<>(Collections.singletonList(item));
            }
        }
        return new ArrayList<>();
    }
}
