public class CategoryReport extends BaseWriterCSV {

    @Override
    public void makeHeader() {
        this.lines.add("id,name,type");
    }

    @Override
    public void addLine() {

    }

    public void addLine(Category category) {
        String line = String.format(
                "%d,%s,%s",
                category.getId(),
                category.getName(),
                category.getType());
        this.lines.addLast(line);
    }
}
