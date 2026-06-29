package service.impl;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import dao.CandidateDao;
import dao.impl.CandidateDaoImpl;
import model.Candidate;
import service.CandidateService;

public class CandidateServiceImpl implements CandidateService{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	CandidateDao cdi=new CandidateDaoImpl();

	@Override
	public void createCandidate(Candidate candidate) {
		cdi.insert(candidate);
		
	}

	@Override
	public boolean checkCandidate(String email, int jobId) {
		boolean r=false;
		
		Candidate candidate=cdi.selectByEmailAndJobId(email, jobId);
		
		if(candidate!=null)
		{
			r=true;
		}
		
		return r;
	}

	@Override
	public DefaultTableModel findAllCandidateTable() {
		List<Candidate> l=cdi.selectAll();
		
		DefaultTableModel model=new DefaultTableModel();
		
		model.addColumn("ID");
		model.addColumn("姓名");
		model.addColumn("電話");
		model.addColumn("Email");
		model.addColumn("應徵部門");
		model.addColumn("應徵職缺");
		model.addColumn("面試評價");
		model.addColumn("面試結果");
		model.addColumn("候選人狀態");
		
		for(Candidate c:l)
		{
			Object[] row=new Object[]
			{
					c.getId(),
					c.getName(),
					c.getPhone(),
					c.getEmail(),
					c.getDepartmentName(),
					c.getJobTitle(),
					c.getInterviewReview(),
					c.getInterviewResult(),
					c.getStatus()
					
					
					
					
			};
			
			model.addRow(row);
			
		}
		
		
		
		return model;
	}

	@Override
	public void update(Candidate candidate) {
		cdi.update(candidate);
		
	}

	@Override
	public void delete(int id) {
		cdi.delete(id);
		
	}

}
