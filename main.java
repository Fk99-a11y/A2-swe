import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import src.models.*;
import src.utils.JsonHandler;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import src.ui.LoginScreen;
import src.controllers.AppContext;

public class main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

       
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.start(stage);
    }

   
    public static void demoData() {

        File folder = new File("data");
        if (!folder.exists()) {
            folder.mkdir();
        }

        System.out.println("--- Personal Finance Management System ---");

        User user = new User(1, "Ahmed Ali", "ahmed@gmail.com", 1000.0);
        System.out.println("Initial Balance: " + user.getBalance());

        List<Transaction> transactions = new ArrayList<>();

        Income salary = new Income(101, 500.0, new Date(), "Freelance Project", "Software Development");
        transactions.add(salary);
        user.updateBalance(500.0);
        System.out.println("Income Added: 500.0. New Balance: " + user.getBalance());

        Expense lunch = new Expense(102, 200.0, new Date(), "Lunch at Pizza Hut", 3);
        transactions.add(lunch);
        user.updateBalance(-200.0);
        System.out.println("Expense Added: 200.0. Final Balance: " + user.getBalance());

        JsonHandler.saveToFile("data/user_profile.json", user);
        JsonHandler.saveToFile("data/transactions_history.json", transactions);

        System.out.println("------------------------------------");
        System.out.println("Success! Data has been saved to the 'data' folder.");
    }

    public static void main(String[] args) {
        launch(args);
    }
}