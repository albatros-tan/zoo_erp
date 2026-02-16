public class Category {
    protected static int idCounter = 0;
    private final int id;
    private CategoryType type;
    private String name;

    public Category(CategoryType type, String name) {
        this.id = ++this.idCounter;
        this.type = type;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public CategoryType getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

}
