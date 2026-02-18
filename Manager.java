public class Manager {
    private ILog log;
    private OperationRepository operationRepository;
    private ListOfCategories listOfCategories;
    private AccountRepository accountRepository;
    private IBank bank;
    private IOperationHandler depositCommand;
    private IOperationHandler withdrawCommand;
    private BankClient bankClient;
    private DisplayReport report;
    private ReportToCSV csvReport;
    private IGenerateAccNumber generator;

    public Manager(
            ILog log,
            OperationRepository operationRepository,
            ListOfCategories listOfCategories,
            AccountRepository accountRepository,
            IBank bank,
            IOperationHandler depositCommand,
            IOperationHandler withdrawCommand,
            BankClient bankClient,
            DisplayReport report,
            ReportToCSV csvReport,
            IGenerateAccNumber generator) {
        this.log = log;
        this.operationRepository = operationRepository;
        this.listOfCategories = listOfCategories;
        this.accountRepository = accountRepository;
        this.bank = bank;
        this.depositCommand = depositCommand;
        this.withdrawCommand = withdrawCommand;
        this.bankClient = bankClient;
        this.report = report;
        this.csvReport = csvReport;
        this.generator = generator;
    }

    public void demo() {
        bankClient.createCategory(CategoryType.INCOME, "Зарплата");
        bankClient.createCategory(CategoryType.INCOME, "Перевод");
        bankClient.createCategory(CategoryType.COSTS, "Кафе");
        bankClient.createCategory(CategoryType.COSTS, "Продукты");
        bankClient.createCategory(CategoryType.COSTS, "Заправка");

        bankClient.createNewAccount("Зарплатный счет", generator);
        bankClient.createNewAccount("Накопительный счет", generator);
        bankClient.createNewAccount("Зарплатный счет", generator);

        bankClient.addExistsAccount("qwerty76dsas", 1400, "Тестовый счет");

        bankClient.deposit(
                "qwerty76dsas",
                1334,
                "Тестовое пополнение",
                "Аванс");

        bankClient.withdraw("qwerty76dsas",
                700,
                "Тестовое списание",
                "Кафе");

        report.getCategories();
        report.getAllAccounts();
        report.getOperations();
        report.getOperationsByAccount("qwerty76dsas");
        csvReport.getCategories("init_categories.csv", true);
        csvReport.getAllAccounts("init_accounts.csv");
        csvReport.getOperations("init_operations.csv", true);
    }

    public void newCategory(CategoryType type, String name) {
        bankClient.createCategory(type, name);
    }

    public void newAccount(String name) {
        bankClient.createNewAccount(name, generator);
    }

    public void loadAccount(String id, double balance, String name) {
        bankClient.addExistsAccount(id, balance, name);
    }

    public void deposit(
            String accountId,
            double amount,
            String description,
            String destination) {
        bankClient.deposit(
                accountId,
                amount,
                description,
                destination);
    }

    public void withdraw(
            String accountId,
            double amount,
            String description,
            String source) {
        bankClient.withdraw(
                accountId,
                amount,
                description,
                source);
    }

    public void printReportByCategory() {
        report.getCategories();
    }

    public void printReportByAccounts() {
        report.getAllAccounts();
    }

    public void printReportByOperations() {
        report.getOperations();
    }

    public void printReportByOperationsByAccount(String accountId) {
        report.getOperationsByAccount(accountId);
    }

    public void ReportByCategoryToCSV(String nameReport, boolean OrderById) {
        csvReport.getCategories(nameReport, OrderById);
    }

    public void ReportByAccountsToCSV(String nameReport) {
        csvReport.getAllAccounts(nameReport);
    }

    public void ReportByOperationsToCSV(String nameReport, boolean OrderById) {
        csvReport.getOperations(nameReport, OrderById);
    }

}
