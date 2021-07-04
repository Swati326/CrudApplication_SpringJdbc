package org.swati.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.swati.Model.Student;
import org.swati.Repository.RegisterRepo;

@Service("registerservice")
public class RegisterServiceImpl implements RegisterService{
@Autowired
RegisterRepo registerrepo;
	public boolean insert(Student student) {
		// TODO Auto-generated method stub
		if(student.getAge()>18)
		{
			boolean b=registerrepo.insert(student);
			return b;
		}
		return false;
	}

	public boolean update(Student student) {
		// TODO Auto-generated method stub
		return registerrepo.update(student);
	}

	public List<Student> getAllRecords() {
		// TODO Auto-generated method stub
		return registerrepo.getAllRecords();
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return registerrepo.delete(id);
	}

	public Student getUserByName(String name) {
		// TODO Auto-generated method stub
		return registerrepo.getUserByName(name);
	}

}
