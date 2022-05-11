package com.example.MoneyLion.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.ref.Cleaner;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository
        extends JpaRepository<Client, Long> {
    @Query("SELECT e from Client e where e.email = ?1")
    Optional<Client> findClientByEmail(String email);

    @Query("SELECT f from Client f where f.featureName= ?1")
    Optional<Client> findClientByFeature(String featureName);

    @Query("SELECT c FROM Client c WHERE c.featureName = :featureName and c.email = :email")
    List<Client> findClientByFeatureNameAndEmail(String featureName, String email);

}
