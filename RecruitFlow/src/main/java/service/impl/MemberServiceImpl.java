package service.impl;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import dao.MemberDao;
import dao.impl.MemberDaoImpl;
import model.Member;
import service.MemberService;

public class MemberServiceImpl implements MemberService {

	public static void main(String[] args) {
		
		//System.out.println(new MemberServiceImpl().Login("hr01", "1234"));
		
		System.out.println(new MemberServiceImpl().checkUsername("hr33"));
		

	}
	
	MemberDao mdi=new MemberDaoImpl();
	@Override
	public Member Login(String username, String password) {
		
		return mdi.selectByUsernameAndPassword(username, password);
	}

	@Override
	public void createMember(Member member) {
		 mdi.insert(member);
		
	}

	@Override
	public boolean checkUsername(String username) {
		boolean x=false;
		
		Member member=mdi.selectByUsername(username);
		
		if(member!=null)x=true;
		return x;
	}

	@Override
	public DefaultTableModel findAllMemberTable() {
		List<Member> l=mdi.selectAll();
		
		DefaultTableModel model=new DefaultTableModel();
		//建立欄位標題
		model.addColumn("ID");
		model.addColumn("帳號");
		model.addColumn("密碼");
		model.addColumn("姓名");
		model.addColumn("角色");
		
		for(Member p:l)
		{
			//把每一筆資料都建立一維陣列
			Object[] row=new Object[]{p.getId(),p.getUsername(),p.getPassword(),p.getName(),p.getRole()};
			
			//把此陣列放進table
			model.addRow(row);
			
			
		}
		
		return model;
	}

	@Override
	public void update(Member member) {
		mdi.update(member);
		
	}

	@Override
	public void delete(int id) {
		mdi.delete(id);
		
	}

	

}
