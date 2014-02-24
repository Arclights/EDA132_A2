package arff;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Data {

	private String relation;
	private ArrayList<String> attribute;
	private HashMap<String, String[]> attributeValues;
	private ArrayList<HashMap<String, String>> rows;
	private String goalAttribute;
	private HashMap<String, Integer> frequenzy;
	private static final String CHI2_FILE = "files/chi2.data";
	private HashMap<Integer,Double> chi2;
	
	Data() throws FileNotFoundException {
		attribute = new ArrayList<String>();
		attributeValues = new HashMap<String, String[]>();
		rows = new ArrayList<HashMap<String, String>>();
		frequenzy = new HashMap<String, Integer>();
		loadChi2();
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
		for (String key : frequenzy.keySet()) {
			result.put(key, 0);
		}
		for (HashMap<String, String> row : rows) {
			if (includes(row, partialDecitions)) {
				String goal = row.get(goalAttribute);
				Integer i = result.get(goal);
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

	public String chi2(HashMap<String,String> treeChoises) {
		HashMap<String,Integer> partialFrequenzies = getPartialFrequenzies(treeChoises);
		
		double numerator = 0;
		double denominator =0;
		for (String key : partialFrequenzies.keySet()){
			denominator += frequenzy.get(key);
			numerator += partialFrequenzies.get(key);
		}
		double q = numerator/denominator;
		
		HashMap<String, Double> freqHat = new HashMap<String,Double>();
		
		for (String key:partialFrequenzies.keySet()){
			double val = frequenzy.get(key) * q;
			freqHat.put(key, val);
		}
		
		double delta = 0;
		
		for (String key : partialFrequenzies.keySet()) {
			double a = Math.pow(partialFrequenzies.get(key)-freqHat.get(key), 2);
			double b = freqHat.get(key);
			
			delta += a/b;
		}
		
		if (delta > chi2.get(partialFrequenzies.size()-1)) {
			return null;
		}
		
		int max = -1;
		String maxKey = null;
		
		for (String key : partialFrequenzies.keySet() ) {
			int i = partialFrequenzies.get(key);
			if (i > max) {
				max = i;
				maxKey = key;
			}
		}
		return maxKey;
	}
	
	private void loadChi2() throws FileNotFoundException {
		chi2 = new HashMap<Integer,Double>();
		
		Scanner s = new Scanner(new File(CHI2_FILE));
		
		s.nextLine();
		
		while (s.hasNext()) {
			int df = s.nextInt();
			double p = s.nextDouble();
			s.nextLine();
			chi2.put(df,p);
		}
		s.close();
	}
	
	public void printGoals() {
		System.out.println(frequenzy);
	}

}
