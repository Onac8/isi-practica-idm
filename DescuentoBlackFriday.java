//package sut_code;
import java.util.Calendar;

public class DescuentoBlackFriday {

	public double PrecioFinal(double PrecioOriginal) {
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DATE);
		int month = calendar.get(Calendar.MONTH) + 1; //Note: +1 the month for current month

		//CASO ERROR
		if (PrecioOriginal <= 0) {
			throw new IllegalArgumentException ("DescuentoBlackFriday.PrecioFinal");
		}

		if (day == 23 && month == 11) {
			return PrecioOriginal * 0.7;
		}
		return PrecioOriginal;
	}

	public static void main(String args[]) {
		DescuentoBlackFriday test = new DescuentoBlackFriday();
		System.out.println(test.PrecioFinal(10));
		System.out.println(test.PrecioFinal(30));
		System.out.println(test.PrecioFinal(5.5));
		System.out.println(test.PrecioFinal(0));
		System.out.println(test.PrecioFinal(-2));
	}

}
