package src.factories;

import src.models.Transaction;
import src.models.Income;
import src.models.Expense;
import java.util.Date;

/**
 * Factory pattern for creating Transaction objects
 * SOLID: Single Responsibility - 
 */
public class TransactionFactory {
    
    public static Transaction createIncome(int id, double amount, Date date, String notes, String source) {
        return new Income(id, amount, date, notes, source);
    }
    
    public static Transaction createExpense(int id, double amount, Date date, String notes, int categoryId) {
        return new Expense(id, amount, date, notes, categoryId);
    }
}
