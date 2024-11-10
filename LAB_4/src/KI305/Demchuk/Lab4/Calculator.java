package KI305.Demchuk.Lab4;
/**
* Class <code>CalculatorException</code> extends ArithmeticException
* @author Demchuk
* @version 1.0
*/
	class CalculatorException extends ArithmeticException
		{
		public CalculatorException(){}
		public CalculatorException(String cause)
		{
			super(cause);
		}
	}

	/**
	* Clas <code>Calculator</code> realizing my metod with variant tan(x)/3x
	* @author Demchuk
	* @version 1.0
	*/
	public class Calculator {
	/**
	* @param x in radian
	* @return result
	* @throws CalcException if we wound cause
	*/
		public double calc(double x) {
	        double rad = Math.toRadians(x);
	        
	        // Перевірка на можливий поділ на нуль
	        if (Math.abs(3 * x) < 1e-10) {
	            throw new CalculatorException("Недопустиме значення x: знаменник дорівнює нулю.");
	        }
	        return Math.tan(rad) / (3 * x);
	    }
	}