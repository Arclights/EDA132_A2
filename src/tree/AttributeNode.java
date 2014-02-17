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
		return tabs + "Arttribute: "+attribute+"\n" + super.toString() + "\n";
	}

}
