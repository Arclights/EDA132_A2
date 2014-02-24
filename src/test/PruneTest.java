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
		for (Object o: System.getProperties().keySet()) {
			System.out.printf("%s:%s\n",o.toString(),System.getProperty((String)o));
		}
		
		try {
			File folder = new File("files");
			for (File file : folder.listFiles()) {
				if (file.getAbsolutePath().endsWith(".arff")) {
					System.out.println("-----------------");
					System.out.println("Testing " + file);
					try {

						Data d = Reader.getDataFromFile(file);
						Tree tree = ID3.decisionTreeLearning(d.getExamples(),
								d.getAttributes(), d.getGoalAttribute(),
								d.getattributeValues(), null);
						int before = tree.hashCode();
						String sBefore = tree.toString();
						Pruning.Prune(tree, d);
						int after = tree.hashCode();
						String sAfter = tree.toString();
						if (before != after) {
							System.out.println("...was pruned");
							System.out.println("Before:");
							System.out.println(sBefore);
							System.out.println("After:");
							System.out.println(sAfter);
						} else {
							System.out.println("...was not pruned");
							System.out.println("Before:");
							System.out.println(sBefore);
						}
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