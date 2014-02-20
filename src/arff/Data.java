package arff;

import java.util.ArrayList;
import java.util.HashMap;

public class Data {

	private String relation;
	private ArrayList<String> attribute;
	private HashMap<String, String[]> attributeValues;
	private ArrayList<HashMap<String, String>> rows;
	private String goalAttribute;
	private HashMap<String, Integer> frequenzy;

	Data() {
		attribute = new ArrayList<String>();
		attributeValues = new HashMap<String, String[]>();
		rows = new ArrayList<HashMap<String, String>>();
		frequenzy = new HashMap<String, Integer>();
	}

	void setRelation(String relation) {
		this.relation = relation;
	}

	void addAttribute(String a, String[] values) {
		attribute.add(a);
		attributeValues.put(a, values);
	}

	void setGoalAttribute(String goalAttribute) {
		this.goalAttribute = goalAttribute;
	}

	public String getGoalAttribute() {
		return goalAttribute;
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

		String rowGoal = newRow.get(goalAttribute);
		Integer i = frequenzy.get(rowGoal);
		if (i == null) {
			i = 0;
		}
		i++;
		frequenzy.put(rowGoal, i);
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

	public HashMap<String, Integer> getPartialFrequenzies(
			HashMap<String, String> partialDecitions) {
		HashMap<String, Integer> result = new HashMap<String, Integer>();

		for (HashMap<String, String> row : rows) {
			if (includes(row, partialDecitions)) {
				String goal = row.get(goalAttribute);
				Integer i = result.get(goal);
				if (i == null) {
					i = 0;
				}
				i++;
				result.put(goal, i);
			}
		}

		return result;
	}

	private boolean includes(HashMap<String, String> row,
			HashMap<String, String> list) {
		for (String key : list.keySet()) {
			String correct = list.get(key);
			String rowData = row.get(key);

			if (!correct.equals(rowData))
				return false;
		}

		return true;
	}

	public void printGoals() {
		System.out.println(frequenzy);
	}

}
