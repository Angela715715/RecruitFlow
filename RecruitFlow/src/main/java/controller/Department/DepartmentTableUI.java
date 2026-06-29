package controller.Department;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Department;
import service.DepartmentService;
import service.impl.DepartmentServiceImpl;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class DepartmentTableUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField name;
	private int departmentId=0;
	private DepartmentService ds=new  DepartmentServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentTableUI frame = new DepartmentTableUI();
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
	public DepartmentTableUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 456, 363);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 236, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("部門名稱");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(155, 220, 130, 26);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(155, 251, 130, 26);
		contentPane.add(name);
		name.setColumns(10);
		
		/************************event*************************/
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 41, 382, 177);
		contentPane.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				
				departmentId=Integer.parseInt(table.getValueAt(row, 0).toString());
				name.setText(table.getValueAt(row, 1).toString());
								
			}
		});
		
		
		
		JButton btnNewButton = new JButton("新增");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name=name.getText();
				
				if(ds.checkName(Name))
				{
					AddDepartmentError error=new AddDepartmentError();
					 error.setVisible(true);
					 
					 return;
				}
				
				
				Department department=new Department(
						
						name.getText());
						
				
				ds.createDepartment(department);
				
				
				
				loadDepartmentTable();
				
				
				name.setText("");
				
				
				AddDepartmentSuccess success=new AddDepartmentSuccess();
				success.setVisible(true);
				
				
			}
		});
		btnNewButton.setBounds(12, 287, 94, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Department department=new Department();
				
				department.setId(departmentId);
				department.setName(name.getText());
				
				
				ds.update(department);
				
				loadDepartmentTable();
			}
		});
		btnNewButton_1.setBounds(118, 287, 94, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("刪除");
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ds.delete(departmentId);
				
				loadDepartmentTable();
				name.setText("");
				
				departmentId=0;
				
			}
		});
		btnNewButton_2.setBounds(224, 287, 94, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("清空");
		btnNewButton_3.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				name.setText("");
				
				departmentId=0;

				
			}
		});
		btnNewButton_3.setBounds(330, 287, 94, 29);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("部門管理");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(165, 6, 110, 29);
		contentPane.add(lblNewLabel_1);
		
		loadDepartmentTable();

	}
	
	private void loadDepartmentTable()
	{
		table.setModel(ds.findAllDepartmentTable());
	}
}
