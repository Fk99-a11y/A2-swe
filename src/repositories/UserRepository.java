package src.repositories;

import src.models.User;
import src.utils.JsonHandler;

/**
 * Repository for User data operations
 */
public class UserRepository {

private static final String FILE_NAME = "data/user_profile.json";
    private User currentUser;

    public UserRepository() {
        load();
    }

    // Load user from file
    public void load() {
        currentUser = JsonHandler.loadFromFile(FILE_NAME, User.class);

        if (currentUser == null) {
            currentUser = new User(1, "Default User", "user@email.com", 0.0);
            save();
        }
    }

    // Save user to file
    public void save() {
        JsonHandler.saveToFile(FILE_NAME, currentUser);
    }

    // Get current user
    public User getUser() {
        return currentUser;
    }

    // Update user
    public void updateUser(User user) {
        this.currentUser = user;
        save();
    }

    // Update balance
    public void updateBalance(double amount) {
        currentUser.updateBalance(amount);
        save();
    }

    // Get balance
    public double getBalance() {
        return currentUser.getBalance();
    }

    // Simple authentication
    public boolean authenticate(String email) {
        return currentUser.getEmail().equals(email);
    }

    // Register new user
    public void register(User user) {
        this.currentUser = user;
        save();
    }
}
