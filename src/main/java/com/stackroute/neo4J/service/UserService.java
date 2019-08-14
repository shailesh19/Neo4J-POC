package com.stackroute.neo4J.service;

import com.stackroute.neo4J.domain.User;
import java.util.List;

public interface UserService {

    public User saveUser(User user);
    public List<User> getAllUsers();
    public User getUserById(int uId);
    public User updateUser(User user);
    public User deleteUserById(int uId);
}
