public class DepositOperation extends BaseOperationHandler {

    public DepositOperation(OperationRepository operationRepository, IBank bank) {
        super(operationRepository, bank);
    }

    @Override
    public void executeOperation(
            String accountId,
            String description,
            double amount,
            int categoryId) {
        Operation operation = new Operation(
                OperationType.INCOME,
                accountId,
                amount,
                description,
                categoryId);
        this.operationRepository.addOperation(accountId, operation);
        this.bank.topUpAccount(operation);
    }

    @Override
    public void undoOperation(String accountId) {
        Operation operation = this.operationRepository.removeOperation(accountId);
        if (operation != null) {
            boolean result = this.bank.withdrawFromAccount(operation);
            if (result == false) {
                this.operationRepository.addOperation(accountId, operation);
            }
        }
    }
}