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
	public static Tree decisionTreeLearning(
			ArrayList<HashMap<String, String>> examples,
			ArrayList<String> attributes, String goalAttribute,
			HashMap<String, String[]> attributeValues,
			ArrayList<HashMap<String, String>> parentExamples) {
		// System.out.println("Attributes: " + attributes);
		// System.out.println("Examples: " + examples);
		if (examples.isEmpty()) {
			// System.out.println("examples.isEmpty()\n");
			return new Tree(new GoalNode(pluralityValue(parentExamples,
					goalAttribute)));
		} else if (hasSameClassifications(examples, goalAttribute)) {
			// System.out.println("hasSameClassifications(examples)\n");
			return new Tree(new GoalNode(examples.get(0).get(goalAttribute)));
		} else if (attributes.isEmpty()) {
			// System.out.println("attributes.isEmpty()\n");
			return new Tree(new GoalNode(
					pluralityValue(examples, goalAttribute)));
		}
		String A = "";
		double largestImportance = 0;
		for (int i = 0; i < attributes.size() - 1; i++) {
			String attr = attributes.get(i);
			double importance = Importance2.informationGain(attr, examples,
					attributeValues, goalAttribute);
			// System.out.println("A: " + attr + "\timportance: " + importance);
			if (importance > largestImportance) {
				largestImportance = importance;
				A = attr;
			}
		}
		// System.out.println(A);

		Tree tree = new Tree(new AttributeNode(A));

		for (String vk : attributeValues.get(A)) {
			ArrayList<HashMap<String, String>> exs = getExs(A, vk, examples);
			ArrayList<String> attributesMinusA = (ArrayList<String>) attributes
					.clone();
			attributesMinusA.remove(A);
			// System.out.println("A: " + A);
			// System.out.println("vk: " + vk);
			// System.out.println("exs:" + exs);
			// System.out.println("attributesMinusA: " + attributesMinusA);
			// System.out.println();
			Tree subtree = decisionTreeLearning(exs, attributesMinusA,
					goalAttribute, attributeValues, examples);
			tree.appendSubtree(vk, subtree);
		}

		return tree;
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

}
