package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import sample.Main;
import sample.main.MyListener;
import sample.models.Item;

import java.util.Objects;

public class ItemController {
    public Label priceLabel;
    @FXML
    private Label nameLabel;

    @FXML
    private ImageView img;
    private Item item;
    private MyListener myListener;

    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(item);
    }

    public void setData(Item item, MyListener myListener) {
        this.item = item;
        this.myListener = myListener;
        nameLabel.setText(item.getName());
        priceLabel.setText(Main.CURRENCY + item.getPrice());
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(item.getImgSrc())));
        img.setImage(image);
    }
}
