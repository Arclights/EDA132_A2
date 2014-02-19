package arff;

import java.util.ArrayList;
import java.util.HashMap;

public class Data {

	private String relation;
	private ArrayList<String> attribute;
	private HashMap<String, String[]> attributeValues;
	private ArrayList<HashMap<String, String>> rows;

	Data() {
		attribute = new ArrayList<String>();
		attributeValues = new HashMap<String, String[]>();
		rows = new ArrayList<HashMap<String, String>>();
	}

	void setRelation(String relation) {
		this.relation = relation;
	}

	void addAttribute(String a, String[] values) {
		attribute.add(a);
		attributeValues.put(a, values);
	}

	public int getSize() {
		return rows.size();
	}

	public ArrayList<String> getAttributes() {
		return attribute;
	}

	public ArrayList<HashMap<String, String>> getExamples() {
		return rows;
	}

	public HashMap<String, String[]> getattributeValues() {
		return attributeValues;
	}

	public void addData(ArrayList<String> cells) {
		if (cells.size() != attribute.size())
			throw new IllegalArgumentException("Wrong size on row, was "
					+ cells.size() + " expected " + attribute.size());
		String[] row = cells.toArray(new String[0]);
		HashMap<String, String> newRow = new HashMap<String, String>();
		for (int i = 0; i < row.length; i++) {
			newRow.put(attribute.get(i), row[i]);
		}
		rows.add(newRow);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String nl = System.getProperty("line.separator");
		sb.append(relation).append(nl);

		sb.append("Number of attributes: ").append(attribute.size()).append(nl);
		sb.append("-----------").append(nl);
		for (String a : attribute)
			sb.append(a).append(nl);
		sb.append("-----------").append(nl);
		for (HashMap<String, String> row : rows) {
			sb.append(row).append(nl);
		}

		return sb.toString();
	}

}
