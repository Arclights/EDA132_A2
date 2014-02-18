package tree;

import java.util.HashMap;

public class Node {
	protected HashMap<String, Node> children;
	protected int depth;

	public Node() {
		children = new HashMap<String, Node>();
	}

	public void setDepth(int depth) {
		this.depth = depth;
		for (Node n : children.values()) {
			n.setDepth(depth + 1);
		}
	}

	public void appendSubtree(String label, Tree subtree) {
		children.put(label, subtree.getRoot());
	}

	public void addChild(String value, Node child) {
		children.put(value, child);
	}

}
