/*Название (title): строка, содержащая название предмета одежды.
Категория (category): строка, указывающая на категорию предмета (например, верхняя одежда, обувь, платье и т.д.).
Размер (size): строка или числовое значение, указывающее на размер предмета одежды.
Цвет (color): строка, описывающая цвет предмета.
Стиль (style): строка, указывающая на стиль предмета (например, спортивный, классический, повседневный и т.д.).
Фотография (photo): изображение предмета одежды для визуального отображения.
Дата добавления (dateAdded): дата, когда предмет был добавлен в гардероб.
*/

import java.util.Date;

public class Item {
    private int itemId;
    private String title, category, size, color, style, imagePath;
    private Date dateAdded;

    public Item(int itemId, String title, String category, String size, String color, String style, Date dateAdded) {
        this.itemId = itemId;
        this.title = title;
        this.category = category;
        this.size = size;
        this.color = color;
        this.style = style;
        this.dateAdded = dateAdded;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public String getStyle() {
        return style;
    }

    public Date getDateAdded() {
        return dateAdded;
    }
}
