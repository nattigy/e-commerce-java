package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    public static final String CURRENCY = "$";

    public static void main(String[] args) {
        launch(args);
//        Database databaseInstance = Database.getInstance();
//        Database databaseInstance2 = Database.getInstance();
//        ItemRepository repo = new ItemRepository(databaseInstance);
//        ItemRepository repo2 = new ItemRepository(databaseInstance2);
//        System.out.println("repo.getItems()");
//        System.out.println(repo.getItems());
//        repo.addItem(new Item("10","new Item", "170", null, "", null));
//        System.out.println("repo.getItems()");
//        System.out.println(repo2.getItems());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("views/market.fxml")));
        primaryStage.setTitle("Fruits Marker");
        primaryStage.setScene(new Scene(root, 1300, 700));
        primaryStage.show();
    }
}
