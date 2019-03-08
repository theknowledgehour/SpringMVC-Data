package com.zensar.oauth2.repository;

import com.zensar.oauth2.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, String> {

}
