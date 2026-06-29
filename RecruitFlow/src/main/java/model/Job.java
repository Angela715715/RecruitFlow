package model;

public class Job {

	private int id;
	private int departmentId;
	private String title;
	private String description;
	private String status;
	private String departmentName;
	
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Job(int departmentId, String title, String description, String status) {
		super();
		this.departmentId = departmentId;
		this.title = title;
		this.description = description;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
	public String toString()
	{
		return title;
	}
	
		
	
	
	
}
