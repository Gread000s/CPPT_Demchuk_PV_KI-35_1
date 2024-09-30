
package lab1;

import java.io.*;
import java.util.*;

/**
 * Клас lab1 демонструє роботу з зубчастим масивом, його записом та виведеннм на екран.
 * @author Pavlo Demchuk
 */
public class lab1 {

    /**
     * Меттод котрий зчитує розмір матриці і символ заповнювач з консолі, після чого
     * заповнює зубчастий масив і виводить його на екран, з записом в файл.
     * @throws FileNotFoundException якщо файл не може бути створений або відкритий
     */
    public static void main(String[] args) throws FileNotFoundException {
        // Ініціалізація змінних
        int nRows;
        char[][] arr; // оголошення зубчастого масиву
        String filler; // символ-заповнювач
        Scanner in = new Scanner(System.in); // об'єкт для зчитування введених даних з консолі

        // Створення текстового файлу для запису даних
        File dataFile = new File("MyFile.txt");
        PrintWriter fout = new PrintWriter(dataFile); // об'єкт для запису у файл

        // Зчитування розміру матриці
        System.out.print("Введіть розмір квадратної матриці: ");
        nRows = in.nextInt();
        in.nextLine();

        // Ініціалізація зубчастого масиву
        arr = new char[nRows][];
        for (int i = 0; i < nRows; i++) {
            arr[i] = new char[nRows - i]; // кожен рядок стає менший на один символ
        }

        // Зчитування символа-заповнювача
        System.out.print("\nВведіть символ-заповнювач: ");
        filler = in.nextLine();

        // Заповнення масиву і виведення результату
        outer: for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nRows - i; j++) {
                if (filler.length() == 1) {
                    arr[i][j] = filler.charAt(0);
                    System.out.print(arr[i][j] + " "); // виведення символу в консоль
                    fout.print(arr[i][j] + " "); // запис символу у файл
                } else if (filler.isEmpty()) {
                    System.out.print("\nНе введено символ заповнювач");
                    break outer;
                } else {
                    System.out.print("\nЗабагато символів заповнювачів");
                    break outer;
                }
            }
            System.out.println();
            fout.println();
        }

        // Закриття потоку для запису у файл
        fout.flush();
        fout.close();
    }
}
