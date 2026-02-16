public class CostOperation extends BaseOperationHandler {

    public CostOperation(OperationRepository operationRepository, Bank bank) {
        super(operationRepository, bank);
    }

    @Override
    public void executeOperation(
            String accountId,
            String description,
            double amount,
            int categoryId) {
        Operation operation = new Operation(
                OperationType.COSTS,
                accountId,
                amount,
                description,
                categoryId);
        this.operationRepository.addOperation(accountId, operation);
        boolean result = this.bank.withdrawFromAccount(operation);
        if (result == false) {
            this.operationRepository.removeOperation(accountId);
        }
    }

    @Override
    public void undoOperation(String accountId) {
        Operation operation = this.operationRepository.removeOperation(accountId);
        if (operation != null) {
            this.bank.topUpAccount(operation);
        }
    }
}
