package dao;

import java.util.List;


import model.Job;

public interface JobDao {
	
		//create
		void insert(Job job);
		
		
		//read
		List<Job> selectAll();
		Job  selectByTitle(String title);
		
		List<Job> selectByDepartmentId(int departmentId);
		
		
		
		//update
		void update(Job job);
		
		//delete
		void delete(int id);


}
