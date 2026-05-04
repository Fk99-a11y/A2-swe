package src.models;
import java.util.Date;
/**
 * Represents money earned by the user from various sources.
 * Inherits from the Transaction class.
 */

public class Income extends Transaction {
    private String source;

    public Income(int transactionId, double amount, Date date, String notes, String source) {
        super(transactionId, amount, date, notes); // بيبعت البيانات للأب
        this.source = source;
    }
    public String getSource() {
        return source;
    }
    /**
     * Overrides the getDetails method to include the income source.
     * @return Formatted details of the income.
     */

    @Override
    public String getDetails() {
        return "Income Source: " + source + " | Amount: " + amount + " | Date: " + date;
    }
}
