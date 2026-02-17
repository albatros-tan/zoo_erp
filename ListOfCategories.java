import java.util.Collection;
import java.util.Collections;
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
            this.log.warning(categoryName, "Категория не найдена");
            return null;
        }
        return category;
    }

    public Collection<Category> getCategories() {
        return Collections.unmodifiableCollection(this.categories.values());
    }

}
