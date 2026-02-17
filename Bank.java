public class Bank implements IBank {
    private ILog log;
    private AccountRepository accountRepository;

    public Bank(ILog log, AccountRepository accountRepository) {
        this.log = log;
        this.accountRepository = accountRepository;
    }

    private BankAccount getAccount(String accountId) {
        BankAccount account = this.accountRepository.getAccount(accountId);
        if (account == null) {
            throw new IllegalArgumentException("Найден аккаунт " + accountId);
        }
        return account;
    }

    @Override
    public void topUpAccount(Operation operation) {
        BankAccount account = getAccount(operation.getAccountId());
        double result = account.getBalance() + operation.getAmount();
        account.setBalance(result);
        this.log.info(account.getId(), "Счет пополнен");
        this.log.printMsg(account.toString());
    }

    @Override
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
