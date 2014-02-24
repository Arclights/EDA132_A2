package test;

import java.io.File;
import java.io.FileNotFoundException;

import arff.Data;
import arff.Reader;

public class TestReader {
	public static void main(String[] args) throws FileNotFoundException {
		Data d = Reader.getDataFromFile(new File("files/restaurant.arff"));
		System.out.println(d);
	}
}
