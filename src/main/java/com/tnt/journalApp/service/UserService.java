    package com.tnt.journalApp.service;

import com.tnt.journalApp.entity.JournalEntry;
import com.tnt.journalApp.entity.User;
import com.tnt.journalApp.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserService {
    @Autowired
    private UserRepo userRepo; //dependency injection

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//    Create a save entry method
    public void saveEntry(User user){
        userRepo.save(user);
    }

    public void saveNewUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER"));
        userRepo.save(user);
    }

    public List<User> getAll(){
        return userRepo.findAll();
    }

//    Find by ID
    public Optional<User> findById(ObjectId id){
        return userRepo.findById(id);
    }

    public void deleteByid(ObjectId id){
        userRepo.deleteById(id);
    }

    public User findByUserName(String userName){
        return userRepo.findByUserName(userName);
    }
}
