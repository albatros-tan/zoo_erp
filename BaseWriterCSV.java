import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseWriterCSV {
    ILog log = new PrintMessage();
    List<String> lines = new ArrayList<>();

    abstract public void makeHeader();

    abstract public void addLine();

    public void clearData() {
        this.lines.clear();
    }

    public void writeToFile(String filePath) {
        Path path = Paths.get(filePath);
        try {
            Files.write(
                    path,
                    this.lines,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            this.log.error(
                    "WriterCSV",
                    "Ошибка записи в файл: " + filePath,
                    e.getMessage());
            e.printStackTrace();
        }
        clearData();
    }

}
