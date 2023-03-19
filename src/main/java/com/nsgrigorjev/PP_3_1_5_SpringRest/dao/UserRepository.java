package com.nsgrigorjev.PP_3_1_5_SpringRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.nsgrigorjev.PP_3_1_5_SpringRest.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u join fetch u.roles where u.email = :email")
    User findByUsername(@Param("email")String email);
}
