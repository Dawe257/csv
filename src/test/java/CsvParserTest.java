import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CsvParserTest {
    String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
    String fileName = "data.csv";

    @Test
    @DisplayName("Успешный парсинг")
    public void successParseCsv() {
        List<Employee> expected = new ArrayList<>();
        expected.add(new Employee(1, "John", "Smith", "USA",25));
        expected.add(new Employee(2, "Ivan", "Petrov", "RU",23));

        List<Employee> list = Main.parseCSV(columnMapping, fileName);

        Assertions.assertNotNull(list);
        Assertions.assertEquals(list, expected);
    }

    @Test
    @DisplayName("Тест на невалидные значения")
    public void shouldThrowError() {
        String[] notValidColumnMapping = {"id", "id", "blabla", "age", "id"};
        String notValidFilename = "blablabla";

        Assertions.assertThrows(RuntimeException.class,
                () -> Main.parseCSV(columnMapping, notValidFilename));
        Assertions.assertThrows(RuntimeException.class,
                () -> Main.parseCSV(notValidColumnMapping, fileName));
    }

}
