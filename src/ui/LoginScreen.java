package src.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import src.controllers.AppContext;

public class LoginScreen extends Application {

    @Override
    public void start(Stage stage) {

        // ===== UI =====
        Label title = new Label("Login");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Label messageLabel = new Label();

        Button loginButton = new Button("Login");

        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20;");

        root.getChildren().addAll(
                title,
                emailField,
                passwordField,
                loginButton,
                messageLabel
        );

        // ===== LOGIN LOGIC =====
        loginButton.setOnAction(e -> {

            String email = emailField.getText();
            String password = passwordField.getText();

            boolean success = AppContext.authController.authenticate(email, password);

            if (success) {
                messageLabel.setText("Login Success ✔");

                try {
                    DashboardScreen dashboard = new DashboardScreen();
                    dashboard.start(stage); 
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            } else {
                messageLabel.setText("Invalid email or password ❌");
            }
        });

        Scene scene = new Scene(root, 300, 250);
        stage.setTitle("Login Screen");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}