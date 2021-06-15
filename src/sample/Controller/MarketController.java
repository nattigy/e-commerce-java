package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import sample.Main;
import sample.database.Database;
import sample.main.MyListener;
import sample.models.Item;
import sample.repository.FilterByName;
import sample.repository.FilterByPrice;
import sample.repository.ItemRepository;
import sample.repository.StrategyContext;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class MarketController implements Initializable {

    public VBox chosenItemCard;
    public Label itemNameLabel;
    public Label itemPriceLabel;
    public ImageView itemImg;
    public ScrollPane scroll;
    public GridPane grid;
    public TextField addItemName;
    public TextField addItemPrice;
    public TextField addItemDescription;
    public TextField addItemPicture;
    public Label labelDescription;
    public TextField filterName;
    public Button filterByName;
    public TextField filterPrice;
    public Button filterByPrice;

    private MyListener myListener;

    ItemRepository itemRepository;
    List<Item> items;

    private void setChosenItem(Item item) {
        itemNameLabel.setText(item.getName());
        labelDescription.setText(item.getDescription());
        itemPriceLabel.setText(Main.CURRENCY + item.getPrice());
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(item.getImgSrc())));
        itemImg.setImage(image);
        chosenItemCard.setStyle("-fx-background-color: #" + item.getColor() + ";\n" +
                "    -fx-background-radius: 30;");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Database databaseInstance = Database.getInstance();
        itemRepository = new ItemRepository(databaseInstance);

        items = itemRepository.getItems();

        if (items.size() > 0) {
            setChosenItem(items.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Item Item) {
                    setChosenItem(Item);
                }
            };
        }
        buildItems();
    }

    public void addItem(ActionEvent actionEvent) {
        Database databaseInstance = Database.getInstance();
        ItemRepository repo = new ItemRepository(databaseInstance);
        repo.addItem(
                new Item((itemRepository.getItems().size() + 1 + ""), addItemName.getText(), Double.parseDouble(addItemPrice.getText()), addItemDescription.getText(), "", "../img/" + addItemPicture.getText(), "000")
        );
        items = itemRepository.getItems();
        buildItems();
    }

    public void buildItems() {
        int column = 0;
        int row = 1;
        grid.getChildren().clear();
        try {
            for (Item item : items) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../views/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(item, myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void filterByName(ActionEvent actionEvent) {
        StrategyContext context = new StrategyContext(new FilterByName());
        items = context.executeStrategy(itemRepository.getItems(), filterName.getText());
        buildItems();
    }

    public void filterByPrice(ActionEvent actionEvent) {
        StrategyContext context = new StrategyContext(new FilterByPrice());
        items = context.executeStrategy(itemRepository.getItems(), filterPrice.getText());
        buildItems();
    }

    public void clearFilters(ActionEvent actionEvent) {
        items = itemRepository.getItems();

        if (items.size() > 0) {
            setChosenItem(items.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Item Item) {
                    setChosenItem(Item);
                }
            };
        }
        buildItems();
    }
}
