package tree;

import java.util.HashMap;

import arff.Data;

public class GoalNode extends Node {
	private String goal;

	public GoalNode(String goal) {
		super();
		this.goal = goal;
	}

	@Override
	public String toString() {
		return ": " + goal;
	}

	@Override
	public String Prune(Data data, HashMap<String, String> decisions) {
		return "";
	}
}
