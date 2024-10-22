package KI305.Demchuk.Lab3;

import java.io.*;

/**
 * Клас TreeApp демонструє роботу з класом Tree
 */
public class TreeApp {

    /**
     * Головний метод програми, який демонструє роботу з деревом, включаючи створення,
     * встановлення сезонів, вирощування плодів та перевірку стану дерева у різні пори року.
     *
     * @param args масив аргументів командного рядка 
     */
    public static void main(String[] args) {
        try {
            // Створення об'єкта дерева
            Tree appleTree = new Tree("Apple Tree", "Apple", 10, "Garden", 5.0,
                    "Loamy", "Full Sun", "Male", "John", 7, 50, "Apple");

            // Демонстрація методів класу Tree
            System.out.println("Назва дерева: " + appleTree.getName());
            System.out.println("Вік дерева: " + appleTree.getAge() + " років");
            System.out.println("Висота дерева: " + appleTree.getHeight() + " метрів");
            System.out.println("Кількість гілок: " + appleTree.getBranches());

            // Встановлення початкової пори року
            System.out.println("\nВстановлюємо сезон весна:");
            appleTree.setSeason("spring");
            appleTree.checkFeeling();  // Перевірка стану дерева навесні

            // Вирощування плодів
            System.out.println("\nВстановлюємо сезон літо:");
            appleTree.setSeason("summer");
            appleTree.growFruits();  // Вирощування плодів улітку
            System.out.println("Кількість плодів влітку: " + appleTree.getFruitCount());
            appleTree.checkFeeling();  // Перевірка стану дерева влітку

            // Осінь - листя жовте, плодів немає
            System.out.println("\nВстановлюємо сезон осінь:");
            appleTree.setSeason("fall");
            appleTree.growFruits();  // Вирощування плодів восени
            appleTree.checkFeeling();  // Перевірка стану дерева восени

            // Зима - листя немає, плодів немає
            System.out.println("\nВстановлюємо сезон зима:");
            appleTree.setSeason("winter");
            appleTree.checkFeeling();  // Перевірка стану дерева взимку

        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}
