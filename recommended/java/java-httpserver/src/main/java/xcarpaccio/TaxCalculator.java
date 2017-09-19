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

		if (order.country.equals("FR") && preTax < 500) {
			return preTax;
		}

		Double taxRate = (Double) rates.get(order.country);
		postTax = preTax * taxRate;

		if (order.reduction.equals("STANDARD")) {
			if (postTax >= 50000) {
				total = postTax * 0.85;
			} else if (postTax >= 10000) {
				total = postTax * 0.9;
			} else if (postTax >= 7000) {
				total = postTax * 0.93;
			} else if (postTax >= 5000) {
				total = postTax * 0.95;
			} else if (postTax >= 1000) {
				total = postTax * 0.97;
			} else {
				total = postTax;
			}

			return total;
		} else if (order.reduction.equals("HALF PRICE")) {
			return postTax * 0.5;
		}else {
			return null;
		}
	}
}