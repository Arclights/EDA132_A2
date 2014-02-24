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
			File folder = new File("files");
			for (File file : folder.listFiles()) {
				if (file.getAbsolutePath().endsWith(".arff")) {
					System.out.println("Testing " + file);
					try {

						Data d = Reader.getDataFromFile(file);
						Tree tree = ID3.decisionTreeLearning(d.getExamples(),
								d.getAttributes(), d.getGoalAttribute(),
								d.getattributeValues(), null);
						int before = tree.hashCode();
						Pruning.Prune(tree, d);
						int after = tree.hashCode();
						if (before != after)
							System.out.println("...was pruned");
						else
							System.out.println("...was not prnued");
					} catch (IllegalArgumentException e) {
						System.out.println("...could not parse");
					}
				} else {
					System.out.println("ignored " + file);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}