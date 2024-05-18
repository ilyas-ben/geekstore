package com.proj;

import com.proj.model.User;
import com.proj.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {
    @Autowired
    private UserRepository repo;

    @Test
    public void testAddNew() {
        User user = new User();
        user.setEmail("adel.ama@uir.ac.ma");
        user.setMdP("01221");
        user.setNom("ama");
        user.setPrenom("ADL");
        user.setType(1);

        User savedUser = repo.save(user);
        Assertions.assertNotNull(savedUser);

        //Assertions.assertThrows(savedUser).isNotNull();//
    }

    @Test
    public void testListAll(){
        Iterable<User> users = repo.findAll();
        //Assertions.assertThat(users).hasSizeGreaterThan(0);//

        for (User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate(){
        Integer userId = 2;
        Optional<User> optionalUser = repo.findById(userId);
        User user = optionalUser.get();
        user.setType(1);
        repo.save(user);

        User updateUser = repo.findById(userId).get();
        //Assertions.assertEquals(updateUser.getMdP(), "010101");//
    }

    @Test
    public void testGet(){
        Integer userId = 1;
        Optional<User> optionalUser = repo.findById(userId);
        Assertions.assertNotNull(optionalUser);
        System.out.println(optionalUser.get());
    }

    @Test
    public void testDelete(){
        Integer userId = 1;
        repo.deleteById(userId);
        Optional<User> optionalUser = repo.findById(userId);
        //Assertions.assertNull(optionalUser);//
    }

}
