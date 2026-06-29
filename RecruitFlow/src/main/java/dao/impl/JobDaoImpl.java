package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.JobDao;
import model.Job;
import util.DbConnection;

public class JobDaoImpl implements JobDao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Connection conn=DbConnection.getDb();
	
	
	@Override
	public void insert(Job job) {
		String sql="insert into job(department_id,title,description,status)values(?,?,?,?)";
		
		try 
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, job.getDepartmentId());
			ps.setString(2, job.getTitle());
			ps.setString(3, job.getDescription());
			ps.setString(4, job.getStatus());
			ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Job> selectAll() {
		List<Job> l=new ArrayList<>();
		
		String sql="select j.id,j.department_id,d.name as department_name, "
				+ "j.title,j.description,j.status "
				+ "from job j "
				+ "join department d "
				+ "on j.department_id=d.id";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Job job=new Job();
				
				job.setId(rs.getInt("id"));
				job.setDepartmentId(rs.getInt("department_id"));
				job.setDepartmentName(rs.getString("department_name"));
				job.setTitle(rs.getString("title"));
				job.setDescription(rs.getString("description"));
				job.setStatus(rs.getString("status"));
				
				l.add(job);
				
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public Job selectByTitle(String title) {
		Job job=null;
		
		String sql="select* from job where title=?";
		try 
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, title);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				job=new Job();
				job.setId(rs.getInt("id"));
				job.setDepartmentId(rs.getInt("department_id"));
				job.setTitle(rs.getString("title"));
				job.setDescription(rs.getString("description"));
				job.setStatus(rs.getString("status"));
			}
			
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return job;
	}

	@Override
	public void update(Job job) {
		String sql="update job set department_id=?,title=?,description=?,status=? where id=?";
		
		try 
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, job.getDepartmentId());
			ps.setString(2, job.getTitle());
			ps.setString(3, job.getDescription());
			ps.setString(4, job.getStatus());
			ps.setInt(5, job.getId());
			
			ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void delete(int id) {
		String sql="delete from job where id=?";
		
		try 
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public List<Job> selectByDepartmentId(int departmentId) {
		List<Job> l = new ArrayList<>();
		
		String sql = "select * from job where department_id=?";
		
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, departmentId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Job job = new Job();
				
				job.setId(rs.getInt("id"));
				job.setDepartmentId(rs.getInt("department_id"));
				job.setTitle(rs.getString("title"));
				job.setDescription(rs.getString("description"));
				job.setStatus(rs.getString("status"));
				
				l.add(job);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return l;
	}

}
