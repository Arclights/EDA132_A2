package test;

import java.io.File;
import java.io.FileNotFoundException;

import algorithm.Importance;
import algorithm.Importance2;
import arff.Data;
import arff.Reader;

public class ImportanceTest {

	public ImportanceTest() {
		Data d;
		try {
			d = Reader.getDataFromFile(new File("files/restaurant.arff"));
			System.out.println("Importance function:");
			System.out.println("B(0.99) = " + Importance.B(0.99));
			System.out.println("Gain(Patrons) = "
					+ Importance.importance("Pat", d.getExamples(),
							d.getattributeValues()));
			System.out.println("Gain(Type) = "
					+ Importance.importance("Type", d.getExamples(),
							d.getattributeValues()));
			System.out.println("Information Gain Ratio:");
			System.out.println("Gain(Patrons) = "
					+ Importance2.informationGainRatio("Pat", d.getExamples(),
							d.getattributeValues(), d.getGoalAttribute()));
			System.out.println("Gain(Type) = "
					+ Importance2.informationGainRatio("Type", d.getExamples(),
							d.getattributeValues(), d.getGoalAttribute()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ImportanceTest();
	}

}
