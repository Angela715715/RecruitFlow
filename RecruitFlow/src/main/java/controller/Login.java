package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.MemberService;
import service.impl.MemberServiceImpl;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 431);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(247, 248, 239));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/************************event***********************/
		MemberService ms=new MemberServiceImpl();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(494, 49, 285, 299);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("帳號:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel.setBounds(40, 97, 65, 29);
		panel.add(lblNewLabel);
		
		username = new JTextField();
		username.setBounds(114, 99, 119, 25);
		panel.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("密碼:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1.setBounds(43, 170, 46, 25);
		panel.add(lblNewLabel_1);
		
		password = new JTextField();
		password.setBounds(114, 170, 119, 25);
		panel.add(password);
		password.setColumns(10);
		
		JButton btnNewButton = new JButton("登入");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(88, 129, 87));
		btnNewButton.setBounds(84, 235, 111, 29);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 236, 224));
		panel_1.setBounds(0, 0, 285, 61);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("招募管理系統");
		lblNewLabel_3.setFont(new Font("新細明體", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 0, 285, 61);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Recruit Flow");
		lblNewLabel_2.setForeground(new Color(52, 78, 65));
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 50));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(48, 117, 360, 170);
		contentPane.add(lblNewLabel_2);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String userName=username.getText();
				String passWord=password.getText();
				
				Member member =ms.Login(userName, passWord);
				
				if(member!=null)
				{
					if("ADMIN".equals(member.getRole()))
					{
						AdminMainUI ui = new AdminMainUI();
			            ui.setVisible(true);
			            dispose();
					}
					
					else if("HR".equals(member.getRole()))
					{
						HRMainUI ui = new HRMainUI();
						ui.setVisible(true);
						dispose();
					}
					else if("MANAGER".equals(member.getRole()))
					{
						ManagerMainUI ui = new ManagerMainUI();
						ui.setVisible(true);
						dispose();
					}
					
				}
				else
				{
					LoginError error=new LoginError();
					error.setVisible(true);
					dispose();
				}
			 
			}
		});

	}
}
