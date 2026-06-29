package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Candidate.CandidateTableUI;
import controller.Department.DepartmentTableUI;
import controller.Job.JobTableUI;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;


public class AdminMainUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMainUI frame = new AdminMainUI();
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
	public AdminMainUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 324, 356);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 236, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("帳號管理");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MemberTableUI m=new MemberTableUI();
				m.setVisible(true);
			}
		});
		btnNewButton.setBounds(87, 52, 133, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("部門管理");
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DepartmentTableUI d=new DepartmentTableUI();
				d.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(87, 120, 133, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("職缺管理");
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JobTableUI ui=new JobTableUI();
				ui.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(87, 188, 133, 39);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("求職者管理");
		btnNewButton_3.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CandidateTableUI ui=new CandidateTableUI();
				ui.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(87, 256, 133, 39);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("回登入頁");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login=new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton_4.setBounds(6, 5, 82, 29);
		contentPane.add(btnNewButton_4);

	}
}
