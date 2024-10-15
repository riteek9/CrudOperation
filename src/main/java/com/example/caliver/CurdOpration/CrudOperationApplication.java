package com.example.caliver.CurdOpration;

import com.example.caliver.CurdOpration.Repo.EmployeeRepo;
import com.example.caliver.CurdOpration.User.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CrudOperationApplication {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(CrudOperationApplication.class, args);
//		UserRepo userRepo=context.getBean(UserRepo.class);

		EmployeeRepo employee=context.getBean(EmployeeRepo.class);
		Employee emp=new Employee();
		emp.setFirst_name("Anil");
		emp.setLast_name("Sharma");
		emp.setAge(32);
		employee.save(emp);








	}

}
