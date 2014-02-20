package tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import arff.Data;

public abstract class Node {
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

	public abstract String Prune(Data data, HashMap<String, String> decisions);

	public HashMap<String, String> copyHashMap(HashMap<String, String> map) {
		HashMap<String, String> out = new HashMap<String, String>();
		for (String key : map.keySet()) {
			out.put(key, map.get(key));
		}
		return out;
	}

	public Set<String> copySet(Set<String> set) {
		Set<String> out = new HashSet<String>();
		for (String elem : set) {
			out.add(elem);
		}
		return out;
	}

}
