package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MemberDao;
import model.Member;
import util.DbConnection;

public class MemberDaoImpl implements MemberDao{

	public static void main(String[] args) {
		/*Member member=new Member("mg02","1234","paul","Manager");
		new MemberDaoImpl().insert(member);*/
		
		//System.out.println(new MemberDaoImpl().selectByUsernameAndPassword("hr01", "1234"));
		//System.out.println(new MemberDaoImpl().selectByUsername("xx"));
		
		/*MemberDao dao=new MemberDaoImpl();
		
		Member m=dao.selectByUsername("hr02");
		
		
		m.setName("reby1");
		
		dao.update(m);*/
		
		//new MemberDaoImpl().delete(2);
		
		

	}
	Connection conn=DbConnection.getDb();

	@Override
	public void insert(Member member) {
		String sql="insert into member(username,password,name,role)values(?,?,?,?)";
		
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, member.getUsername());
			ps.setString(2,member.getPassword());
			ps.setString(3, member.getName());
			ps.setString(4, member.getRole());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public Member selectByUsernameAndPassword(String username, String password) {
		Member member=null;
		String sql="select* from member where username=? and password=?";
		try 
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				member=new Member();
				member.setId(rs.getInt("id"));
				member.setUsername(rs.getString("username"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setRole(rs.getString("role"));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return member;
	}

	@Override
	public Member selectByUsername(String username) {
		Member member=null;
		String sql="select*from member where username=?";
		try 
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,username);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				member=new Member();
				member.setId(rs.getInt("id"));
				member.setUsername(rs.getString("username"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setRole(rs.getString("role"));
			}
			
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return member;
	}

	@Override
	public void update(Member member) {
		String sql="update member set username=?,password=?,name=?,role=? where id=? ";
		
		try 
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,member.getUsername());
			ps.setString(2,member.getPassword());
			ps.setString(3,member.getName());
			ps.setString(4,member.getRole());
			ps.setInt(5,member.getId());
			
			ps.executeUpdate();
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		String sql="delete from member where id=?";
		
		try 
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Member> selectAll() {
		
		List<Member> l=new ArrayList<>();
		
		String sql="select* from member";
		
		try 
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Member member=new Member();
				member=new Member();
				member.setId(rs.getInt("id"));
				member.setUsername(rs.getString("username"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setRole(rs.getString("role"));
				
				l.add(member);
				
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return l;
	}

	

}
