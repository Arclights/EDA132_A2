package tree;

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
			out += "\n"+tabs+attribute+" = " + label  + children.get(label);
		}
		return out;
	}

}
