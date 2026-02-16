public interface IOperationHandler {
    public void executeOperation(
            String accountId,
            String description,
            double amount,
            int categoryId);

    public void undoOperation(String accountId);
}
