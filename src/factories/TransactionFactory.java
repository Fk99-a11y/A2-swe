public class TransactionFactory {

    public static Transaction create(double amount) {
        return new Transaction(0, amount);
    }
}
