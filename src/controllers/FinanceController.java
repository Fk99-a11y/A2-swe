public class FinanceController {

    private BudgetService service = new BudgetService();

    public void addExpense(String title, double amount) {
        service.addExpense(title, amount);
    }
}
