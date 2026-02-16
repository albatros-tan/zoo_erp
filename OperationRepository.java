import java.util.ArrayList;
import java.util.HashMap;

public class OperationRepository {
    private ILog log;
    private HashMap<String, ArrayList<Operation>> repository = new HashMap<>();

    public OperationRepository(ILog log) {
        this.log = log;
    }

    public void addOperation(String accountId, Operation operation) {
        if (!this.repository.containsKey(accountId)) {
            this.repository.put(accountId, new ArrayList<>());
        }
        this.repository.get(accountId).add(operation);
        this.log.info(accountId, "Добавлена " + operation.toString());
    }

    public ArrayList<Operation> getOperations(String accountId) {
        ArrayList<Operation> operations = this.repository.get(accountId);
        return operations;
    }

    public Operation removeOperation(String accountId) {
        ArrayList<Operation> operations = this.getOperations(accountId);
        if (operations == null) {
            this.log.warning(accountId, "Список операций пуст");
            return null;
        }
        return operations.remove(operations.size() - 1);
    }

}
