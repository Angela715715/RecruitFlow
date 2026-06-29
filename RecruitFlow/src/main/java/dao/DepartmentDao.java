package dao;

import java.util.List;

import model.Department;

public interface DepartmentDao {
	//create
	void insert(Department department);
	
	
	//read
	List<Department> selectAll();
	Department selectByName(String name);
	
	
	
	//update
	void update(Department department);
	
	//delete
	void delete(int id);

}
