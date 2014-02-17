package arff;

import java.util.ArrayList;

public class Data {

	private String relation;
	private ArrayList<String> attribute;
 	
	
	Data(){
		attribute = new ArrayList<String>();
	}
	
	void setRelation(String relation) {
		this.relation = relation;
		
	}
	
	void addAttribute(String a) {
		attribute.add(a);
	}
	
	@Override
	public String toString() {
		return relation;
	}
	
}
