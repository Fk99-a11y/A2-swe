package src.controllers;

public class AppContext {

  
    public static final AuthController authController = new AuthController();
    public static final FinanceController financeController = new FinanceController();

    private AppContext() {
        
    }
}