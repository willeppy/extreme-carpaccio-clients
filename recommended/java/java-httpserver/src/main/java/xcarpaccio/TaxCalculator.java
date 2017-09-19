package xcarpaccio;

import java.util.HashMap;
import java.util.Map;

public class TaxCalculator {
	public static Double calculateTaxes(Order order, Map rates) {
		System.out.println("ORDER PROCESSING");
		Double preTax = 0.0; // pre taxation
		Double postTax = 0.0; // post taxation
		Double total = 0.0; // post reduction

		for (int i = 0; i < order.prices.length; i++) {
			preTax += order.prices[i] * order.quantities[i];
		}

		postTax = preTax * rates.get(order.country);

		if (reduction.equals("STANDARD")) {
			switch (postTax) {
				case postTax >= 50000:
					total = postTax * 0.85;
					break;
				case postTax >= 10000:
					total = postTax * 0.9;
					break;
				case postTax >= 7000:
					total = postTax * 0.93;
					break;
				case postTax >= 5000:
					total = postTax * 0.95;
					break;
				default:
					total = postTax * 0.97;
					break;
			}
			return total;
		} else {
			return null;
		}
	}
}