package com.proj.repository;

import com.proj.model.User;
import org.springframework.data.repository.CrudRepository;

public interface ReclamationRepository extends CrudRepository<User, Integer> {
    
}
