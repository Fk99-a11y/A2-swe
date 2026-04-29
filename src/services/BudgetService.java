public class BudgetService {

    private ExpenseRepository repo = new ExpenseRepository();

    public void addExpense(String title, double amount) {
        Expense e = new Expense(0, title, amount);
        repo.save(e);
    }
}
