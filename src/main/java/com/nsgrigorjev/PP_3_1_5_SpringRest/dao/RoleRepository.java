package com.nsgrigorjev.PP_3_1_5_SpringRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nsgrigorjev.PP_3_1_5_SpringRest.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
