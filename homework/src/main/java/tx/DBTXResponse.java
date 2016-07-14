package tx;

import java.util.List;

public class DBTXResponse<T> {
	String name;
	List<T> elements;
	
	public DBTXResponse(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<T> getElements() {
		return elements;
	}
	public void setElements(List<T> students) {
		this.elements = students;
	}
	
}
