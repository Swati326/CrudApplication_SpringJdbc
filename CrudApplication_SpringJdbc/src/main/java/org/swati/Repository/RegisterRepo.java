package org.swati.Repository;

import java.util.List;

import org.swati.Model.Student;

public interface RegisterRepo {
	public boolean insert(Student student);
	public boolean update(Student student);
	public List<Student> getAllRecords();
	public boolean delete(int id);
	public Student getUserByName(String name);
}
