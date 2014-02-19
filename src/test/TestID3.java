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
			Data d = Reader.getDataFromFile(new File("files/restaurant.arff"));
			Tree tree = ID3.decisionTreeLearning(d.getData(),
					d.getAttributes(), null);
			System.out.println(tree);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
