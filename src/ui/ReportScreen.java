package src.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import src.controllers.AppContext;
import src.models.Transaction;
import src.models.Income;
import src.models.Expense;

import java.util.List;

/**
 * Reports Screen - Displays financial summary + transaction details
 */
public class ReportScreen extends Application {

    @Override
    public void start(Stage stage) {

        Label title = new Label("Reports Screen");

        Label incomeLabel = new Label();
        Label expenseLabel = new Label();
        Label balanceLabel = new Label();

        TextArea reportArea = new TextArea();
        reportArea.setEditable(false);
        reportArea.setPrefHeight(250);

        Button loadButton = new Button("Load Report");

        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20;");

        root.getChildren().addAll(
                title,
                incomeLabel,
                expenseLabel,
                balanceLabel,
                reportArea,
                loadButton
        );

        loadButton.setOnAction(e -> {

            List<Transaction> transactions = AppContext.financeController.getAllTransactions();

            double income = 0;
            double expense = 0;

            StringBuilder details = new StringBuilder();

            for (Transaction t : transactions) {

                if (t instanceof Income) {
                    income += t.getAmount();
                } else if (t instanceof Expense) {
                    expense += t.getAmount();
                }

                details.append(t.getDetails()).append("\n");
            }

            double balance = income - expense;

            incomeLabel.setText("Total Income: " + income);
            expenseLabel.setText("Total Expenses: " + expense);
            balanceLabel.setText("Net Balance: " + balance);

            reportArea.setText(details.toString());
        });

        Scene scene = new Scene(root, 500, 400);
        stage.setTitle("Reports");
        stage.setScene(scene);
        stage.show();
    }
}