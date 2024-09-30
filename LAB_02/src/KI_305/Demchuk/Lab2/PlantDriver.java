package KI_305.Demchuk.Lab2;

/**
 * Клас для демонстрації роботи класу Plant.
 */
public class PlantDriver {

    /**
     * Конструктор за замовчуванням для класу PlantDriver.
     */
    public PlantDriver() {
        // Пустий конструктор
    }

    /**
     * Основний метод для запуску демонстрації.
     *
     * @param args Аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        // Приклад створення рослини
        Plant plant = new Plant("Sunflower", "Helianthus", 2, "Outside",
                1.5, "Loamy", "Full sun", "Male", "Pavlo", 1);

        // Виведення статусу рослини
        plant.status();
        // Полив рослини
        plant.water();
        // Додавання добрив
        plant.fertilize();
        // Перевірка стану рослини
        plant.checkFeeling();
        // Зміна місця знаходження
        plant.relocate("Indoor");
        // Зміна доглядача
        Plant.Caretaker newCaretaker = plant.new Caretaker();
        newCaretaker.setNameCaretaker("John");
        newCaretaker.setSexCaretaker("Male");
        plant.setCaretaker(newCaretaker);
        // Виведення статусу після змін
        plant.status();
    }
}
