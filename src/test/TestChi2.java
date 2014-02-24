package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

import tree.Tree;
import algorithm.ID3;
import arff.Data;
import arff.Reader;

public class TestChi2 {

	public static void main(String[] args) {
		try {

			Data d = Reader.getDataFromFile(new File("files/restaurant2.arff"));
			Tree tree = ID3.decisionTreeLearning(d.getExamples(),
					d.getAttributes(), d.getGoalAttribute(),
					d.getattributeValues(), null);
			System.out.println("Pre-pruning:");
			System.out.println(tree);

			HashMap<String,String> ways = new HashMap<String,String>();
			ways.put("Pat", "Full");
			ways.put("Hun", "Yes");
			ways.put("Type","Thai");
			d.chi2(ways);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
