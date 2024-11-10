package KI305.Demchuk.Lab4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Клас <code>CalculatorApp</code> демонструє використання класу Calculator та запис результатів у файл.
 * @author Demchuk
 * @version 1.0
 */
public class CalculatorApp {

    /**
     * Основний метод програми.
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        try {
            System.out.print("Введіть значення x: ");
            double x = scanner.nextDouble();

            // Обчислення результату
            double result = calculator.calc(x);
            System.out.println("Результат: " + result);

            // Запис результату у файл
            try (FileWriter writer = new FileWriter("calc_res.txt")) {
                writer.write("Результат для x = " + x + ": " + result);
            }
        } catch (CalculatorException e) {
            System.err.println("Помилка: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Помилка запису у файл: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
