package com.example.caliver.CurdOpration.Controller;

import com.example.caliver.CurdOpration.Repo.StudentsRepo;
import com.example.caliver.CurdOpration.User.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentsRepo studentsRepo;

    @PostMapping("/add")
    public Students addStudent(@RequestBody Students students){
        return studentsRepo.save(students);
    }
    @GetMapping
    public Iterable<Students> getStudent(){
        return studentsRepo.findAll();
    }

    @GetMapping("/id")
    public Optional<Students> getIdStudent(@PathVariable int roll_no){
        return studentsRepo.findById(roll_no);
    }

    @PutMapping("id2")
    public Students UpdateStudents(@PathVariable int roll_no, @RequestBody Students UpdateStudent){
        Optional<Students>existingStudentOpt=studentsRepo.findById(roll_no);
        if (existingStudentOpt.isPresent()){
            Students existingStudent=existingStudentOpt.get();
            existingStudent.setName(UpdateStudent.getName());
            existingStudent.setAge(UpdateStudent.getAge());
            existingStudent.setGrade(UpdateStudent.getGrade());
            return studentsRepo.save(existingStudent);

        }
        return null;

    }

    @DeleteMapping("Del")
    public void deleteStudents(@PathVariable int roll_no ){
         studentsRepo.deleteById(roll_no);
    }
}
