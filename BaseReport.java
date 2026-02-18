public abstract class BaseReport implements IReport {
    protected ListOfCategories listOfCategories;
    protected AccountRepository accountRepository;
    protected OperationRepository operationRepository;

    public BaseReport(
            ListOfCategories listOfCategories,
            AccountRepository accountRepository,
            OperationRepository operationRepository) {
        this.listOfCategories = listOfCategories;
        this.accountRepository = accountRepository;
        this.operationRepository = operationRepository;
    }

}
