package com.zensar.repository;

import com.zensar.domain.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CredentialRepository extends JpaRepository<Credentials,Long> {
    Credentials findByName(String name);
}
