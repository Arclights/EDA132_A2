package arff;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {

	private static final String RELATION = "@RELATION";
	private static final String DATA = "@DATA";
	private static final String ATTRIBUTE = "@ATTRIBUTE";
	private static final String COMMENT_TOKEN = "%";

	public static Data getDataFromFile(File input) throws FileNotFoundException {
		Data data = new Data();
		Scanner s = new Scanner(input);

		String row = null;
		String relation = null;
		while (s.hasNext() && (relation = getRelation(row)) == null) {
			row = s.nextLine();
		}
		data.setRelation(relation);

		while (s.hasNext() && !isData(row)) {
			row = s.nextLine();
			setAtribute(row, data);
		}

		while (s.hasNext()) {
			row = s.nextLine();
			setData(row, data);
		}
		s.close();
		return data;
	}

	private static void setData(String row, Data data) {
		// String regex = "('(.*?)'|(?))";
		// Matcher m = getMatcher(regex, row);
		// ArrayList<String> cells = new ArrayList<String>();
		// while (m.find()) {
		// cells.add(m.group(1));
		// }
		if (!isComment(row)) {
//			System.out.println(row);
			String[] temp = row.replaceAll("[\' ]", "").split(",");
			ArrayList<String> cells = new ArrayList<String>();
			for (String s : temp)
				cells.add(s);
			data.addData(cells);
		}
	}

	private static void setAtribute(String row, Data d) {
		if (startWith(row, ATTRIBUTE)) {
			String data = pureData(row, ATTRIBUTE);

			Matcher m = null;
			if ((m = getMatcher("'([\\w0-9\\-_]+)'\\s+\\{.*\\}", row)).find()) {
				d.addAttribute(m.group(1));
				// System.out.println("Attribute: " +m.group());
			} else if ((m = getMatcher("([\\w0-9\\-_]+)\\s+\\{.*\\}", row))
					.find()) {
				d.addAttribute(m.group(1));
			} else {
				System.err.println("Could not undestand attribute!");
				System.err.println(data);
				throw new IllegalArgumentException();
			}
		}

	}

	private static Matcher getMatcher(String regex, String data) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(data);
		return m;
	}

	private static boolean startWith(String row, String prefix) {
		String rowUpper = row.toUpperCase();
		return rowUpper.startsWith(prefix);
	}

	private static boolean isData(String row) {
		return startWith(row, DATA);
	}

	private static boolean isComment(String row) {
		return row == null || row.startsWith(COMMENT_TOKEN);
	}

	private static String getRelation(String row) {
		if (isComment(row))
			return null;
		String rowUpper = row.toUpperCase();
		if (rowUpper.startsWith(RELATION)) {
			return pureData(row, RELATION);
		}
		return null;
	}

	private static String pureData(String row, String prefix) {
		int start = new String(prefix).length();
		return row.substring(start).trim();
	}
}
