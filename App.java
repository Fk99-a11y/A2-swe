import src.controllers.FinanceController;
import src.models.*;

import java.util.Date;

public class App {

    FinanceController controller = new FinanceController();

    public void start() {

        System.out.println("Personal Budget System Running");

        controller.addTransaction(500, "income", "salary");
        controller.addTransaction(200, "expense", "food");
    }
}