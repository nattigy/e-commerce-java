package sample.repository;

import sample.models.Item;

import java.util.ArrayList;
import java.util.List;

public class FilterByPrice implements FilterStrategy {
    @Override
    public List<Item> doFiltering(List<Item> items, String price) {
        List<Item> newItems = new ArrayList<>(items);
        for (int i = 0; i < newItems.size(); i++) {
            if (newItems.get(i).getPrice() > Double.parseDouble(price)) {
                newItems.remove(i);
            }
        }
        return newItems;
    }
}
