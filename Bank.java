public class Bank {
    private ILog log;
    private AccountRepository accountRepository;

    public Bank(ILog log) {
        this.log = log;
    }

    private BankAccount getAccount(String accountId) {
        BankAccount account = this.accountRepository.getAccount(accountId);
        if (account == null) {
            throw new IllegalArgumentException("Нейден аккаунт " + accountId);
        }
        return account;
    }

    public void topUpAccount(Operation operation) {
        BankAccount account = getAccount(operation.getAccountId());
        double result = account.getBalance() + operation.getAmount();
        account.setBalance(result);
        this.log.info(account.getId(), "Счет пополнен");
        this.log.printMsg(account.toString());
    }

    public boolean withdrawFromAccount(Operation operation) {
        BankAccount account = getAccount(operation.getAccountId());
        double result = account.getBalance() - operation.getAmount();
        if (result < 0) {
            this.log.warning(account.getId(), "Списание невозможно");
            return false;
        }
        account.setBalance(result);
        this.log.info(account.getId(), "Успешное списание");
        this.log.printMsg(account.toString());
        return true;
    }

}
