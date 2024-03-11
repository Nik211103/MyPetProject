import java.util.*;

public class Wardrobe {
    private List<Item> items;
    private int nextItemId = 1;
    public Wardrobe() {
        this.items = new ArrayList<>();
    }

    public Item findItemById(int itemId) {
        for (Item item : items) {
            if (item.getItemId() == itemId) {
                return item;
            }
        }
        return null; // Возвращаем null, если предмет не найден
    }
    // Метод для добавления нового предмета одежды
    public void addItem(String title, String category, String size, String color, String style, Date dateAdded) {
        Item newItem = new Item(nextItemId, title, category, size, color, style, dateAdded);
        items.add(newItem);
        nextItemId++; // Увеличиваем счетчик для следующего идентификатора
        System.out.println("Новый предмет \"" + title + "\" успешно добавлен в гардероб.");
    }

    // Метод для просмотра всех предметов в гардеробе
    public void viewItems() {
        sortByDateAdded(true); // Сортировка по возрастанию даты добавления

        if (items.isEmpty()) {
            System.out.println("В гардеробе нет предметов одежды.");
        } else {
            System.out.println("Предметы в гардеробе:");
            for (Item item : items) {
                System.out.println("Название: " + item.getTitle());
                System.out.println("Категория: " + item.getCategory());
                System.out.println("Размер: " + item.getSize());
                System.out.println("Цвет: " + item.getColor());
                System.out.println("Стиль: " + item.getStyle());
                System.out.println("Дата добавления: " + item.getDateAdded());
                System.out.println("----------------------");
            }
        }
    }


    // Метод для редактирования информации о предмете
    public void editItem(int itemId, String title, String category, String size, String color, String style, Date dateAdded) {
        Item item = findItemById(itemId);

        if (item != null) {
            item.setTitle(title);
            item.setCategory(category);
            item.setSize(size);
            item.setColor(color);
            item.setStyle(style);
            item.setDateAdded(dateAdded);
            System.out.println("Информация о предмете успешно обновлена.");
        } else {
            System.out.println("Предмет с указанным идентификатором не найден.");
        }
    }

    // Метод для удаления предмета из гардероба
    public void deleteItem(int itemId) {
        Item item = findItemById(itemId);

        if (item != null) {
            items.remove(item);
            System.out.println("Предмет успешно удален из гардероба.");
        } else {
            System.out.println("Предмет с указанным идентификатором не найден.");
        }
    }

    // Метод для поиска предмета из гардероба
    public void findItem(String title) {
        boolean found = false;
        for (Item item : items) {
            if (item.getTitle().equals(title)) {
                System.out.println("Предмет найден:");
                System.out.println("Название: " + item.getTitle());
                System.out.println("Категория: " + item.getCategory());
                System.out.println("Размер: " + item.getSize());
                System.out.println("Цвет: " + item.getColor());
                System.out.println("Стиль: " + item.getStyle());
                System.out.println("Дата добавления: " + item.getDateAdded());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Предмет с названием \"" + title + "\" не найден.");
        }
    }

    // Метод для фильтрации предметов по категории
    public void filterByCategory(String category) {
        System.out.println("Предметы в категории \"" + category + "\":");
        boolean found = false;
        for (Item item : items) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                System.out.println("Название: " + item.getTitle());
                System.out.println("Размер: " + item.getSize());
                System.out.println("Цвет: " + item.getColor());
                System.out.println("Стиль: " + item.getStyle());
                System.out.println("Дата добавления: " + item.getDateAdded());
                System.out.println("----------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Предметы в категории \"" + category + "\" не найдены.");
        }
    }

    public void sortByDateAdded(boolean ascending) {
        if (ascending) {
            Collections.sort(items, Comparator.comparing(Item::getDateAdded));
        } else {
            Collections.sort(items, Comparator.comparing(Item::getDateAdded).reversed());
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
