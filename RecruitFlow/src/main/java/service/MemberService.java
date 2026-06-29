package service;



import javax.swing.table.DefaultTableModel;

import model.Member;

public interface MemberService {
	//登入判斷
	Member Login(String username,String password);
	
	//註冊,新增
	void createMember(Member member);
	
	//檢查帳號重複
	boolean checkUsername(String username);
	
	//用table顯示會員列表//MemberTableUI
	DefaultTableModel findAllMemberTable();
	
	//UPDATE
	void update(Member member);
	
	//delete
	void delete(int id);

}
