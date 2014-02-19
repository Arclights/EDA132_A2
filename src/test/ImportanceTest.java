package test;

import java.util.ArrayList;
import java.util.HashMap;

import algorithm.Importance;

public class ImportanceTest {

	public ImportanceTest() {
		ArrayList<HashMap<String, String>> examples = MockData.getExamples();
		System.out.println("B(0.99) = "+Importance.B(0.99));
		System.out.println("Gain(Patrons) = "
				+ Importance.importance("Pat", examples));
		System.out.println("Gain(Type) = "
				+ Importance.importance("Type", examples));
	}

	public static void main(String[] args) {
		new ImportanceTest();
	}

}
