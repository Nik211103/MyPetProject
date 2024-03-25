import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Wardrobe wardrobe = new Wardrobe(); // Создаем экземпляр класса Wardrobe

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить предмет одежды");
            System.out.println("2. Просмотреть все предметы одежды");
            System.out.println("3. Поиск предмета одежды");
            System.out.println("4. Выход");

            choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера ввода

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    displayItems();
                    break;
                case 3:
                    searchItem();
                    break;
                case 4:
                    System.out.println("Завершение работы.");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        } while (choice != 4);
    }

    private static void addItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название предмета:");
        String title = scanner.nextLine();
        System.out.println("Введите категорию предмета:");
        String category = scanner.nextLine();
        System.out.println("Введите размер предмета:");
        String size = scanner.nextLine();
        System.out.println("Введите цвет предмета:");
        String color = scanner.nextLine();
        System.out.println("Введите стиль предмета:");
        String style = scanner.nextLine();
        System.out.println("Введите дату добавления предмета в формате dd/MM/yyyy:");
        String dateString = scanner.nextLine();
        Date dateAdded = null;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false); // Установка строгого режима парсинга

        try {
            dateAdded = dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Ошибка: Некорректный формат даты. Пожалуйста, введите дату в формате dd/MM/yyyy.");
            return;
        }

        if (validateItem(title, category, size, color, style, dateAdded)) {
            wardrobe.addItem(title, category, size, color, style, dateAdded);
        }
    }

    private static boolean validateItem(String title, String category, String size, String color, String style, Date dateAdded) {
        if (title.isEmpty() || category.isEmpty() || size.isEmpty() || color.isEmpty() || style.isEmpty() || dateAdded == null) {
            System.out.println("Ошибка: Все поля должны быть заполнены.");
            return false;
        }

        return true;
    }

    private static void displayItems() {
        System.out.println("Список предметов одежды в гардеробе:");
        List<Item> items = wardrobe.getItems(); // Получаем список всех предметов из гардероба

        if (items.isEmpty()) {
            System.out.println("В гардеробе нет предметов одежды.");
        } else {
            for (Item item : items) {
                System.out.println("Название: " + item.getTitle());
                System.out.println("Категория: " + item.getCategory());
                System.out.println("Размер: " + item.getSize());
                System.out.println("Цвет: " + item.getColor());
                System.out.println("Стиль: " + item.getStyle());
                System.out.println("Дата добавления: " + item.getDateAdded());
                System.out.println("Изображение: " + item.getImagePath());
                System.out.println("----------------------");
            }
        }
    }

    private static void searchItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите критерии поиска:");
        System.out.println("Название:");
        String searchTitle = scanner.nextLine();
        System.out.println("Категория:");
        String searchCategory = scanner.nextLine();
        System.out.println("Цвет:");
        String searchColor = scanner.nextLine();

        List<Item> items = wardrobe.getItems();
        boolean found = false;

        for (Item item : items) {
            if (item.getTitle().equalsIgnoreCase(searchTitle) || item.getCategory().equalsIgnoreCase(searchCategory) || item.getColor().equalsIgnoreCase(searchColor)) {
                System.out.println("Найден предмет:");
                System.out.println("Название: " + item.getTitle());
                System.out.println("Категория: " + item.getCategory());
                System.out.println("Цвет: " + item.getColor());
                System.out.println("----------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Предмет не найден.");
        }
    }
}