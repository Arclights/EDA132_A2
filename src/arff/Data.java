package arff;

import java.util.ArrayList;
import java.util.Iterator;

public class Data implements Iterable<String[]> {

	private String relation;
	private ArrayList<String> attribute;
 	private ArrayList<String[]> rows;
	
	Data(){
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

	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String nl = System.getProperty("line.separator");
		sb.append(relation).append(nl);
		
		sb.append("Number of attributes: ").append(attribute.size()).append(nl);
		
		return sb.toString();
	}

	@Override
	public Iterator<String[]> iterator() {
		return new DataIterator();
	}
	
	private class DataIterator implements Iterator<String[]> {

		int i = 0;
		
		@Override
		public boolean hasNext() {
			return i<rows.size();
		}

		@Override
		public String[] next() {
			return rows.get(i++);
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	
}
