public abstract class BaseOperationHandler implements IOperationHandler {
    public OperationRepository operationRepository;
    public IBank bank;

    public BaseOperationHandler(OperationRepository operationRepository, IBank bank) {
        this.operationRepository = operationRepository;
        this.bank = bank;
    }
}
