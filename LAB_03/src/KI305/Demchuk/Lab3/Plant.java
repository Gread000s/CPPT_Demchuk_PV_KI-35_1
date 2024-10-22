/*
 * Пакет лабораторної роботи №3 
 */
package KI305.Demchuk.Lab3;

import java.io.*;

public abstract class Plant {


    private String name;                            // Назва рослини
    private Species species;                        // Вид рослини
    private int age;                                // Вік рослини
    private int feeling;                            // "Відчуття" рослини, як вона почувається
    private String location;                        // Місцезнаходження рослини (на вулиці або в приміщенні)
    private double height;                          // Висота рослини
    private DirtType dirtType;                      // Тип ґрунту
    private SunlightExposure sunlightExposure;      // Кількість світла, яку отримує рослина
    private Caretaker caretaker;                    // Доглядач рослини


    private static boolean isFirstLog = true;       // Прапорець для перевірки, чи це перший запис у файл


    /**
     * Конструктор за замовчуванням, ініціалізує значення властивостей рослини.
     */
    public Plant() {
        this.species = new Species();
        this.dirtType = new DirtType();
        this.sunlightExposure = new SunlightExposure();
        this.caretaker = new Caretaker();
        this.feeling = 5;  // Початковий стан "відчуттів" рослини (від 0 до 10)
    }


    /**
     * Конструктор з параметрами.
     *
     * @param name Назва рослини
     * @param species Вид рослини
     * @param age Вік рослини
     * @param location Місцезнаходження рослини
     * @param height Висота рослини
     * @param dirtType Тип ґрунту
     * @param sunlightExposure Рівень освітлення
     * @param caretakerSex Стать доглядача
     * @param caretakerName Ім'я доглядача
     * @param feeling Початковий стан рослини
     */
    public Plant(String name, String species, int age, String location,
                 double height, String dirtType, String sunlightExposure,
                 String caretakerSex, String caretakerName, int feeling) {
        this();
        this.name = name;
        this.age = age;
        this.feeling = feeling;
        this.location = location;
        this.height = height;
        this.species.setSpecies(species);
        this.dirtType.setDirtType(dirtType);
        this.sunlightExposure.setExposure(sunlightExposure);
        this.caretaker.setSexCaretaker(caretakerSex);
        this.caretaker.setNameCaretaker(caretakerName);
        logActivity( "Tree name: " + name);
        logActivity( "Tree species: " + species);
        logActivity( "Tree age: " + age);
        logActivity( "Tree feeling: " + feeling);
        logActivity( "Tree location: " + location);
        logActivity( "Tree height: " + height);
        logActivity( "Dirt type: " + dirtType);
        logActivity( "Sunlight exposure: " + sunlightExposure);
        logActivity( "Caretaker: " + caretakerName + " (" + caretakerSex + ")\n");
    }

    /**
     * Отримує назву рослини.
     * 
     * @return Назва рослини.
     */
    public String getName() {
        return name;
    }

    /**
     * Отримує вік рослини.
     * 
     * @return Вік рослини.
     */
    public int getAge() {
        return age;
    }

    /**
     * Отримує висоту рослини.
     * 
     * @return Висота рослини в метрах.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Метод для поливу рослини. Покращує її стан.
     */
    public void water() {
        this.feeling += 1;
        if (this.feeling > 10) this.feeling = 10;  // Максимум щастя = 10
        logActivity(name + " is watered. Feeling improved to " + this.feeling);
    }


    /**
     * Метод для внесення добрив. Покращує стан рослини більше, ніж полив.
     */
    public void fertilize() {
        this.feeling += 2;
        if (this.feeling > 10) this.feeling = 10;  // Максимум щастя = 10
        logActivity(name + " is fertilized. Feeling improved to " + this.feeling);
    }


    /**
     * Метод для зростання рослини залежно від рівня освітлення.
     *
     * @param sunlight Тип освітлення (повне сонце, часткова тінь тощо)
     */
    public void grow(String sunlight) {
        if (sunlight.equals("full sun")) {
            this.height += 2;
            this.feeling += 1;
            if (this.feeling > 10) this.feeling = 10;
            logActivity(name + " grows well in full sun: height+2, feeling improved to " + this.feeling);
        } else if (sunlight.equals("partial shade")) {
            this.height += 1;
            this.feeling += 0.5;
            logActivity(name + " grows in partial shade: height+1, feeling improved slightly.");
        } else {
            this.height -= 1;
            this.feeling -= 1;
            if (this.feeling < 0) this.feeling = 0;  // Мінімум щастя = 0
            logActivity(name + " struggles in low light: height-1, feeling decreased to " + this.feeling);
        }
    }


    /**
     * Метод для перевірки стану рослини на основі її "відчуттів".
     */
    public void checkFeeling() {
        if (this.feeling >= 8) {
            logActivity(name + " is very happy and thriving.");
        } else if (this.feeling >= 5) {
            logActivity(name + " is doing fine, but could use some more care.");
        } else {
            logActivity(name + " is struggling and needs attention!");
        }
    }


    /**
     * Метод для отримання поточного стану рослини.
     */
    public void status() {
        logActivity("Status of " + name + ": Age: " + age + ", Location: " + location + 
                    ", Height: " + height + ", Feeling: " + feeling);
    }


    /**
     * Метод для зміни місцезнаходження рослини.
     *
     * @param newLocation Нове місцезнаходження рослини
     */
    public void relocate(String newLocation) {
        this.location = newLocation;
        logActivity(name + " has been relocated to " + newLocation);
    }


    /**
     * Метод для зміни доглядача рослини.
     *
     * @param newCaretaker Новий доглядач
     */
    public void setCaretaker(Caretaker newCaretaker) {
        this.caretaker = newCaretaker;
        logActivity(name + "'s caretaker has been changed to " + newCaretaker.getNameCaretaker());
    }


    /**
     * Метод для запису активності в лог.
     *
     * @param message Повідомлення для запису в файл
     */
    public void logActivity(String message) {
        try (FileWriter fw = new FileWriter("plant_activity.txt", !isFirstLog)) {
            fw.write(message + "\n");
            System.out.println(message);
            isFirstLog = false;  // Після першого виклику файл більше не буде перезаписуватись
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }


    /**
     * Метод для зміни типу ґрунту рослини.
     *
     * @param newSoilType Новий тип ґрунту
     */
    public void changeSoil(String newSoilType) {
        this.dirtType.setDirtType(newSoilType);
        logActivity(name + " soil type changed to " + newSoilType);
    }


    /**
     * Метод для перевірки рівня води рослини.
     */
    public void checkWaterLevel() {
        logActivity(name + " water level is optimal.");
    }


    // Внутрішні класи для представлення виду рослини, типу ґрунту, освітлення та доглядача


    /**
     * Внутрішній клас для представлення виду рослини.
     */
    public class Species {
        private String species;


        /**
         * Отримує вид рослини.
         * @return Вид рослини.
         */
        public String getSpecies() {
            return species;
        }


        /**
         * Встановлює вид рослини.
         * @param species Вид рослини.
         */
        public void setSpecies(String species) {
            this.species = species;
        }
    }


    /**
     * Внутрішній клас для представлення типу ґрунту рослини.
     */
    public class DirtType {
        private String dirtType;


        /**
         * Отримує тип ґрунту рослини.
         * @return Тип ґрунту.
         */
        public String getDirtType() {
            return dirtType;
        }


        /**
         * Встановлює тип ґрунту рослини.
         * @param dirtType Тип ґрунту.
         */
        public void setDirtType(String dirtType) {
            this.dirtType = dirtType;
        }
    }


    /**
     * Внутрішній клас для представлення рівня освітлення рослини.
     */
    public class SunlightExposure {
        private String exposure;


        /**
         * Отримує рівень освітлення рослини.
         * @return Рівень освітлення.
         */
        public String getExposure() {
            return exposure;
        }


        /**
         * Встановлює рівень освітлення рослини.
         * @param exposure Рівень освітлення.
         */
        public void setExposure(String exposure) {
            this.exposure = exposure;
        }
    }


    /**
     * Внутрішній клас для представлення доглядача рослини.
     */
    public class Caretaker {
        private String sexCaretaker;
        private String nameCaretaker;


        /**
         * Отримує стать доглядача.
         * @return Стать доглядача.
         */
        public String getSexCaretaker() {
            return sexCaretaker;
        }


        /**
         * Встановлює стать доглядача.
         * @param sexCaretaker Стать доглядача.
         */
        public void setSexCaretaker(String sexCaretaker) {
            this.sexCaretaker = sexCaretaker;
        }


        /**
         * Отримує ім'я доглядача.
         * @return Ім'я доглядача.
         */
        public String getNameCaretaker() {
            return nameCaretaker;
        }


        /**
         * Встановлює ім'я доглядача.
         * @param nameCaretaker Ім'я доглядача.
         */
        public void setNameCaretaker(String nameCaretaker) {
            this.nameCaretaker = nameCaretaker;
        }
    }
}
