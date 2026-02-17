public class BankClient {
    private ILog log;
    private ListOfCategories listOfCategories;
    private AccountRepository accountRepository;
    private IOperationHandler depositCommand;
    private IOperationHandler withdrawCommand;

    public BankClient(
            ILog log,
            IOperationHandler depositCommand,
            IOperationHandler withdrawCommand,
            ListOfCategories listOfCategories,
            AccountRepository accountRepository) {
        this.log = log;
        this.listOfCategories = listOfCategories;
        this.accountRepository = accountRepository;
        this.depositCommand = depositCommand;
        this.withdrawCommand = withdrawCommand;
    }

    public void createCategory(CategoryType type, String name) {
        this.listOfCategories.addCategory(new Category(type, name));
    }

    public void createNewAccount(String name, IGenerateAccNumber generator) {
        BankAccount account = BankAccount.initNewAccount(name, generator);
        this.accountRepository.addAccount(account);
        this.log.printMsg(account.toString());
    }

    public void addExistsAccount(String id, double balnce, String name) {
        BankAccount account = BankAccount.builder()
                .id(id)
                .balance(balnce)
                .name(name)
                .build();
        this.accountRepository.addAccount(account);
        this.log.printMsg(account.toString());
    }

    public void deposit(
            String accountId,
            double amount,
            String desciption,
            String destination) {
        Category category = this.listOfCategories.getCategory(destination);
        if (category == null) {
            category = new Category(CategoryType.INCOME, destination);
            this.listOfCategories.addCategory(category);
        }
        this.depositCommand.executeOperation(accountId, desciption, amount, category.getId());
    }

    public void withdraw(
            String accountId,
            double amount,
            String desciption,
            String source) {
        Category category = this.listOfCategories.getCategory(source);
        if (category == null) {
            category = new Category(CategoryType.COSTS, source);
            this.listOfCategories.addCategory(category);
        }
        this.withdrawCommand.executeOperation(accountId, desciption, amount, category.getId());
    }

}
