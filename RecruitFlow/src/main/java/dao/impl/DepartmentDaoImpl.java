package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DepartmentDao;
import model.Department;
import util.DbConnection;

public class DepartmentDaoImpl implements DepartmentDao{

	public static void main(String[] args) {
		

	}
	
	Connection conn=DbConnection.getDb();

	@Override
	public void insert(Department department) {
		String sql="insert into department(name)values(?)";
		
		try 
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,department.getName());
			ps.executeUpdate();
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Department> selectAll() {
		List<Department> l=new ArrayList<>();
		
		String sql="select* from department";
		try 
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Department d=new Department();
				d.setId(rs.getInt("id"));
				d.setName(rs.getString("name"));
				
				l.add(d);
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
	public Department selectByName(String name) {
		Department d=null;
		
		String sql="select*from department where name=?";
		
		try 
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				d=new Department();
				d.setId(rs.getInt("id"));
				d.setName(rs.getString("name"));
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return d;
	}

	@Override
	public void update(Department department) {
		String sql="update department set name=? where id=?";
		try 
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, department.getName());
			ps.setInt(2, department.getId());
			
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
		String sql="delete from department where id=?";
		
		try 
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,id);
			
			ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
