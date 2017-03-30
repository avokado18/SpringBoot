package com.cinimex.myProject.service;

import com.cinimex.myProject.model.User;
import com.cinimex.myProject.model.Word;
import com.cinimex.myProject.repository.UserRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Transactional
    public User create(User user){
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setPassword(user.getPassword()  );
        return userRepository.save(newUser);
    }

    @Transactional
    public User getOne(Long id){
        return userRepository.findOne(id);
    }

    @Transactional
    public List<User> getAll() {
        return Lists.newArrayList(userRepository.findAll());
    }

}
