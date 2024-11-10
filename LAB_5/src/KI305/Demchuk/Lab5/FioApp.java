package KI305.Demchuk.Lab5;
/**
* Lab5
*/
import java.io.*;
import java.util.*;
/**
* Class FioApp designed to validate and test the Fio class
*/
public class FioApp {
	/**
	* @param args
	* @throws FileNotFoundException
	* @throws IOException
	*/
	public static void main(String[] args) throws FileNotFoundException, IOException{
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Fio eq = new Fio();
		try {
			
			System.out.println("Enter x: ");
			
			PrintWriter fw_1 = new PrintWriter("TextRes.txt");
			File fr_1 = new File("TextRes.txt");
			
			DataOutputStream fw_2 = new DataOutputStream(new FileOutputStream("BinRes.bin"));
			DataInputStream fr_2 = new DataInputStream(new FileInputStream("BinRes.bin"));
			
			double x = scanner.nextDouble();
			double res = eq.calc(x);
			
			System.out.println("Result: " + res);
			
			eq.WriteTxt(fw_1, res);
			eq.WriteBin(fw_2, res);
			
			eq.ReadTxt(fr_1, scanner,res);
			System.out.println("Result text: " + res);
			eq.ReadBin(fr_2, res);
			System.out.println("Result bin: " + res);
		
		} catch(FileNotFoundException ex){
		System.err.println(ex.getMessage());
		} catch(IOException e) {
		System.err.println(e.getMessage());
		} catch (IllegalArgumentException e){
		System.err.println("Error: " + e.getMessage());
		}
	}
}
