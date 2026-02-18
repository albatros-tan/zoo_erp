public class Main {

    public static void main(String[] args) {
        // Сздание зависимостей
        ILog log = new PrintMessage();
        OperationRepository operationRepository = new OperationRepository(log);
        ListOfCategories listOfCategories = new ListOfCategories(log);
        AccountRepository accountRepository = new AccountRepository();
        IBank bank = new Bank(log, accountRepository);
        IOperationHandler depositCommand = new DepositOperation(operationRepository, bank);
        IOperationHandler withdrawCommand = new CostOperation(operationRepository, bank);
        BankClient bankClient = new BankClient(
                log,
                depositCommand,
                withdrawCommand,
                listOfCategories,
                accountRepository);
        DisplayReport report = new DisplayReport(
                listOfCategories,
                accountRepository,
                operationRepository);
        ReportToCSV csvReport = new ReportToCSV(
                listOfCategories,
                accountRepository,
                operationRepository,
                new WriterCsv());
        IGenerateAccNumber generator = new GenerateAccountNumber();
        // Передача зависимостей в контейнер
        Manager manager = new Manager(
                log,
                operationRepository,
                listOfCategories,
                accountRepository,
                bank,
                depositCommand,
                withdrawCommand,
                bankClient,
                report,
                csvReport,
                generator);
        manager.demo(); // метод создающий некотоое количество данных
        manager.newAccount("Зарплата");
        manager.ReportByAccountsToCSV("testing.csv");
    }
}