package com.example.caliver.CurdOpration.Repo;

import com.example.caliver.CurdOpration.User.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepo extends CrudRepository<Employee,Long> {

}
