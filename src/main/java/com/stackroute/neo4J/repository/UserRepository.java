package com.stackroute.neo4J.repository;

import com.stackroute.neo4J.domain.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends Neo4jRepository<User, Integer> {

    @Query("MATCH (u:User)<-[r:RATED]-(m:Movie) RETURN u,r,m")
    List<User> getAllUsers();
}
