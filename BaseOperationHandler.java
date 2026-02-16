public abstract class BaseOperationHandler implements IOperationHandler {
    public OperationRepository operationRepository;
    public Bank bank;

    public BaseOperationHandler(OperationRepository operationRepository, Bank bank) {
        this.operationRepository = operationRepository;
        this.bank = bank;
    }
}
