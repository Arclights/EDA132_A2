package arff;

import java.io.File;
import java.io.FileNotFoundException;

public class Tester {
	public static void main(String[] args) throws FileNotFoundException {
		Data d = Reader.getDataFromFile(new File("files/vote.arff"));
		System.out.println(d);
	}
}
