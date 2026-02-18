public class Manager {
    ILog log;
    Bank bank;
    BankClient bankClient;
    DisplayReport report;
    ReportToCSV csvReport;
    IGenerateAccNumber generator;

    public Manager() {
        this.log = new PrintMessage();
        OperationRepository operationRepository = new OperationRepository(log);
        ListOfCategories listOfCategories = new ListOfCategories(log);
        AccountRepository accountRepository = new AccountRepository();
        this.bank = new Bank(log, accountRepository);
        DepositOperation depositCommand = new DepositOperation(operationRepository, this.bank);
        CostOperation withdrawCommand = new CostOperation(operationRepository, this.bank);
        this.bankClient = new BankClient(
                log,
                depositCommand,
                withdrawCommand,
                listOfCategories,
                accountRepository);
        this.report = new DisplayReport(
                listOfCategories,
                accountRepository,
                operationRepository);
        this.csvReport = new ReportToCSV(
                listOfCategories,
                accountRepository,
                operationRepository,
                new WriterCsv());
        this.generator = new GenerateAccountNumber();
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
    }
}
