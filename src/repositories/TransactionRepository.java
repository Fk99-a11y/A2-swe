package src.repositories;

import src.models.Transaction;
import src.models.Income;
import src.models.Expense;
import src.utils.JsonHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Repository for Transaction data operations
 * Handles Income and Expense transactions
 */
public class TransactionRepository extends BaseRepository<Transaction> {
    
    public TransactionRepository() {
        super("transactions.json");
    }
    
    @Override
    protected Class<Transaction> getType() {
        return Transaction.class;
    }
    
    /**
     * Get all Income transactions
     */
    public List<Transaction> getIncomes() {
        List<Transaction> incomes = new ArrayList<>();
        for (Transaction t : items) {
            if (t instanceof Income) {
                incomes.add(t);
            }
        }
        return incomes;
    }
    
    /**
     * Get all Expense transactions
     */
    public List<Transaction> getExpenses() {
        List<Transaction> expenses = new ArrayList<>();
        for (Transaction t : items) {
            if (t instanceof Expense) {
                expenses.add(t);
            }
        }
        return expenses;
    }
    
    /**
     * Get total income amount
     */
    public double getTotalIncome() {
        double total = 0;
        for (Transaction t : getIncomes()) {
            total += t.getAmount();
        }
        return total;
    }
    
    /**
     * Get total expense amount
     */
    public double getTotalExpense() {
        double total = 0;
        for (Transaction t : getExpenses()) {
            total += t.getAmount();
        }
        return total;
    }
    
    /**
     * Get net balance (income - expense)
     */
    public double getNetBalance() {
        return getTotalIncome() - getTotalExpense();
    }
    
    /**
     * Get expenses by category ID
     */
    public List<Expense> getExpensesByCategory(int categoryId) {
        List<Expense> result = new ArrayList<>();
        for (Transaction t : items) {
            if (t instanceof Expense) {
                Expense e = (Expense) t;
                if (e.getCategoryId() == categoryId) {
                    result.add(e);
                }
            }
        }
        return result;
    }
    
    /**
     * Get expenses for a specific month
     * @param month "May", "June", etc.
     */
    public List<Transaction> getExpensesByMonth(String month) {
        List<Transaction> result = new ArrayList<>();
        for (Transaction t : getExpenses()) {
            // Convert date to month name (simplified)
            // You can enhance this based on your date format
            if (t.getDate() != null) {
                result.add(t);
            }
        }
        return result;
    }
    package src.repositories;

import src.models.Transaction;
import src.models.Income;
import src.models.Expense;
import src.utils.JsonHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Repository for Transaction data operations
 * Handles Income and Expense transactions
 */
public class TransactionRepository extends BaseRepository<Transaction> {
    
    public TransactionRepository() {
        super("transactions.json");
    }
    
    @Override
    protected Class<Transaction> getType() {
        return Transaction.class;
    }
    
    /**
     * Get all Income transactions
     */
    public List<Transaction> getIncomes() {
        List<Transaction> incomes = new ArrayList<>();
        for (Transaction t : items) {
            if (t instanceof Income) {
                incomes.add(t);
            }
        }
        return incomes;
    }
    
    /**
     * Get all Expense transactions
     */
    public List<Transaction> getExpenses() {
        List<Transaction> expenses = new ArrayList<>();
        for (Transaction t : items) {
            if (t instanceof Expense) {
                expenses.add(t);
            }
        }
        return expenses;
    }
    
    /**
     * Get total income amount
     */
    public double getTotalIncome() {
        double total = 0;
        for (Transaction t : getIncomes()) {
            total += t.getAmount();
        }
        return total;
    }
    
    /**
     * Get total expense amount
     */
    public double getTotalExpense() {
        double total = 0;
        for (Transaction t : getExpenses()) {
            total += t.getAmount();
        }
        return total;
    }
    
    /**
     * Get net balance (income - expense)
     */
    public double getNetBalance() {
        return getTotalIncome() - getTotalExpense();
    }
    
    /**
     * Get expenses by category ID
     */
    public List<Expense> getExpensesByCategory(int categoryId) {
        List<Expense> result = new ArrayList<>();
        for (Transaction t : items) {
            if (t instanceof Expense) {
                Expense e = (Expense) t;
                if (e.getCategoryId() == categoryId) {
                    result.add(e);
                }
            }
        }
        return result;
    }
    
    /**
     * Get expenses for a specific month
     * @param month "May", "June", etc.
     */
    public List<Transaction> getExpensesByMonth(String month) {
        List<Transaction> result = new ArrayList<>();
        for (Transaction t : getExpenses()) {
            // Convert date to month name (simplified)
            // You can enhance this based on your date format
            if (t.getDate() != null) {
                result.add(t);
            }
        }
        return result;
    }
}
// ADD Transaction
public void addTransaction(Transaction transaction) {
    add(transaction); // من BaseRepository
}

// DELETE by ID
public void deleteTransaction(int id) {
    items.removeIf(t -> t.getTransactionId() == id);
    save();
}

// GET by ID
public Transaction getById(int id) {
    for (Transaction t : items) {
        if (t.getTransactionId() == id) {
            return t;
        }
    }
    return null;
}
}
