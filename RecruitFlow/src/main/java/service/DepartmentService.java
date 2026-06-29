package service;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Department;

public interface DepartmentService {
	
		//新增部門
		void createDepartment(Department department);
		
		//檢查部門重複
		boolean checkName(String name);
		
		//用table顯示部門列表
		DefaultTableModel findAllDepartmentTable();
		
		List<Department> selectAll();
		
		//UPDATE
		void update(Department department);
		
		//delete
		void delete(int id);

}
