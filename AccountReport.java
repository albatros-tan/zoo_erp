public class AccountReport extends BaseWriterCSV {
    @Override
    public void makeHeader() {
        this.lines.add("id,name,balance");
    }

    @Override
    public void addLine() {

    }

    public void addLine(BankAccount account) {
        String line = String.format(
                "%s,%s,%.2f",
                account.getId(),
                account.getName(),
                account.getBalance());
        this.lines.addLast(line);
    }
}
