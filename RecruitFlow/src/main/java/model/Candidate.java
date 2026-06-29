package model;

public class Candidate {
	private int id;
	private String name;
	private String phone;
	private String email;
	private int jobId;
	private String departmentName;
	private String jobTitle;
	private String interviewReview;
	private String interviewResult;
	private String status;
	
	
	
	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Candidate(String name, String phone, String email, int jobId, String interviewReview, String interviewResult,
			String status) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.jobId = jobId;
		this.interviewReview = interviewReview;
		this.interviewResult = interviewResult;
		this.status = status;
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


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getJobId() {
		return jobId;
	}


	public void setJobId(int jobId) {
		this.jobId = jobId;
	}


	public String getJobTitle() {
		return jobTitle;
	}


	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	

	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public String getInterviewReview() {
		return interviewReview;
	}


	public void setInterviewReview(String interviewReview) {
		this.interviewReview = interviewReview;
	}


	public String getInterviewResult() {
		return interviewResult;
	}


	public void setInterviewResult(String interviewResult) {
		this.interviewResult = interviewResult;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
