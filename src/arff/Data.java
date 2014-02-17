package arff;

import java.util.ArrayList;

public class Data {

	private String relation;
	private ArrayList<String> attribute;
	private ArrayList<String[]> rows;

	Data() {
		attribute = new ArrayList<String>();
		rows = new ArrayList<String[]>();
	}

	void setRelation(String relation) {
		this.relation = relation;
	}

	void addAttribute(String a) {
		attribute.add(a);
	}

	public int getSize() {
		return rows.size();
	}

	public ArrayList<String> getAttributes() {
		return attribute;
	}

	public ArrayList<String[]> getData() {
		return rows;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String nl = System.getProperty("line.separator");
		sb.append(relation).append(nl);

		sb.append("Number of attributes: ").append(attribute.size()).append(nl);

		return sb.toString();
	}

}
