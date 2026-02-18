import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WriterCsv {
    private CategoryReport categoryReport = new CategoryReport();
    private AccountReport accountReport = new AccountReport();
    private OperationReport operationReport = new OperationReport();

    public void createReportCategory(String pathFile, Collection<Category> categories) {
        this.categoryReport.clearData();
        this.categoryReport.makeHeader();
        for (Category category : categories) {
            this.categoryReport.addLine(category);
        }
        this.categoryReport.writeToFile(pathFile);
    }

    public void createOrderingReportCategory(String pathFile, Collection<Category> categories) {
        List<Category> orderingCategories = categories.stream()
                .sorted(Comparator.comparing(Category::getId))
                .collect(Collectors.toList());
        createReportCategory(pathFile, orderingCategories);
    }

    public void createReportAccounts(String pathFile, Collection<BankAccount> accounts) {
        this.accountReport.clearData();
        this.accountReport.makeHeader();
        for (BankAccount account : accounts) {
            this.accountReport.addLine(account);
        }
        this.accountReport.writeToFile(pathFile);
    }

    public void createOrderingReportOperation(String pathFile, Collection<Operation> operations) {
        List<Operation> orderingOperations = operations.stream()
                .sorted(Comparator.comparing(Operation::getId))
                .collect(Collectors.toList());
        createReportOperation(pathFile, orderingOperations);
    }

    public void createReportOperation(String pathFile, Collection<Operation> operations) {
        this.operationReport.clearData();
        this.operationReport.makeHeader();
        for (Operation operation : operations) {
            this.operationReport.addLine(operation);
        }
        this.operationReport.writeToFile(pathFile);
    }
}
