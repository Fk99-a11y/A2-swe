package src.ui;

import javafx.stage.Stage;
import javafx.scene.Scene;

public class Navigation {

    private static Stage stage;

    public static void init(Stage primaryStage) {
        stage = primaryStage;
    }

    public static void go(Scene scene, String title) {
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }
}