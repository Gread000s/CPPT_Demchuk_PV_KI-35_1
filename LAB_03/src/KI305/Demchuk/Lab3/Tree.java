package KI305.Demchuk.Lab3;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Інтерфейс Fruit визначає методи для роботи з фруктами у класах, що його імплементують.
 */
interface Fruit {
    /**
     * Повертає тип фруктів, які вирощує дерево.
     * 
     * @return тип фруктів як String.
     */
    String getFruitType();

    /**
     * Метод для вирощування фруктів. Реалізація залежить від сезону.
     */
    void growFruits();
}

/**
 * Клас Tree описує дерево, яке може рости, мати гілки, вирощувати фрукти та реагувати на зміни сезону.
 * Наслідує клас Plant та імплементує інтерфейс Fruit.
 */
public class Tree extends Plant implements Fruit {

    private int branches;
    private String fruitType;
    private int fruitCount;
    private String season;
    private String leafColor;
    private boolean hasFruits;

    /**
     * Конструктор для створення нового дерева.
     * 
     * @param name ім'я дерева
     * @param species вид дерева
     * @param age вік дерева
     * @param location розташування дерева
     * @param height висота дерева
     * @param dirtType тип ґрунту, в якому росте дерево
     * @param sunlightExposure рівень освітлення сонцем
     * @param caretakerSex стать доглядача дерева
     * @param caretakerName ім'я доглядача
     * @param feeling початковий стан дерева
     * @param branches кількість гілок на дереві
     * @param fruitType тип фруктів, які вирощує дерево
     */
    public Tree(String name, String species, int age, String location,
                double height, String dirtType, String sunlightExposure,
                String caretakerSex, String caretakerName, int feeling,
                int branches, String fruitType) {
        super(name, species, age, location, height, dirtType, sunlightExposure, caretakerSex, caretakerName, feeling);
        this.branches = branches;
        this.fruitType = fruitType;
        this.fruitCount = 0;
        this.season = "spring";
        updateTreeAppearance();
    }

    /**
     * Повертає тип фруктів, які вирощує дерево.
     * 
     * @return тип фруктів як String.
     */
    
    public String getFruitType() {
        return fruitType;
    }

    /**
     * Вирощує фрукти, якщо поточний сезон - літо.
     * Збільшує кількість фруктів на 10.
     */
    
    public void growFruits() {
        if ("summer".equals(season)) {
            this.fruitCount += 10;
            logActivity("Grew 10 fruits. Total fruits: " + this.fruitCount);
        } else {
            logActivity("Cannot grow fruits. It's not summer.");
        }
    }

    /**
     * Повертає кількість гілок на дереві.
     * 
     * @return кількість гілок.
     */
    public int getBranches() {
        return branches;
    }

    /**
     * Додає нові гілки до дерева.
     * 
     * @param newBranches кількість нових гілок, які додаються до дерева.
     */
    public void addBranches(int newBranches) {
        this.branches += newBranches;
        logActivity("Added " + newBranches + " branches. Total branches: " + this.branches);
    }

    /**
     * Повертає кількість фруктів на дереві.
     * 
     * @return кількість фруктів.
     */
    public int getFruitCount() {
        return fruitCount;
    }

    /**
     * Перевіряє поточний стан дерева, включаючи кількість гілок, фруктів та колір листя.
     */
    
    public void checkFeeling() {
        super.checkFeeling();
        logActivity("Tree " + getName() + " has " + this.branches + " branches, " 
                    + this.fruitCount + " fruits, leaf color: " + this.leafColor + ".");
    }

    /**
     * Встановлює поточний сезон для дерева.
     * 
     * @param season новий сезон (spring, summer, fall, winter).
     */
    public void setSeason(String season) {
        this.season = season;
        updateTreeAppearance();
        logActivity("Season changed to " + season + ". Tree appearance updated.");
    }

    /**
     * Оновлює зовнішній вигляд дерева (колір листя та наявність фруктів) залежно від сезону.
     */
    private void updateTreeAppearance() {
        switch (season) {
            case "spring":
                leafColor = "green";
                hasFruits = false;
                break;
            case "summer":
                leafColor = "green";
                hasFruits = true;
                break;
            case "fall":
                leafColor = "yellow";
                hasFruits = true;
                break;
            case "winter":
                leafColor = "none";
                hasFruits = false;
                break;
            default:
                leafColor = "unknown";
                hasFruits = false;
                break;
        }
    }

    /**
     * Записує дані дерева до файлу  та виводить повідомлення у консоль.
     * 
     * @param message повідомлення.
     */
    
    public void logActivity(String message) {
        StringBuilder sb = new StringBuilder();
        sb.append(message).append("\n");

        try (FileWriter fw = new FileWriter("plant_activity.txt", true)) {
            fw.write(sb.toString());
            System.out.println(message);
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}
