package test;

import java.io.File;
import java.io.FileNotFoundException;

import tree.Tree;
import algorithm.ID3;
import arff.Data;
import arff.Reader;

public class TestID3 {

	public static void main(String[] args) {
		try {
			Data d = Reader.getDataFromFile(new File("files/restaurant2.arff"));
			Tree tree = ID3.decisionTreeLearning(d.getExamples(),
					d.getAttributes(), d.getGoalAttribute(),
					d.getattributeValues(), null);
			System.out.println(tree);
			System.out.println();
			d.printGoals();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
