package test;

import tree.Tree;
import algorithm.ID3;

public class TestID3 {

	public static void main(String[] args){
		Tree tree = ID3.decisionTreeLearning(MockData.getExamples(), MockData.getAttributes(), null);
		System.out.println(tree);
	}
}
