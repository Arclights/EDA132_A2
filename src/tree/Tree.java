package tree;

import java.util.HashMap;

import arff.Data;

public class Tree {
	private Node root;

	public Tree(Node root) {
		this.root = root;
	}

	public void appendSubtree(String value, Tree subTree) {
		root.addChild(value, subTree.root);
		subTree.root.setDepth(1);
	}

	public Node getRoot() {
		return root;
	}

	@Override
	public String toString() {
		return root.toString();
	}

	public void Prune(Data data) {
		root.Prune(data, new HashMap<String, String>());
	}
}
