package com.stackroute.neo4J.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import java.util.List;

@NodeEntity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class  User {

    @Id
    private int uId;
    private String uName;
    private int age;

    @Relationship(type = "RATED", direction = Relationship.INCOMING)
    private List<Movie> movies;
}
