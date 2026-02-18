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
    };

    @Override
    public void getOperations() {
    };

}
