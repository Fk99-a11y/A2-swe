package src.repositories;

import src.models.Budget;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

/**
 * Repository for Budget data operations
 */
public class BudgetRepository extends BaseRepository<Budget> {

    public BudgetRepository() {
        super("budgets.json");
    }

    @Override
    protected Class<Budget> getType() {
        return Budget.class;
    }

    // Find budget by month
    public Optional<Budget> findByMonth(String month) {
        return items.stream()
                .filter(b -> b.getMonth().equalsIgnoreCase(month))
                .findFirst();
    }

    // Find budget by ID
    public Optional<Budget> findById(int budgetId) {
        return items.stream()
                .filter(b -> b.getBudgetId() == budgetId)
                .findFirst();
    }

    // Get all budgets that exceeded limit
    public List<Budget> getOverLimitBudgets() {
        List<Budget> overLimit = new ArrayList<>();
        for (Budget b : items) {
            if (b.checkLimit()) {
                overLimit.add(b);
            }
        }
        return overLimit;
    }
}
