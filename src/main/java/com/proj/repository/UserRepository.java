package com.proj.repository;

import com.proj.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);

    User findByIdUtilisateur (Integer idUtilisateur);


}
