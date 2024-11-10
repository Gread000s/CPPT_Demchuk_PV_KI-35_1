package KI305.Demchuk.Lab5;
import java.io.*;
import java.util.*;

/**
* Fio клас реалізує моє рівняння  tan(x)/3x.
* Також записує та зчитує у файли формату тексту та бінарні.
*/
public class Fio {
	/**
     * Метод обчислення виразу tg(x) / 3x.
     * @param x Значення аргументу x в градусах.
     * @return результат обчислення.
     * @throws IllegalArgumentException якщо знаменник дорівнює нулю.
     */
	    public double calc(double x) {
	        double rad = Math.toRadians(x);
	        
	        // Перевірка на можливий поділ на нуль
	        if (Math.abs(3 * x) < 1e-10) {
	            throw new IllegalArgumentException("Недопустиме значення x: знаменник дорівнює нулю.");
	        }
	        
	        return Math.tan(rad) / (3 * x);
	    }
	
	
	    /**
	     * Метод для запису даних у текстовий файл з високою точністю.
	     * @param writer Потік для запису у текстовий файл.
	     * @param x Значення, яке потрібно записати.
	     */
	
	public void WriteTxt(PrintWriter writer, double x) throws FileNotFoundException{
		writer.printf("%.10f\n ",x);
		writer.close();
	}
	
	/**
     * Метод для зчитування даних з текстового файлу.
     * @param file Файл для зчитування.
     * @param x Значення, яке потрібно записати.
     * @return Значення, зчитане з файлу.
     * @throws IOException якщо файл не знайдено або сталася інша помилка.
     */
	
	public void ReadTxt(File file, Scanner scaner, double x){
		try
		{
			if (file.exists()){
			scaner = new Scanner(file);
			x = scaner.nextDouble();
			scaner.close();
			}
			else
			throw new FileNotFoundException("File " + file.getName() + "not found");
		}
		catch (FileNotFoundException eror){
		System.out.print(eror.getMessage());
		}
	}
	
	/**
     * Метод для запису даних у бінарний файл.
     * @param output Потік для запису у бінарний файл.
     * @param x Значення, яке потрібно записати.
     */
	public void WriteBin(DataOutputStream f, double x) throws FileNotFoundException, IOException
	{
	f.writeDouble(x);
	f.close();
	}
	
	/**
     * Метод для зчитування даних з бінарного файлу.
     * @param input Потік для зчитування з бінарного файлу.
     * @return Значення, зчитане з файлу.
     */
    public void ReadBin(DataInputStream f, double x) throws FileNotFoundException, IOException
    {
    x = f.readDouble();
    f.close();
    }
}
