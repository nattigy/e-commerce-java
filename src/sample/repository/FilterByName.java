package sample.repository;

import sample.models.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterByName implements FilterStrategy{
    @Override
    public List<Item> doFiltering(List<Item> items) {
        return new ArrayList<Item>(
                Arrays.asList(new Item("9", "Banana", "2.99", "description", "", "../img/banana.png", "E7C00F"))
        );
    }
}
