package src.controllers;

import src.models.User;
import src.utils.JsonHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles authentication logic (login & register)
 */
public class AuthController {

    private static List<User> users = new ArrayList<>();

    public AuthController() {
        // Dummy user for testing
        users.add(new User(1, "Ahmed Ali", "ahmed@gmail.com", 1000.0));
    }

    /**
     * Authenticate user login
     * (simple email-based login for project scope)
     */
    public boolean authenticate(String email, String password) {

        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Register new user
     */
    public void register(User user) {
        users.add(user);

        JsonHandler.saveToFile("data/user_profile.json", users);
    }

    /**
     * Get user by email (useful for JavaFX session)
     */
    public User getUser(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }
}