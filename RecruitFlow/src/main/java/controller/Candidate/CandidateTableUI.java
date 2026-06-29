package controller.Candidate;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Candidate;
import model.Department;
import model.Job;
import service.CandidateService;
import service.DepartmentService;
import service.JobService;
import service.impl.CandidateServiceImpl;
import service.impl.DepartmentServiceImpl;
import service.impl.JobServiceImpl;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class CandidateTableUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField name;
	private JTextField phone;
	private JTextField email;
	
	private JTextArea interviewReview;
	
	private JComboBox<Department> department;
	private JComboBox<Job> job;
	private JComboBox<String> interviewResult;
	private JComboBox<String> status;
	
	private int candidateId=0;
	
	private String role;
	
	CandidateService cs=new CandidateServiceImpl();
	DepartmentService ds=new DepartmentServiceImpl();
	JobService js=new JobServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CandidateTableUI frame = new CandidateTableUI();
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
	public CandidateTableUI() {
		this("ADMIN");
	}
	
	
	public CandidateTableUI(String role) {
		this.role=role;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 843, 706);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 236, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 464, 777, 187);
		contentPane.add(scrollPane);
		
		
		
		JLabel lblNewLabel = new JLabel("基本資料");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setBounds(66, 43, 83, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("姓名:");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_1.setBounds(66, 103, 83, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("電話:");
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_2.setBounds(66, 174, 83, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("新細明體", Font.BOLD, 20));
		lblEmail.setBounds(66, 235, 83, 24);
		contentPane.add(lblEmail);
		
		JLabel lblNewLabel_3 = new JLabel("應徵/面試資料");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_3.setBounds(432, 43, 182, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("應徵部門:");
		lblNewLabel_4.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_4.setBounds(432, 98, 109, 24);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("應徵職缺:");
		lblNewLabel_5.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_5.setBounds(432, 148, 109, 24);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("面試結果:");
		lblNewLabel_6.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_6.setBounds(432, 207, 109, 24);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("候選人狀態:");
		lblNewLabel_7.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_7.setBounds(432, 263, 109, 24);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("面試評價:");
		lblNewLabel_7_1.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_7_1.setBounds(46, 336, 109, 24);
		contentPane.add(lblNewLabel_7_1);
		
		interviewReview = new JTextArea();
		interviewReview.setBounds(165, 308, 626, 86);
		contentPane.add(interviewReview);
		
		name = new JTextField();
		name.setBounds(140, 103, 194, 24);
		contentPane.add(name);
		name.setColumns(10);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(140, 174, 194, 24);
		contentPane.add(phone);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(140, 237, 194, 24);
		contentPane.add(email);
		
		department = new JComboBox<>();
		department.addActionListener(e->{
				Department d=(Department) department.getSelectedItem();
				
				if(d!=null)
				{
					loadJobCombo(d.getId());
				}
			});
		department.setBounds(581, 99, 182, 23);
		contentPane.add(department);
		
		job = new JComboBox<>();
		job.setBounds(581, 149, 182, 23);
		contentPane.add(job);
		
		interviewResult = new JComboBox<>();
		interviewResult.addItem("PENDING");
		interviewResult.addItem("PASS");
		interviewResult.addItem("FAIL");
		interviewResult.setBounds(581, 208, 182, 23);
		contentPane.add(interviewResult);
		
		status = new JComboBox<>();
		status.addItem("NEW");
		status.addItem("SCREENING");
		status.addItem("INTERVIEW");
		status.addItem("ON_HOLD");
		status.addItem("REJECTED");
		status.addItem("OFFER");
		status.addItem("HIRED");
		
		
		status.setBounds(581, 264, 182, 23);
		contentPane.add(status);
		
		/***************************event***************************/
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row=table.getSelectedRow();
				
				candidateId=Integer.parseInt(table.getValueAt(row, 0).toString());
				
				name.setText(table.getValueAt(row, 1).toString());
				phone.setText(table.getValueAt(row, 2).toString());
				email.setText(table.getValueAt(row, 3).toString());
				
				String department=table.getValueAt(row, 4).toString();
				String jobTitle=table.getValueAt(row, 5).toString();
				
				setSelectedDepartmentByName(department);
				setSelectedJobByTitle(jobTitle);
				
				interviewReview.setText(table.getValueAt(row, 6).toString());
				interviewResult.setSelectedItem(table.getValueAt(row, 7).toString());
				status.setSelectedItem(table.getValueAt(row, 8).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		

		JButton btnNewButton = new JButton("新增");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String Name=name.getText().trim();
				String Phone=phone.getText().trim();
				String Email=email.getText().trim();
				
				if(Name.equals("")||Email.equals(""))
				{
					AddCandidateError error = new AddCandidateError();
					error.setVisible(true);
					return;
				}
				
				Job j=(Job) job.getSelectedItem();
				
				if(j==null)
				{
					return;
				}
				
				if(cs.checkCandidate(Email, j.getId()))
				{
					AddCandidateError error = new AddCandidateError();
					error.setVisible(true);
					return;
				}
				
				Candidate c=new Candidate(
						Name,
						Phone,
						Email,
						j.getId(),
						interviewReview.getText(),
						interviewResult.getSelectedItem().toString(),
						status.getSelectedItem().toString()
				
						);
				
				cs.createCandidate(c);
				
				loadCandidateTable();
				
				clear();
				
				AddCandidateSuccess success=new AddCandidateSuccess();
				success.setVisible(true);
			}
		});
		btnNewButton.setBounds(66, 419, 109, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(candidateId==0)
				{
					return;
				}
				
				Job j=(Job) job.getSelectedItem();
				
				if(j==null)
				{
					return;
				}
				
				Candidate c=new Candidate();
				
				c.setId(candidateId);
				c.setName(name.getText());
				c.setPhone(phone.getText());
				c.setEmail(email.getText());
				c.setJobId(j.getId());
				c.setInterviewReview(interviewReview.getText());
				c.setInterviewResult(interviewResult.getSelectedItem().toString());
				c.setStatus(status.getSelectedItem().toString());
				
				cs.update(c);
				
				loadCandidateTable();
				
				clear();
	
			}
		});
		btnNewButton_1.setBounds(256, 419, 109, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("刪除");
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(candidateId==0)
				{
					return;
				}
				
				cs.delete(candidateId);
				
				loadCandidateTable();
				
				clear();
			}
		});
		btnNewButton_2.setBounds(446, 419, 109, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("清空");
		btnNewButton_3.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
							clear();
			}
		});
		btnNewButton_3.setBounds(636, 419, 109, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_8 = new JLabel("求職者管理");
		lblNewLabel_8.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(319, 6, 188, 29);
		contentPane.add(lblNewLabel_8);
		
		if("MANAGER".equals(role))
		{
			btnNewButton.setEnabled(false);
			btnNewButton_2.setEnabled(false);
			
			name.setEditable(false);
			phone.setEditable(false);
			email.setEditable(false);
			department.setEnabled(false);
			job.setEnabled(false);
			
		}
		
		loadDepartmentCombo();
		loadCandidateTable();
		
		
		

	}
	
	//顯示Jtable
	private void loadCandidateTable()
	{
		table.setModel(cs.findAllCandidateTable());
	}
	
	
	private void loadDepartmentCombo()
	{
		department.removeAllItems();
		
		List<Department> list=ds.selectAll();
		
		for(Department d:list)
		{
			department.addItem(d);
		}
		
		if(department.getItemCount()>0)
		{
			Department d=(Department) department.getSelectedItem();
			loadJobCombo(d.getId());
		}
	}
	
	
	
	private void loadJobCombo(int departmentId)
	{
		job.removeAllItems();
		
		List<Job> list=js.selectByDepartmentId(departmentId);
		
		for(Job j:list)
		{
			job.addItem(j);
		}
	}
	
	
	//選回部門
	private void setSelectedDepartmentByName(String departmentName)
	{
		for(int i=0;i<department.getItemCount();i++)
		{
			Department d=department.getItemAt(i);
			
			if(d.getName().equals(departmentName))
			{
				department.setSelectedIndex(i);
				loadJobCombo(d.getId());
				break;
			}
		}
		
	}
	
	
	private void setSelectedJobByTitle(String jobTitle)
	{
		for(int i=0;i<job.getItemCount();i++)
		{
			Job j=job.getItemAt(i);
			
			if(j.getTitle().equals(jobTitle))
			{
				job.setSelectedIndex(i);
				break;
			}
		}
	}
	
	private void clear()
	{
		name.setText("");
		phone.setText("");
		email.setText("");
		interviewReview.setText("");
		
		if(department.getItemCount()>0)
		{
			department.setSelectedIndex(0);
		}
		
		if(job.getItemCount()>0)
		{
			job.setSelectedIndex(0);
		}
		
		interviewResult.setSelectedIndex(0);
		status.setSelectedIndex(0);
		
		candidateId=0;
	}
}
