package dao;

import java.util.List;

import model.Member;

public interface MemberDao {
	//create
	void insert(Member member);
	
	
	
	//read
	Member selectByUsernameAndPassword(String username,String password);//登入用 檢查帳號密碼
	Member selectByUsername(String username);//註冊的時候檢查帳號有沒有重複
	
	List<Member> selectAll();
	
	
	//update
	void update(Member member);
	
	
	//delete
	void delete(int id);
	

}
