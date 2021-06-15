package sample.repository;

import sample.database.Database;
import sample.models.Item;

import java.util.List;

public class ItemRepository {
    Database database;

    public ItemRepository(Database database) {
        this.database = database;
    }

    public void addItem(Item item) {
        this.database.addItem(item);
    }

    public void removeItem(String id) {
        this.database.removeItem(id);
    }

    public List<Item> getItems() {
        return this.database.getItems();
    }

    public Item getItem(String id) {
        return this.getItem(id);
    }
}
