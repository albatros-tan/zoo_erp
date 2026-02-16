import java.util.HashMap;
import java.util.Map;

public class ListOfCategories {
    private ILog log;
    private static final Map<String, Category> categories = new HashMap<>();

    public ListOfCategories(ILog log) {
        this.log = log;
    }

    public void addCategory(Category category) {
        if (this.categories.containsKey(category.getName())) {
            this.log.warning(category.getName(), "Такая категория уже существует!");
        } else {
            this.categories.put(category.getName(), category);
        }
    }

    public Category getCategory(String categoryName) {
        Category category = this.categories.get(categoryName);
        if (category == null) {
            this.log.error(categoryName, "Такая категория не найдена", categoryName);
            throw new RuntimeException("Категория " + categoryName + " не найдена");
        }
        return category;
    }
}
