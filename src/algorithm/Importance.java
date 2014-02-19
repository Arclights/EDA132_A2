package algorithm;

import java.util.ArrayList;
import java.util.HashMap;

public class Importance {
	public static double importance(String attribute,
			ArrayList<HashMap<String, String>> examples,
			HashMap<String, String[]> attributeValues) {
		int[] pn = getPositivesAndNegatives(null, null, examples);
		return B((double) pn[0] / (pn[0] + pn[1]))
				- remainder(attribute, examples, attributeValues, pn);
	}

	private static double remainder(String attribute,
			ArrayList<HashMap<String, String>> examples,
			HashMap<String, String[]> attributeValues, int[] pn) {
		double out = 0;
		for (String distinctValue : attributeValues.get(attribute)) {
			int[] pnk = getPositivesAndNegatives(distinctValue, attribute,
					examples);
			if (pnk[0] + pnk[1] > 0) {
				System.out.println("B: "+B((double) pnk[0] / (pnk[0] + pnk[1])));
				out += (double) (pnk[0] + pnk[1]) / (pn[0] + pn[1])
						* B((double) pnk[0] / (pnk[0] + pnk[1]));
			}
		}
		return out;
	}

	public static double B(double q) {
		return -(q * log2(q) + (1 - q) * log2(1 - q));
	}

	private static double log2(double x) {
		if (x == 0) { // To avoid inifinity
			return 0;
		}
		return Math.log(x) / Math.log(2);
	}

	// private static Set<String> getDistinctValues(String attribute,
	// ArrayList<HashMap<String, String>> examples) {
	// ArrayList<String> out = new ArrayList<String>();
	// for (HashMap<String, String> example : examples) {
	// out.add(example.get(attribute));
	// }
	// return new HashSet<String>(out);
	// }

	private static int[] getPositivesAndNegatives(String distinctValue,
			String attribute, ArrayList<HashMap<String, String>> examples) {
		int[] pn = new int[2];
		for (HashMap<String, String> example : examples) {
			if (attribute == null
					|| example.get(attribute).equals(distinctValue)) {
				if (example.get("Goal").equals("Yes")) {
					pn[0]++;
				} else {
					pn[1]++;
				}
			}
		}
		return pn;
	}
}
