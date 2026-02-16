import java.util.HashMap;

public class AccountRepository {
    private static HashMap<String, BankAccount> repository = new HashMap<>();

    public AccountRepository() {
    }

    public void addAccount(BankAccount bankAccount) {
        if (!this.repository.containsKey(bankAccount.getId())) {
            this.repository.put(bankAccount.getId(), bankAccount);
        }
    }

    public BankAccount getAccount(String accountId) {
        if (!this.repository.containsKey(accountId)) {
            return null;
        }
        return this.repository.get(accountId);
    }
}
