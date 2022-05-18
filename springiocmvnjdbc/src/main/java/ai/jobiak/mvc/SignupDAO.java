package ai.jobiak.mvc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.PreparedStatementCallback;

public class SignupDAO {

	private JdbcTemplate mysqlTemplate;
	
	public JdbcTemplate getTemplate() {
		return mysqlTemplate;
	}
	
	public void setTemplate(JdbcTemplate mysqlTemplate) {
		this.mysqlTemplate=mysqlTemplate;
	}

	public void insertRow(String fname, String email, long mobile) {

		String query = "insert into signup values(?,?,?)";
		mysqlTemplate.update(query,fname,email,mobile);
		
	}
	
	public void updateEmail(long mobile,String email) {
		String updateQuery="update signup set email =? where mobile = ?";
		mysqlTemplate.update(updateQuery,email,mobile);
	}
	
	public void updateName(long mobile,String fname) {
		String updateQuery ="update signup set fname=? where mobile = ?";
		mysqlTemplate.update(updateQuery,fname,mobile);
	}
	
	public User showUser(long mobile) {
		String sql = "select * from signup where mobile = ?";
		return mysqlTemplate.queryForObject(sql, new Object[] {mobile}, (rs, rowNum) ->
		
		new User(
				rs.getString("fname"),
				rs.getString("email"),
				rs.getLong("mobile")
				)
				
				
				);
		
	}
	
	
	
	
	
	
	
/*	public Boolean insertRow(String fname, String email, long mobile) {

	
		String query="insert into signup values(?,?,?)";
		return mysqlTemplate.execute(query,new PreparedStatementCallback<Boolean>() {
			
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps)throws SQLException, DataAccessException {
				ps.setString(1,fname);
				ps.setString(2,email);
				ps.setLong(3,mobile);
				
				return ps.execute();
				
			}
	
		});
	
		
	}	*/
}

