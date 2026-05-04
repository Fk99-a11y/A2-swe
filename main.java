import models.*;
import utils.JsonHandler;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.File;

public class main {
    public static void main(String[] args) {
        // 1. Prepare data folder
        File folder = new File("data");
        if (!folder.exists()) {
            folder.mkdir();
        }

        System.out.println("--- Personal Finance Management System ---");

        // 2. Create a User with initial balance of 1000.0
        User user = new User(1, "Ahmed Ali", "ahmed@gmail.com", 1000.0);
        System.out.println("Initial Balance: " + user.getBalance());

        // 3. Create a list to store transactions
        List<Transaction> transactions = new ArrayList<>();

        // 4. Add an Income transaction (e.g., Salary)
        Income salary = new Income(101, 500.0, new Date(), "Freelance Project", "Software Development");
        transactions.add(salary);
        user.updateBalance(500.0); // Updating user balance
        System.out.println("Income Added: 500.0. New Balance: " + user.getBalance());

        // 5. Add an Expense transaction (e.g., Food)
        Expense lunch = new Expense(102, 200.0, new Date(), "Lunch at Pizza Hut", 3); // Category 3 = Food
        transactions.add(lunch);
        user.updateBalance(-200.0);
        System.out.println("Expense Added: 200.0. Final Balance: " + user.getBalance());

        JsonHandler.saveToFile("data/user_profile.json", user);
        JsonHandler.saveToFile("data/transactions_history.json", transactions);

        System.out.println("------------------------------------");
        System.out.println("Success! Data has been saved to the 'data' folder.");
    }
}