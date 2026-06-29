package service;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Job;

public interface JobService {
	//create
	void createJob(Job job);
	
	boolean checkTitle(String title);//檢查職缺是否重複
	
	//read
	DefaultTableModel findAllJobTable(); //Jtable
	
	List<Job> selectByDepartmentId(int departmentId);
	
	//update
	void update(Job job);
	
	
	//delete
	void delete( int id);
}
