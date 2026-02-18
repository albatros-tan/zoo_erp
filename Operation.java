import java.time.Instant;

public class Operation {
    private static int idCounter = 0;
    private int id;
    private OperationType type;
    private String bankAccountId;
    private double amount;
    private String description;
    private int categoryId;
    private Instant date = Instant.now();

    public Operation(
            OperationType type,
            String bankAccountId,
            double amount,
            String description,
            int categoryId) {
        this.id = ++this.idCounter;
        this.type = type;
        this.bankAccountId = bankAccountId;
        this.amount = amount;
        this.description = description;
        this.categoryId = categoryId;
    }

    public Instant getDate() {
        return this.date;
    }

    public String getAccountId() {
        return this.bankAccountId;
    }

    public double getAmount() {
        return this.amount;
    }

    public int getId() {
        return this.id;
    }

    public OperationType getType() {
        return this.type;
    }

    public String getDescription() {
        return this.description;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    @Override
    public String toString() {
        return "Операция " + this.description + " | "
                + this.id + " | "
                + this.type + " | account "
                + this.bankAccountId + " | category "
                + this.categoryId + " | "
                + this.amount + " | " + this.date;
    }
}
