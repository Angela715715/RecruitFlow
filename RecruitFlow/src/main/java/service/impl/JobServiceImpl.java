package service.impl;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import dao.JobDao;
import dao.impl.JobDaoImpl;
import model.Job;
import service.JobService;

public class JobServiceImpl implements JobService{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	JobDao jdi=new JobDaoImpl();

	@Override
	public void createJob(Job job) {
		jdi.insert(job);
		
	}

	@Override
	public boolean checkTitle(String title) {
		boolean r=false;
		
		Job job=jdi.selectByTitle(title);
		
		if(job!=null)
		{
			r=true;
		}
		return r;
	}

	@Override
	public DefaultTableModel findAllJobTable() {
		
		List<Job> l=jdi.selectAll();
		
		DefaultTableModel model=new DefaultTableModel();
		
		model.addColumn("ID");
		model.addColumn("部門ID");
		model.addColumn("部門");
		model.addColumn("職缺名稱");
		model.addColumn("職缺描述");
		model.addColumn("狀態");
		
		for(Job job:l)
		{
			Object[] row=new Object[]
			{
					job.getId(),
					job.getDepartmentId(),
					job.getDepartmentName(),
					job.getTitle(),
					job.getDescription(),
					job.getStatus()
			};
			
			model.addRow(row);
		}
				
		return model;
	}

	@Override
	public void update(Job job) {
		
		jdi.update(job);
	}

	@Override
	public void delete(int id) {
			
		jdi.delete(id);
	}

	@Override
	public List<Job> selectByDepartmentId(int departmentId) {
		
		return jdi.selectByDepartmentId(departmentId);
	}

}
