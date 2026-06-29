package model;

public class Department {
	private int id;
	private String name;
	
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	
	public Department(String name) {
		super();
		this.name = name;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString()
	{
		return name;
	}

}
