package com.stackroute.neo4J.repository;

import com.stackroute.neo4J.domain.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface MovieRepository extends Neo4jRepository<Movie, Integer> {
}
