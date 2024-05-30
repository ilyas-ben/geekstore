package com.proj.repository;

import com.proj.model.Commande;
import com.proj.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommandeRepository extends CrudRepository<Commande, Integer> {


    @Query("from Commande c where c.client.id = :idu ")
    List<Commande> getCommmandesByUserId(@Param("idu") Integer idUtilisateur);
}
