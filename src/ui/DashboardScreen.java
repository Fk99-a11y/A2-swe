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

public class DashboardScreen extends Application {

    @Override
    public void start(Stage stage) {

        Label title = new Label("Dashboard");

      
        double balance = AppContext.financeController.getBalance();

        List<Transaction> transactions = AppContext.financeController.getAllTransactions();

        double income = 0;
        double expense = 0;

        for (Transaction t : transactions) {
            if (t instanceof Income) {
                income += t.getAmount();
            } else if (t instanceof Expense) {
                expense += t.getAmount();
            }
        }

        // ===== Labels =====
        Label balanceLabel = new Label("Balance: " + balance);
        Label incomeLabel = new Label("Total Income: " + income);
        Label expenseLabel = new Label("Total Expenses: " + expense);

        // ===== Buttons =====
        Button addTransactionBtn = new Button("Add Transaction");
        Button budgetBtn = new Button("View Budget");
        Button reportBtn = new Button("View Reports");

        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20;");

        root.getChildren().addAll(
                title,
                balanceLabel,
                incomeLabel,
                expenseLabel,
                addTransactionBtn,
                budgetBtn,
                reportBtn
        );

      

        addTransactionBtn.setOnAction(e -> {
            try {
                new AddTransactionScreen().start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        budgetBtn.setOnAction(e -> {
            try {
                new BudgetScreen().start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        reportBtn.setOnAction(e -> {
            try {
                new ReportScreen().start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("Dashboard");
        stage.setScene(scene);
        stage.show();
    }
}