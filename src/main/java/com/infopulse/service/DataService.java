package com.infopulse.service;

import com.infopulse.entity.User;
import com.infopulse.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataService {

    private UserRepository userRepository;

    public DataService(UserRepository userRepository){
        this.userRepository =userRepository;
    }

    @Transactional
    public void createClient(String name){
        User user = new User();
        user.setName(name);
        userRepository.save(user);
    }

    public List<String> getAll(){
        return userRepository
                .findAll()
                .stream()
                .map(entity -> entity.getName())
                .collect(Collectors.toList());
    }
}
