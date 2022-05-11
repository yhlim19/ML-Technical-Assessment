package com.example.MoneyLion.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository
        extends JpaRepository<Client, Long> {

    @Query("SELECT f from Client f where f.featureName= :featureName and f.email = :email")
    Optional<Client> findClientBonding(String featureName,String email);

    @Query("SELECT c FROM Client c WHERE c.featureName = :featureName and c.email = :email")
    List<Client> findClientByFeatureNameAndEmail(String featureName, String email);

}
