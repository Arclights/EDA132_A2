package tree;

public class GoalNode extends Node {
	private boolean goal;

	public GoalNode(boolean goal) {
		super();
		this.goal = goal;
	}

	@Override
	public String toString() {
		String tabs = new String(new char[depth]).replace("\0", "\t");
		return super.toString() + tabs + "Goal: " + (goal ? "Yes" : "No")+"\n";
	}
}
