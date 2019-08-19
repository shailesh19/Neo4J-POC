package com.stackroute.neo4J.service;

import com.stackroute.neo4J.domain.Movie;
import com.stackroute.neo4J.domain.User;
import java.util.List;

public interface UserService {

    public User saveUser(User user);
    public List<User> getAllUsers();
    public User getUserById(int uId);
    public User updateUser(User user);
    public User deleteUser(User user);
    public Movie saveMovie(Movie movie);
    public Movie deleteMovie(Movie movie);
    public Movie getMovieById(int mId);
}
