package app.model;

public class TestData {

	private Integer id;
	private String technology;

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TestData(Integer id, String technology) {
		super();
		this.id = id;
		this.technology = technology;
	}
	
	
	
}
