package tree;

import java.util.HashMap;

public class Node {
	private HashMap<String, Node> children;

	public Node() {
		children = new HashMap<String, Node>();
	}

	public void appendSubtree(String label, Tree subtree) {
		children.put(label, subtree.getRoot());
	}

	public void addChild(String value, Node child) {
		children.put(value, child);
	}

}
