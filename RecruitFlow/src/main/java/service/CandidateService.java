package service;

import javax.swing.table.DefaultTableModel;

import model.Candidate;

public interface CandidateService {
	// create
	void createCandidate(Candidate candidate);
	
	// read
	boolean checkCandidate(String email, int jobId);
	
	DefaultTableModel findAllCandidateTable();
	
	// update
	void update(Candidate candidate);
	
	// delete
	void delete(int id);
	
}
