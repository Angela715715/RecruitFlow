package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.MemberService;
import service.impl.MemberServiceImpl;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class MemberTableUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField username;
	private JTextField password;
	private JTextField name;
	private JComboBox<String> role;
	private int memberId;
	private MemberService ps=new MemberServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberTableUI frame = new MemberTableUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MemberTableUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 735, 511);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 236, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 48, 638, 275);
		contentPane.add(scrollPane);
		
		
		
		JLabel lblNewLabel = new JLabel("帳號");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel.setBounds(85, 335, 51, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_1.setBounds(257, 335, 51, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("姓名");
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_2.setBounds(411, 335, 51, 26);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("角色");
		lblNewLabel_3.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_3.setBounds(591, 335, 51, 26);
		contentPane.add(lblNewLabel_3);
		
		username = new JTextField();
		username.setBounds(53, 371, 113, 32);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(219, 371, 113, 32);
		contentPane.add(password);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(385, 371, 113, 32);
		contentPane.add(name);
		
		role = new JComboBox<>();
		role.addItem("HR");
		role.addItem("MANAGER");
		role.addItem("ADMIN");
		role.setBounds(551, 371, 113, 32);
		contentPane.add(role);
		
		
		/***************************event*************************/
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				
				memberId=Integer.parseInt(table.getValueAt(row, 0).toString());
				username.setText(table.getValueAt(row, 1).toString());
				password.setText(table.getValueAt(row, 2).toString());
				name.setText(table.getValueAt(row, 3).toString());
				role.setSelectedItem(table.getValueAt(row, 4).toString());
				
			}
		});
		scrollPane.setViewportView(table);
		
		
		//新增帳號
		JButton btnNewButton = new JButton("新增");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String userName=username.getText();
				
				if(ps.checkUsername(userName))
				{
					AddMemberError addmembererror=new AddMemberError();
					 addmembererror.setVisible(true);
					 
					 return;
				}
				
				
				Member member=new Member(
						username.getText(),
						password.getText(),
						name.getText(),
						role.getSelectedItem().toString());
				
				ps.createMember(member);
				
				
				
				loadMemberTable();
				
				username.setText("");
				password.setText("");
				name.setText("");
				role.setSelectedIndex(0);
				
				AddMemberSuccess addmembersuccess=new AddMemberSuccess();
				addmembersuccess.setVisible(true);
				
				
			}
		});
		btnNewButton.setBounds(56, 423, 104, 26);
		contentPane.add(btnNewButton);
		
		//修改資料
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Member member=new Member();
				
				member.setId(memberId);
				member.setUsername(username.getText());
				member.setPassword(password.getText());
				member.setName(name.getText());
				member.setRole(role.getSelectedItem().toString());
				
				ps.update(member);
				
				loadMemberTable();
			}
		});
		btnNewButton_1.setBounds(223, 426, 104, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("刪除");
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ps.delete(memberId);
				
				loadMemberTable();
				
				username.setText("");
				password.setText("");
				name.setText("");
				role.setSelectedIndex(0);
				
				memberId=0;
				
				
			}
		});
		btnNewButton_2.setBounds(390, 426, 104, 23);
		contentPane.add(btnNewButton_2);
		
		//清空輸入
		JButton btnNewButton_3 = new JButton("清空");
		btnNewButton_3.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				username.setText("");
				password.setText("");
				name.setText("");
				role.setSelectedIndex(0);
				
				memberId=0;
				
			}
		});
		btnNewButton_3.setBounds(557, 426, 104, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("帳號管理");
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(314, 6, 106, 30);
		contentPane.add(lblNewLabel_4);
		
		loadMemberTable();

	}
	
		private void loadMemberTable()
		{
			table.setModel(ps.findAllMemberTable());
		}
}
