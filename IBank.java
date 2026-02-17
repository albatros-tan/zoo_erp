public interface IBank {
    public void topUpAccount(Operation operation);

    public boolean withdrawFromAccount(Operation operation);
}
