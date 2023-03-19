package com.nsgrigorjev.PP_3_1_5_SpringRest;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.nsgrigorjev.PP_3_1_5_SpringRest.dao.RoleRepository;
import com.nsgrigorjev.PP_3_1_5_SpringRest.dao.UserRepository;
import com.nsgrigorjev.PP_3_1_5_SpringRest.model.Role;
import com.nsgrigorjev.PP_3_1_5_SpringRest.model.User;

import javax.annotation.PostConstruct;
import java.util.List;


@Component
public class init {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public init(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @PostConstruct
    private void postConstruct() {
        Role admin = new Role();
        admin.setId(1L);
        admin.setRole("ROLE_ADMIN");
        Role user = new Role();
        user.setId(2L);
        user.setRole("ROLE_USER");
        roleRepository.saveAll(List.of(admin, user));

        User adminUser = new User();
        adminUser.setName("Semen");
        adminUser.setLastName("Semenov");
        adminUser.setAge((byte) 36);
        adminUser.setEmail("admin");
        adminUser.setPassword(passwordEncoder.encode("admin"));
        adminUser.addRole(admin);

        User normalUser = new User();
        normalUser.setName("Artem");
        normalUser.setLastName("Izmailov");
        normalUser.setAge((byte) 45);
        normalUser.setEmail("user");
        normalUser.setPassword(passwordEncoder.encode("user"));
        normalUser.addRole(user);

        userRepository.save(adminUser);
        userRepository.save(normalUser);
    }

}


