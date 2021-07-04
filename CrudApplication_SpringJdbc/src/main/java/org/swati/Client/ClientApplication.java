package org.swati.Client;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.swati.Config.Config;
import org.swati.Model.Student;
import org.swati.Service.RegisterServiceImpl;


public class ClientApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		RegisterServiceImpl r=(RegisterServiceImpl)context.getBean("registerservice");
		Scanner sc=new Scanner(System.in);
		System.out.println("1:Insert");
		System.out.println("2:update");
		System.out.println("3:Select");
		System.out.println("4:Delete");
		System.out.println("5:select data by name");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
		System.out.println("The age of voter should be greater than 18");
		System.out.println("enter the name ,email,contact,age");
		sc.nextLine();
		String name=sc.nextLine();
		String email=sc.nextLine();
		String contact=sc.nextLine();
		int age=sc.nextInt();
		Student s=new Student();
		s.setName(name);
		s.setAge(age);
		s.setEmail(email);
		s.setContact(contact);
		boolean b=r.insert(s);
		if(b)
		{
			System.out.println("inserted successfully");
		}
		else
		{
			System.out.println("not insert successfully");
		}
		break;
		
		case 2:
			System.out.println("enter the age");
			 age=sc.nextInt();
			 System.out.println("enter name");
			 sc.nextLine();
		     name=sc.nextLine();
		     System.out.println("enter the email");
			 email=sc.nextLine();
			 System.out.println("enter the contact");
			 contact=sc.nextLine();
			 System.out.println("Enter the id");
			 int id=sc.nextInt();
			Student s1=new Student();
			s1.setName(name);
			s1.setEmail(email);
			s1.setContact(contact);
			s1.setId(id);
			s1.setAge(age);
			b=r.update(s1);
			if(b)
			{
				System.out.println("updated sucessfully");
			}
			else
			{
				System.out.println("not updated");
			}
			break;
			
		case 3:
			List<Student> list=r.getAllRecords();
			 System.out.println("Id\tName\t\tEmail\tContact\tAge\t");
			for(Student st:list)
			{
				System.out.println(st.getId()+"\t"+st.getName()+"\t"+st.getEmail()+"\t"+st.getContact()+"\t"+st.getAge());
			}
			break;
		case 4:
			
			System.out.println("enter the id for delete");
			sc.nextLine();
			 id=sc.nextInt();
			 b=r.delete(id);
			 if(b)
			 {
				 System.out.println("delete successfully");
			 }
			 else
			 {
				 System.out.println("not yet deleted");
			 }
			 break;
		case 5:
			System.out.println("enter name to fetch data by using name");
			sc.nextLine();
			name=sc.nextLine();
			Student student=new Student();
			 student=r.getUserByName(name);
			 System.out.println("Id\t\tName\t\tEmail\t\tContact\t\tAge\t\t");
			
			System.out.println(student.getName()+"\t"+student.getEmail()+"\t"+student.getContact()+"\t"+student.getAge()+"\t"+student.getId());
			break;
			
		default:
			System.out.println("wrong input");

	}

}
}
