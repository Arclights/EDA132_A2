package test;

import java.io.File;
import java.io.FileNotFoundException;

import tree.Tree;
import algorithm.ID3;
import algorithm.Pruning;
import arff.Data;
import arff.Reader;

public class PruneTest {

	public static void main(String[] args) {
		try {
			Data d = Reader.getDataFromFile(new File("files/restaurant2.arff"));
			Tree tree = ID3.decisionTreeLearning(d.getExamples(),
					d.getAttributes(), d.getGoalAttribute(),
					d.getattributeValues(), null);
			System.out.println("Pre-pruning:");
			System.out.println(tree);
			System.out.println("\n\n");
			Pruning.Prune(tree, d);
			System.out.println("Post-pruning:");
			System.out.println(tree);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
