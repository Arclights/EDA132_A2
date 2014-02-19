package test;

import java.util.ArrayList;
import java.util.HashMap;

public class MockData {

	public static ArrayList<HashMap<String, String>> getExamples() {
		ArrayList<HashMap<String, String>> examples = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> x1 = new HashMap<String, String>();
		x1.put("Alt", "Yes");
		x1.put("Bar", "No");
		x1.put("Fri", "No");
		x1.put("Hun", "Yes");
		x1.put("Pat", "Some");
		x1.put("Price", "$$$");
		x1.put("Rain", "No");
		x1.put("Res", "Yes");
		x1.put("Type", "French");
		x1.put("Est", "0-10");
		x1.put("Goal", "Yes");
		examples.add(x1);
		HashMap<String, String> x2 = new HashMap<String, String>();
		x2.put("Alt", "Yes");
		x2.put("Bar", "No");
		x2.put("Fri", "No");
		x2.put("Hun", "Yes");
		x2.put("Pat", "Full");
		x2.put("Price", "$");
		x2.put("Rain", "No");
		x2.put("Res", "No");
		x2.put("Type", "Thai");
		x2.put("Est", "30-60");
		x2.put("Goal", "No");
		examples.add(x2);
		HashMap<String, String> x3 = new HashMap<String, String>();
		x3.put("Alt", "No");
		x3.put("Bar", "Yes");
		x3.put("Fri", "No");
		x3.put("Hun", "No");
		x3.put("Pat", "Some");
		x3.put("Price", "$");
		x3.put("Rain", "No");
		x3.put("Res", "No");
		x3.put("Type", "Burger");
		x3.put("Est", "0-10");
		x3.put("Goal", "Yes");
		examples.add(x3);
		HashMap<String, String> x4 = new HashMap<String, String>();
		x4.put("Alt", "Yes");
		x4.put("Bar", "No");
		x4.put("Fri", "Yes");
		x4.put("Hun", "Yes");
		x4.put("Pat", "Full");
		x4.put("Price", "$");
		x4.put("Rain", "Yes");
		x4.put("Res", "No");
		x4.put("Type", "Thai");
		x4.put("Est", "10-30");
		x4.put("Goal", "Yes");
		examples.add(x4);
		HashMap<String, String> x5 = new HashMap<String, String>();
		x5.put("Alt", "Yes");
		x5.put("Bar", "No");
		x5.put("Fri", "Yes");
		x5.put("Hun", "No");
		x5.put("Pat", "Full");
		x5.put("Price", "$$$");
		x5.put("Rain", "No");
		x5.put("Res", "Yes");
		x5.put("Type", "French");
		x5.put("Est", ">60");
		x5.put("Goal", "No");
		examples.add(x5);
		HashMap<String, String> x6 = new HashMap<String, String>();
		x6.put("Alt", "No");
		x6.put("Bar", "Yes");
		x6.put("Fri", "No");
		x6.put("Hun", "Yes");
		x6.put("Pat", "Some");
		x6.put("Price", "$$");
		x6.put("Rain", "Yes");
		x6.put("Res", "Yes");
		x6.put("Type", "Italian");
		x6.put("Est", "0-10");
		x6.put("Goal", "Yes");
		examples.add(x6);
		HashMap<String, String> x7 = new HashMap<String, String>();
		x7.put("Alt", "No");
		x7.put("Bar", "Yes");
		x7.put("Fri", "No");
		x7.put("Hun", "No");
		x7.put("Pat", "None");
		x7.put("Price", "$");
		x7.put("Rain", "Yes");
		x7.put("Res", "No");
		x7.put("Type", "Burger");
		x7.put("Est", "0-10");
		x7.put("Goal", "No");
		examples.add(x7);
		HashMap<String, String> x8 = new HashMap<String, String>();
		x8.put("Alt", "No");
		x8.put("Bar", "No");
		x8.put("Fri", "No");
		x8.put("Hun", "Yes");
		x8.put("Pat", "Some");
		x8.put("Price", "$$");
		x8.put("Rain", "Yes");
		x8.put("Res", "Yes");
		x8.put("Type", "Thai");
		x8.put("Est", "0-10");
		x8.put("Goal", "Yes");
		examples.add(x8);
		HashMap<String, String> x9 = new HashMap<String, String>();
		x9.put("Alt", "No");
		x9.put("Bar", "Yes");
		x9.put("Fri", "Yes");
		x9.put("Hun", "No");
		x9.put("Pat", "Full");
		x9.put("Price", "$");
		x9.put("Rain", "Yes");
		x9.put("Res", "No");
		x9.put("Type", "Burger");
		x9.put("Est", ">60");
		x9.put("Goal", "No");
		examples.add(x9);
		HashMap<String, String> x10 = new HashMap<String, String>();
		x10.put("Alt", "Yes");
		x10.put("Bar", "Yes");
		x10.put("Fri", "Yes");
		x10.put("Hun", "Yes");
		x10.put("Pat", "Full");
		x10.put("Price", "$$$");
		x10.put("Rain", "No");
		x10.put("Res", "Yes");
		x10.put("Type", "Italian");
		x10.put("Est", "10-30");
		x10.put("Goal", "No");
		examples.add(x10);
		HashMap<String, String> x11 = new HashMap<String, String>();
		x11.put("Alt", "No");
		x11.put("Bar", "No");
		x11.put("Fri", "No");
		x11.put("Hun", "No");
		x11.put("Pat", "None");
		x11.put("Price", "$");
		x11.put("Rain", "No");
		x11.put("Res", "No");
		x11.put("Type", "Thai");
		x11.put("Est", "0-10");
		x11.put("Goal", "No");
		examples.add(x11);
		HashMap<String, String> x12 = new HashMap<String, String>();
		x12.put("Alt", "Yes");
		x12.put("Bar", "Yes");
		x12.put("Fri", "Yes");
		x12.put("Hun", "Yes");
		x12.put("Pat", "Full");
		x12.put("Price", "$");
		x12.put("Rain", "No");
		x12.put("Res", "No");
		x12.put("Type", "Burger");
		x12.put("Est", "30-60");
		x12.put("Goal", "Yes");
		examples.add(x12);
		// examples.add(new String[] { "Yes", "No", "No", "Yes", "Some", "$$$",
		// "No", "Yes", "French", "0-10", "Yes" });
		// examples.add(new String[] { "Yes", "No", "No", "Yes", "Full", "$",
		// "No", "Yes", "Thai", "30-60", "No" });
		// examples.add(new String[] { "No", "Yes", "No", "No", "Some", "$",
		// "No",
		// "No", "Burger", "0-10", "Yes" });
		// examples.add(new String[] { "Yes", "No", "Yes", "Yes", "Full", "$",
		// "Yes", "No", "Thai", "10-30", "Yes" });
		// examples.add(new String[] { "Yes", "No", "Yes", "No", "Full", "$$$",
		// "No", "Yes", "French", ">60", "No" });
		// examples.add(new String[] { "No", "Yes", "No", "Yes", "Some", "$$",
		// "Yes", "Yes", "Italian", "0-10", "Yes" });
		// examples.add(new String[] { "No", "Yes", "No", "No", "None", "$",
		// "Yes", "No", "Burger", "0-10", "No" });
		// examples.add(new String[] { "No", "No", "No", "Yes", "Some", "$$",
		// "Yes", "Yes", "Thai", "0-10", "Yes" });
//		examples.add(new String[] { "No", "Yes", "Yes", "No", "Full", "$",
//				"Yes", "No", "Burger", ">60", "No" });
//		examples.add(new String[] { "Yes", "Yes", "Yes", "Yes", "Full", "$$$",
//				"No", "Yes", "Italian", "10-30", "No" });
//		examples.add(new String[] { "No", "No", "No", "No", "None", "$", "No",
//				"No", "Thai", "0-10", "No" });
		// examples.add(new String[] { "Yes", "Yes", "Yes", "Yes", "Full", "$",
		// "No", "No", "Burger", "30-60", "Yes" });
		return examples;
	}
	
	
	public static ArrayList<HashMap<String, String>> getExamplesPatFull() {
		ArrayList<HashMap<String, String>> examples = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> x2 = new HashMap<String, String>();
		x2.put("Alt", "Yes");
		x2.put("Bar", "No");
		x2.put("Fri", "No");
		x2.put("Hun", "Yes");
		x2.put("Pat", "Full");
		x2.put("Price", "$");
		x2.put("Rain", "No");
		x2.put("Res", "No");
		x2.put("Type", "Thai");
		x2.put("Est", "30-60");
		x2.put("Goal", "No");
		examples.add(x2);
		HashMap<String, String> x4 = new HashMap<String, String>();
		x4.put("Alt", "Yes");
		x4.put("Bar", "No");
		x4.put("Fri", "Yes");
		x4.put("Hun", "Yes");
		x4.put("Pat", "Full");
		x4.put("Price", "$");
		x4.put("Rain", "Yes");
		x4.put("Res", "No");
		x4.put("Type", "Thai");
		x4.put("Est", "10-30");
		x4.put("Goal", "Yes");
		examples.add(x4);
		HashMap<String, String> x5 = new HashMap<String, String>();
		x5.put("Alt", "Yes");
		x5.put("Bar", "No");
		x5.put("Fri", "Yes");
		x5.put("Hun", "No");
		x5.put("Pat", "Full");
		x5.put("Price", "$$$");
		x5.put("Rain", "No");
		x5.put("Res", "Yes");
		x5.put("Type", "French");
		x5.put("Est", ">60");
		x5.put("Goal", "No");
		examples.add(x5);
		HashMap<String, String> x9 = new HashMap<String, String>();
		x9.put("Alt", "No");
		x9.put("Bar", "Yes");
		x9.put("Fri", "Yes");
		x9.put("Hun", "No");
		x9.put("Pat", "Full");
		x9.put("Price", "$");
		x9.put("Rain", "Yes");
		x9.put("Res", "No");
		x9.put("Type", "Burger");
		x9.put("Est", ">60");
		x9.put("Goal", "No");
		examples.add(x9);
		HashMap<String, String> x10 = new HashMap<String, String>();
		x10.put("Alt", "Yes");
		x10.put("Bar", "Yes");
		x10.put("Fri", "Yes");
		x10.put("Hun", "Yes");
		x10.put("Pat", "Full");
		x10.put("Price", "$$$");
		x10.put("Rain", "No");
		x10.put("Res", "Yes");
		x10.put("Type", "Italian");
		x10.put("Est", "10-30");
		x10.put("Goal", "No");
		examples.add(x10);
		HashMap<String, String> x12 = new HashMap<String, String>();
		x12.put("Alt", "Yes");
		x12.put("Bar", "Yes");
		x12.put("Fri", "Yes");
		x12.put("Hun", "Yes");
		x12.put("Pat", "Full");
		x12.put("Price", "$");
		x12.put("Rain", "No");
		x12.put("Res", "No");
		x12.put("Type", "Burger");
		x12.put("Est", "30-60");
		x12.put("Goal", "Yes");
		examples.add(x12);
		return examples;
	}

	public static ArrayList<String> getAttributes() {
		ArrayList<String> attr = new ArrayList<String>();
		attr.add("Alt");
		attr.add("Bar");
		attr.add("Fri");
		attr.add("Hun");
		attr.add("Pat");
		attr.add("Price");
		attr.add("Rain");
		attr.add("Res");
		attr.add("Type");
		attr.add("Est");
		attr.add("Goal");
		return attr;
	}
	
	public static ArrayList<String> getAttributesPatFull() {
		ArrayList<String> attr = new ArrayList<String>();
		attr.add("Alt");
		attr.add("Bar");
		attr.add("Fri");
		attr.add("Hun");
		attr.add("Price");
		attr.add("Rain");
		attr.add("Res");
		attr.add("Type");
		attr.add("Est");
		attr.add("Goal");
		return attr;
	}
}
