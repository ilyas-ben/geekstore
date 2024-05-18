package com.proj.service;

import com.proj.model.User;
import com.proj.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository repo;

    public void save(User user) {

        repo.save(user);
    }

    public User getUserByEmail(String email) {
        return repo.findByEmail(email);
    }


    public User getUserById(Integer idUtilisateur){
        return repo.findByIdUtilisateur(idUtilisateur);
    }

    public Optional<User> getUserById2(Integer idUtilisateur){
        return repo.findById(idUtilisateur);
    }

}
