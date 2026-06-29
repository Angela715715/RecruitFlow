package controller.Job;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Department;
import model.Job;
import service.DepartmentService;
import service.JobService;
import service.impl.DepartmentServiceImpl;
import service.impl.JobServiceImpl;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;

public class JobTableUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField title;
	private JTextField description;
	
	private JComboBox<Department>department;
	private JComboBox<String>status;
	
	private int jobId=0;
	
	JobService js=new JobServiceImpl();
	DepartmentService ds=new DepartmentServiceImpl(); 
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JobTableUI frame = new JobTableUI();
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
	public JobTableUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 585, 426);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 236, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
				
		JLabel lblNewLabel = new JLabel("部門");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(41, 261, 61, 27);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("職缺名稱");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_1.setBounds(169, 261, 81, 27);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("職缺描述");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_2.setBounds(313, 261, 81, 27);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("狀態");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_3.setBounds(451, 259, 61, 29);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_3);
		
		department = new JComboBox<>();
		department.setBounds(23, 298, 95, 27);
		contentPane.add(department);
		
		status = new JComboBox<>();
		status.addItem("OPEN");
		status.addItem("CLOSED");
		status.setBounds(447, 298, 95, 27);
		contentPane.add(status);
		
		title = new JTextField();
		title.setBounds(141, 297, 130, 26);
		contentPane.add(title);
		title.setColumns(10);
		
		description = new JTextField();
		description.setBounds(294, 297, 130, 26);
		description.setColumns(10);
		contentPane.add(description);
		
		
		/*************************event***********************/
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(19, 46, 531, 201);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				
				jobId=Integer.parseInt(table.getValueAt(row, 0).toString());
				
				int departmentId=Integer.parseInt(table.getValueAt(row, 1).toString());
				
				setSelectedDepartment(departmentId);
				
				title.setText(table.getValueAt(row, 3).toString());
				description.setText(table.getValueAt(row, 4).toString());
				status.setSelectedItem(table.getValueAt(row, 5).toString());
			}
		});

	
		JButton btnNewButton = new JButton("新增");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String Title = title.getText().trim();
				
				if(Title.equals(""))
				{
					return;
				}
				
				if(js.checkTitle(Title))
				{
					AddJobError error=new AddJobError();
					error.setVisible(true);
					
					return;
				}
				
				Department d = (Department) department.getSelectedItem();
				
				Job job = new Job(
						d.getId(),
						Title,
						description.getText(),
						status.getSelectedItem().toString()
				);
				
				js.createJob(job);
				
				loadJobTable();
				
				clear();
				
				AddJobSuccess success=new AddJobSuccess();
				success.setVisible(true);
				
				
			}
		});
		btnNewButton.setBounds(10, 348, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(jobId == 0)
				{
					return;
				}
				
				Department d = (Department) department.getSelectedItem();
				
				Job job = new Job();
				
				job.setId(jobId);
				job.setDepartmentId(d.getId());
				job.setTitle(title.getText());
				job.setDescription(description.getText());
				job.setStatus(status.getSelectedItem().toString());
				
				js.update(job);
				
				loadJobTable();
				
				clear();
			}
		});
		btnNewButton_1.setBounds(150, 348, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("刪除");
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(jobId == 0)
				{
					return;
				}
				
				
				js.delete(jobId);
				
				loadJobTable();
				
				clear();
			}
		});
		btnNewButton_2.setBounds(290, 348, 117, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("清空");
		btnNewButton_3.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clear();
			}
		});
		btnNewButton_3.setBounds(430, 348, 117, 29);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("職缺管理");
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(226, 6, 117, 28);
		contentPane.add(lblNewLabel_4);
		
		
		
		loadDepartmentCombo();
		loadJobTable();

	}
	
	
	
	
	
	private void loadJobTable()
	{
		table.setModel(js.findAllJobTable());
	}

	private void loadDepartmentCombo()
	{
		List<Department> list = ds.selectAll();
		
		for(Department d : list)
		{
			department.addItem(d);
		}
	}
	private void setSelectedDepartment(int departmentId)
	{
		for(int i = 0; i < department.getItemCount(); i++)
		{
			Department d = department.getItemAt(i);
			
			if(d.getId() == departmentId)
			{
				department.setSelectedIndex(i);
				break;
			}
		}
	}
	
	private void clear()
	{
		title.setText("");
		description.setText("");
		
		if(department.getItemCount() > 0)
		{
			department.setSelectedIndex(0);
		}
		
		status.setSelectedIndex(0);
		
		jobId = 0;
	}



	
}
