package org.swati.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.swati.Model.Student;



@Repository("registerRepo")
public class RegisterRepoImpl implements RegisterRepo {
@Autowired
	private JdbcTemplate template;
	Student student;
	
	public boolean insert(final Student student) {
		// TODO Auto-generated method stub
		int val=template.update("insert into register values('0',?,?,?,?)", new PreparedStatementSetter() {

			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1,student.getName());
				ps.setString(2,student.getEmail());
				ps.setString(3,student.getContact());
				ps.setInt(4,student.getAge());
			}
			
			
		});
		if(val>0)
		{
			return true;
		}
		else
		{
		return false;
	}
	}
	public boolean update(final Student student) {
		// TODO Auto-generated method stub
		int val=template.update("update Register set name=?,email=?,contact=?,age=? where id=?", new PreparedStatementSetter() {

			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, student.getName());
				ps.setString(2, student.getEmail());
				ps.setString(3, student.getContact());
				ps.setInt(4, student.getAge());
				ps.setInt(5, student.getId());
			}
			
		});
		if(val>0)
		{
			return true;
		}
		else
		{
		return false;
	}
	}
	public List<Student> getAllRecords() {
		// TODO Auto-generated method stub
		List<Student> list = template.query("select *from register", new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student stud=new Student();
				stud.setId(rs.getInt(1));
				stud.setName(rs.getString(2));
				stud.setEmail(rs.getString(3));
				stud.setContact(rs.getString(4));
				stud.setAge(rs.getInt(5));
				return stud;	
			}
			
		});
		return list;
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		int val=template.update("delete from register where id=?",new Object[] {id});
		if(val > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public Student getUserByName(String name) {
		// TODO Auto-generated method stub
		student=template.queryForObject("select *from register where name=?", new Object[] {name}, new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student s3=new Student();
				s3.setId(rs.getInt(1));
				s3.setName(rs.getString(2));
				s3.setEmail(rs.getString(3));
				s3.setContact(rs.getString(4));
				s3.setAge(rs.getInt(5));
				return s3;
			}
			
		});
		return student;
	}
	

}
