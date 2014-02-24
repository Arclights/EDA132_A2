package tree;

import java.util.HashMap;

import arff.Data;

public class AttributeNode extends Node {
	private String attribute;

	public AttributeNode(String attribute) {
		super();
		this.attribute = attribute;
	}

	@Override
	public String toString() {
		String tabs = new String(new char[depth]).replace("\0", "\t");
		String out = "";
		for (String label : children.keySet()) {
			out += "\n" + tabs + attribute + " = " + label
					+ children.get(label);
		}
		return out;
	}

	@Override
	public String Prune(Data data, HashMap<String, String> decisions) {
		boolean containsAttributeNode = false;
		for (String attributeValue : copySet(children.keySet())) {
			Node child = children.get(attributeValue);
			if (child instanceof AttributeNode) {
				HashMap<String, String> newDescisions = copyHashMap(decisions);
				newDescisions.put(attribute, attributeValue);
				String newNodeValue = child.Prune(data, newDescisions);
				if (newNodeValue!=null) {
					children.remove(attributeValue);
					children.put(attributeValue, new GoalNode(newNodeValue));
				} else {
					containsAttributeNode = true;
				}
			}
		}

		if (!containsAttributeNode) {
			return data.chi2(decisions);
		}
		return null;
	}

}
