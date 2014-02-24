package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import tree.AttributeNode;
import tree.GoalNode;
import tree.Tree;

public class ID3 {

	public static boolean verbose = false;

	public static Tree decisionTreeLearning(
			ArrayList<HashMap<String, String>> examples,
			ArrayList<String> attributes, String goalAttribute,
			HashMap<String, String[]> attributeValues,
			ArrayList<HashMap<String, String>> parentExamples) {
		print("Attributes: " + attributes);
		print("Examples: " + examples);
		if (examples.isEmpty()) {
			print("examples.isEmpty()\n");
			return new Tree(new GoalNode(pluralityValue(parentExamples,
					goalAttribute)));
		} else if (hasSameClassifications(examples, goalAttribute)) {
			print("hasSameClassifications(examples)\n");
			return new Tree(new GoalNode(examples.get(0).get(goalAttribute)));
		} else if (attributes.size() == 1) {
			print("attributes.isEmpty()\n");
			return new Tree(new GoalNode(
					pluralityValue(examples, goalAttribute)));
		}
		String A = "";
		double largestImportance = -1;
		for (int i = 0; i < attributes.size() - 1; i++) {
			String attr = attributes.get(i);
			double importance = Importance2.informationGain(attr, examples,
					attributeValues, goalAttribute);
			print("A: " + attr + "\timportance: " + importance);
			if (importance > largestImportance) {
				largestImportance = importance;
				A = attr;
			}
		}
		print(A);

		Tree tree = new Tree(new AttributeNode(A));

		for (String vk : attributeValues.get(A)) {
			ArrayList<HashMap<String, String>> exs = getExs(A, vk, examples);
			ArrayList<String> attributesMinusA = cloneArrayList(attributes);
			attributesMinusA.remove(A);
			print("A: " + A);
			print("vk: " + vk);
			print("exs:" + exs);
			print("attributesMinusA: " + attributesMinusA);
			print("");
			Tree subtree = decisionTreeLearning(exs, attributesMinusA,
					goalAttribute, attributeValues, examples);
			tree.appendSubtree(vk, subtree);
		}

		return tree;
	}

	private static ArrayList<String> cloneArrayList(ArrayList<String> list) {
		ArrayList<String> result = new ArrayList<String>();
		for (String s : list)
			result.add(s);
		return result;
	}

	private static ArrayList<HashMap<String, String>> getExs(String attribute,
			String vk, ArrayList<HashMap<String, String>> examples) {
		ArrayList<HashMap<String, String>> exs = new ArrayList<HashMap<String, String>>();
		for (HashMap<String, String> example : examples) {
			if (example.get(attribute).equals(vk)) {
				exs.add(example);
			}
		}
		return exs;
	}

	private static boolean hasSameClassifications(
			ArrayList<HashMap<String, String>> examples, String goalAttribute) {
		String g = "";
		HashMap<String, String> example = examples.get(0);
		g = example.get(goalAttribute);
		for (int i = 1; i < examples.size(); i++) {
			example = examples.get(i);
			if (!g.equals("") && !example.get(goalAttribute).equals(g)) {
				return false;
			}
		}
		return true;
	}

	private static String pluralityValue(
			ArrayList<HashMap<String, String>> examples, String goalAttribute) {
		Set<String> set = new HashSet<String>();
		for (HashMap<String, String> example : examples) {
			set.add(example.get(goalAttribute));
		}
		int largestFreq = 0;
		String value = "";
		for (String s : set) {
			int freq = Collections.frequency(set, s);
			if (freq > largestFreq) {
				largestFreq = freq;
				value = s;
			}
		}
		return value;
	}	
	public static void print(String s) {
		if (verbose)
			System.out.println(s);
	}
}
