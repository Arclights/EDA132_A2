package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import arff.Data;
import arff.Reader;

public class TestCreateRandomData {
	public static void main(String[] args) throws FileNotFoundException {
		
		Data d = Reader.getDataFromFile(new File("files/restaurant2.arff"));
		
		int size = d.getAttributes().size();
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			ArrayList<String> row = new ArrayList<String>();
			
			for (int j = 0; j < size; j++) {
				String[] options = d.getattributeValues().get(d.getAttributes().get(j));
				int index = r.nextInt(options.length);
				
				row.add("'" + options[index] + "'");
			}
			
			String output = row.toString();
			
			System.out.println(output.substring(1,output.length()-1));
		}
		
		
	}
}
