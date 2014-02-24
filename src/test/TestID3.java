package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

import tree.Tree;
import algorithm.ID3;
import arff.Data;
import arff.Reader;

public class TestID3 {

	public static void main(String[] args) {
		try {
			Data d = Reader.getDataFromFile(new File("files/restaurant3.arff2"));
			ID3.verbose = true;
			Tree tree = ID3.decisionTreeLearning(d.getExamples(),
					d.getAttributes(), d.getGoalAttribute(),
					d.getattributeValues(), null);
			System.out.println(tree);
			System.out.println();
			d.printGoals();
			
			HashMap<String,String> test = new HashMap<String,String>();
			
			test.put("Pat", "Full");
			
			System.out.println(d.getPartialFrequenzies(test));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
