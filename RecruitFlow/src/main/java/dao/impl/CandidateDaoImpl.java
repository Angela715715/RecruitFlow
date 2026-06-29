package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CandidateDao;
import model.Candidate;
import util.DbConnection;

public class CandidateDaoImpl implements CandidateDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Connection conn = DbConnection.getDb();

	@Override
	public void insert(Candidate candidate) {
		String sql = "insert into candidate(name,phone,email,job_id,interview_review,interview_result,status) "
				+ "values(?,?,?,?,?,?,?)";

			try {
				PreparedStatement ps = conn.prepareStatement(sql);
	
				ps.setString(1, candidate.getName());
				ps.setString(2, candidate.getPhone());
				ps.setString(3, candidate.getEmail());
				ps.setInt(4, candidate.getJobId());
				ps.setString(5, candidate.getInterviewReview());
				ps.setString(6, candidate.getInterviewResult());
				ps.setString(7, candidate.getStatus());
	
				ps.executeUpdate();
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	@Override
	public List<Candidate> selectAll() {
		List<Candidate> l = new ArrayList<>();

		String sql = "select c.id,c.name,c.phone,c.email,c.job_id, " + "d.name as department_name,"
				+ "j.title as job_title, " + "c.interview_review,c.interview_result,c.status " + "from candidate c "
				+ "join job j " + "on c.job_id=j.id " + "join department d " + "on j.department_id=d.id";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Candidate c = new Candidate();

				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setPhone(rs.getString("phone"));
				c.setEmail(rs.getString("email"));
				c.setJobId(rs.getInt("job_id"));
				c.setDepartmentName(rs.getString("department_name"));
				c.setJobTitle(rs.getString("job_title"));
				c.setInterviewReview(rs.getString("interview_review"));
				c.setInterviewResult(rs.getString("interview_result"));
				c.setStatus(rs.getString("status"));

				l.add(c);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}

	@Override
	public Candidate selectByEmailAndJobId(String email, int jobId) {
		Candidate c = null;

		String sql = "select* from candidate where email=? and job_id=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setInt(2, jobId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				c = new Candidate();

				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setPhone(rs.getString("phone"));
				c.setEmail(rs.getString("email"));
				c.setJobId(rs.getInt("job_id"));
				c.setInterviewReview(rs.getString("interview_review"));
				c.setInterviewResult(rs.getString("interview_result"));
				c.setStatus(rs.getString("status"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c;
	}

	@Override
	public void update(Candidate candidate) {
		String sql = "update candidate set name=?,phone=?,email=?,job_id=?, "
				+ "interview_review=?,interview_result=?,status=? " + "where id=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, candidate.getName());
			ps.setString(2, candidate.getPhone());
			ps.setString(3, candidate.getEmail());
			ps.setInt(4, candidate.getJobId());
			ps.setString(5, candidate.getInterviewReview());
			ps.setString(6, candidate.getInterviewResult());
			ps.setString(7, candidate.getStatus());
			ps.setInt(8, candidate.getId());

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		String sql = "delete from candidate where id=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
