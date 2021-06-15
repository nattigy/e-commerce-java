package sample.database;

import sample.models.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {

    private static final Database databaseInstance = new Database();
    private List<Item> items = new ArrayList<Item>(
            Arrays.asList(
                    new Item("0", "Kiwi", 2.99, "description", "", "../img/kiwi.png", "6A7324"),
                    new Item("1", "Coconut", 3.99, "description", "", "../img/coconut.png", "A7745B"),
                    new Item("2", "Peach", 1.50, "description", "", "../img/peach.png", "F16C31"),
                    new Item("3", "Grapes", 0.99, "description", "", "../img/grapes.png", "291D36"),
                    new Item("4", "Watermelon", 4.99, "description", "", "../img/watermelon.png", "22371D"),
                    new Item("5", "Orange", 2.99, "description", "", "../img/orange.png", "FB5D03"),
                    new Item("6", "StrawBerry", 2.99, "description", "", "../img/strawberry.png", "80080C"),
                    new Item("7", "Mango", 2.99, "description", "", "../img/mango.png", "FFB605"),
                    new Item("8", "Cherry", 2.99, "description", "", "../img/cherry.png", "5F060E"),
                    new Item("9", "Banana", 2.99, "description", "", "../img/banana.png", "E7C00F")
            )
    );

    private Database() {
    }

    public static Database getInstance() {
        return databaseInstance;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item getItem(String id) {
        Item newItem = null;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                newItem = item;
                break;
            }
        }
        return newItem;
    }

    public void removeItem(String id) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                items.remove(item);
                return;
            }
        }
    }
}
