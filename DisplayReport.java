import java.util.ArrayList;
import java.util.Set;

public class DisplayReport implements IReport {
    private ListOfCategories listOfCategories;
    private AccountRepository accountRepository;
    private OperationRepository operationRepository;

    public DisplayReport(
            ListOfCategories listOfCategories,
            AccountRepository accountRepository,
            OperationRepository operationRepository) {
        this.listOfCategories = listOfCategories;
        this.accountRepository = accountRepository;
        this.operationRepository = operationRepository;
    }

    @Override
    public void getCategories() {
        System.out.println("==============Список категорий" + "==============");
        for (Category category : this.listOfCategories.getCategories()) {
            System.out.println(category);
        }
        System.out.println("-".repeat(45));
    }

    @Override
    public void getAllAccounts() {
        System.out.println("==============Список счетов" + "==============");
        for (BankAccount account : this.accountRepository.getAccounts()) {
            System.out.println(account);
        }
        System.out.println("-".repeat(45));
    }

    @Override
    public void getOperationsByAccount(String accountId) {
        System.out.println("==========Операции по " + accountId + "==========");
        ArrayList<Operation> operations = this.operationRepository.getOperations(accountId);
        for (Operation operation : operations) {
            System.out.println(operation);
        }
        System.out.println("-".repeat(45));
    }

    @Override
    public void getOperations() {
        System.out.println("==============Список операций" + "==============");
        Set<String> accountIds = this.operationRepository.getAccountIds();
        for (String accountId : accountIds) {
            System.out.println(accountId);
            for (Operation operation : this.operationRepository.getOperations(accountId)) {
                System.out.println(operation.toString());
            }
        }
        System.out.println("-".repeat(45));
    }
}
