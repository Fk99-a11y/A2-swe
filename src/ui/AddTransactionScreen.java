package src.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import src.controllers.AppContext;

import java.util.Date;

public class AddTransactionScreen extends Application {

    @Override
    public void start(Stage stage) {

        Label title = new Label("Add Transaction");

        TextField amountField = new TextField();
        amountField.setPromptText("Amount");

        ChoiceBox<String> typeChoice = new ChoiceBox<>();
        typeChoice.getItems().addAll("Income", "Expense");

        TextField categoryField = new TextField();
        categoryField.setPromptText("Category ID");

        TextField notesField = new TextField();
        notesField.setPromptText("Notes");

        Label messageLabel = new Label();

        Button saveButton = new Button("Save Transaction");

        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20;");

        root.getChildren().addAll(
                title,
                amountField,
                typeChoice,
                categoryField,
                notesField,
                saveButton,
                messageLabel
        );

        // ===== SAVE LOGIC =====
        saveButton.setOnAction(e -> {

            try {
                String amountText = amountField.getText();
                String type = typeChoice.getValue();
                String categoryText = categoryField.getText();
                String notes = notesField.getText();

                // ===== VALIDATION =====
                if (amountText.isEmpty() || type == null || categoryText.isEmpty()) {
                    messageLabel.setText("⚠ Please fill all fields");
                    return;
                }

                double amount = Double.parseDouble(amountText);
                int categoryId = Integer.parseInt(categoryText);

                boolean success = AppContext.financeController.addTransaction(
                        amount,
                        type,
                        categoryId,
                        new Date(),
                        notes
                );

                if (success) {
                    messageLabel.setText("✔ Transaction Added Successfully");

                    // clear fields
                    amountField.clear();
                    categoryField.clear();
                    notesField.clear();
                    typeChoice.setValue(null);

                } else {
                    messageLabel.setText("❌ Failed to add transaction");
                }

            } catch (NumberFormatException ex) {
                messageLabel.setText("⚠ Invalid number format");
            }
        });

        Scene scene = new Scene(root, 400, 350);
        stage.setTitle("Add Transaction");
        stage.setScene(scene);
        stage.show();
    }
}