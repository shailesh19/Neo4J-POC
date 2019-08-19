package com.stackroute.neo4J.service;

import com.stackroute.neo4J.domain.User;
import com.stackroute.neo4J.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUserById(int uId) {
        return userRepository.findById(uId).get();
    }


    @Override
    public User updateUser(User user) {
        userRepository.deleteById(user.getUId());
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(User user) {
        Optional<User> optionalUser = userRepository.findById(user.getUId());
        userRepository.deleteById(user.getUId());
        return optionalUser.get();
    }
}
