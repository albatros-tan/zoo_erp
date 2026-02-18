public class OperationReport extends BaseWriterCSV {
    @Override
    public void makeHeader() {
        this.lines.add("id,type,accountId,amount,description,categoryId,date");
    }

    @Override
    public void addLine() {

    }

    public void addLine(Operation operation) {
        String line = String.format(
                "%d,%s,%s,%.2f,%s,%d,%s",
                operation.getId(),
                operation.getType(),
                operation.getAccountId(),
                operation.getAmount(),
                operation.getDescription(),
                operation.getCategoryId(),
                operation.getDate());
        this.lines.addLast(line);
    }

}
