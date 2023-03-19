package com.nsgrigorjev.PP_3_1_5_SpringRest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nsgrigorjev.PP_3_1_5_SpringRest.dao.UserRepository;
import com.nsgrigorjev.PP_3_1_5_SpringRest.model.User;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImp implements UserService, UserDetailsService {


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImp(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User getUserById(long id) {
        User user = null;
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            user = optional.get();
        }
        return user;
    }

    @Override
    @Transactional
    public void createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

    }

    @Override
    @Transactional
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void editUser(User user) {
        userRepository
                .findById(user.getUserId())
                .ifPresent(user1 -> {
                    user1.setName(user.getName());
                    user1.setLastName(user.getLastName());
                    user1.setAge(user.getAge());
                    user1.setEmail(user.getEmail());
                    user1.setRoles(user.getRoles());
                    if (!(user.getPassword().equals(user1.getPassword()))) {
                        user1.setPassword(passwordEncoder.encode(user.getPassword()));
                    }
                    userRepository.save(user1);
                });
    }


    @Override
    @Transactional
    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("User not found!");
        }
        return user;
    }
}
