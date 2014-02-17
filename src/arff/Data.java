package arff;

public class Data {

	private String relation;
	
	Data(){
		
	}
	
	void setRelation(String relation) {
		this.relation = relation;
		
	}
	
	@Override
	public String toString() {
		return relation;
	}
	
}
