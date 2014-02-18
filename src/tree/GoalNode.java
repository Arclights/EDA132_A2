package tree;

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
}
