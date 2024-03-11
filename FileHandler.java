
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileHandler {
    private int nextItemId = 1;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Укажите здесь нужный формат даты

    public void saveItemsToFile(List<Item> items, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Item item : items) {
                writer.write(item.getTitle() + "," + item.getCategory() + "," + item.getSize() + "," + item.getColor() + "," + item.getStyle() + "," + dateFormat.format(item.getDateAdded()));
                writer.newLine();
            }
            System.out.println("Данные успешно сохранены в файл " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении данных в файл: " + e.getMessage());
        }
    }

    public List<Item> loadItemsFromFile(String fileName) {
        List<Item> loadedItems = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    String title = data[0];
                    String category = data[1];
                    String size = data[2];
                    String color = data[3];
                    String style = data[4];
                    try {
                        Date dateAdded = dateFormat.parse(data[5]); // Парсинг строки в объект Date
                        Item loadedItem = new Item(nextItemId, title, category, size, color, style, dateAdded);
                        loadedItems.add(loadedItem);
                        nextItemId++; // Увеличиваем счетчик для следующего идентификатора
                    } catch (ParseException e) {
                        System.out.println("Ошибка при парсинге даты: " + e.getMessage());
                    }
                }
            }
            System.out.println("Данные успешно загружены из файла " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке данных из файла: " + e.getMessage());
        }
        return loadedItems;
    }
}