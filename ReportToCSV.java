import java.util.Set;

public class ReportToCSV extends BaseReport {
    private WriterCsv writerCsv;

    public ReportToCSV(
            ListOfCategories listOfCategories,
            AccountRepository accountRepository,
            OperationRepository operationRepository,
            WriterCsv writerCsv) {
        super(listOfCategories, accountRepository, operationRepository);
        this.writerCsv = writerCsv;
    }

    @Override
    public void getCategories() {
        String nameReport = "categories.csv";
        getCategories(nameReport, false);
    };

    public void getCategories(String nameReport, boolean orderById) {
        String pathToReport = ReportConstants.getPath(nameReport);
        if (orderById == true) {
            this.writerCsv.createOrderingReportCategory(
                    pathToReport,
                    this.listOfCategories.getCategories());
        } else {
            this.writerCsv.createReportCategory(
                    pathToReport,
                    this.listOfCategories.getCategories());
        }
    };

    @Override
    public void getAllAccounts() {
        String nameReport = "accounts.csv";
        getAllAccounts(nameReport);
    };

    public void getAllAccounts(String nameReport) {
        String pathToReport = ReportConstants.getPath(nameReport);
        this.writerCsv.createReportAccounts(
                pathToReport,
                this.accountRepository.getAccounts());
    };

    @Override
    public void getOperationsByAccount(String accountId) {
        String nameReport = "accounts.csv";
        getOperationsByAccount(accountId, nameReport, false);
    };

    public void getOperationsByAccount(
            String accountId,
            String nameReport,
            boolean orderById) {
        String pathToReport = ReportConstants.getPath(nameReport);
        if (orderById == true) {
            this.writerCsv.createOrderingReportOperation(
                    pathToReport,
                    this.operationRepository.getOperations(accountId));
        } else {
            this.writerCsv.createReportOperation(
                    pathToReport,
                    this.operationRepository.getOperations(accountId));
        }
    };

    @Override
    public void getOperations() {
        String nameReport = "accounts.csv";
        getOperations(nameReport, false);
    };

    public void getOperations(String nameReport, boolean orderById) {
        Set<String> accountIds = this.operationRepository.getAccountIds();
        for (String accountId : accountIds) {

            String pathToReport = ReportConstants.getPath(
                    nameReport.replaceAll(".csv", "_" + accountId + ".csv"));
            if (orderById == true) {
                this.writerCsv.createOrderingReportOperation(
                        pathToReport,
                        this.operationRepository.getOperations(accountId));
            } else {
                this.writerCsv.createOrderingReportOperation(
                        pathToReport,
                        this.operationRepository.getOperations(accountId));
            }
        }
    };

}
