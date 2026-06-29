package service.impl;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import dao.DepartmentDao;
import dao.impl.DepartmentDaoImpl;
import model.Department;
import service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	DepartmentDao ddi=new DepartmentDaoImpl();

	@Override
	public void createDepartment(Department department) {
		ddi.insert(department);
		
	}

	@Override
	public boolean checkName(String name) {
		boolean r=false;
		
		Department department=ddi.selectByName(name);
		if(department!=null)
		{
			r=true;
		}
		return r;
	}

	@Override
	public DefaultTableModel findAllDepartmentTable() {
		List<Department> l=ddi.selectAll();
		
		DefaultTableModel model=new DefaultTableModel();
		
		model.addColumn("ID");
		model.addColumn("部門名稱");
		
		for(Department d:l)
		{
			Object[] row=new Object[] {
					d.getId(),
					d.getName()
			};
			
			model.addRow(row);
		}
		
		
		return model;
	}

	@Override
	public void update(Department department) {
		ddi.update(department);
		
	}

	@Override
	public void delete(int id) {
		ddi.delete(id);		
	}

	@Override
	public List<Department> selectAll() {
		
		return ddi.selectAll();
	}

}
