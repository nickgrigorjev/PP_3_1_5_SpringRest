package com.nsgrigorjev.PP_3_1_5_SpringRest.service;

import com.nsgrigorjev.PP_3_1_5_SpringRest.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();
    User getUserById(long id);
    void createUser(User user);
    void deleteUserById(long id);
    User findByUsername(String username);

    void editUser(User user);

}
