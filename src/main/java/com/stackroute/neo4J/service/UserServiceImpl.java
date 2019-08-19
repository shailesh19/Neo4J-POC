package com.stackroute.neo4J.service;

import com.stackroute.neo4J.domain.Movie;
import com.stackroute.neo4J.domain.User;
import com.stackroute.neo4J.repository.MovieRepository;
import com.stackroute.neo4J.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private MovieRepository movieRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, MovieRepository movieRepository) {
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
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

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie deleteMovie(Movie movie) {
        Optional<Movie> optionalMovie = movieRepository.findById(movie.getMId());
        movieRepository.deleteById(movie.getMId());
        return optionalMovie.get();
    }

    @Override
    public Movie getMovieById(int mId) {
        return movieRepository.findById(mId).get();
    }
}
