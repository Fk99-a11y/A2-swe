package models;
/**
 * Manages monthly spending limits and monitors current expenditures.
 */
public class Budget {
    private int budgetId;
    private double limitAmount;
    private double currentSpending;
    private String month;

    public Budget(int budgetId, double limitAmount, String month) {
        this.budgetId = budgetId;
        this.limitAmount = limitAmount;
        this.month = month;
        this.currentSpending = 0.0;
    }
    /**
     * Checks if the current spending has exceeded the pre-defined limit.
     * @return true if current spending is greater than the limit amount.
     */
    public boolean checkLimit() {
        return currentSpending > limitAmount;
    }
    /**
     * Calculates the remaining money available in the budget.
     * @return The difference between the limit and current spending.
     */
    public double getRemainingAmount() {
        return limitAmount - currentSpending;
    }
}
