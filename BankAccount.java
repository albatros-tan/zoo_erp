public class BankAccount {
    private String id;
    private double balance;
    private String name;

    private BankAccount(String id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getName() {
        return this.name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[-] Счет № "
                + this.id
                + " (" + this.name + ") "
                + " | На балансе " + this.balance
                + " рублей";
    }

    public static BankAccount initNewAccount(String name, IGenerateAccNumber generator) {
        if (name == null || name.trim().isEmpty()) {
            name = AccountConstants.UNKNOWN_ACCOUNT_NAME;
        }
        String generatedId = generator.generateAccountNumber();
        return new BankAccount(generatedId, name, 0.0);
    }

    public static class BankAccountBuilder {
        private String id;
        private double balance;
        private String name;

        private BankAccountBuilder() {
        }

        public BankAccountBuilder id(String id) {
            this.id = id.trim();
            return this;
        }

        public BankAccountBuilder name(String name) {
            this.name = name.trim();
            return this;
        }

        public BankAccountBuilder balance(double balance) {
            this.balance = balance;
            return this;
        }

        public BankAccount buld() {
            if (this.name == null || this.name.isEmpty()) {
                throw new IllegalStateException("Название счета обязательно!");
            }
            if (this.id == null || this.id.isEmpty()) {
                throw new IllegalStateException("ID счета обязателен");
            }
            if (this.balance < 0) {
                throw new IllegalStateException("Баланс не может быть отрицательным");
            }
            return new BankAccount(this.id, this.name, this.balance);
        }

    }

}
