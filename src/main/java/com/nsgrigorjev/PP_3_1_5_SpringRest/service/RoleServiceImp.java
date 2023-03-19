package com.nsgrigorjev.PP_3_1_5_SpringRest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nsgrigorjev.PP_3_1_5_SpringRest.dao.RoleRepository;
import com.nsgrigorjev.PP_3_1_5_SpringRest.model.Role;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

@Override
    public List<Role> findAllRole(){
        return roleRepository.findAll();
}
}