package algorithm;

import java.util.ArrayList;
import java.util.HashMap;

public class Importance2 {
	public static double informationGainRatio(String attribute,
			ArrayList<HashMap<String, String>> examples,
			HashMap<String, String[]> attributeValues, String goalAttribute) {
		double iv = intrinsicValue(attribute, examples, attributeValues);
		if (iv == 0) {
			return 1;
		}
		return informationGain(attribute, examples, attributeValues,
				goalAttribute)
				/ intrinsicValue(attribute, examples, attributeValues);
	}

	public static double informationGain(String attribute,
			ArrayList<HashMap<String, String>> examples,
			HashMap<String, String[]> attributeValues, String goalAttribute) {
		return H(examples, attributeValues, goalAttribute)
				- remainder(attribute, examples, attributeValues, goalAttribute);
	}

	private static double intrinsicValue(String attribute,
			ArrayList<HashMap<String, String>> examples,
			HashMap<String, String[]> attributeValues) {
		double out = 0;
		for (String attrValue : attributeValues.get(attribute)) {
			ArrayList<HashMap<String, String>> examplesWValue = new ArrayList<HashMap<String, String>>();
			for (HashMap<String, String> example : examples) {
				if (example.get(attribute).equals(attrValue)) {
					examplesWValue.add(example);
				}
			}
			out += B((double) examplesWValue.size() / examples.size());
		}
		return out;
	}

	private static double remainder(String attribute,
			ArrayList<HashMap<String, String>> examples,
			HashMap<String, String[]> attributeValues, String goalAttribute) {
		double out = 0;
		for (String attrValue : attributeValues.get(attribute)) {
			ArrayList<HashMap<String, String>> examplesWValue = new ArrayList<HashMap<String, String>>();
			for (HashMap<String, String> example : examples) {
				if (example.get(attribute).equals(attrValue)) {
					examplesWValue.add(example);
				}
			}
			if (!examplesWValue.isEmpty()) {
				out += (double) examplesWValue.size() / examples.size()
						* H(examplesWValue, attributeValues, goalAttribute);
			}
		}
		return out;
	}

	private static double H(ArrayList<HashMap<String, String>> examples,
			HashMap<String, String[]> attributeValues, String goalAttribute) {
		double out = 0;
		for (String goalValue : attributeValues.get(goalAttribute)) {
			int valueCounter = 0;
			for (HashMap<String, String> example : examples) {
				if (example.get(goalAttribute).equals(goalValue)) {
					valueCounter++;
				}
			}
			out += B((double) valueCounter / examples.size());
		}
		return out;
	}

	public static double B(double q) {
		return -(q * Importance.log2(q));
	}
}
