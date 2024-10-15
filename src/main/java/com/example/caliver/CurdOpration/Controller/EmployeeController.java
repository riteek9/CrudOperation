package com.example.caliver.CurdOpration.Controller;

import com.example.caliver.CurdOpration.User.Employee;
import com.example.caliver.CurdOpration.Repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @PostMapping("add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepo.save(employee);
    }

    @GetMapping
    public Iterable<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @GetMapping("id1")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeRepo.findById(id);
    }

    @PutMapping("id2")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        Optional<Employee> existingEmployeeOpt = employeeRepo.findById(id);
        if (existingEmployeeOpt.isPresent()) {
            Employee existingEmployee = existingEmployeeOpt.get();
            existingEmployee.setFirst_name(updatedEmployee.getFirst_name());
            existingEmployee.setLast_name(updatedEmployee.getLast_name());
            existingEmployee.setId(updatedEmployee.getId());
            existingEmployee.setAge(updatedEmployee.getAge());
            return employeeRepo.save(existingEmployee);
        }
        return null;
    }

    @DeleteMapping("id3")
    public void deleteEmployee(@PathVariable Long id) {
        employeeRepo.deleteById(id);
    }
}
