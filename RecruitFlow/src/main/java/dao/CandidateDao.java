package dao;

import java.util.List;

import model.Candidate;

public interface CandidateDao {
	//create
	void insert(Candidate candidate);
	
	//read
	List<Candidate> selectAll();
	Candidate selectByEmailAndJobId(String email,int jobId);
	
	
	//update
	void update(Candidate candidate);
	
	
	//delete
	void delete(int id);
}
