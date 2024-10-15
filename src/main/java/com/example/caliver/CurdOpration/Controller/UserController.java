package com.example.caliver.CurdOpration.Controller;

import com.example.caliver.CurdOpration.Repo.UserRepo;
import com.example.caliver.CurdOpration.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("User")
public class UserController {
@Autowired
    private UserRepo userRepo;

    @GetMapping
    public Iterable<User> getUser(){
        return userRepo.findAll();
    }

    @GetMapping("/id")
    public Optional<User> get1User(@PathVariable int id){
        return userRepo.findById(id);

    }
    @PostMapping("add")
    public User user(@RequestBody User user){
        return userRepo.save(user);
    }
    @PutMapping("id2")
    public User user2(@PathVariable int id,@RequestBody User UpdateUser){
        Optional<User> findAndUpdate= userRepo.findById(id);
        if (findAndUpdate.isPresent()){
            User CurrentOpt=findAndUpdate.get();
            CurrentOpt.setName(UpdateUser.getName());
            CurrentOpt.setId(UpdateUser.getId());
            CurrentOpt.setCity(UpdateUser.getCity());
            CurrentOpt.setStatus(UpdateUser.getStatus());

            return userRepo.save(UpdateUser);
        }
        return null;
    }
@DeleteMapping
    public void getDelete(@PathVariable int id){
        userRepo.deleteById(id);
}
}
